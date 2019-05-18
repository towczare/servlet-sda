package foo.bar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet(urlPatterns = {"/", "/random", "/add", "/animal"}, displayName = "Animal Servlet")
public class AnimalServlet extends HttpServlet {

    private static final String TEXT_PLAIN = "text/plain";
    private AnimalService animalsService;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String type = request.getParameter("type");
        response.setContentType(TEXT_PLAIN);

        if(isRoute(request, "/random")) {
            Animal animal = animalsService.getRandomAnimal(AnimalType.of(type));
            response.getWriter().write(animal.toString());
        } else if(isRoute(request, "/add")) {
            request.getRequestDispatcher("animal-form.jsp").forward(request, response);
        } else if(isRoute(request, "/animal")) {
            String animalId = request.getParameter("animalId");
            if (animalId == null) {
                response.sendRedirect("/animal-servlet");
            } else {
                Animal animal = animalsService.getAnimal(animalId);
                if (animal == null) {
                    response.sendRedirect("/animal-servlet");
                } else {
                    request.setAttribute("animalId", animalId);
                    request.setAttribute("animalDetails", animal);
                    request.getRequestDispatcher("animal-details.jsp").forward(request, response);
                }
            }
        } else {
            List<Animal> animals = animalsService.findAll();
            request.setAttribute("animals", animals);
            request.getRequestDispatcher("animal-list.jsp").forward(request, response);
        }
    }

    private boolean isRoute(HttpServletRequest request, String urlPattern) {
        return request.getServletPath().equals(urlPattern);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String animalName = request.getParameter("animalName");
        String animalType = request.getParameter("animalType");

        if(animalType == null || animalName == null) {
            response.sendRedirect("/animal-servlet");
        } else {
            animalsService.add(animalName, AnimalType.of(animalType));
            response.sendRedirect("/animal-servlet");
        }
    }

    @Override
    public void init() throws ServletException {
        animalsService = new AnimalService();
        System.out.println("Servlet " + this.getServletName() + " has started");
    }

    @Override
    public void destroy() {
        System.out.println("Servlet " + this.getServletName() + " has stopped");
    }

}
