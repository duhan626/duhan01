package com.shujuniu.web.interceptor;


import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;


@Component
public class JsonpHandlerInterceptor implements HandlerInterceptor {

    private static Logger logger = LoggerFactory.getLogger(JsonpHandlerInterceptor.class);
    public static final String CALLBACK_FUNCTION_NAME = "callback";
    public static final String DEMO_PARAM = "demo";
    public static final String JSONP_FLAG = "jsonpFlag";
    public static final String CHARACTER_UTF8 = "UTF-8";
    public static final String CONTENT_TYPE_JSON = "application/json;charset=utf8";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        String callback = request.getParameter(CALLBACK_FUNCTION_NAME);
        if (StringUtils.isNotBlank(callback)) {
            response.setCharacterEncoding(CHARACTER_UTF8);
            response.setContentType(CONTENT_TYPE_JSON);
            write(response, callback + "(");
            request.setAttribute(JSONP_FLAG, true);
        } else {
            request.setAttribute(JSONP_FLAG, false);
        }

        return true;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        boolean jsonpFlag = (Boolean)request.getAttribute(JSONP_FLAG);
        if (jsonpFlag) {
            write(response, ")");
        }
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }


    /**
     * 写入信息
     * @param response
     * @param value
     * @throws IOException
     */
    private void write(HttpServletResponse response, String value){
        try {
            OutputStream os = response.getOutputStream();
            os.write(value.getBytes());
            os.flush();
        }catch (Exception ex){
            logger.error("response写入异常" +ExceptionUtils.getFullStackTrace(ex));
        }
    }


}
