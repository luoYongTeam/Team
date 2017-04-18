package org.mvc.view;


import com.google.gson.Gson;
import org.mvc.web.ActionContext;
import org.mvc.web.ViewResult;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ly on 2016/12/12.
 */
public class JsonView implements ViewResult {

    private Object obj;

    public JsonView(Object obj){
        this.obj = obj;
    }

    @Override
    public void view() throws ServletException, IOException {
        HttpServletResponse response = ActionContext.getContext().getResponse();
        response.setContentType("application/json;charset=utf-8");
        String json = new Gson().toJson(obj);
        response.getWriter().println(json);
    }
}
