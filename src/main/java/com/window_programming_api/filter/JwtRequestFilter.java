package com.window_programming_api.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.window_programming_api.converter.Converter;
import com.window_programming_api.dto.MyUser;
import com.window_programming_api.dto.UserDTO;
import com.window_programming_api.service.IUserService;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private Converter converter;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		UserDTO userDto = null;
		if (request.getHeader("Authorization") != null) {
			String authorizationHeader = request.getHeader("Authorization");
			if (!authorizationHeader.equals("") && authorizationHeader.startsWith("Token ")) {
	            String jwt = authorizationHeader.substring(6);
	            userDto = userService.findOneByTokenCode(jwt);
	        }
		}
        

        if (userDto != null) {
        	MyUser myUser = converter.toMyUser(userDto);
            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(myUser, null, myUser.getAuthorities());
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);
		
	}

}
