package org.techtask.config;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.techtask.component.AuthEntryPointJwt;
import org.techtask.component.AuthTokenFilter;
import org.techtask.exception.SecurityConfigExceptions;

@Slf4j
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@AllArgsConstructor
public class SpringSecurityConfig {

    private final AuthTokenFilter authenticationTokenFilter;
    private final AuthEntryPointJwt authEntryPointJwt;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) {
        disableCorsAndCsrf(httpSecurity);
        addCustomExceptionHandler(httpSecurity);
        setAuthorizeRequest(httpSecurity);
        settingFilterBefore(httpSecurity);
        return buildSecurityFilterChain(httpSecurity);
    }

    private void disableCorsAndCsrf(HttpSecurity httpSecurity) {
        try {
            httpSecurity
                    .cors(AbstractHttpConfigurer::disable)
                    .csrf(AbstractHttpConfigurer::disable);
        } catch (Exception exception) {
            log.error("Error was caused while cors disabling! - {}",
                    exception.getMessage());
            throw new SecurityConfigExceptions("Sorry, it`s our mistake, " +
                    "we are already working on it!");
        }
    }

    private void addCustomExceptionHandler(HttpSecurity httpSecurity) {
        try {
            httpSecurity.exceptionHandling(handling ->
                    handling.authenticationEntryPoint(authEntryPointJwt));
        } catch (Exception exception) {
            log.error("Error was caused by exception handling! - {}",
                    exception.getMessage());
            throw new SecurityConfigExceptions("Sorry, it`s our mistake, " +
                    "we are already working on it!");
        }
    }

    private void setAuthorizeRequest(HttpSecurity httpSecurity) {
        try {
            httpSecurity.authorizeHttpRequests(
                    authorizeHttpRequests -> authorizeHttpRequests
                            .antMatchers("/api/v1/auth/login",
                                    "/api/v1/auth/register")
                            .permitAll()
                            .anyRequest().authenticated()
            );
        } catch (Exception exception) {
            log.error("Authorization exception - {}", exception.getMessage());
            throw new SecurityConfigExceptions("Sorry, it`s our mistake, " +
                    "we are already working on it!");
        }
    }

    private void settingFilterBefore(HttpSecurity httpSecurity) {
        httpSecurity.addFilterBefore(authenticationTokenFilter,
                UsernamePasswordAuthenticationFilter.class);
    }

    private SecurityFilterChain buildSecurityFilterChain(HttpSecurity httpSecurity) {
        try {
            return httpSecurity.build();
        } catch (Exception exception) {
            log.error("Build exception - {}", exception.getMessage());
            throw new SecurityConfigExceptions("Sorry, it`s our mistake, " +
                    "we are already working on it!");
        }
    }

}
