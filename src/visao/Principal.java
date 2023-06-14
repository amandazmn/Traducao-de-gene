package visao;

import java.util.ArrayList;
import java.util.Scanner;

import controle.GeneDAO;
import modelo.Gene;

public class Principal {
	public static int menu() {
		Scanner leitura = new Scanner(System.in);
		System.out.println("            Menu            ");
		System.out.println("0 - Inserir gene");
		System.out.println("1 - Listar genes cadastrados");
		System.out.println("2 - Alterar sequência");
		System.out.println("3 - Excluir gene");
		System.out.println("4 - Exibir tabela");
		System.out.println("5 - Fechar");
		Integer opcao = Integer.valueOf(leitura.nextLine());

		return opcao;
	}

	public static void main(String[] args) {

		Scanner leitura = new Scanner(System.in);

		Integer opcao = Integer.MAX_VALUE;
		GeneDAO dao = GeneDAO.getInstancia();
		ArrayList<Gene> genes = dao.listarGenes();

		while (opcao != 0) {
			opcao = menu();

			switch (opcao) {
			case 0: {

				System.out.println("Tipo 1 - DNA para RNAm | 2 - DNA para RNAm para AA): ");
				String read = leitura.nextLine();
				Integer tipo = Integer.valueOf(read);

				System.out.println("Digita nome: ");
				String nome = leitura.nextLine();

				Gene gene = new Gene();
				gene.setNome(nome);
				System.out.println("Sequência: ");
				String sequencia = leitura.nextLine();
				gene.setSequencia(sequencia);
				switch (tipo) {
				case 1: {
					String mRNA = gene.getmRNA(gene.getSequencia());
					gene.setTraducao(mRNA);
				}
				case 2: {
					String AA = gene.getProteina(gene.getSequencia());
					gene.setTraducao(AA);
				}
				}
				boolean inseriu = dao.inserir(gene);
				if (inseriu == true) {
					System.out.println("Cadastrou o gene com sucesso.");
				} else {
					System.out.println("Erro ao cadastrar o gene.");
				}

			}
			case 1: {
				System.out.println("Listagem de genes cadastrados: "); //perguntar para prof. Nós não chamamos o método listar
				for (Gene gen : genes) {
					System.out.println("Nome: " + gen.getNome());
					System.out.println("Sequência: " + gen.getSequencia());
					System.out.println("Tradução: " + gen.getTraducao());
				}
			}
			case 2: {
				System.out.println("Nome do gene que deseja editar: ");
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

						boolean alterou = dao.alterar(gene, novaSequencia);

						System.out.println("Nova sequência: " + gene.getSequencia());
						if (alterou == true) {
							System.out.println("Alterou a sequência com sucesso.");
						} else {
							System.out.println("Erro ao alterar a sequência.");
						}
					}
				}
			}
			case 3: {

			}
			case 5: {
				// Encerra o sistema
				leitura.close();
				break;
			}
			}
		}
	}
}
