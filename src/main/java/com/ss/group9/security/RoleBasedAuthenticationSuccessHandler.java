package com.ss.group9.security;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;


public class RoleBasedAuthenticationSuccessHandler implements AuthenticationSuccessHandler{

	private Map<String, String> roleUrlMap;
	 
	@Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
 
		String role = "ROLE_USER";
        if (authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            System.out.println(userDetails.getAuthorities());
            for (GrantedAuthority authority : userDetails.getAuthorities()) {
            	role = authority.getAuthority().toString();
            }    
            response.sendRedirect(request.getContextPath() + roleUrlMap.get(role));
        }
    }
 
    public void setRoleUrlMap(Map<String, String> roleUrlMap) {
        this.roleUrlMap = roleUrlMap;
    }
}
