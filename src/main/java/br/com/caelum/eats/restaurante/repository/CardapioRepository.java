package br.com.caelum.eats.restaurante.repository;

import javax.enterprise.context.ApplicationScoped;

import br.com.caelum.eats.restaurante.entidade.Cardapio;
import br.com.caelum.eats.restaurante.entidade.Restaurante;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class CardapioRepository implements PanacheRepository<Cardapio> {

	public Cardapio findByRestaurante(Restaurante restaurante) {
		return find("restaurante", restaurante).firstResult();
	}
}
