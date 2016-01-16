package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ConnectionFactory;
import model.Telefone;
import model.TipoEnum;

public class JDBCTelefoneDAO implements TelefoneDAO{
	
	private Connection connection;
	
public JDBCTelefoneDAO() throws ClassNotFoundException {
		
		this.connection = new ConnectionFactory().getConnection();
		
	}

	public void Cadastra(Telefone telefone) {
		String sql = "insert into telefones " +
	             "(id_numero,tipo)" +
	             " values (?,?)";

	     try {
 
			PreparedStatement stmt = connection.prepareStatement(sql);

	         // seta os valores

	         stmt.setInt(1,telefone.getId_numero());
	         stmt.setString(2,telefone.getTipo().name());
	         
	         
	         // executa
	         stmt.execute();
	         stmt.close();

	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }

}		

	public void Exclui(Telefone telefone) {
		try {
	    	 
	         PreparedStatement stmt = 
	        	connection.prepareStatement("delete from telefones where id_numero=?");

	         stmt.setLong(1, telefone.getId_numero());
	         
	         stmt.execute();
	         stmt.close();

	     } catch (SQLException e) {
	         throw new RuntimeException(e);

	     }
}					

	public List<Telefone> ObtemTelefonePorNumero(String numero) {
try {
			
			List<Telefone> telefones = new ArrayList<Telefone>();
			Telefone telefone = new Telefone();
			PreparedStatement stmt = this.connection.prepareStatement("Select * from telefones where numero = ?");
			stmt.setString(1, numero);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				
				telefone.setId_numero(rs.getInt("id_numero"));
				telefone.setTipo(TipoEnum.valueOf(rs.getString("tipo")));
				
				
	             telefones.add(telefone);
			}
			
	        rs.close();
	        stmt.close();
	        
	        return telefones;
	        
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}	
	}

	public List<Telefone> TodasOsTelefones() {
		try {
			List<Telefone> telefones = new ArrayList<Telefone>();
			PreparedStatement stmt = this.connection.prepareStatement("Select * from telefones");
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Telefone telefone =  new Telefone();
				telefone.setId_numero(rs.getInt("id_numero"));
				telefone.setTipo(TipoEnum.valueOf(rs.getString("tipo")));
				
	             telefones.add(telefone);
			}
			
	        rs.close();
	        stmt.close();
	        
	        return telefones;
			} catch (SQLException e) {
				throw new RuntimeException(e);
		}	
	}
}