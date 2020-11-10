package br.com.caelum.eats.restaurante.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import br.com.caelum.eats.restaurante.entidade.Restaurante;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class RestauranteRepository implements PanacheRepository<Restaurante> {

	List<Restaurante> findAllByAprovado(boolean aprovado) {
		return list("aprovado", aprovado);
	}

	public void aprovarPorId(Boolean aprovado, Long id) {
		update("aprovado = ?1 where id = ?2", aprovado, id);
	}

	public Restaurante findByCnpj(String cnpj) {
		return find("cnpj", cnpj).firstResult();
	}

}
