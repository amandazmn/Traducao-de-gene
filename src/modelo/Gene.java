package modelo;

public class Gene {
	private String nome;
	private String sequencia;
	private String traducao;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSequencia() {
		return sequencia;
	}

	public void setSequencia(String sequencia) {
		this.sequencia = sequencia;
	}

	public String getTraducao() {
		return traducao;
	}

	public void setTraducao(String traducao) {
		this.traducao = traducao;
	}

	public String getmRNA() {
		return sequencia.replace('T', 'U');
	}

	public String getProteina() {

		String mRNA = getmRNA();
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

	/*
	 * public static void main(String[] args) { Gene a = new Gene();
	 * a.sequencia="TTTTTATTCTTGTAATAG"; System.out.println("mRNA     "+
	 * a.getmRNA()); System.out.println("Proteina "+ a.getProteina()); }
	 */

}
