package main;
import java.util.List;

import model.Curso;
import model.Telefone;
import model.TipoEnum;
import dao.CursoDAO;
import dao.JDBCCursoDAO;
import dao.JDBCTelefoneDAO;


public class Teste {

	public static void main(String[] args) throws ClassNotFoundException {
		Curso curso = new Curso();
		curso.setId_curso(3);
		curso.setNome("Jogos Digitais");
		curso.setArea("Exatas");

		 // grave nessa conexão!

		 CursoDAO dao = new JDBCCursoDAO();

		 // método elegante
		 dao.Cadastra(curso);
		 
		 System.out.println("Dados de curso gravado!");
		
	
//--------------------------
		
//		JDBCCursoDAO dao = new JDBCCursoDAO();
//		
//		List<Curso> cursos = dao.TodosOsCursos();
//		
//		for (Curso curso : cursos) {
//			System.out.println("id_curso: " + curso.getId_curso());
//			System.out.println("nome: " + curso.getNome());
//			System.out.println("Area: " + curso.getArea());  
//		}
//	}
//}
//-----------------------
//		JDBCCursoDAO dao = new JDBCCursoDAO();
//	
//		List<Curso> cursos = dao.ObtemCursoPorNome("Jogos Digitais");
//		for (Curso cursoz : cursos) {
//			System.out.println("id_curso: " + cursoz.getId_curso());
//			System.out.println("nome: " + cursoz.getNome());
//			System.out.println("Area: " + cursoz.getArea());  
//		}
//	}

	Telefone telefone = new Telefone();
	telefone.setId_numero(1);
	telefone.setTipo(TipoEnum.FIXO);
	

 // grave nessa conexão!

 JDBCTelefoneDAO dao = new JDBCTelefoneDAO();

 // método elegante
 dao.Cadastra(telefone);
 
 System.out.println("Dados de curso gravado!");
}}	

