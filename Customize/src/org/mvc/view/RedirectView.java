package org.mvc.view;


import org.mvc.web.ActionContext;
import org.mvc.web.ViewResult;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ly on 2016/12/12.
 * 重定向视图
 */
public class RedirectView implements ViewResult {

    private String uri;

    public RedirectView(String uri){
        this.uri = uri;
    }


    public void view() throws ServletException, IOException {
        HttpServletResponse response = ActionContext.getContext().getResponse();
        response.sendRedirect(uri);
    }
}
