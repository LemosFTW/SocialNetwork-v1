public class Profile {
	private String descricao;
	private String nome;
	private String email;
	private String[] amigosDoPerfil;
	int counterAmigos;

	public Profile(String nome, String email, String descricao) {
		amigosDoPerfil = new String[50];
		counterAmigos = 0;
		this.nome = nome;
		this.descricao = descricao;
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean verificarAmigo(String amigo) {
		boolean verificacao = false;
		for (int i = 0; i < counterAmigos; i++) {
			if (amigosDoPerfil[i].equals(amigo)) {
				verificacao = true;
			}
		}
		return verificacao;
	}

	public void fazAmizade(String amigo) {
		String mensagem = "";
		if (counterAmigos == amigosDoPerfil.length) {
		} else {
			for (int i = 0; i < counterAmigos; i++) {
				if (amigosDoPerfil[i].equals(amigo)) {
					mensagem = "Amizade existente.";
				}
			}
			if (!(mensagem.equals("Amizade existente."))) {
				amigosDoPerfil[counterAmigos++] = (amigo);
			}
		}
	}

	public String amigoDaArray(int i) {
		String amigo = "";
		amigo = amigosDoPerfil[i];
		return amigo;

	}
}
