package model;

public class Curso {
	
	private int id_curso;
	private String nome;
	private String area;
	
	
	public int getId_curso() {
		return id_curso;
	}
	public void setId_curso(int id_curso) {
		this.id_curso = id_curso;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	@Override
	public String toString() {
		return "Curso [id_curso=" + id_curso + ", nome=" + nome + ", area="
				+ area + "]";
	}

	
	

}
