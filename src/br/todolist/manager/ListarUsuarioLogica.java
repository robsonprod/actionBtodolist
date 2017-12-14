package br.todolist.manager;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.todolist.dao.UsuarioDao;
import br.todolist.model.Logica;
import br.todolist.model.Usuario;

public class ListarUsuarioLogica implements Logica{

	@Override
	public boolean executa(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Connection connect = (Connection) request.getAttribute("connect");
		List<Usuario> usuarios = new ArrayList<>();
		UsuarioDao dao = new UsuarioDao(connect);
		
		Usuario user = new Usuario();
		HttpSession session = request.getSession();
		user = (Usuario) session.getAttribute("userLogado");

		usuarios = dao.listaUsuarios();
		request.setAttribute("usuarios", usuarios);
		
		RequestDispatcher rd = request.getRequestDispatcher("/pages/gerenciar-usuarios.jsp");
		rd.forward(request, response);
		return true;
	}

}
