package co.kr.metacoding.backendtest._core.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String url = req.getRequestURI();

        if (url.startsWith("/users")) {
            String userAgent = req.getHeader("User-Agent");
            System.out.println("요청을 보낸 사용자의 정보 : " + userAgent);
        }

        chain.doFilter(request, response);
    }
}
