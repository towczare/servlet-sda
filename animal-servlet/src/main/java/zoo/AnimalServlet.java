package zoo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

public class AnimalServlet extends HttpServlet {

    public static final String TEXT_HTML = "text/html";
    private static final String TYPE = "type";
    private static final List<Animal> FISHES = new ArrayList<>();
    private static final List<Animal> REPTILES = new ArrayList<>();


    private static final Map<AnimalType, List<Animal>> ANIMALS
            = new HashMap<>();

    static {
        FISHES.add(new Animal("Gold fish", AnimalType.FISH));
        FISHES.add(new Animal("Nemo", AnimalType.FISH));
        FISHES.add(new Animal("Karp", AnimalType.FISH));
        FISHES.add(new Animal("Szczupak", AnimalType.FISH));

        REPTILES.add(new Animal("Turtle Leonardo", AnimalType.REPTILE));
        REPTILES.add(new Animal("Turtle Donatello", AnimalType.REPTILE));
        REPTILES.add(new Animal("Crocodile Jerry", AnimalType.REPTILE));

        ANIMALS.put(AnimalType.FISH, FISHES);
        ANIMALS.put(AnimalType.REPTILE, REPTILES);
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType(TEXT_HTML);

        List<Animal> animals = new ArrayList<>();
        String typeValue = request.getParameter(TYPE);
        if(typeValue != null)  {
            AnimalType animalType = AnimalType.getAnimalType(typeValue);
            System.out.println("Animal type from request " + animalType);
            animals = ANIMALS.get(animalType) != null ? ANIMALS.get(animalType) : Collections.emptyList();
        }

        response.getWriter().write(animals.toString());
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
