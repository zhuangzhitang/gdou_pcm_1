package net.itaem.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/**
 * 过滤设置servlet的编码格式
 * @author zhetang
 *
 */
public class SetCharacterEncodingFilter implements Filter {
	private String encoding = null ;
	private FilterConfig filterConfig = null ;
	private boolean ignore = true ;
	
	public void destroy() {
		this.encoding  = null ;
		this.filterConfig = null ;
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain fileChain) throws IOException, ServletException {
		if(ignore||(request.getCharacterEncoding()==null)){
			if(encoding!=null){
				request.setCharacterEncoding(encoding);
			}
		}
		fileChain.doFilter(request,response) ;
	}

	public void init(FilterConfig config) throws ServletException {
		this.filterConfig = config ;
		this.encoding = filterConfig.getInitParameter("charset");
		String value = filterConfig.getInitParameter("ignore") ;
		if(value==null){
			this.ignore = true ;
		}else if(value.equalsIgnoreCase("yes")){
			this.ignore= true ;
		}else if(value.equalsIgnoreCase("no")){
			this.ignore = false ;
		}else {
			this.ignore = false ;
		}
	}

}
