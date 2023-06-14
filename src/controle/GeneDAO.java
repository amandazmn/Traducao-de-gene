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
