package cn.com.project.util;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SessionInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Integer loginId = (Integer) Comm.getUserInfoId(request);//获取登录用户的id
		if(loginId == null){
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			StringBuilder sb = new StringBuilder();
			sb.append(" <script type='text/javascript'> ");
			sb.append(" alert('请先登录');");
			sb.append(" window.top.location.href='");
			sb.append(request.getContextPath()+"/index/temp/login.jsp");
			sb.append("';");
			sb.append(" </script> ");
			
			out.write(sb.toString());
			
			out.flush();
			out.close();
			
			return false;
	}
		return super.preHandle(request, response, handler);
	}
}
