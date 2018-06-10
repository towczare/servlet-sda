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
    public static final String ANIMAL_ID = "animalId";

    private AnimalService animalService;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType(TEXT_HTML);

        if(request.getServletPath().equals(ADD_ACTION)) {
            animalForm(request, response);
        } else if(request.getServletPath().equals(DETAILS_ACTION)) {
            animaDetails(request, response);
        } else {
            animalList(request, response);
        }
    }

    private void animalForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("animalTypes", AnimalType.getAvailableTypesForUser());

        request.getRequestDispatcher("form.jsp").forward(request, response);
    }

    private void animalList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute(ANIMALS_LIST, animalService.findAll());
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }

    private void animaDetails(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String paramId = request.getParameter(ANIMAL_ID);
        if (paramId == null || paramId.equals("")) {
            response.sendRedirect("/animal-servlet");
        } else {
            request.setAttribute("animalDetails", animalService.findOne(Integer.valueOf(paramId)));
            request.getRequestDispatcher("details.jsp").forward(request, response);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("animalName");
        String url = request.getParameter("animalUrl");
        String description = request.getParameter("animalDescription");
        String age = request.getParameter("animalAge");
        String animalType = request.getParameter("animalType");

        animalService.add(new Animal(AnimalService.CURRENT_INDEX++, name, Integer.valueOf(age), url, description, AnimalType.valueOf(animalType)));
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
