package com.github.sync.odontolocico.security;

import com.github.sync.odontolocico.jwt.JwtAuthFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final JwtAuthFilter jwtAuthFilter;

    public SecurityConfig(JwtAuthFilter jwtAuthFilter) {
        this.jwtAuthFilter = jwtAuthFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/",
                                "/src/**",
                                "/register",
                                "/register/clinic",
                                "/api/v1/client/register",
                                "/login",
                                "/api/v1/client/login",
                                "/api/v1/clinic/new",
                                "/invalidToken",
                                "/dashboard",
                                "/clinica/especialista",
                                "/clinic/patient/**",
                                "/api/v1/clinic/specialty/**",
                                "/api/v1/clinic/patient/**",
                                "/clinic/dentist/**",
                                "/clinic/**",
                                "/api/v1/clinic/dentist/**"


                        ).permitAll()
                        .requestMatchers(
                                "/home",
                                "/v1/post/publish"
                        ).authenticated()
                        .anyRequest().authenticated()

                )
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
                        .sessionFixation().migrateSession()
                        .maximumSessions(1)
                        .expiredUrl("/")
                )
//                .formLogin(form -> form
//                        .loginPage("/user/login")
//                       .loginProcessingUrl("/")
//                                .defaultSuccessUrl("/home", true)
//                                .permitAll()
//                )
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
