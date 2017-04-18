package org.mvc.web;




import org.mvc.annotation.Action;
import org.mvc.bean.UserBean;
import org.mvc.view.ForwardView;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created by ly on 2016/12/9.
 */
public class RequestServlet {
@Action("/login")
    public ViewResult excute(String[] addr, int id, UserBean userBean) throws IOException, ServletException {
    System.out.println(id);
    System.out.println(userBean);
    ActionContext.getContext().setAttribute("UserName","ly",ActionContext.SESSION_SCOPE);
    //ActionContext.getContext().forward("index.jsp");
    return new ForwardView("index.jsp");

    }
}
