package br.com.bandtec.agendadeobjetivos.seguranca;

import javax.persistence.Embeddable;

@Embeddable
public class Credenciais {
	
	private String login;
	private String senha;
	
	protected Credenciais() {}
	
	public Credenciais(String login, String senha) {
		this.login = login;
		this.senha = senha;
	}

	public boolean iguais() {
		return login.equals(senha);
	}

	public String getSenha() {
		return senha;
	}

	public String getLogin() {
		return login;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Credenciais other = (Credenciais) obj;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		return true;
	}
}
