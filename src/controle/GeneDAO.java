package controle;

import java.util.ArrayList;

import modelo.Gene;
import modelo.IGeneDAO;

public class GeneDAO implements IGeneDAO {

	private static ArrayList<Gene> genes;
	private static GeneDAO instancia;

	private GeneDAO() {
	}

	public static GeneDAO getInstancia() {
		if (instancia == null) {
			instancia = new GeneDAO();
			genes = new ArrayList<>();
		}

		return instancia;
	}

	@Override
	public boolean inserir(Gene gene) {
		if (gene != null) {
			genes.add(gene);
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public ArrayList<Gene> listarGenes() {
		return genes; 
	}

	@Override
	public boolean alterar(Gene gene, String novaSequencia) {
		if (gene!=null && novaSequencia!=null) {
			gene.setSequencia(novaSequencia);
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean excluir(Gene gene) {
		if (gene!=null) {
			genes.remove(gene);
			return true;
		}
		else {
			return false;
		}
	}


}
