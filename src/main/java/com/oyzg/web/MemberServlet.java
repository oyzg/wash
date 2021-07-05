package com.oyzg.web;

import com.google.gson.Gson;
import com.oyzg.pojo.Member;
import com.oyzg.service.MemberService;
import com.oyzg.service.impl.MemberServiceImpl;
import com.oyzg.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

public class MemberServlet extends BaseServlet {

    private MemberService memberService = new MemberServiceImpl();

    protected void ajaxExistsMname(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mname = req.getParameter("mname");
        boolean existsMname = memberService.existsMname(mname);
        Map<String,Object> map = new HashMap<>();
        map.put("existMname",existsMname);
        Gson gson = new Gson();
        String json = gson.toJson(map);
        resp.getWriter().write(json);
    }

    //注销
    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        resp.sendRedirect(req.getContextPath());
    }

    //登录
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
        //System.out.println(type);
        String mname = req.getParameter("mname");
        String password = req.getParameter("password");
        if(type.equals("店员")) {
            req.getSession().setAttribute("aname",mname);
            req.getSession().setAttribute("password",password);
            resp.sendRedirect("assistantServlet?action=login");
            return ;
        }
        Member member = memberService.login(new Member(mname, password));
        if(member == null) {
            req.setAttribute("msg","用户名或密码错误！");
            req.setAttribute("mname",mname);
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        } else {
            req.getSession().setAttribute("member", member);
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }
    }

    //注册
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取Session中的验证码
        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        //删除Session中的验证码
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);

        //获取请求的参数
        String mname = req.getParameter("mname");
        String password = req.getParameter("password");
        String code = req.getParameter("code");
        String phone = req.getParameter("phone");

        Member member = WebUtils.copyParamToBean(req.getParameterMap(),new Member());

        //检查 检验码是否正确
        if(token != null && token.equalsIgnoreCase(code)) {
            if(memberService.existsMname(mname)) {
                //保存回显信息到request中
                req.setAttribute("msg","用户名已存在！");
                req.setAttribute("username",mname);
                req.setAttribute("phone",phone);
                System.out.println("用户名已存在！");
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
            } else {
                memberService.registMember(new Member(null,mname,0,0,password));
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req,resp);
            }
        } else {
            //保存回显信息到request中
            req.setAttribute("msg","验证码错误！");
            req.setAttribute("username",mname);
            req.setAttribute("phone",phone);
            System.out.println("验证码错误，请重新输入！");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
        }
    }

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Member> list = memberService.findAll();
        req.setAttribute("mlist",list);
        req.getRequestDispatcher("/pages/member/member.jsp").forward(req,resp);
    }

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = WebUtils.parseInt(req.getParameter("id"), 0);
        String mname = req.getParameter("name");
        Integer grade = WebUtils.parseInt(req.getParameter("grade"), 0);
        Integer balance = WebUtils.parseInt(req.getParameter("balance"), 0);
        String password = req.getParameter("password");
        Member member = new Member(id, mname, grade, balance, password);
        memberService.add(member);
        req.getRequestDispatcher("memberServlet?action=list").forward(req,resp);
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = WebUtils.parseInt(req.getParameter("id"), 0);
        String mname = req.getParameter("name");
        Integer grade = WebUtils.parseInt(req.getParameter("grade"),0);
        Integer balance = WebUtils.parseInt(req.getParameter("balance"), 0);
        String password = req.getParameter("password");
        Member member = new Member(id, mname, grade, balance, password);
        memberService.update(member);
        resp.sendRedirect(req.getContextPath()+"/memberServlet?action=list");

    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = WebUtils.parseInt(req.getParameter("id"), 0);
        memberService.delete(id);
        resp.sendRedirect(req.getContextPath()+"/memberServlet?action=list");
    }

    protected void getMember(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = WebUtils.parseInt(req.getParameter("id"), 0);
        Member member = memberService.findById(id);
        req.setAttribute("member",member);
        req.getRequestDispatcher("/pages/member/member_edit.jsp").forward(req,resp);
    }

    protected void recharge(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer money = WebUtils.parseInt(req.getParameter("money"), 0);
        Member member = (Member) req.getSession().getAttribute("member");
        Integer id = member.getMid();
        memberService.recharge(id, money);
        resp.sendRedirect(req.getContextPath()+"/memberServlet?action=findById&id="+id);
    }

    protected void findById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = WebUtils.parseInt(req.getParameter("id"), 0);
        Member member = memberService.findById(id);
        List<Member> list = new ArrayList<>();
        list.add(member);
        req.setAttribute("mlist",list);
        req.getRequestDispatcher("/pages/member/MyInfo.jsp").forward(req,resp);
    }



}
