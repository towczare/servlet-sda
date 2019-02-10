package sda.pizza;

import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.polly.model.OutputFormat;

import java.io.IOException;
import java.io.InputStream;

public class PizzaService {

    private final PollyService pollyService;

    public PizzaService() {
        this.pollyService = new PollyService(Region.getRegion(Regions.US_EAST_1));
    }

    public void generateAudio(PizzaOrder pizzaOrder, String person) throws IOException {
        InputStream speechStream = pollyService.synthesize(pizzaOrder.toTextOrder(), OutputFormat.Mp3, person);
        pollyService.saveToFile(speechStream);
    }
}
