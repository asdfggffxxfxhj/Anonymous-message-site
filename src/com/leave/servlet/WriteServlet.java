package com.leave.servlet;

import com.leave.bean.Msg;
import com.leave.service.MsgService;
import com.leave.service.impl.MsgServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "WriteServlet", value = "/WriteServlet")
public class WriteServlet extends ViewBaseServlet {
    private Msg msg=new Msg();
    private MsgService msgService=new MsgServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf8");
        request.setCharacterEncoding("UTF-8");
        Map<String, String[]> param = new HashMap<>(request.getParameterMap());   //使用hashmao存储,进而后面可以添加数据
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   //设置日期格式
        String time = sdf.format(new Date());
        param.put("msg_time", new String[]{time}); //添加日期
        try {
            BeanUtils.populate(msg,param);
            System.out.println(msg);   //查看是否封装成功
            msgService.addMsg(msg);  //调用业务层方法，添加数据
            response.getWriter().write("<script>alert('添加留言成功！')</script>");
            processTemplate("writer",request,response); //跳转到写入界面
        } catch (Exception e) {
            response.getWriter().write("<script>alert('添加留言失败！')</script>");
            processTemplate("writer",request,response); //跳转到写入界面
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
