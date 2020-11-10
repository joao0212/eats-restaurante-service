package br.com.caelum.eats.restaurante.controller;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import br.com.caelum.eats.restaurante.entidade.Cardapio;
import br.com.caelum.eats.restaurante.entidade.Restaurante;
import br.com.caelum.eats.restaurante.entidade.RestauranteParaDistancia;
import br.com.caelum.eats.restaurante.repository.CardapioRepository;
import br.com.caelum.eats.restaurante.repository.RestauranteRepository;
import br.com.caelum.eats.restaurante.service.DistanciaRestClientService;

@Path("/restaurantes")
public class RestauranteController {

	@Inject
	RestauranteRepository restauranteRepository;

	@Inject
	CardapioRepository cardapioRepository;

	@Inject
	@RestClient
	DistanciaRestClientService distanciaRestClient;

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Restaurante buscar(@PathParam("id") Long id) {
		return restauranteRepository.findById(id);
	}

	@POST
	@Transactional
	public Response inserir(Restaurante restaurante) {
		restaurante.setAprovado(false);
		restauranteRepository.persist(restaurante);
		Cardapio cardapio = new Cardapio();
		Restaurante restauranteInserido = restauranteRepository.findByCnpj(restaurante.getCnpj());
		cardapio.setRestaurante(restauranteInserido);
		cardapioRepository.persist(cardapio);
		return Response.status(Status.CREATED).build();
	}

	@PATCH
	@Transactional
	@Path("/{id}")
	public void aprovar(@PathParam("id") Long id) {
		restauranteRepository.aprovarPorId(Boolean.TRUE, id);
		Restaurante restaurante = restauranteRepository.findById(id);
		RestauranteParaDistancia restauranteParaDistancia = new RestauranteParaDistancia(restaurante);
		distanciaRestClient.inserir(restauranteParaDistancia);
	}
}
