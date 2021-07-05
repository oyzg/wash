package com.oyzg.web;

import com.oyzg.pojo.Assistant;
import com.oyzg.pojo.Clothes;
import com.oyzg.pojo.Member;
import com.oyzg.pojo.TypePrice;
import com.oyzg.service.AssistantService;
import com.oyzg.service.ClothesService;
import com.oyzg.service.TypeService;
import com.oyzg.service.impl.AssistantServiceImpl;
import com.oyzg.service.impl.ClothesServiceImpl;
import com.oyzg.service.impl.TypeServiceImpl;
import com.oyzg.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AssistantServlet extends BaseServlet{

    private AssistantService assistantService = new AssistantServiceImpl();
    private ClothesService clothesService = new ClothesServiceImpl();
    private TypeService typeService = new TypeServiceImpl();

    //登录
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mname = (String) req.getSession().getAttribute("aname");
        String password = (String) req.getSession().getAttribute("password");
        Assistant assistant = assistantService.login(new Assistant(mname, password));
        System.out.println(assistant);
        if(assistant == null) {
            req.setAttribute("msg","用户名或密码错误！");
            req.setAttribute("mname",mname);
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        } else {
            req.getSession().setAttribute("assistant", assistant);
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }
    }

    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        resp.sendRedirect(req.getContextPath());
    }

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Assistant> alist = assistantService.findAll();
        req.setAttribute("alist",alist);
        req.getRequestDispatcher("/pages/assistant/assistant.jsp").forward(req,resp);
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = WebUtils.parseInt(req.getParameter("id"), 0);
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        Assistant assistant = new Assistant(id, name, password);
        assistantService.update(assistant);
//        req.getRequestDispatcher("assistantServlet?action=list").forward(req,resp);
        resp.sendRedirect(req.getContextPath()+"/assistantServlet?action=list");
    }

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = WebUtils.parseInt(req.getParameter("id"), 0);
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        Assistant assistant = new Assistant(id, name, password);
        assistantService.add(assistant);
        req.getRequestDispatcher("assistantServlet?action=list").forward(req,resp);
    }

    protected void getAssistant(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = WebUtils.parseInt(req.getParameter("id"), 0);
        Assistant assistant = assistantService.findByid(id);
        req.setAttribute("assistant",assistant);
        req.getRequestDispatcher("/pages/assistant/assistant_edit.jsp").forward(req,resp);
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = WebUtils.parseInt(req.getParameter("aid"), 0);
        assistantService.delete(id);
        resp.sendRedirect(req.getContextPath()+"/assistantServlet?action=list");
    }

    protected void findById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = WebUtils.parseInt(req.getParameter("id"), 0);
        Assistant assistant = assistantService.findByid(id);
        List<Clothes> list = clothesService.findByAId(assistant);
        Integer sum = 0;
        for (Clothes clothes : list) {
            Integer tid = clothes.getTid();
            TypePrice typePrice = typeService.findByid(tid);
            sum += (clothes.getCcount()*typePrice.getUnitprice());
        }
        req.setAttribute("sum",sum);
        req.setAttribute("id",id);

        List<Assistant> alist = new ArrayList<>();
        alist.add(assistant);
        req.setAttribute("alist",alist);
        req.getRequestDispatcher("/pages/assistant/assistant.jsp").forward(req,resp);
    }





}
