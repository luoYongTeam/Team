package org.mvc.view;



import org.mvc.web.ActionContext;
import org.mvc.web.ViewResult;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ly on 2016/12/12.
 * 转发视图
 */
public class ForwardView implements ViewResult {

    private String uri;

    public ForwardView(String uri){
        this.uri = uri;
    }

    @Override
    public void view() throws ServletException, IOException {
        HttpServletRequest request = ActionContext.getContext().getRequest();
        HttpServletResponse response = ActionContext.getContext().getResponse();
        request.getRequestDispatcher(uri).forward(request, response);
    }
}
