package br.com.caelum.eats.restaurante.controller;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.caelum.eats.restaurante.entidade.Cardapio;
import br.com.caelum.eats.restaurante.entidade.CategoriaDoCardapio;
import br.com.caelum.eats.restaurante.exception.ResourceNotFoundException;
import br.com.caelum.eats.restaurante.repository.CategoriaDoCardapioRepository;

@Path("/categorias")
public class CategoriaDoCardapioController {

	@Inject
	CategoriaDoCardapioRepository categoriaDoCardapioRepository;

	@GET
	@Produces(value = MediaType.APPLICATION_JSON)
	@Path("/{idCategoria}")
	public CategoriaDoCardapio buscarPorId(@PathParam("idCategoria") Long idCategoria) {
		return categoriaDoCardapioRepository.findByIdOptional(idCategoria)
				.orElseThrow(() -> new ResourceNotFoundException());
	}

	@POST
	@Transactional
	@Path("/cardapio/{idCardapio}")
	public Response inserirPorIdCardapio(@PathParam("idCardapio") Long idCardapio, CategoriaDoCardapio categoria) {
		Cardapio cardapio = new Cardapio();
		cardapio.setId(idCardapio);
		categoria.setCardapio(cardapio);
		categoriaDoCardapioRepository.persist(categoria);
		return Response.status(Status.CREATED).build();
	}
}
