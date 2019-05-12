package foo.bar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@WebServlet(urlPatterns = {"/", "/random"}, displayName = "Animal Servlet")
public class AnimalServlet extends HttpServlet {

    private static final String TEXT_PLAIN = "text/plain";
    private AnimalService animalsService;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String type = request.getParameter("type");
        response.setContentType(TEXT_PLAIN);

        if(request.getServletPath().equals("/random")) {
            Animal animal = animalsService.getRandomAnimal(AnimalType.of(type));
            response.getWriter().write(animal.toString());
        } else {
            List<Animal> animals = animalsService.findAll();
            response.getWriter().write(String.join(", ", animals.toString()));
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String animalName = request.getParameter("animalName");
        String animalType = request.getParameter("animalType");

        if(animalType == null || animalName == null) {
            response.sendRedirect("/animal-servlet");
        } else {
            animalsService.add(animalType, new Animal(animalName));
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
