package dao;

import java.util.List;

import model.Curso;

public interface CursoDAO {

	public void Cadastra(Curso curso);
	public void Exclui(Curso curso);
	public List<Curso> ObtemCursoPorNome(String nome);
	public List<Curso> TodosOsCursos();
	
}
