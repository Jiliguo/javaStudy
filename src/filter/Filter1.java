package filter;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Filter1 implements Filter{
	
	public Filter1() {
		// TODO Auto-generated constructor stub
		System.out.println("创建Filter实例");
	}
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("执行过滤器Filter的init方法!"); 
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("执行Filter的distory方法");
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("过滤器处理方法");
		final HttpServletRequest request=(HttpServletRequest) arg0;
		HttpServletResponse response=(HttpServletResponse) arg1;
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		
		HttpServletRequest proxy=(HttpServletRequest) Proxy.newProxyInstance(
				request.getClass().getClassLoader(),
				new Class[]{HttpServletRequest.class}, 
				new InvocationHandler() {
					
					@Override
					public Object invoke(Object proxy, Method method, Object[] args)
							throws Throwable {
						// TODO Auto-generated method stub
						Object returnValue=null;
						String methodName=method.getName();
						if("getParameter".equals(methodName)){
							String value=request.getParameter(args[0].toString());
							String methodSubmit=request.getMethod();
							if("GET".equalsIgnoreCase(methodSubmit)){
								if(value!=null&&!"".equals(value.trim())){
									value=new String(value.getBytes("ISO8859-1"), "UTF-8");
								}
							}
							return value;
						}else{
							returnValue=method.invoke(request, args);
						}
						return returnValue;
					}
				
				});
		
		arg2.doFilter(arg0, arg1);
		System.out.println("servlet处理完回到Filter");
	}

}
