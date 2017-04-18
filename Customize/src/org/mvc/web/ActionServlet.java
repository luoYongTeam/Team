package org.mvc.web;



import org.mvc.convertor.ConvertorHandlerChain;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * Created by ly on 2016/12/8.
 * 核心控制器(核心职责就是做请求的分发)
 */

public class ActionServlet extends FrameworkServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //当请求过来的时候，就可以从ServletContext中找到具体的映射类信息
        Map<String, Method> map = (Map<String, Method>) req.getServletContext().getAttribute(MAP_URI);
        //根据请求路径作为key找出对应的业务控制器
        Method method = map.get(req.getServletPath());
        if (method != null) {
            //1. 初始化ActionContext
            initActionContext(req, resp);
            //2. 表单参数的类型转换
            Object[] values = paramsConvert(method);
            //3. 回调Method对象，执行请求操作, 并返回响应试图结果对象
            ViewResult viewResult = invokeAction(method, values);
            //4. 响应视图结果集
            reponseView(viewResult);
        } else {
            //如果method是空的话，表示没有匹配的url与之对应
            //那么就将这个请求交给web容器默认的Servlet处理这个请求
            forwardDefaultServlet(req, resp);
        }

    }

    //初始化ActionContext
    private void initActionContext(HttpServletRequest request, HttpServletResponse response){
        ActionContext context = ActionContext.getContext();
        context.setRequest(request);
        context.setResponse(response);
    }

    //表单的参数转换
    private Object[] paramsConvert(Method method){
        //处理参数的类型转换
        return new ConvertorHandlerChain().execute(method);
    }

    //执行目标方法的回调,处理请求。并将转换好的参数传递给执行方法
    private ViewResult invokeAction(Method method, Object[] values) throws ServletException {
        Class<?> clazz = method.getDeclaringClass();
        ViewResult viewResult = null;
        try {
            viewResult = (ViewResult) method.invoke(clazz.newInstance(), values);
        } catch (Exception e) {
            throw new ServletException(e.getMessage());
        }
        return viewResult;
    }

    //响应视图结果集
    private void reponseView(ViewResult viewResult) throws ServletException, IOException {
        if(viewResult != null){
            viewResult.view();
        }
    }

    //转发给Tomcat默认的Servlet处理请求(DefaultServlet)
    private void forwardDefaultServlet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getServletContext().getNamedDispatcher(DEFAUTL_SERVLET_NAME).forward(request, response);
    }
}
