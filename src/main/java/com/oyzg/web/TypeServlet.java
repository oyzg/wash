package com.oyzg.web;

import com.oyzg.pojo.Member;
import com.oyzg.pojo.TypePrice;
import com.oyzg.service.TypeService;
import com.oyzg.service.impl.TypeServiceImpl;
import com.oyzg.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class TypeServlet extends BaseServlet{

    private TypeService typeService = new TypeServiceImpl();

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<TypePrice> list = typeService.findAll();
        req.setAttribute("tlist",list);
        req.getRequestDispatcher("/pages/type/type.jsp").forward(req,resp);
    }

    protected void show(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<TypePrice> list = typeService.findAll();
        req.setAttribute("tlist",list);
        req.getRequestDispatcher("/pages/type/type_manager.jsp").forward(req,resp);
    }

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = WebUtils.parseInt(req.getParameter("id"), 0);
        String name = req.getParameter("name");
        Integer price = WebUtils.parseInt(req.getParameter("price"), 0);
        TypePrice typePrice = new TypePrice(id,name,price);
        typeService.add(typePrice);
        req.getRequestDispatcher("typeServlet?action=show").forward(req,resp);
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = WebUtils.parseInt(req.getParameter("id"), 0);
        String name = req.getParameter("name");
        Integer price = WebUtils.parseInt(req.getParameter("price"), 0);
        TypePrice typePrice = new TypePrice(id,name,price);
        typeService.update(typePrice);
        resp.sendRedirect(req.getContextPath()+"/typeServlet?action=show");

    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = WebUtils.parseInt(req.getParameter("tid"), 0);
        typeService.delete(id);
        resp.sendRedirect(req.getContextPath()+"/typeServlet?action=show");
    }

    protected void getType(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = WebUtils.parseInt(req.getParameter("id"), 0);
        TypePrice type = typeService.findByid(id);
        req.setAttribute("type",type);
        req.getRequestDispatcher("/pages/type/type_edit.jsp").forward(req,resp);
    }

}
