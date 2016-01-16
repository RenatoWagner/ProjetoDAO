package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ConnectionFactory;
import model.Pessoa;

public class JDBCPessoaDAO implements PessoaDAO {
	
	private Connection connection;

public JDBCPessoaDAO() throws ClassNotFoundException {
		
		this.connection = new ConnectionFactory().getConnection();
		
	}

	public void Cadastra(Pessoa pessoa) {

		String sql = "insert into pessoas " +
		             "(id_pessoa,nome,cpf)" +
		             " values (?,?,?)";

		     try {
	  
				PreparedStatement stmt = connection.prepareStatement(sql);

		         // seta os valores

		         stmt.setInt(1,pessoa.getId());
		         stmt.setString(2,pessoa.getNome());
		         stmt.setString(3,pessoa.getCpf());
		         
		         
		         // executa
		         stmt.execute();
		         stmt.close();

		     } catch (SQLException e) {
		         throw new RuntimeException(e);
		     }

	 }		


	public void Exclui(Pessoa pessoa) {
		
		try {
	    	 
	         PreparedStatement stmt = 
	        	connection.prepareStatement("delete from pessoas where id_pessoa=?");

	         stmt.setLong(1, pessoa.getId());
	         
	         stmt.execute();
	         stmt.close();

	     } catch (SQLException e) {
	         throw new RuntimeException(e);

	     }
}				

	public List<Pessoa> ObtemPessoaPorNome(String nome) {
			
		try {
			
			List<Pessoa> pessoas = new ArrayList<Pessoa>();
			Pessoa pessoa = new Pessoa();
			PreparedStatement stmt = this.connection.prepareStatement("Select * from pessoas where nome = ?");
			stmt.setString(1, nome);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				
				pessoa.setId(rs.getInt("id_pessoa"));
				pessoa.setNome(rs.getString("nome"));
				pessoa.setCpf(rs.getString("cpf"));
				
	             pessoas.add(pessoa);
			}
			
	        rs.close();
	        stmt.close();
	        
	        return pessoas;
	        
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}	
	}

	public List<Pessoa> TodasAsPessoas() {

		try {
			List<Pessoa> pessoas = new ArrayList<Pessoa>();
			PreparedStatement stmt = this.connection.prepareStatement("Select * from pessoas");
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Pessoa pessoa =  new Pessoa();
				pessoa.setId(rs.getInt("id_pessoa"));
				pessoa.setNome(rs.getString("nome"));
				pessoa.setCpf(rs.getString("cpf"));				
				
	             pessoas.add(pessoa);
			}
			
	        rs.close();
	        stmt.close();
	        
	        return pessoas;
			} catch (SQLException e) {
				throw new RuntimeException(e);
		}	
	}
}
