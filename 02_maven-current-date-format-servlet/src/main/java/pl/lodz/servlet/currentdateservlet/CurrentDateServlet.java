package pl.lodz.servlet.currentdateservlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentDateServlet extends HttpServlet {

    public static final String DEFAULT_DATE_FORMAT = "MM/dd/yyyy HH:mm:ss";
    public static final String TEXT_PLAIN = "text/plain";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType(TEXT_PLAIN);
        String format = request.getParameter("format");
        DateFormat df = new SimpleDateFormat(format != null ? format : DEFAULT_DATE_FORMAT);

        response.getWriter().write(df.format(new Date()));
    }

    @Override
    public void init() throws ServletException {
        System.out.println("Servlet " + this.getServletName() + " has started");
    }
    @Override
    public void destroy() {
        System.out.println("Servlet " + this.getServletName() + " has stopped");
    }


}
