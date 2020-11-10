package br.com.caelum.eats.restaurante.entidade;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categoria_do_cardapio")
public class CategoriaDoCardapio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	@ManyToOne(optional = false)
	private Cardapio cardapio;

	@OneToMany(mappedBy = "categoria")
	private List<ItemDoCardapio> itens = new ArrayList<>();

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

	public void setCardapio(Cardapio cardapio) {
		this.cardapio = cardapio;
	}

	public void setItens(List<ItemDoCardapio> itens) {
		this.itens = itens;
	}
}
