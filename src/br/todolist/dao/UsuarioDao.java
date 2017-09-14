package br.todolist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.todolist.model.Usuario;

public class UsuarioDao {
	private Connection connect;
	
	public UsuarioDao(Connection connect){
		this.connect = connect;
	}
	
	public void userCheck(int cargo) {
		try {
			PreparedStatement ps = this.connect.prepareStatement("select * from usuario where cargo=?");
			ps.setInt(1, cargo);
			
			ps.execute();
			ps.close();
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void cadastro(Usuario user){
		try {
			//tentando assim
			PreparedStatement ps = this.connect.prepareStatement("insert into usuario (nomeLogin, senha) values (?, ?)");
		ps.setString(1, user.getNomeLogin());
			ps.setString(2, user.getSenha());
			
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Usuario autentica(String nomeLogin, String senha){
		try{
			PreparedStatement ps = this.connect.prepareStatement("select * from usuario where nomeLogin=? and senha=?");
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
}
