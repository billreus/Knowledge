package servlet;

import dao.HeroDAO;
import bean.Hero;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HeroUpdateServlet extends HttpServlet{//更改edit编辑页面的数据

    protected void service(HttpServletRequest request, HttpServletResponse response)
        throws ServletException,IOException{

        request.setCharacterEncoding("UTF-8");

        Hero hero = new Hero();

        hero.setId(Integer.parseInt(request.getParameter("id")));
        hero.setName(request.getParameter("name"));
        hero.setHp(Float.parseFloat(request.getParameter("hp")));
        hero.setDamage(Integer.parseInt(request.getParameter("damage")));

        new HeroDAO().update(hero);

        response.sendRedirect("/servelt_sql/listHero");
    }
}
