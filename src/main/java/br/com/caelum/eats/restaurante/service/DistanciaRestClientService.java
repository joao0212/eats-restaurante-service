package br.com.caelum.eats.restaurante.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import br.com.caelum.eats.restaurante.entidade.RestauranteParaDistancia;

@Path("restaurantes")
@RegisterRestClient
public interface DistanciaRestClientService {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void inserir(RestauranteParaDistancia restauranteParaDistancia);

}
