package com.oyzg.filter;

import com.oyzg.pojo.Assistant;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class ManagerFilter2 implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        Assistant user = (Assistant) httpServletRequest.getSession().getAttribute("assistant");
        if (user == null) {
            httpServletRequest.getRequestDispatcher("/pages/user/login.jsp").forward(servletRequest,servletResponse);
            return ;
        } else {
            if(user.getAid() != 1) {
                httpServletRequest.getRequestDispatcher("/pages/user/login.jsp").forward(servletRequest,servletResponse);
                return ;
            }
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

}
