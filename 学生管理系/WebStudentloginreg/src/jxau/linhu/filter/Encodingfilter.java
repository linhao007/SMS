package jxau.linhu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Encodingfilter implements Filter{
	private String EncodingChar;
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse rep=(HttpServletResponse)response;
		req.setCharacterEncoding(EncodingChar);
		req.setCharacterEncoding(EncodingChar);
	    chain.doFilter(req, rep);
	}

	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		EncodingChar=config.getInitParameter("encoding");
	}

}
