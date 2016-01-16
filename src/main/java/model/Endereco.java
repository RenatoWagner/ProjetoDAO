package model;

public class Endereco{
	
	private String rua;
	private int id_numero;
	private String bairro;
	private String cidade;
	private EstadoEnum estado;
	

	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public int getNumero() {
		return id_numero;
	}
	public void setNumero(int numero) {
		this.id_numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public EstadoEnum getEstado() {
		return estado;
	}
	public void setEstado(EstadoEnum estado) {
		this.estado = estado;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Endereco [rua=" + rua + ", id_numero=" + id_numero
				+ ", bairro=" + bairro + ", cidade=" + cidade + ", estado="
				+ estado + "]";
	}
	
	
	

}
