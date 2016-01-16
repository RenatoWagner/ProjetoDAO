package dao;

import java.util.List;

import model.Telefone;

public interface TelefoneDAO {
	
	public void Cadastra(Telefone telefone);
	public void Exclui(Telefone telefone);
	public List<Telefone> ObtemTelefonePorNumero(String numero);
	public List<Telefone> TodasOsTelefones();
		
}

