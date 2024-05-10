package web.handler;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.service.LoginService;


/**
 * HTTP end-point to handle login service.
 */
public class LoginServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        System.out.println("[LoginServlet] GET");

        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        System.out.println("[LoginServlet] POST");

        String username = req.getParameter("username");
        String password = req.getParameter("passwd");
        String dob = req.getParameter("dob");

        System.out.println("Username/password: " + username + ", " + password);

        String loginStatus = "fail";
        String errorMessage = null;

        try {
            if (LoginService.login(username, password, dob)) {
                loginStatus = "success";
            }
        } catch (ParseException e) {
            errorMessage = e.getMessage();
        }

        String htmlResponse = "<html>";
        htmlResponse += "<head><title>"+ loginStatus + "</title></head>";
        htmlResponse += "<h2 id=\"loginStatus\">Login status: " + loginStatus + "</h2>";
        if (errorMessage != null) {
            htmlResponse += "<h2 id=\"errorMessage\">Error: " + errorMessage + "</h2>";
        }
        htmlResponse += "</html>";

        PrintWriter writer = resp.getWriter();
        writer.println(htmlResponse);
    }


}
