package com.fpoly.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class CookieService extends SavedRequestAwareAuthenticationSuccessHandler implements
AuthenticationSuccessHandler{
	@Autowired
	HttpServletRequest request;
	@Autowired
	HttpServletResponse response;

	
	
	public Cookie get(String name) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equalsIgnoreCase(name)) {
					return cookie;
				}
			}
		}
		return null;
	}

	public String getValue(String name) {
		Cookie cookie = get(name);
		if (cookie != null) {
			return cookie.getValue();
		}
		return "";
	}

	public Cookie add(String name, String value, int hours) throws UnsupportedEncodingException {
		Cookie cookie = new Cookie(name, URLEncoder.encode( value, "UTF-8" ));
		cookie.setMaxAge(hours * 60 * 60);
		cookie.setPath("/");
		cookie.setSecure(true);
		cookie.setHttpOnly(true);
		response.addCookie(cookie);
		return cookie;
	}

	public void remove(String name) throws UnsupportedEncodingException {
		add(name, "", 0);
	}



}
