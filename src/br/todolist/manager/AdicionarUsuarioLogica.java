package br.todolist.manager;

import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.todolist.dao.UsuarioDao;
import br.todolist.model.Logica;
import br.todolist.model.Usuario;

public class AdicionarUsuarioLogica implements Logica{

	@Override
	public boolean executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String nomeLogin = request.getParameter("nomeLogin");
		String senha = request.getParameter("senha");
		String cargo = request.getParameter("cargo");
		
		
		Connection connect = (Connection) request.getAttribute("connect");
		UsuarioDao dao = new UsuarioDao(connect);

		Usuario usuario = new Usuario();
		usuario.setNomeLogin(nomeLogin);
		usuario.setSenha(senha);
		usuario.setCargo(new Integer(cargo));
		
		if(possuiNomeSenha(usuario)) {
			dao.adiciona(usuario);
			request.setAttribute("msgUsuario", "Usuario cadastrado com sucesso");
			RequestDispatcher rd = request.getRequestDispatcher("/pages/index.jsp");
			rd.forward(request, response);
		}
		
		return true;
	}
	
	public boolean possuiNomeSenha(Usuario usuario) {
		return usuario.getNomeLogin() != null || usuario.getNomeLogin().isEmpty() && usuario.getSenha() != null || usuario.getSenha().isEmpty();
	}

}
