package br.todolist.manager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.todolist.model.Logica;
import br.todolist.model.Usuario;

public class CadastroUsuarioLogica implements Logica{

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String nomeLogin = request.getParameter("nomeLogin");
		String senha = request.getParameter("senha");
		
		Usuario user = new Usuario();
		user.setNomeLogin(nomeLogin);
		user.setSenha(senha);
		
		
		response.sendRedirect("/login.jsp");
	}

}
