package data;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;


@WebServlet("/api/aftale/*")
public class Servertest extends HttpServlet {
DB db = new DB();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] split = req.getRequestURI().split("/");

        //TODO: get id and find a user in the db
        DB conn = new DB();

        String id = split[split.length-1];

        Patient ptFromDB = null;
        try{
            ptFromDB = conn.getPatient(id);
        } catch (Exception e){
            e.printStackTrace();
        }
        //TODO: hent aftaler over
        if(ptFromDB != null){

        }
        else{

        }



        //TODO: return some xml
        XmlMapper mapper = new XmlMapper();
        String xmlString = mapper.writeValueAsString(ptFromDB);

        resp.getWriter().write(xmlString);
        resp.flushBuffer();

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

//https://www.baeldung.com/jackson-xml-serialization-and-deserialization