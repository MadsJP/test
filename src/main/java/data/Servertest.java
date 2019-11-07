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
        String CPR = req.getParameter("CPR");
        String Password = req.getParameter("Password");
        //System.out.println(CPR);
        //System.out.println(Password);

        boolean validering = false;
        try {
            validering = DB.validering(CPR, Password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        //System.out.println("her kommer brugeren med cpr "+ CPR + " password " + Password);
        if(validering) {
            resp.sendRedirect("booking.jsp?cpr="+ CPR);
        }
        else {
            resp.sendRedirect("login.jsp");
        }
    }
}