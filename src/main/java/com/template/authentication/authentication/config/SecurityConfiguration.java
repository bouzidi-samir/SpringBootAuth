package com.template.authentication.authentication.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {
    private final JwtAuthentificationFilter jwtAutthFilter;
    private final AuthenticationProvider authenticationProvider;

    //Bean in charge of configuring all the security filter of pour app

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                    .csrf()
                    .disable()
                    .authorizeHttpRequests()
                    .requestMatchers("/api/v1/auth/**")
                    .permitAll()
                    .anyRequest()
                    .authenticated()
                    .and()
                    .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and()
                    .authenticationProvider(authenticationProvider)
                    .addFilterBefore(jwtAutthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
   }

}
