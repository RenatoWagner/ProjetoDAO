package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ConnectionFactory;
import model.Curso;

public class JDBCCursoDAO implements CursoDAO{
	
	private Connection connection;

public JDBCCursoDAO() throws ClassNotFoundException {
		
		this.connection = ConnectionFactory.getConnection();
		
	}

	public void Cadastra(Curso curso) {
		 String sql = "insert into cursos " +
	             "(id_curso,nome,area)" +
	             " values (?,?,?)";

	     try {
  
			PreparedStatement stmt = connection.prepareStatement(sql);

	         // seta os valores

	         stmt.setLong(1,curso.getId_curso());
	         stmt.setString(2,curso.getNome());
	         stmt.setString(3,curso.getArea());
	         
	         // executa
	         stmt.execute();
	         stmt.close();

	     } catch (SQLException e) {
	         throw new RuntimeException(e);
	     }

	 }

	public void Exclui(Curso curso) {

	     try {
	    	 
	         PreparedStatement stmt = 
	        	connection.prepareStatement("delete from cursos where id_curso=?");

	         stmt.setLong(1, curso.getId_curso());
	         stmt.execute();
	         stmt.close();

	     } catch (SQLException e) {
	         throw new RuntimeException(e);

	     }
	 }

	public List<Curso> ObtemCursoPorNome(String nome) {
		
		try {
			
			List<Curso> cursos = new ArrayList<Curso>();
			Curso curso = new Curso();
			PreparedStatement stmt = this.connection.prepareStatement("Select * from cursos where nome = ?");
			stmt.setString(1, nome);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				
				curso.setId_curso(rs.getInt("id_curso"));
				curso.setNome(rs.getString("nome"));
				curso.setArea(rs.getString("area"));
				
	             cursos.add(curso);
			}
			
	        rs.close();
	        stmt.close();
	        
	        return cursos;
	        
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}	
	}
	
	public List<Curso> TodosOsCursos() {

		try {
			List<Curso> cursos = new ArrayList<Curso>();
			PreparedStatement stmt = this.connection.prepareStatement("Select * from cursos");
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				Curso curso =  new Curso();
				curso.setId_curso(rs.getInt("id_curso"));
				curso.setNome(rs.getString("nome"));
				curso.setArea(rs.getString("area"));
				
	             cursos.add(curso);
			}
			
	        rs.close();
	        stmt.close();
	        
	        return cursos;
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}	
	}




}
