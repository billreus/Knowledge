import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        String password = request.getParameter("password");
        System.out.println("name:" + name);

        String html = null;

        if ("admin".equals(name) && "123".equals(password))
            //html = "<div style='color:green'>登录成功</div>";
            //服务器端跳转，直接吧html发送给了浏览器
            request.getRequestDispatcher("success.html").forward(request, response);
        else
            //客户端跳转，服务器发送特殊消息给浏览器，让浏览器访问html；
            // 浏览器发送请求，服务器端再把内容发给浏览器
            response.sendRedirect("fail.jsp");
            //request.getRequestDispatcher("fail.jsp").forward(request, response);
        response.setContentType("text/html;charset=UTF-8"); //输出时中文编码
        PrintWriter pw = response.getWriter();
        pw.println(html);
    }
}