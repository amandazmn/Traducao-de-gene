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
	
	public String getmRNA(String sequencia) {
		sequencia = sequencia.toUpperCase();	
		return sequencia.replace('T', 'U');
	}

	public String getProteina(String sequencia) {
		String mRNA = getmRNA(sequencia);
		String proteina = "";
		for (int i = 0; i < mRNA.length(); i += 3) {
			String codon = mRNA.substring(i, i + 3);

			String aa = "";
			if (codon.equals("UUU") || codon.equals("UUC")) {
				aa = "F";
			} else if (codon.equals("UUA") || codon.equals("UUG") || codon.equals("CUU") || codon.equals("CUG") || codon.equals("CUC") || codon.equals("CUA")) {
				aa = "L";
			} else if (codon.equals("UAA") || codon.equals("UAG") || codon.equals("UGA")) {
				aa = "*";
			} else if (codon.equals("GAC") || codon.equals("GAU")) {
				aa = "D";
			} else if (codon.equals("GAA") || codon.equals("GAG")) {
				aa = "E";
			} else if (codon.equals("CGA") || codon.equals("CGC") || codon.equals("CGG")|| codon.equals("CGU")|| codon.equals("AGA")|| codon.equals("AGG")) {
				aa = "R";
			} else if (codon.equals("AAA") || codon.equals("AAG")) {
				aa = "K";
			} else if (codon.equals("AAC") || codon.equals("AAU")) {
				aa = "N";
			} else if (codon.equals("CAC") || codon.equals("CAU")) {
				aa = "H";
			} else if (codon.equals("CAA") || codon.equals("CAG")) {
				aa = "Q";
			} else if (codon.equals("UCA") || codon.equals("UCC") || codon.equals("UCG")|| codon.equals("UCU")|| codon.equals("AGC")|| codon.equals("AGU")) {
				aa = "S";
			} else if (codon.equals("ACA") || codon.equals("ACC") || codon.equals("ACG") || codon.equals("ACU")) {
				aa = "T";
			} else if (codon.equals("GCA") || codon.equals("GCC") || codon.equals("GCG") || codon.equals("GCU")) {
				aa = "A";
			} else if (codon.equals("GGA") || codon.equals("GGC") || codon.equals("GGG") || codon.equals("GGU")) {
				aa = "G";
			} else if (codon.equals("GUA") || codon.equals("GUC") || codon.equals("GUG") || codon.equals("GUU")) {
				aa = "V";
			} else if (codon.equals("CCA") || codon.equals("CCC") || codon.equals("CCG") || codon.equals("CCU")) {
				aa = "P";
			} else if (codon.equals("UAC") || codon.equals("UAU")) {
				aa = "Y";
			} else if (codon.equals("AUA") || codon.equals("AUC") || codon.equals("AUU")) {
				aa = "I";
			} else if (codon.equals("AUG")) {
				aa = "M";
			} else if (codon.equals("UGG")) {
				aa = "W";
			} else if (codon.equals("UGC") || codon.equals("UGU")) {
				aa = "C";
			}
			
			proteina = proteina + aa;

			System.out.print(codon + " ");
		}
		System.out.println();
		return proteina;
	}


}
