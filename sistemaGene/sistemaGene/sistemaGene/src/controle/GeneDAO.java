package controle;

import java.util.ArrayList;
import java.util.Scanner;

import modelo.Gene;

public class GeneDAO {
	
	public static Gene cadastrarGene() {
		Scanner leitura = new Scanner(System.in);
		ArrayList<Gene> genes = new ArrayList<>();
		Gene g = new Gene();
		System.out.println("Tipo 1 - DNA para RNAm | 2 - RNAm para AA): ");
		Integer tipo = Integer.valueOf(leitura.nextLine());
		System.out.println("Nome: ");
		g.setNome(leitura.nextLine());
		System.out.println("Sequência: ");
		String sequencia = leitura.nextLine();
		g.setSequencia(sequencia);
		switch (tipo) {
		case 1: {
			String mRNA;
			mRNA = g.getmRNA();
			g.setTraducao(mRNA);
		}
		case 2: {
			String AA;
			AA = g.getmRNA();
			AA = g.getProteina();
			g.setTraducao(AA);
		}
		}
		genes.add(g);
		return g;
	}

	public static ArrayList<Gene> editarGene(ArrayList<Gene> genes) {
		System.out.println("Nome do gene que deseja editar: ");
		Scanner leitura = new Scanner(System.in);
		String nome = leitura.nextLine();
		for (Gene gene : genes) {
			if (gene.getNome().equals(nome)) {
				System.out.println("Sequência: ");
				System.out.println("Número do códon     Códon");
				String sequencia = gene.getSequencia();
				Integer j = 0;
				for (int i = 0; i < sequencia.length(); i += 3) {
					System.out.println(j + "                   " + gene.getSequencia().substring(i, i + 3));
					j++;
				}
				j = 0;
				String[] codons = new String[Integer.MAX_VALUE];
				for (int i = 0; i < sequencia.length(); i += 3) {
					codons[j] = gene.getSequencia().substring(i, i + 3);
					j++;
				}
				System.out.println("Número de códons que deseja editar: ");
				Integer n = Integer.valueOf(leitura.nextLine());
				for (int i = 0; i < n; i++) {
					System.out.println("Número do códon que deseja editar: ");
					Integer nCodon = Integer.valueOf(leitura.nextLine());
					System.out.println("Códon: " + codons[nCodon]);
					System.out.println("Novo códon: ");
					codons[nCodon] = leitura.nextLine();
				}
				String novaSequencia = null;
				for (int i = 0; i < codons.length; i++) {
					novaSequencia = novaSequencia + codons[i];
				}
				gene.setSequencia(novaSequencia);
				System.out.println("Nova sequência: " + novaSequencia);
			}
		}
		return genes;
	}

}
