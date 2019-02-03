package foo.bar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NiceWordCollectorServlet extends HttpServlet {

    private static final String TEXT_PLAIN = "text/plain";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType(TEXT_PLAIN);

        if(request.getServletPath().equals("/random")) {
            response.getWriter().write(NiceWordRepository.getRandom());
        } else {
            response.getWriter().write(String.join(", ", NiceWordRepository.findAll()));
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String word = request.getParameter("word");
        NiceWordRepository.add(word);
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
