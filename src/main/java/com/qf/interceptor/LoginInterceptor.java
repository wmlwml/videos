package com.qf.interceptor;

import com.qf.entity.Admin;
import com.qf.entity.User;
import com.qf.util.StrUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @auth wangbo
 * @date 2020/1/2 14:24
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        try{

            String uri = request.getRequestURI();
            Admin admin = (Admin)request.getSession().getAttribute(StrUtils.LOGIN_USER);
            User user = (User)request.getSession().getAttribute(StrUtils.con_sumer);

            if (user == null && admin == null) {//暂时还没有登录
                //jquery 发送ajax请求的时候，会有一个特殊的请求头
                String value = request.getHeader("X-Requested-With");
//            if (value != null && value.equals("XMLHttpRequest")) {//证明你是一个ajax请求
////                response.getWriter().write("{'code':1, 'info':'未登录'}");
//                return true;
//            } else {
//                //现在是一个非ajax的请求，直接重定向到登录页面
//                response.sendRedirect(request.getContextPath()+ "/pageAdmin/login.html");
//            }
//            return false;
                if (value != null && value.equals("XMLHttpRequest")) {//证明你是一个ajax请求
                    return true;
                } else {
                    //现在是一个非ajax的请求，直接重定向到登录页面
//                response.sendRedirect(request.getContextPath()+ "/pageAdmin/login.html");
                    response.sendRedirect(request.getContextPath()+ "/before/index.html");
                }
                return false;

            } else {
//              request.getRequestDispatcher(request.getContextPath()+ "/before/index.html");
                return true;

            }
        } catch (Exception e) {
            return true;
        }


    }
}
