package br.com.caelum.eats.restaurante.entidade;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
@Table(name = "item_do_cardapio")
public class ItemDoCardapio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 150)
	private String nome;

	private String descricao;

	@NotNull
	@Positive
	private BigDecimal preco;

	@Positive
	@Column(name = "preco_promocional")
	private BigDecimal precoPromocional;

	@ManyToOne(optional = false)
	private CategoriaDoCardapio categoria;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public BigDecimal getPrecoPromocional() {
		return precoPromocional;
	}

	public void setPrecoPromocional(BigDecimal precoPromocional) {
		this.precoPromocional = precoPromocional;
	}

	public CategoriaDoCardapio getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaDoCardapio categoria) {
		this.categoria = categoria;
	}

	public BigDecimal getPrecoEfetivo() {
		return precoPromocional != null ? precoPromocional : preco;
	}
}
