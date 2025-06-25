package com.example.spring_study.common.security.filter;

import jakarta.servlet.Filter;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.FilterChainProxy;

import java.util.List;

@Configuration
public class FilterLoggingConfig {

    @Bean
    public ApplicationRunner logSecurityFilters(FilterChainProxy filterChainProxy) {
        return args -> {
            List<Filter> filters = filterChainProxy.getFilters("/");

            System.out.println("\n=== [Spring Security Filter Chain 순서] ===");
            for (int i = 0; i < filters.size(); i++) {
                System.out.printf("%2d. %s%n", i + 1, filters.get(i).getClass().getSimpleName());
            }
            System.out.println("==========================================\n");
        };
    }

}
