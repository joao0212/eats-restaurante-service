package br.com.caelum.eats.restaurante.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import br.com.caelum.eats.restaurante.entidade.HorarioDeFuncionamento;
import br.com.caelum.eats.restaurante.entidade.Restaurante;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class HorarioDeFuncionamentoRepository implements PanacheRepository<HorarioDeFuncionamento> {

	public List<HorarioDeFuncionamento> findAllByRestaurante(Restaurante restaurante) {
		return list("restaurante", restaurante);
	}
}
