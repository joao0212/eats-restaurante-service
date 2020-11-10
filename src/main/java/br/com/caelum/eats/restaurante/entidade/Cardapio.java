package br.com.caelum.eats.restaurante.entidade;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Cardapio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne(optional = false)
	private Restaurante restaurante;

	@OneToMany(mappedBy = "cardapio")
	private List<CategoriaDoCardapio> categorias = new ArrayList<>();

	public void setId(Long id) {
		this.id = id;
	}

	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}

	public List<CategoriaDoCardapio> getCategorias() {
		return categorias;
	}

}
