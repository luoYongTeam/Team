package org.mvc.web;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by ly on 2016/12/12.
 * 每一个线程都对用一个ActionContext实例
 * 只要当前线程没有结束，不管获取多少次，得到的都是同一个对象
 */
public class ActionContext {

    //作用域常量名称
    public static final String REQUEST_SCOPE = "request";
    public static final String SESSION_SCOPE = "session";
    public static final String APPLICATION_SCOPE = "application";

    //定义一个本地线程副本变量，存放当前类ActionContext实例
    private static ThreadLocal<ActionContext> local = new ThreadLocal<>();

    //请求对象
    private HttpServletRequest request;
    //响应对象
    private HttpServletResponse response;

    //不允许从外部创建当前类的实例
    private ActionContext(){
    }

    //通过这个方法来获取ActionContext对象
    //这里获取的ActionContext对象是跟当前线程绑定在一起的
    //不同的线程将获取自己的ActionContext对象
    public static ActionContext getContext(){
        if(local.get() == null){
            local.set(new ActionContext());
        }
        return local.get();
    }

    //获取请求对象
    public HttpServletRequest getRequest() {
        return request;
    }

    void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    //获取相应对象
    public HttpServletResponse getResponse() {
        return response;
    }

    void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    //获取HttpSession
    public HttpSession getSesison(){
        return request.getSession();
    }

    //获取上下文对象
    public ServletContext getApplication(){
        return request.getServletContext();
    }

    //设置作用域
    public void setAttribute(String key, Object value, String scope){
        if(REQUEST_SCOPE.equals(scope)){
            request.setAttribute(key,value);
        }else if(SESSION_SCOPE.equals(scope)){
            getSesison().setAttribute(key,value);
        }else if(APPLICATION_SCOPE.equals(scope)){
            getApplication().setAttribute(key,value);
        }
    }

}
