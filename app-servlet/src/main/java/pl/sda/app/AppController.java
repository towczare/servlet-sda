package pl.sda.app;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/"})
public class AppController extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        request.setAttribute("countryList", "'Germany': ['Duesseldorf', 'Leinfelden-Echterdingen', 'Eschborn',],\n" +
//                "        'Spain': ['Barcelona',],\n" +
//                "        'Hungary': ['Pecs',],");

        //sample taken from https://stackoverflow.com/questions/18351921/how-to-populate-a-cascading-dropdown-with-jquery
        request.setAttribute("countryList", Country.toJsArray());

        request.getRequestDispatcher("app.jsp").forward(request, response);
    }
}
