package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ConnectionFactory;
import model.Endereco;
import model.EstadoEnum;
import model.TipoEnum;

public class JDBCEnderecoDAO implements EnderecoDAO {
	
	private Connection connection;

public JDBCEnderecoDAO() throws ClassNotFoundException {
		
		this.connection = new ConnectionFactory().getConnection();
		
	}

	public void Cadastra(Endereco endereco) {
			 String sql = "insert into enderecos " +
		             "(id_numero,rua,bairro,cidade,estado)" +
		             " values (?,?,?,?,?)";

		     try {
	  
				PreparedStatement stmt = connection.prepareStatement(sql);

		         // seta os valores

		         stmt.setLong(1,endereco.getNumero());
		         stmt.setString(2,endereco.getRua());
		         stmt.setString(3,endereco.getBairro());
		         stmt.setString(4,endereco.getCidade());
		         stmt.setString(5,endereco.getEstado().name());

		         
		         // executa
		         stmt.execute();
		         stmt.close();

		     } catch (SQLException e) {
		         throw new RuntimeException(e);
		     }

	 }		

	public void Exclui(Endereco endereco) {
		  try {
		    	 
		         PreparedStatement stmt = 
		        	connection.prepareStatement("delete from cursos where id_numero=?");

		         stmt.setLong(1, endereco.getNumero());
		         stmt.execute();
		         stmt.close();

		     } catch (SQLException e) {
		         throw new RuntimeException(e);

		     }
	}		

	public List<Endereco> ObtemEnderecoPorRua(String rua) {
		try {
			
			List<Endereco> enderecos = new ArrayList<Endereco>();
			Endereco endereco = new Endereco();
			PreparedStatement stmt = this.connection.prepareStatement("Select * from enderecos where rua = ?");
			stmt.setString(1, rua);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				
				endereco.setNumero(rs.getInt("id_numero"));
				endereco.setRua(rs.getString("rua"));
				endereco.setBairro(rs.getString("bairro"));
				endereco.setCidade(rs.getString("cidade"));
				endereco.setEstado(EstadoEnum.valueOf(rs.getString("estado")));

				
	             enderecos.add(endereco);
			}
			
	        rs.close();
	        stmt.close();
	        
	        return enderecos;
	        
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}	
	}
	

	public List<Endereco> TodasOsEnderecos() {
		
		try {
			List<Endereco> enderecos = new ArrayList<Endereco>();
			PreparedStatement stmt = this.connection.prepareStatement("Select * from enderecos");
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Endereco endereco =  new Endereco();
				endereco.setNumero(rs.getInt("id_numero"));
				endereco.setRua(rs.getString("rua"));
				endereco.setBairro(rs.getString("bairro"));
				endereco.setCidade(rs.getString("cidade"));
				endereco.setEstado(EstadoEnum.valueOf(rs.getString("estado")));
				
				
	             enderecos.add(endereco);
			}
			
	        rs.close();
	        stmt.close();
	        
	        return enderecos;
			} catch (SQLException e) {
				throw new RuntimeException(e);
		}	
	}
}
