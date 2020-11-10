package br.com.caelum.eats.restaurante.repository;

import javax.enterprise.context.ApplicationScoped;

import br.com.caelum.eats.restaurante.entidade.ItemDoCardapio;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class ItemDoCardapioRepository implements PanacheRepository<ItemDoCardapio> {

}
