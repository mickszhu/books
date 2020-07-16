package com.mickszhu.demo.interceptor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@ControllerAdvice
public class APIExceptionHandler {

    @ExceptionHandler(value = RuntimeException.class)
    @ResponseBody
    public Object baseErrorHandler(HttpServletRequest request, RuntimeException e) throws Exception {
        //把错误输出到日志
        //logger.error("DescribeException Handler---Host: {} invokes url: {} ERROR: {}", request.getRemoteHost(), request.getRequestURL(), e.getMessage());
        HashMap<String, String> res = new HashMap<>();
        res.put("message",e.getMessage());
        res.put("code","401");
        return res;
    }
}
