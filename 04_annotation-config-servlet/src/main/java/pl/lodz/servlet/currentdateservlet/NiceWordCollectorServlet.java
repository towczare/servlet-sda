package pl.lodz.servlet.currentdateservlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@WebServlet(urlPatterns = {"/", "/random"})
public class NiceWordCollectorServlet extends HttpServlet {

    public static final String TEXT_PLAIN = "text/plain";
    private static final Random RANDOM = new Random();

    public static List<String> niceWordCollection = new ArrayList<>();

    static {
        niceWordCollection.add("BEAUTIFUL");
        niceWordCollection.add("CHEERFUL");
        niceWordCollection.add("DESIRE");
        niceWordCollection.add("ENERGETIC");
        niceWordCollection.add("FLOURISH");
        niceWordCollection.add("GROOVY");
        niceWordCollection.add("HELPFULNESS");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType(TEXT_PLAIN);

        if(request.getServletPath().equals("/random")) {
            randomNiceWord(response);
        } else {
            response.getWriter().write(
                    String.join(", ", niceWordCollection));
        }

    }

    private void randomNiceWord(HttpServletResponse response) throws IOException {
        int size = niceWordCollection.size();

        response.getWriter().write(
                niceWordCollection.get(RANDOM.nextInt(size)));
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String word = request.getParameter("word");
        niceWordCollection.add(word);
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
