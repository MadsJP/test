package data;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/servertest")
public class Servertest extends HttpServlet {
DB db = new DB();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("Farvel" + req.getRequestURI());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cpr = req.getParameter("CPRnummer");
        String password = req.getParameter("password");
        //System.out.println("post metode bliver anvendt");
        boolean youarein=false;
        try {
            youarein= DB.validering(cpr,password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("her kommer cpr "+cpr);
        if(youarein) {
            resp.sendRedirect("booking.jsp");
        }else if(youarein){
            resp.sendRedirect("index.jsp");
        }
    }
}