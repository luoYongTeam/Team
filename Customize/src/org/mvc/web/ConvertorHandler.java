package org.mvc.web;



import org.mvc.convertor.ConvertorHandlerChain;

import java.lang.reflect.Parameter;

/**
 * Created by ly on 2016/12/13.
 * 抽象的类型转换器
 */
public interface ConvertorHandler {

    public Object convert(Parameter parameter, ConvertorHandlerChain chain);
}
