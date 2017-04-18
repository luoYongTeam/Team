package org.mvc.web;

import org.mvc.annotation.Action;
import org.mvc.utils.ScanUtil;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ly on 2016/12/12.
 * 完成框架的初始化操作(扫描并解析创建map映射集合)
 */
public class FrameworkServlet extends HttpServlet{

    private static final String PATH = "scan";
    //map集合在上下文中的key
    protected static final String MAP_URI = "actions";
    //默认servlet的name
    protected  static final String DEFAUTL_SERVLET_NAME = "default";

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        //从配置文件中获取具体要扫描的包路径
        String pkgPath = config.getInitParameter(PATH);
        //1. 执行扫描，返回对应的完整类名
        List<String> classNames = scan(pkgPath);
        //2. 解析出对应的业务控制器(业务控制器是由注解标识的)
        try {
            Map<String, Method> map = resolve(classNames);
            //3. 将map集合保存在ServletContext中
            config.getServletContext().setAttribute(MAP_URI, map);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //执行扫描
    private List<String> scan(String pkgPath) {
        // 如果包路径为空，则扫描整个项目的所有包，
        // 否则扫描指定的pkgPath包路径
        return pkgPath == null ? ScanUtil.scanPackage("") : ScanUtil.scanPackage(pkgPath);
    }

    //解析方法，找出具体的业务控制器，并封装到map中
    private Map<String, Method> resolve(List<String> classNames) throws ClassNotFoundException {
        //定义一个Map用于存放请求映射信息
        Map<String, Method> map = new HashMap<>();
        //遍历所有的className
        for (String className : classNames) {
            //根据完整类名执行类加载操作，获取Class对象
            Class<?> clazz = Class.forName(className);
            //依据Class对象获取所有公共的方法
            Method[] methods = clazz.getMethods();
            for (Method method : methods) {
                //判断方法上是否标识了@Action注解
                if (method.isAnnotationPresent(Action.class)) {
                    //获取相应的注解信息
                    Action anno = method.getAnnotation(Action.class);
                    //将映射信息放入map中
                    //key:请求的url，value：处理请求的method
                    map.put(anno.value(), method);
                }
            }
        }
        return map;
    }

}
