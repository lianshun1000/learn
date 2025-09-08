package com.learn.springai.config;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.IOException;

/**
 * @author lianshun
 * 2025/9/3 10:17
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    /*@Configuration
    public static class Utf8Filter implements Filter {
        @Override
        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
                throws IOException, ServletException {
            if (response instanceof HttpServletResponse) {
                ((HttpServletResponse) response).setCharacterEncoding("UTF-8");
                ((HttpServletResponse) response).setHeader("Content-Type", "text/event-stream;charset=UTF-8");
            }
            chain.doFilter(request, response);
        }
    }*/

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET","POST","PUT","DELETE","OPTIONS")
                .allowedHeaders("*");
    }
}
