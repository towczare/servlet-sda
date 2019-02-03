package foo.bar;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AnimalServlet extends HttpServlet {

    public static final String TEXT_PLAIN = "text/plain";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType(TEXT_PLAIN);
        response.getWriter().write("DOG");
    }


}
