package com.halen.springboot.component;

import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;

import java.util.Map;

/**
 * Created By Halen 2020/5/8 17:52
 * 给容器中加入我们自己定义的ErrorAttributes
 */
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(RequestAttributes requestAttributes, boolean includeStackTrace) {
        Map<String, Object> map = super.getErrorAttributes(requestAttributes, includeStackTrace);
        map.put("company", "halen");
        Map<String, Object> ext = (Map<String, Object>) requestAttributes.getAttribute("ext", 0);
        map.put("ext", ext);
        return map;
    }
}
