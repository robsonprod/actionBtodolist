package br.todolist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.todolist.model.Usuario;

public class UsuarioDao {
	private Connection connect;
	
	public UsuarioDao(Connection connect){
		this.connect = connect;
	}
	
	public void adiciona(Usuario user){
		try {
			PreparedStatement ps = this.connect.prepareStatement("INSERT INTO usuario (nomeLogin, senha, cargo) VALUES (?, ?, ?)");
			ps.setString(1, user.getNomeLogin());
			ps.setString(2, user.getSenha());
			ps.setInt(3, user.getCargo());
			
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Usuario autentica(String nomeLogin, String senha){
		try{
			PreparedStatement ps = this.connect.prepareStatement("SELECT * FROM usuario WHERE nomeLogin=? AND senha=?");
			ps.setString(1, nomeLogin);
			ps.setString(2, senha);
			
			Usuario user = null;
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				Long id = rs.getLong("id");
				String uNomeLogin = rs.getString("nomeLogin");
				String uSenha = rs.getString("senha");
				Integer uCargo = rs.getInt("cargo");
				
				user = new Usuario();
				user.setId(id);
				user.setNomeLogin(uNomeLogin);
				user.setSenha(uSenha);
				user.setCargo(uCargo);
			}
			rs.close();
			ps.close();
			return user;
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}
	
	public List<Usuario> listaUsuarios(){
		
		PreparedStatement ps;
		List<Usuario> usuarios = new ArrayList<>();
		try {
			ps = this.connect.prepareStatement("SELECT * FROM usuario");
			ResultSet rs = ps.executeQuery();
			
			Usuario usuario = null;
			while(rs.next()) {
				usuario = new Usuario();
				usuario.setId(rs.getLong("id"));
				usuario.setCargo(rs.getInt("cargo"));
				usuario.setNomeLogin(rs.getString("nomeLogin"));
				usuarios.add(usuario);
			}
			rs.close();
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return usuarios;
	}
	
}
