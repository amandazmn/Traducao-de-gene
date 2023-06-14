package controle;

import java.util.ArrayList;
import java.util.Scanner;

import modelo.Gene;
import modelo.IGeneDAO;

public class GeneDAO implements IGeneDAO {

	private static ArrayList<Gene> genes;
	private static GeneDAO instancia;

	public static GeneDAO getInstancia() {
		if (instancia == null) {
			instancia = new GeneDAO();
			genes = new ArrayList<>();
		}

		return instancia;
	}

	/*
	 * Remover todos os arraylist dentro de metodo (so pode usar o arraylist GENES
	 * 
	 * Remover todos os scanner dentro de metodos
	 */

	

	@Override
	public boolean inserir(Gene gene) {
		genes.add(gene);
		return false;
	}

	@Override
	public ArrayList<Gene> listarGenes() {
		return genes;
	}

	@Override
	public boolean alterar(Gene gene, String novaSequencia) {
		gene.setSequencia(novaSequencia);
		return false;
	}

	@Override
	public boolean excluir(Gene gene) {
		
		return false;
	}

	@Override
	public boolean exibirTabela() {
		
		return false;
	}

}
