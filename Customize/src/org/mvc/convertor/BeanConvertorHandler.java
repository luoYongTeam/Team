package org.mvc.convertor;



import org.apache.commons.beanutils.BeanUtils;
import org.mvc.web.ActionContext;
import org.mvc.web.ConvertorHandler;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Parameter;
import java.util.Map;

/**
 * Created by ly on 2016/12/13.
 * 对象类型转换器
 */
public class BeanConvertorHandler implements ConvertorHandler {

    @Override
    public Object convert(Parameter parameter, ConvertorHandlerChain chain) {
        HttpServletRequest request = ActionContext.getContext().getRequest();
        Map<String, String[]> map = request.getParameterMap();
        try{
            Object instance = parameter.getType().newInstance();
            BeanUtils.populate(instance, map);
            return instance;
        }catch(Exception e){
        }
        return chain.convert(parameter);
    }
}
