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
            html = "<div style='color:green'>登录成功</div>";
        else
            html = "<div style='color:red'>登陆失败</div>";
        response.setContentType("text/html;charset=UTF-8"); //输出时中文编码
        PrintWriter pw = response.getWriter();
        pw.println(html);
    }
}