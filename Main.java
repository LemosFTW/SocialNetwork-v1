import java.util.Scanner;

public class Main {
	private static final String QUIT = "SAIR";
	private static final String CONSULTAPESSOA = "CONSULTAPESSOA";
	private static final String REGISTA = "REGISTA";
	private static final String CONSULTAAMIZADE = "CONSULTAAMIZADE";
	private static final String AMIGOS = "AMIGOS";
	private static final String CONSULTAAMIGOS = "CONSULTAAMIGOS";
	private static final String NOVOESTADO = "NOVOESTADO";
	private static final String CONSULTAESTADO = "CONSULTAESTADO";
	private static final String PESSOAS = "PESSOAS";

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		RedeSocial rs = new RedeSocial();
		comnadRe(rs, in);
	}

	private static void comnadRe(RedeSocial rs, Scanner in) {
		String comando = comando = "";
		while (!(comando.equals(QUIT))) {
			comando = comandReader(in);
			switch (comando) {
			case CONSULTAPESSOA:
				verificaPessoaRegistradaMain(rs, in);
				break;
			case REGISTA:
				registrarNaRedeSocial(rs, in);
				break;
			case CONSULTAAMIZADE:
				consultaAmizadeMain(rs, in);
				break;
			case AMIGOS:
				fazAmizadeMain(rs, in);
				break;
			case CONSULTAAMIGOS:
				listarAmizades(rs, in);
				break;
			case NOVOESTADO:
				alteraEstadoPerfilMain(rs, in);
				break;
			case CONSULTAESTADO:
				consultaEstadoPerfilMain(rs, in);
				break;
			case PESSOAS:
				listarPessoasMain(rs);
				break;
			default:
				break;
			}

		}
		System.out.println("Adeus." + "\n");
	}

	private static String comandReader(Scanner in) {
		String inputComand = in.nextLine().toUpperCase();
		return inputComand;
	}

	private static void listarPessoasMain(RedeSocial rs) {
		String a = rs.listaDePerfis();
		if (!a.equals(""))
			System.out.println("Lista de pessoas registadas:\n" + a + "\n");
		else {
			System.out.println("Rede Social vazia." + "\n");
		}
	}

	private static void registrarNaRedeSocial(RedeSocial rs, Scanner in) {
		String nome = in.nextLine();
		String desc = in.nextLine();
		String email = in.nextLine();
		String mensagem = rs.addToRedeSocial(nome, desc, email);
		System.out.println(mensagem);
	}

	private static void verificaPessoaRegistradaMain(RedeSocial rs, Scanner in) {
		String nome = in.nextLine();
		if (rs.verificaSePessoaRegistrada(nome)) {
			System.out.println("Pessoa registada." + "\n");
		} else
			System.out.println("Sem registo." + "\n");
	}

	private static void consultaEstadoPerfilMain(RedeSocial rs, Scanner in) {
		String nome = in.nextLine();
		String resultadoDaConsulta = rs.consultaEstadoDoPerfil(nome);
		if (resultadoDaConsulta.equals("")) {
			System.out.println("Sem registo." + "\n");
		} else
			System.out.println(resultadoDaConsulta + "\n");
	}

	private static void alteraEstadoPerfilMain(RedeSocial rs, Scanner in) {
		String nome = in.nextLine();
		String descricao = in.nextLine();

		boolean conseguiu = rs.alterarEstado(nome, descricao);
		if (conseguiu)
			System.out.println("Estado alterado." + "\n");
		else
			System.out.println("Sem registo." + "\n");
	}

	private static void consultaAmizadeMain(RedeSocial rs, Scanner in) {
		String nome1 = in.nextLine();
		String nome2 = in.nextLine();
		if (rs.verificaAmizade(nome1, nome2)) {
			System.out.println("Amizade existente." + "\n");
		} else
			System.out.println("Amizade inexistente." + "\n");
	}

	private static void fazAmizadeMain(RedeSocial rs, Scanner in) {
		String nome1 = in.nextLine();
		String nome2 = in.nextLine();
		if (nome1.equals(nome2)) {
			System.out.println("Amizade invalida." + "\n");
		} else if (!(rs.verificaSePessoaRegistrada(nome1)) || !(rs.verificaSePessoaRegistrada(nome2))
				|| rs.verificaSeEstaVazia()) {
			System.out.println("Sem registo." + "\n");
		} else if (rs.verificaAmizade(nome1, nome2)) {
			System.out.println("Amizade existente." + "\n");
		} else if (rs.verificaSePessoaRegistrada(nome2) && rs.verificaSePessoaRegistrada(nome1)
				&& !nome1.equals(nome2)) {
			rs.doAmizade(nome1, nome2);
			System.out.println("Amizade criada." + "\n");
		}
	}

	private static void listarAmizades(RedeSocial rs, Scanner in) {
		String name = in.nextLine();
		String lista = "";
		lista = rs.listaAmizades(name);
		if (!(rs.verificaSePessoaRegistrada(name))) {
			System.out.println("Sem registo." + "\n");
		} else if (lista.equals("")) {
			System.out.println("Nao tem amigos registados." + "\n");
		} else {
			System.out.println("Lista de amigos:\n" + lista);
		}
	}

}
