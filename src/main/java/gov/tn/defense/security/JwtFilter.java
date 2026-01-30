package gov.tn.defense.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import gov.tn.defense.repositories.AppUserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

@Component
public class JwtFilter extends OncePerRequestFilter {

	    @Autowired
	    private AppUserRepository appUserRepository;

	    @Autowired
	    private JwtUtils jwtUtils;

	    @Override
	    protected void doFilterInternal(HttpServletRequest request,
	                                    HttpServletResponse response,
	                                    FilterChain chain) throws ServletException, IOException {

	        final String authHeader = request.getHeader("Authorization");

	        String username = null;
	        String jwt = null;

	        if (authHeader != null && authHeader.startsWith("Bearer ")) {
	            jwt = authHeader.substring(7);
	            username = jwtUtils.extractUsername(jwt);
	        }

	        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
	            UserDetails userDetails = this.appUserRepository.findByUsername(username);

	            if (jwtUtils.isTokenValid(jwt, userDetails.getUsername())) {
	                UsernamePasswordAuthenticationToken authToken =
	                    new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

	                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
	                SecurityContextHolder.getContext().setAuthentication(authToken);
	            }
	        }

	        chain.doFilter(request, response);
	    }
	}