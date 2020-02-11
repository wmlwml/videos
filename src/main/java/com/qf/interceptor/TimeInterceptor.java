package com.qf.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @auth wangbo
 * @date 2020/1/2 11:50
 */
public class TimeInterceptor implements HandlerInterceptor{
    //记录一下访问的时间
    private long  beginTime ;
    @Override
    //请求到之后进行拦截， true 放行， false 不是不再继续访问了
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("prehandele");
       beginTime = System.currentTimeMillis();
        return true;
    }

    //访问了资源，。页面渲染之前执行这个方法
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("posthandle");
    }
    //页面渲染了
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("after");
        long endTime = System.currentTimeMillis();
        long v = endTime - beginTime;
        System.out.println(v);

    }
}
