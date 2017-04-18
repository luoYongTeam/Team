package org.mvc.web;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created by wangl on 2016/12/12.
 * 抽象的视图结果集
 */
public interface ViewResult {

    //抽象的响应方法，不同的实现类有不同的具体实现
    public void view() throws ServletException, IOException;
}
