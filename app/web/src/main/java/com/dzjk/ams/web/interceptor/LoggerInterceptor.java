package com.dzjk.ams.web.interceptor;

import com.dzjk.ams.core.common.util.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * Created by daixiaohu on 2018/3/30.
 */
public class LoggerInterceptor implements HandlerInterceptor {
    private final static String SESSION_TOKEN_KEY = "sessionTokenId";

    private static final transient Logger logger = LoggerFactory.getLogger(LoggerInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        // 放SessionId
        String token ="ams-thread-"+String.valueOf(System.currentTimeMillis())+ UUID.randomUUID().toString().substring(0,6);
        MDC. put(SESSION_TOKEN_KEY, token);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        // 最后执行MDC删除
        MDC. remove(SESSION_TOKEN_KEY);
    }
}
