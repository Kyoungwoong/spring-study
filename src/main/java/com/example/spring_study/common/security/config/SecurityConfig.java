package com.example.spring_study.common.security.config;

import com.example.spring_study.common.security.filter.JwtRequestFilter;
import com.example.spring_study.common.security.service.UserDetailsServiceImpl;
import com.example.spring_study.common.security.utils.JwtUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutFilter;

@Slf4j
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    /* 권한 제외 대상 */
    private static final String[] PERMIT_ALL_URLS = new String[] {
    };

    /* admin accepted url */
    private static final String[] PERMIT_ADMIN_URLS = new String[] {
    };

    private final JwtRequestFilter filter;
    private final UserDetailsServiceImpl memberDetailsService;
    private final WebConfig webConfig;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig)
            throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain web(HttpSecurity http) throws Exception {

        http.formLogin()
                .loginPage("/login.html")   			// 사용자 정의 로그인 페이지
                .defaultSuccessUrl("/home")			// 로그인 성공 후 이동 페이지
                .failureUrl("/login.html?error=true")	        // 로그인 실패 후 이동 페이지
                .usernameParameter("username")			// 아이디 파라미터명 설정
                .passwordParameter("password")			// 패스워드 파라미터명 설정
                .loginProcessingUrl("/login");			// 로그인 Form Action Url
//                .successHandler(loginSuccessHandler())		// 로그인 성공 후 핸들러
//                .failureHandler(loginFailureHandler());		// 로그인 실패 후 핸들러

        return http
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement((sessionManagement) ->
                        sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers(PERMIT_ALL_URLS)
                            .permitAll();
                    auth.requestMatchers(PERMIT_ADMIN_URLS)
                            .hasRole("ADMIN");
                    auth.anyRequest()
                            .authenticated();
                })
                .addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class)
//                .addFilterBefore(filter, LogoutFilter.class)
                .addFilter(webConfig.corsFilter())
                .build();
    }
}
