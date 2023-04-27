package com.leave.servlet;

import com.leave.service.MsgService;
import com.leave.service.impl.MsgServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LeaveServlet", value = "/LeaveServlet")
public class LeaveServlet extends ViewBaseServlet {
    private MsgService msgService=new MsgServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //获取req的值
        String req=request.getParameter("req");
        System.out.println(req);
        if (req == null) {
            response.sendRedirect(request.getContextPath()+"/index");
        } else if (req.equals("write")) {
            toWrite(request,response);
        } else if (req.equals("search")) {
            toSearch(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response );
    }
    //跳转到写留言界面
public void toWrite(HttpServletRequest request,HttpServletResponse response) throws IOException {
        processTemplate("writer",request,response);
}
//跳转到查询留言界面
    public void toSearch(HttpServletRequest request,HttpServletResponse response) throws IOException {
        processTemplate("search",request,response);
    }
}
