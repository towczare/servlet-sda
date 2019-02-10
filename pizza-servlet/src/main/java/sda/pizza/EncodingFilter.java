package sda.pizza;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by tomic on 16.06.18.
 */
public class EncodingFilter implements Filter {

    static final String UTF_8 = "UTF-8";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding(UTF_8);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
