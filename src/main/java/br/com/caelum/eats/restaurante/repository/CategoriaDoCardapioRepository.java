package br.com.caelum.eats.restaurante.repository;

import javax.enterprise.context.ApplicationScoped;

import br.com.caelum.eats.restaurante.entidade.CategoriaDoCardapio;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class CategoriaDoCardapioRepository implements PanacheRepository<CategoriaDoCardapio> {

}
