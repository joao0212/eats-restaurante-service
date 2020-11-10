package br.com.caelum.eats.restaurante.entidade;

public class RestauranteParaDistancia {

	public RestauranteParaDistancia(Restaurante restaurante) {
		this.cep = restaurante.getCep();
		this.aprovado = Boolean.TRUE;
		this.tipoDeCozinhaId = restaurante.getTipoDeCozinhaId();
		this.id = restaurante.getId();
	}

	private String cep;

	private Long id;

	private Boolean aprovado;

	private Long tipoDeCozinhaId;

	public String getCep() {
		return cep;
	}

	public Boolean getAprovado() {
		return aprovado;
	}

	public Long getTipoDeCozinhaId() {
		return tipoDeCozinhaId;
	}

	public Long getId() {
		return id;
	}
}
