package org.mvc.convertor;





import org.mvc.web.ConvertorHandler;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by ly on 2016/12/13.
 */
public class ConvertorHandlerChain {

    private static List<ConvertorHandler> list = new ArrayList<>();
    private Iterator<ConvertorHandler> iterator;

    static {
        list.add(new BasicConvertorHandler());
        list.add(new BeanConvertorHandler());
        list.add(new ServletAPIConvertorHandler());
    }

    /**
     *
     * @param method 当前要映射参数的方法
     * @return
     */
    public Object[] execute(Method method){
        //获取当前方法所有的参数
        Parameter[] params = method.getParameters();
        //Object数组用于存放转换后的值
        Object[] values = new Object[params.length];
        //循环遍历参数
        for(int i=0; i<values.length; i++){
            //每映射完一个参数，重新初始化迭代器
            iterator = list.iterator();
            values[i] = convert(params[i]);
        }
        return values;
    }

    //执行类型转换（责任链模式）
    Object convert(Parameter parameter){
        if(iterator.hasNext()){
            ConvertorHandler handler = iterator.next();
            return handler.convert(parameter, this);
        }
        return null;
    }
}
