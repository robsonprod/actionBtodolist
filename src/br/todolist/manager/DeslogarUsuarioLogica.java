package br.todolist.manager;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.todolist.model.Logica;
import br.todolist.model.Usuario;

public class DeslogarUsuarioLogica implements Logica{

	@Override
	public boolean executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		Usuario userAutenticado = (Usuario) session.getAttribute("userLogado");
		
		if(userAutenticado != null) {
			session.setAttribute("userLogado", null);
			RequestDispatcher rd = request.getRequestDispatcher("/pages/login.jsp");
			rd.forward(request, response);
		}
		
		return false;
	}

}
