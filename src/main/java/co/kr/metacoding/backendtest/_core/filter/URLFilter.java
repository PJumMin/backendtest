package co.kr.metacoding.backendtest._core.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.regex.Pattern;

@Component
public class URLFilter implements Filter {

    // 허용된 특수문자: ?, &, =, :, /
    private static final Pattern BLOCKED_PATTERN = Pattern.compile("[^a-zA-Z0-9/?&=:\\-_.]");

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        // 요청 URI를 디코딩 후 검사
        String uri = URLDecoder.decode(req.getRequestURI(), StandardCharsets.UTF_8);

        // 허용되지 않은 특수문자가 포함된 경우 차단
        if (BLOCKED_PATTERN.matcher(uri).find()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.setContentType("application/json; charset=utf-8");
            resp.getWriter().write("{\"error\": \"URL에 허용되지 않은 특수문자가 포함되어 있습니다.\"}");
            return;
        }

        chain.doFilter(request, response);
    }
}
