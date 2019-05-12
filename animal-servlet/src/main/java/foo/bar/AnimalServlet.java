package foo.bar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class AnimalServlet extends HttpServlet {

    private static final String TEXT_PLAIN = "text/plain";
    private static final Random RANDOM = new Random();

    private static List<Animal> ANIMALS = new ArrayList<>();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Animal animal = getRandomAnimal();
        response.setContentType(TEXT_PLAIN);
        response.getWriter().write(animal.toString());
    }

    private Animal getRandomAnimal() {
        return ANIMALS.get(RANDOM.nextInt(ANIMALS.size()));
    }

    @Override
    public void init() throws ServletException {
        populateAnimalList();
        System.out.println("Servlet " + this.getServletName() + " has started");
    }

    private void populateAnimalList() {
        ANIMALS.add(new Animal("Piesek Pimpuś"));
        ANIMALS.add(new Animal("Kot Filemon"));
        ANIMALS.add(new Animal("Mysz Miki"));
    }

    @Override
    public void destroy() {
        System.out.println("Servlet " + this.getServletName() + " has stopped");
    }


}
