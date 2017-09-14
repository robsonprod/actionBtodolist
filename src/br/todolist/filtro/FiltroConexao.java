package br.todolist.filtro;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import br.todolist.dao.ConnectionFactory;
import br.todolist.exception.TarefaServletException;

@WebFilter(filterName="FiltroConexao", urlPatterns="/pages/sistema")
public class FiltroConexao implements Filter{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		Connection connect = new ConnectionFactory().getConnection();
		request.setAttribute("connect", connect);
		chain.doFilter(request, response);
		try{
			connect.close();
		}catch(SQLException e){
			throw new TarefaServletException("Erro ao tentar fechar conexão com banco!");
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
