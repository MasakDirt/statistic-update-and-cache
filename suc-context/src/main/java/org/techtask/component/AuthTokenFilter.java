package org.techtask.component;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.techtask.util.JwtUtils;
import org.techtask.service.UserService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@Component
@AllArgsConstructor
public class AuthTokenFilter extends OncePerRequestFilter {

    private static final String BEARER_PREFIX = "Bearer ";

    private final JwtUtils jwtUtils;
    private final UserService userService;

    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                  FilterChain filterChain) throws ServletException, IOException {
        if (hasAuthorizationBearer(request)) {
            String token = getAccessToken(request);
            if (jwtUtils.isJwtTokenValid(token)) {
                setAuthContext(token, request);
            }
        }
        filterChain.doFilter(request, response);
    }

    private boolean hasAuthorizationBearer(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        return Objects.nonNull(header) && header.startsWith(BEARER_PREFIX);
    }

    private String getAccessToken(HttpServletRequest request) {
        return request.getHeader("Authorization")
                .substring(BEARER_PREFIX.length());
    }

    private void setAuthContext(String token, HttpServletRequest request) {
        UsernamePasswordAuthenticationToken authenticationToken =
                getUsernamePasswordAuthenticationToken(token);

        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
    }

    private UsernamePasswordAuthenticationToken getUsernamePasswordAuthenticationToken(String token) {
        var userDetails = userService.getByEmail(jwtUtils.getSubject(token));

        return new UsernamePasswordAuthenticationToken(userDetails.getUsername(),
                null, userDetails.getAuthorities());
    }

}
