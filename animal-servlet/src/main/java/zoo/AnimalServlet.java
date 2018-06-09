package zoo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AnimalServlet extends HttpServlet {

    public static final String TEXT_HTML = "text/html";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType(TEXT_HTML);
        response.getWriter().write(Animal.random().toString());
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
