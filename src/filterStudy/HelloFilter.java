package filterStudy;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloFilter implements Filter{

	public HelloFilter() {
		// TODO Auto-generated constructor stub
		System.out.println("1.构造函数调用了");
	}
	 
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("2.初始化函数调用了");
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("3.过滤器业务方法调用了");
		chain.doFilter(request, response);
		System.out.println("5.servlet函数调用完了，又回到filter了");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("6.过滤器销毁");
	}

}
