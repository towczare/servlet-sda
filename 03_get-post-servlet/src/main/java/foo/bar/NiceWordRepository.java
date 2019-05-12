package foo.bar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NiceWordRepository {

    private static List<String> niceWordCollection = new ArrayList<>();
    private static final Random RANDOM = new Random();

    static {
        niceWordCollection.add("BEAUTIFUL");
        niceWordCollection.add("CHEERFUL");
        niceWordCollection.add("DESIRE");
        niceWordCollection.add("ENERGETIC");
        niceWordCollection.add("FLOURISH");
        niceWordCollection.add("GROOVY");
        niceWordCollection.add("HELPFULNESS");
    }

    public static List<String> findAll() {
        return niceWordCollection;
    }

    public static String getRandom() {
        int size = niceWordCollection.size();
        return niceWordCollection.get(RANDOM.nextInt(size));
    }

    public static void add(String word) {
        if(word != null) {
            niceWordCollection.add(word);
        }
    }
}