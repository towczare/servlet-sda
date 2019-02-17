package sda.pizza;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

@WebServlet(urlPatterns = {
        PizzaServlet.PIZZA_ACTION,
        PizzaServlet.PIZZA_AUDIO_ACTION
})
public class PizzaServlet extends HttpServlet {

    private static final String TEXT_HTML = "text/html";
    static final String PIZZA_ACTION = "/";
    static final String PIZZA_AUDIO_ACTION = "/audio";
    private static final String PIZZA_COMPONENTS = "pizzaComponents";
    private static final String PIZZA_SIZES = "pizzaSizes";

    private PizzaService pizzaService;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (request.getServletPath().equals(PIZZA_AUDIO_ACTION)) {
            audioContent(request, response);
        } else if (request.getServletPath().equals(PIZZA_ACTION)) {
            response.setContentType(TEXT_HTML);
            request.setAttribute(PIZZA_COMPONENTS, PizzaComponent.values());
            request.setAttribute(PIZZA_SIZES, PizzaSize.values());
            request.getRequestDispatcher("pizza.jsp").forward(request, response);
        } else {
            response.setContentType(TEXT_HTML);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if(request.getServletPath().equals(PIZZA_AUDIO_ACTION)) {
            PizzaOrder pizzaOrder = fromRequest(request);
            String person = request.getParameter("person");

            pizzaService.generateAudio(pizzaOrder, person);
            response.sendRedirect("/pizza-servlet");
        }

    }

    private PizzaOrder fromRequest(HttpServletRequest request) {
        String[] components = request.getParameterValues("components");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String size = request.getParameter("pizzaSize");

        return new PizzaOrder(Arrays.asList(components), size, address, phone);
    }

    private void audioContent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("audio/mp3");
        ServletOutputStream out = response.getOutputStream();
        FileInputStream fin = new FileInputStream("c:\\TMP\\pizza.mp3");

        byte[] buf = new byte[4096];
        int read;
        while ((read = fin.read(buf)) != -1) {
            out.write(buf, 0, read);
        }

        fin.close();
        out.flush();
        out.close();
    }


    @Override
    public void init() throws ServletException {
        System.out.println("Servlet " + this.getServletName() + " has started");
        pizzaService = new PizzaService();
    }

    @Override
    public void destroy() {
        System.out.println("Servlet " + this.getServletName() + " has stopped");
    }
}
