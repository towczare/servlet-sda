package foo.bar;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

@WebFilter(filterName="insultFilter")
public class InsultFilter implements Filter {

    private static Logger LOG = Logger.getLogger(InsultFilter.class);
    private static List<String> BAD_WORDS = new ArrayList<>();

    private FilterConfig filterConfig;

    static {
        BAD_WORDS.add("psia krew");
        BAD_WORDS.add("motyla noga");
        BAD_WORDS.add("kurczę blade");
        BAD_WORDS.add("do diaska");
        BAD_WORDS.add("jasny gwint");
        BAD_WORDS.add("kurde");
        BAD_WORDS.add("niech to gęś kopnie");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        Enumeration<String> params = req.getParameterNames();
        while(params.hasMoreElements()){
            String name = params.nextElement();
            String value = req.getParameter(name);
            if(BAD_WORDS.contains(value.toLowerCase())){
                LOG.info("WE HAVE TO TAKE A CLOSER LOOK FOR THIS USER!");

                LOG.info(req.getRemoteAddr() + "::Request Params::{"+name+"="+value+"}");
                Cookie[] cookies = req.getCookies();
                if(cookies != null){
                    for(Cookie cookie : cookies){
                        LOG.info(req.getRemoteAddr() + "::Cookie::{"+cookie.getName()+","+cookie.getValue()+"}");
                    }
                }
            }
        }

        // pass the request along the filter chain
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
