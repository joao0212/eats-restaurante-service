package br.com.caelum.eats.restaurante.controller;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.caelum.eats.restaurante.entidade.Cardapio;
import br.com.caelum.eats.restaurante.entidade.Restaurante;
import br.com.caelum.eats.restaurante.exception.ResourceNotFoundException;
import br.com.caelum.eats.restaurante.repository.CardapioRepository;

@Path("/cardapios")
public class CardapioController {

	@Inject
	CardapioRepository cardapioRepository;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("restaurantes/{idRestaurante}")
	public Cardapio buscarPorRestaurante(@PathParam("idRestaurante") Long idRestaurante) {
		Restaurante restaurante = new Restaurante();
		restaurante.setId(idRestaurante);
		return cardapioRepository.findByRestaurante(restaurante);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{idCardapio}")
	public Cardapio buscarPorId(@PathParam("idCardapio") Long idCardapio) {
		return cardapioRepository.findByIdOptional(idCardapio).orElseThrow(() -> new ResourceNotFoundException());
	}
}
