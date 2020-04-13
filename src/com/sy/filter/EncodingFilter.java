package com.sy.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class EncodingFilter
 */
@WebFilter("/EncodingFilter")
public class EncodingFilter implements Filter {
		private String enc;
    /**
     * Default constructor. 
     */
    public EncodingFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 이게 중요
		// 요청이 발생하면 실행
		System.out.println(request);
		request.setCharacterEncoding(enc);
		System.out.println("EncodingFilter In");
		
		chain.doFilter(request, response);
		
		response.setCharacterEncoding("UTF-8");
		System.out.println("EncodingFilter Out");
		
		//다음 필터 또는 Servlet으로 전달
		
		//응답이 발생하면 실행
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// filter 객체가 생성 후 초기화 메서드
		 enc = fConfig.getInitParameter("enc");
	}

}
