package br.todolist.manager;

import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.todolist.dao.UsuarioDao;
import br.todolist.model.Logica;
import br.todolist.model.Usuario;

public class AutenticaUsuarioLogica implements Logica {

	@Override
	public boolean executa(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Usuario userAutenticado = null;
		String login = request.getParameter("nomeLogin");
		String senha = request.getParameter("senha");
		Connection connect = (Connection) request.getAttribute("connect");
		
		UsuarioDao dao = new UsuarioDao(connect);
		userAutenticado = dao.autentica(login, senha);

		if(userAutenticado != null){
			HttpSession session = request.getSession();
			session.setAttribute("userLogado", userAutenticado);
			RequestDispatcher rd = request.getRequestDispatcher("/pages/index.jsp");
			rd.forward(request, response);
			return true;
		}else{
			request.setAttribute("msgUsuario", "login ou senha inválidos!");
			response.sendRedirect("/pages/login.jsp");
			return false;
		}
	}

}
