package foo.bar;

import com.sun.scenario.animation.shared.AnimationAccessor;
import org.apache.commons.lang3.RandomUtils;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AnimalServlet extends HttpServlet {

    public static final String TEXT_PLAIN = "text/plain";

    private static List<Animal> ANIMALS = new ArrayList<>();

    static {
        ANIMALS.add(new Animal("bird1", AnimalType.BIRD));
        ANIMALS.add(new Animal("bird2", AnimalType.BIRD));
        ANIMALS.add(new Animal("bird3", AnimalType.BIRD));
        ANIMALS.add(new Animal("fish1", AnimalType.FISH));
        ANIMALS.add(new Animal("fish2", AnimalType.FISH));
        ANIMALS.add(new Animal("fish3", AnimalType.FISH));
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType(TEXT_PLAIN);
        String type = request.getParameter("type");

        Optional<Animal> anyAnimal
                = ANIMALS.stream().sorted((o1, o2) -> RandomUtils.nextInt(0, 2)-1).filter(a -> a.getType().name().equals(type)).findAny();

        response.getWriter().write(anyAnimal.get().getName());
    }


}
