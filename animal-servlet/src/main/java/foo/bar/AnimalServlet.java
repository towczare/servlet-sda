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
    private static final String ANIMAL_ID = "animalId";
    private static final String ANIMAL_TYPES = "animalTypes";
    private static final String VIEW_HEADER = "viewHeader";
    private static final String ACTION = "action";


    private AnimalService animalsService;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType(TEXT_PLAIN);

        if(isRoute(request, "/random")) {
            random(request, response);
        } else if(isRoute(request, "/add")) {
            add(request, response);
        } else if(isRoute(request, "/edit")) {
            edit(request, response);
        } else if(isRoute(request, "/animal")) {
            details(request, response);
        } else {
            list(request, response);
        }
    }

    private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Animal> animals = animalsService.findAll();
        request.setAttribute("animals", animals);
        request.setAttribute(VIEW_HEADER, "List of Animals");
        request.getRequestDispatcher("animal-list.jsp").forward(request, response);
    }

    private void details(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String animalId = request.getParameter(ANIMAL_ID);
        if (animalId == null) {
            response.sendRedirect("/animal-servlet");
        } else {
            Animal animal = animalsService.getAnimal(animalId);
            if (animal == null) {
                response.sendRedirect("/animal-servlet");
            } else {
                request.setAttribute(ANIMAL_ID, animalId);
                request.setAttribute("animalDetails", animal);
                request.setAttribute(VIEW_HEADER, "Details of Animal");
                request.getRequestDispatcher("animal-details.jsp").forward(request, response);
            }
        }
    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String animalId = request.getParameter(ANIMAL_ID);
        Animal animal = animalsService.getAnimal(animalId);
        if (animal == null) {
            response.sendRedirect("/animal-servlet");
        } else {
            request.setAttribute(ANIMAL_TYPES, AnimalType.values());
            request.setAttribute("animalFormData", animal);
            request.setAttribute(VIEW_HEADER, "Edit Animal");
            request.setAttribute(ACTION, "edit");
            request.getRequestDispatcher("animal-form.jsp").forward(request, response);
        }
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute(ANIMAL_TYPES, AnimalType.values());
        request.setAttribute(VIEW_HEADER, "Add Animal");
        request.setAttribute(ACTION, "add");
        request.getRequestDispatcher("animal-form.jsp").forward(request, response);
    }

    private void random(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String type = request.getParameter("type");
        Animal animal = animalsService.getRandomAnimal(AnimalType.of(type));
        response.getWriter().write(animal.toString());
    }

    private boolean isRoute(HttpServletRequest request, String urlPattern) {
        return request.getServletPath().equals(urlPattern);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String animalId = request.getParameter(ANIMAL_ID);
        String animalName = request.getParameter("animalName");
        String animalType = request.getParameter("animalType");
        if (animalId != null) {
            //edycja
            Animal updatedAnimal = new Animal(Long.valueOf(animalId), animalName, AnimalType.of(animalType));
            animalsService.update(updatedAnimal);
        } else {
            // dodawanie
            if (animalType == null || animalName == null) {
            } else {
                animalsService.add(animalName, AnimalType.of(animalType));
            }
        }
        response.sendRedirect("/animal-servlet");
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
