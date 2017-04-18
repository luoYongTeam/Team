package org.mvc.convertor;



import org.apache.commons.beanutils.ConvertUtils;
import org.mvc.web.ActionContext;
import org.mvc.web.ConvertorHandler;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Parameter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ly on 2016/12/13.
 * 基本数据类型的转换器
 */
public class BasicConvertorHandler implements ConvertorHandler {

    private static List<Class<?>> list = new ArrayList<>();

    static {
        list.add(Integer.TYPE);
        list.add(Long.TYPE);
        list.add(Double.TYPE);
        list.add(Float.TYPE);
        list.add(Character.TYPE);
        list.add(Byte.TYPE);
        list.add(Boolean.TYPE);
        list.add(Short.TYPE);
        list.add(Integer.class);
        list.add(Long.class);
        list.add(Double.class);
        list.add(Float.class);
        list.add(Character.class);
        list.add(Byte.class);
        list.add(Boolean.class);
        list.add(Short.class);
        list.add(String.class);
        list.add(java.util.Date.class);
        list.add(java.sql.Date.class);
        list.add(java.sql.Timestamp.class);
        list.add(java.sql.Time.class);
        list.add(BigDecimal.class);
    }

    @Override
    public Object convert(Parameter parameter, ConvertorHandlerChain chain) {
        //如果是可转换的类型，那么就执行类型转换
        if (list.indexOf(parameter.getType()) != -1
                || list.indexOf(parameter.getType().getComponentType()) != -1) {
            //从ActionContext中获取request对象
            HttpServletRequest request = ActionContext.getContext().getRequest();
            //获取表单的数据
            Object requestParam = null;
            if (parameter.getType().isArray()) {
                requestParam = request.getParameterValues(parameter.getName());
            } else {
                requestParam = request.getParameter(parameter.getName());
            }
            if (requestParam != null) {
                return ConvertUtils.convert(requestParam, parameter.getType());
            }
        }
        return chain.convert(parameter);
    }

}
