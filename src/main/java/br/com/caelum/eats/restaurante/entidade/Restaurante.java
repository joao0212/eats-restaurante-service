package br.com.caelum.eats.restaurante.entidade;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
public class Restaurante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 18)
	private String cnpj;

	@NotBlank
	@Size(max = 255)
	private String nome;

	@Size(max = 1000)
	private String descricao;

	@NotBlank
	@Size(max = 9)
	private String cep;

	@NotBlank
	@Size(max = 300)
	private String endereco;

	@Positive
	@Column(name = "taxa_de_entrega_em_reais")
	private BigDecimal taxaDeEntregaEmReais;

	@Positive
	@Min(10)
	@Max(180)
	@Column(name = "tempo_de_entrega_minimo_em_minutos")
	private Integer tempoDeEntregaMinimoEmMinutos;

	@Positive
	@Min(10)
	@Max(180)
	@Column(name = "tempo_de_entrega_maximo_em_minutos")
	private Integer tempoDeEntregaMaximoEmMinutos;

	private Boolean aprovado;

	@Column(name = "tipo_de_cozinha_id")
	private Long tipoDeCozinhaId;

	public void setId(Long id) {
		this.id = id;
	}

	public void setAprovado(Boolean aprovado) {
		this.aprovado = aprovado;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public void setTaxaDeEntregaEmReais(BigDecimal taxaDeEntregaEmReais) {
		this.taxaDeEntregaEmReais = taxaDeEntregaEmReais;
	}

	public void setTempoDeEntregaMinimoEmMinutos(Integer tempoDeEntregaMinimoEmMinutos) {
		this.tempoDeEntregaMinimoEmMinutos = tempoDeEntregaMinimoEmMinutos;
	}

	public void setTempoDeEntregaMaximoEmMinutos(Integer tempoDeEntregaMaximoEmMinutos) {
		this.tempoDeEntregaMaximoEmMinutos = tempoDeEntregaMaximoEmMinutos;
	}

	public void setTipoDeCozinhaId(Long tipoDeCozinhaId) {
		this.tipoDeCozinhaId = tipoDeCozinhaId;
	}

	public String getCep() {
		return cep;
	}

	public Long getTipoDeCozinhaId() {
		return tipoDeCozinhaId;
	}

	public Long getId() {
		return id;
	}

}
