package foo.bar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class AnimalServlet extends HttpServlet {

    private static final String TEXT_PLAIN = "text/plain";
    private static final Random RANDOM = new Random();

    private static Map<AnimalType, List<Animal>> ANIMALS = new HashMap<>();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String type = request.getParameter("type");
        Animal animal = getRandomAnimal(AnimalType.of(type));
        response.setContentType(TEXT_PLAIN);
        response.getWriter().write(animal.toString());
    }

    private Animal getRandomAnimal(AnimalType animalType) {
        List<Animal> animalsOfType = ANIMALS.get(animalType);
        return animalsOfType.get(RANDOM.nextInt(animalsOfType.size()));
    }

    @Override
    public void init() throws ServletException {
        populateAnimalList();
        System.out.println("Servlet " + this.getServletName() + " has started");
    }

    private void populateAnimalList() {
        List<Animal> mammals = new ArrayList<>();
        mammals.add(new Animal("Piesek Pimpuś"));
        mammals.add(new Animal("Kot Filemon"));
        mammals.add(new Animal("Mysz Miki"));
        ANIMALS.put(AnimalType.MAMMAL, mammals);

        List<Animal> ants = new ArrayList<>();
        ants.add(new Animal("Pszczółka Maja"));
        ants.add(new Animal("Mrówka Z"));
        ANIMALS.put(AnimalType.INSECT, ants);

        List<Animal> fishes = new ArrayList<>();
        fishes.add(new Animal("Szczupak król wód"));
        fishes.add(new Animal("Rybka Nemo"));
        ANIMALS.put(AnimalType.FISH, fishes);


        List<Animal> birds = new ArrayList<>();
        birds.add(new Animal("Dzięcioł Felix"));
        birds.add(new Animal("Gołąb"));
        ANIMALS.put(AnimalType.BIRD, birds);

    }

    @Override
    public void destroy() {
        System.out.println("Servlet " + this.getServletName() + " has stopped");
    }


}
