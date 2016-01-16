package dao;

import java.util.List;

import model.Endereco;

public interface EnderecoDAO {
		
	public void Cadastra(Endereco endereco);
	public void Exclui(Endereco endereco);
	public List<Endereco> ObtemEnderecoPorRua(String rua);
	public List<Endereco> TodasOsEnderecos();
	
	}
