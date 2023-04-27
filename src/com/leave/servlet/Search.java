package com.leave.servlet;

import com.leave.bean.Msg;
import com.leave.service.MsgService;
import com.leave.service.impl.MsgServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Search", value = "/Search")
public class Search extends ViewBaseServlet {
    private MsgService msgService=new MsgServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf8");
        request.setCharacterEncoding("utf-8");
        String msg_name=request.getParameter("msg_name");   //获取请求参数
        if (msg_name.equals(null)) {   //如果查询的暗号为空，则不进行下面的操作
            response.getWriter().write("暗号不能为空！");
            processTemplate("search",request,response);
        }else {
            try {
                List<Msg> msgs=msgService.findMsg(msg_name);
                System.out.println(msgs);
                request.setAttribute("msg",msgs);
                processTemplate("search",request,response);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
