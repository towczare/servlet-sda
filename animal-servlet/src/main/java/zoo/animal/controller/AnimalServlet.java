package zoo.animal.controller;

import zoo.animal.model.Animal;
import zoo.animal.model.AnimalType;
import zoo.animal.service.AnimalService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(urlPatterns = {
        AnimalServlet.LIST_ACTION,
        AnimalServlet.ADD_ACTION,
        AnimalServlet.DETAILS_ACTION
})
public class AnimalServlet extends HttpServlet {

    public static final String TEXT_HTML = "text/html";
    public static final String LIST_ACTION = "/";
    public static final String ADD_ACTION = "/add";
    public static final String DETAILS_ACTION = "/details";
    public static final String ANIMALS_LIST = "animalsList";

    private AnimalService animalService;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType(TEXT_HTML);

        if(request.getServletPath().equals(ADD_ACTION)) {
            request.getRequestDispatcher("form.jsp").forward(request, response);
        } else if(request.getServletPath().equals(DETAILS_ACTION)) {
            request.getRequestDispatcher("details.jsp").forward(request, response);
        } else {
            request.setAttribute(ANIMALS_LIST, animalService.findAll());
            request.getRequestDispatcher("list.jsp").forward(request, response);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("animalName");
        animalService.add(new Animal(name, AnimalType.UNKNOWN));
        response.sendRedirect("/animal-servlet");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("Servlet " + this.getServletName() + " has started");
        animalService = new AnimalService();
    }
    @Override
    public void destroy() {
        System.out.println("Servlet " + this.getServletName() + " has stopped");
    }


}
