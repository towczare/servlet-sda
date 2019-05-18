package foo.bar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "mvc-jsp-servlet", urlPatterns = {"/", "/add"})
public class MvcJspServlet extends HttpServlet {

    static final String TEXT_HTML = "text/html";

    static List<String> greetingList = new ArrayList<>();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType(TEXT_HTML);

        if(request.getServletPath().equals("/add")) {
            request.getRequestDispatcher("add.jsp").forward(request, response);
        } else {
            request.setAttribute("greetingList", greetingList); // Available as ${greetingList} in the request scope
            request.getRequestDispatcher("hello.jsp").forward(request, response);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        System.out.printf(name);
        greetingList.add(name);
        response.sendRedirect("/mvc-jsp-servlet");
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
