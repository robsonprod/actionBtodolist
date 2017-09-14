package br.todolist.filtro;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import br.todolist.model.Usuario;

@WebFilter(filterName="FiltroAutorizacao", urlPatterns="/*")
public class FiltroAutorizacao implements Filter{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String logica = req.getParameter("logica");
		String uri = req.getRequestURI();
		
		if(logica == null){
			logica = "";
		}
		
		if(uri.equals("/pages/login.jsp") 
				|| logica.endsWith("AutenticaUsuario")
				|| uri.endsWith("css")
				|| uri.endsWith("js")
				|| uri.endsWith("png")
				|| uri.endsWith("otf")
				|| uri.endsWith("eot")){
			chain.doFilter(request, response);
		}else{
			Usuario userLogado = (Usuario) req.getSession().getAttribute("userLogado");
			if(userLogado != null){
				chain.doFilter(request, response);
			}else{
				RequestDispatcher rd = request.getRequestDispatcher("/pages/login.jsp");
				request.setAttribute("msgUsuario", "Vocẽ precisa estar logado!");
				rd.forward(request, response);
			}
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
