package integracao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.dbunit.DatabaseTestCase;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.XmlDataSet;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.todolist.dao.ConnectionFactory;
import br.todolist.dao.UsuarioDao;
import br.todolist.model.Usuario;

public class UsuarioTest extends DatabaseTestCase{

	public Connection connect;
	public Usuario usuario;
	public UsuarioDao dao;

	private FileInputStream loadFile;
	private IDataSet dataSet;
	
	@BeforeClass
	public static void initClass() {

	}
	
	@Before
	public void init() {
		connect = new ConnectionFactory().getConnection();
	}
	
	@After
	public void clear() {
		limparBanco();
	}
	
	@Test
	public void deveAdicionarUsuario() throws DataSetException, Exception {
		
		int rowCount = getDataSet().getTable("login").getRowCount();
		System.out.println(rowCount);
		
		boolean result = false;
		UsuarioDao dao = new UsuarioDao(connect);
		Usuario usuario = new Usuario("usuarioteste", "123", 2);
		
		dao.adiciona(usuario);
		
		try {
			PreparedStatement ps = this.connect.prepareStatement("SELECT * FROM usuario WHERE cargo=2");
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				result = true;
			}
			
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Assert.assertTrue(result);
		
	}
	
	@Test
	public void deveAutenticarUsuario() {
		executeSql("INSERT INTO usuario (nomeLogin, senha, cargo) VALUES ('user1', '123', 1)");
		
		UsuarioDao dao = new UsuarioDao(connect);
		Usuario userAutenticado = dao.autentica("user1", "123");
		
		Assert.assertEquals("user1", "user1", userAutenticado.getNomeLogin());
	}
	
	@Test
	public void deveListarUsuarios() {
		executeSql("INSERT INTO usuario (nomeLogin, senha, cargo) VALUES ('user1', '123', 1)");
		executeSql("INSERT INTO usuario (nomeLogin, senha, cargo) VALUES ('user2', '123', 1)");
		executeSql("INSERT INTO usuario (nomeLogin, senha, cargo) VALUES ('user3', '123', 1)");
		executeSql("INSERT INTO usuario (nomeLogin, senha, cargo) VALUES ('user4', '123', 1)");
		
		UsuarioDao dao = new UsuarioDao(connect);
		List<Usuario> usuarios = dao.listaUsuarios();
		
		Assert.assertEquals(4, usuarios.size());
	}
	
	public void executeSql(String sql) {
		try {
			PreparedStatement ps = this.connect.prepareStatement(sql);
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void limparBanco() {
		try {
			PreparedStatement ps = this.connect.prepareStatement("DELETE FROM usuario");
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected IDatabaseConnection getConnection() throws Exception {
		connect = new ConnectionFactory().getConnection();
		System.out.println(connect);
		return (IDatabaseConnection) connect;
	}

	@Override
	protected IDataSet getDataSet() throws Exception {
		loadFile = new FileInputStream("dataLogin.xml");
		dataSet = new XmlDataSet(loadFile);
		System.out.println(dataSet);
		return dataSet;
	}
	
}
