package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Hero;
import dao.HeroDAO;

public class HeroListServlet extends HttpServlet {//查询，把HeroDAO中数据拼成一个table

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");

        String userName = (String) request.getSession().getAttribute("userName");
        if (null == userName) {
            response.sendRedirect("index.jsp");
            return;
        }

        int start = 0;
        int end = 5;

        try {
            start = Integer.parseInt(request.getParameter("start"));
        } catch (NumberFormatException e) {
            // 当浏览器没有传参数start时
        }

        int next = start + end;
        int pre = start - end;

        int total = new HeroDAO().getTotal();
        int last;
        // 假设总数是50，是能够被5整除的，那么最后一页的开始就是45
        if (0 == total % end)
            last = total - end;
            // 假设总数是51，不能够被5整除的，那么最后一页的开始就是50
        else
            last = total - total % end;

        //防止溢出
        pre = pre < 0 ? 0 : pre;
        next = next > last ? last : next;

        List<Hero> heros = new HeroDAO().list(start, end);


/*
        StringBuffer sb = new StringBuffer();
        sb.append("<table align='center' border='1' cellspacing='0'>\r\n");
        sb.append("<tr><td>id</td><td>name</td><td>hp</td><td>damage</td></tr>\r\n");

        String trFormat = "<tr><td>%d</td><td>%s</td><td>%f</td><td>%d</td><td><a href='deleteHero" +
                "?id=%d'>delete</a></td><td><a href='editHero?id=%d'>edit</a></td></tr>\r\n";

        for (Hero hero : heros) {
            String tr = String.format(trFormat, hero.getId(), hero.getName(), hero.getHp(), hero.getDamage(), hero.getId(), hero.getId());
            sb.append(tr);
        }

        sb.append("</table>");

        response.getWriter().write(sb.toString());
*/
        request.setAttribute("heros", heros);
        request.setAttribute("next", next);
        request.setAttribute("pre", pre);
        request.setAttribute("last", last);
        request.getRequestDispatcher("/listHero.jsp").forward(request, response);
    }
}