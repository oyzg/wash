package com.oyzg.web;

import com.oyzg.pojo.Clothes;
import com.oyzg.pojo.Member;
import com.oyzg.pojo.TypePrice;
import com.oyzg.service.ClothesService;
import com.oyzg.service.TypeService;
import com.oyzg.service.impl.ClothesServiceImpl;
import com.oyzg.service.impl.TypeServiceImpl;
import com.oyzg.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClothesServlet extends BaseServlet{

    private ClothesService clothesService = new ClothesServiceImpl();
    private TypeService typeService = new TypeServiceImpl();

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Clothes> list = clothesService.queryAll();
        req.setAttribute("clist",list);
        req.getRequestDispatcher("/pages/clothes/clothes_manager.jsp").forward(req,resp);
    }

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer cid = WebUtils.parseInt(req.getParameter("id"), 0);
        Integer count = WebUtils.parseInt(req.getParameter("count"), 0);
        Integer mid = WebUtils.parseInt(req.getParameter("mid"), 0);
        Integer aid = WebUtils.parseInt(req.getParameter("aid"), 0);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        /*Date date = null;
        try {
            date = sdf.parse(req.getParameter("date"));
        } catch (ParseException e) {
            e.printStackTrace();
        }*/
        String date = req.getParameter("date");
        Integer tid = WebUtils.parseInt(req.getParameter("tid"), 0);
        Clothes clothes = new Clothes(cid,count,mid,aid,date,tid);
        clothesService.add(clothes);
        Member member = (Member) req.getSession().getAttribute("member");
        if(member == null) {
            req.getRequestDispatcher("clothesServlet?action=list").forward(req,resp);
        } else {
            req.getRequestDispatcher("clothesServlet?action=findByMid&mid="+member.getMid()).forward(req,resp);
        }

    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer cid = WebUtils.parseInt(req.getParameter("id"), 0);
        Integer count = WebUtils.parseInt(req.getParameter("count"), 0);
        Integer mid = WebUtils.parseInt(req.getParameter("mid"), 0);
        Integer aid = WebUtils.parseInt(req.getParameter("aid"), 0);
        /*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse(req.getParameter("date"));
        } catch (ParseException e) {
            e.printStackTrace();
        }*/
        String date = req.getParameter("date");
        Integer tid = WebUtils.parseInt(req.getParameter("tid"), 0);
        Clothes clothes = new Clothes(cid,count,mid,aid,date,tid);
        clothesService.update(clothes);
        resp.sendRedirect(req.getContextPath()+"/clothesServlet?action=list");

    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer cid = WebUtils.parseInt(req.getParameter("cid"), 0);
        clothesService.delete(cid);
        resp.sendRedirect(req.getContextPath()+"/clothesServlet?action=list");
    }

    protected void getClothes(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer cid = WebUtils.parseInt(req.getParameter("cid"), 0);
        Clothes clothes = clothesService.findByCId(cid);
        req.setAttribute("clothes",clothes);
        req.getRequestDispatcher("/pages/clothes/clothes_edit.jsp").forward(req,resp);
    }

    protected void findByMid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer mid = WebUtils.parseInt(req.getParameter("mid"), 0);
        List<Clothes> bymlist = clothesService.findByMId(mid);
        req.setAttribute("bymlist",bymlist);
        req.getRequestDispatcher("/pages/clothes/clothes.jsp").forward(req,resp);
    }

    protected void settle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Member member = (Member) req.getSession().getAttribute("member");
        Integer mid = member.getMid();
        List<Clothes> list = clothesService.findByMId(mid);
        req.setAttribute("bymlist",list);
        Integer totalPrice = 0;
        for (Clothes clothes : list) {
            Integer tid = clothes.getTid();
            TypePrice typePrice = typeService.findByid(tid);
            totalPrice += clothes.getCcount()*typePrice.getUnitprice();
        }
        totalPrice *= (10 - member.getGrade());
        totalPrice /= 10;
        req.setAttribute("totalPrice",totalPrice);
        req.getRequestDispatcher("/pages/clothes/settle.jsp").forward(req,resp);
    }

    protected void findByDate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String date = req.getParameter("date");
        List<Clothes> clist = clothesService.findByDate(date);
        Integer sum = 0;
        for ( Clothes clothes : clist) {
            Integer tid = clothes.getTid();
            TypePrice typePrice = typeService.findByid(tid);
            sum += (clothes.getCcount()*typePrice.getUnitprice());
        }
        req.setAttribute("sum",sum);
        req.setAttribute("date",date);
        req.setAttribute("clist",clist);
        req.getRequestDispatcher("/pages/clothes/clothes_manager.jsp").forward(req,resp);
    }

}
