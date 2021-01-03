package cn.itclass.web.servlet;

import cn.itclass.dao.UserDao;
import cn.itclass.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //设置编码
        req.setCharacterEncoding("utf-8");
        //获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        HttpSession session = req.getSession();

        //封装user对象
        User loginUser = new User();
        loginUser.setUsername(username);
        loginUser.setPassword(password);
        //调用UserDao的login方法
        UserDao dao = new UserDao();
        User user = dao.login(loginUser);
        //判断user

        if (user.getUsername().equals(username) && user.getPassword().equals(password)){
            //登录成功 储存数据
            session.setAttribute("user", user);
           resp.sendRedirect(req.getContextPath()+"/success.jsp");
        }else{
            //登录失败
           req.setAttribute("login_error", "用户名或密码错误");
           req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
//        if(user == null){
//            //登录失败
//            req.setAttribute("login_error", "用户名或密码错误");
//            req.getRequestDispatcher("/login.jsp").forward(req,resp);
//        }else{
//            //登录成功 储存数据
//            session.setAttribute("user", user);
//           resp.sendRedirect(req.getContextPath()+"/success.jsp");
//
//        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
