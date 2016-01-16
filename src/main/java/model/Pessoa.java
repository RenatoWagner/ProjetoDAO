package model;

public class Pessoa {

	private int id_pessoa;
	private String nome;
	private String cpf;
	

	public int getId() {
		return id_pessoa;
	}
	public void setId(int id) {
		this.id_pessoa = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Pessoa [id_pessoa=" + id_pessoa + ", nome=" + nome + ", cpf="
				+ cpf + "]";
	}

	
}
