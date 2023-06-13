package modelo;

import java.util.ArrayList;

public interface IGeneDAO {
	
	public boolean inserir(Gene gene);
	
	public ArrayList<Gene> listarGenes();
	
	public boolean alterar(Gene gene);
	
	public boolean excluir(Gene gene);
	
	public boolean exibirTabela();
	
}
