package dao;

import java.util.List;

import model.Pessoa;

public interface PessoaDAO {
		
	public void Cadastra(Pessoa pessoa);
	public void Exclui(Pessoa pessoa);
	public List<Pessoa> ObtemPessoaPorNome(String nome);
	public List<Pessoa> TodasAsPessoas();
	
}

