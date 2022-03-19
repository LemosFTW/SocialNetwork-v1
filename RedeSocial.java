
import java.util.ArrayList;

public class RedeSocial implements RedeSocialInterface {
	private ArrayList<Profile> listaDePerfis;
	private Profile[] perfis;
	private static final int TAMANHO_NORMAL = 500;
	private int counter;
	private int counterAmizades;
	private String[] amizades;

	public RedeSocial() {
		listaDePerfis = new ArrayList<Profile>();
		perfis = new Profile[TAMANHO_NORMAL];
		counter = 0;
		amizades = new String[counterAmizades];
		counterAmizades = 0;
	}

	public boolean verificaSeEstaVazia() {
		return counter == 0;
	}

	
	public String addToRedeSocial(String nome, String descricao, String email) {
		String retorno = "";
		if (verificaSePessoaRegistrada(nome)) {
			retorno = "Pessoa registada." + "\n";
		} else if (!(retorno.equals("Pessoa registada."))) {
			perfis[counter++] = new Profile(nome, descricao, email);
			retorno = "Pessoa registada com sucesso." + "\n";
		}
		return retorno;
	}

	public boolean verificaSePessoaRegistrada(String name) {
		boolean esta = false;
		for (int i = 0; i < counter; i++) {
			if (perfis[i].getNome().equals(name)) {
				esta = true;
			}
		}
		return esta;
	}

	public int indiceDoPerfil(String nome) {
		int numero = -1;
		for (int i = 0; i < counter; i++) {
			if (perfis[i].getNome().equals(nome)) {
				numero = i;
			}
		}
		if (numero == -1) {
			numero = 0;
		}
		return numero;
	}

	public void doAmizade(String nome1, String nome2) {
		int pessoa1 = indiceDoPerfil(nome1);
		int pessoa2 = indiceDoPerfil(nome2);
		perfis[pessoa1].fazAmizade(nome2);
		perfis[pessoa2].fazAmizade(nome1);

	}

	public boolean verificaAmizade(String nome1, String nome2) {
		boolean condicao = false;
		int pessoa1 = indiceDoPerfil(nome1);
		int pessoa2 = indiceDoPerfil(nome2);
		if (perfis[pessoa1].verificarAmigo(nome2) && perfis[pessoa2].verificarAmigo(nome1)) {
			condicao = true;
		}
		return condicao;
	}

	// resolver problema que ta aqui
	public String listaAmizades(String name) {
		String lista = "";
		int pessoa = indiceDoPerfil(name);
		for (int i = 0; counter - 1 > i; i++) {
			if (perfis[pessoa].amigoDaArray(i) != null) {
				lista += perfis[pessoa].amigoDaArray(i);
				int numeroDoAmigo = indiceDoPerfil(perfis[pessoa].amigoDaArray(i));
				String emailDele = perfis[numeroDoAmigo].getEmail();
				lista += "; " + emailDele;
				if (perfis[i].counterAmigos != i - 1)
					lista += "\n";
			}

		}
		return lista;
	}

	public String listaDePerfis() {
		String perfisList = "";
		if (perfis.length == 0) {
		} else {
			for (int i = 0; i < counter; i++) {
				perfisList += perfis[i].getNome() + "; " + perfis[i].getEmail();
				if (counter - 1 != i)
					perfisList += "\n";
			}
		}
		return perfisList;
	}

	public String consultaEstadoDoPerfil(String nome) {
		String consulta = "";
		for (int i = 0; i < counter; i++) {
			if (perfis[i].getNome().equals(nome)) {
				consulta += perfis[i].getDescricao();
			}
		}
		return consulta;
	}

	public boolean alterarEstado(String name, String desc) {
		boolean conseguiu = false;
		boolean pessoaExiste = verificaSePessoaRegistrada(name);
		if (pessoaExiste) {
			setNovoEstado(name, desc);
			conseguiu = true;
		}
		return conseguiu;
	}

	public void setNovoEstado(String name, String desc) {
		for (int i = 0; i < counter; i++) {
			if (perfis[i].getNome().equals(name)) {
				perfis[i].setDescricao(desc);
			}
		}
	}
}
