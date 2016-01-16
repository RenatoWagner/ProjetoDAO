package model;

public class Telefone {
	
	private int id_numero;
	private TipoEnum tipo;

	
	public int getId_numero() {
		return id_numero;
	}
	public void setId_numero(int id_numero) {
		this.id_numero = id_numero;
	}
	public TipoEnum getTipo() {
		return tipo;
	}
	public void setTipo(TipoEnum tipo) {
		this.tipo = tipo;
	}
	
	
	@Override
	public String toString() {
		return "Telefone [id_numero=" + id_numero + ", tipo=" + tipo + "]";
	}
	
}
	
	
