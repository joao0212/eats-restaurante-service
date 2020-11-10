package br.com.caelum.eats.restaurante.controller;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.caelum.eats.restaurante.entidade.CategoriaDoCardapio;
import br.com.caelum.eats.restaurante.entidade.ItemDoCardapio;
import br.com.caelum.eats.restaurante.exception.ResourceNotFoundException;
import br.com.caelum.eats.restaurante.repository.ItemDoCardapioRepository;

@Path("/itens")
public class ItemDoCardapioController {

	@Inject
	ItemDoCardapioRepository itemDoCardapioRepository;

	@POST
	@Transactional
	public Response inserir(ItemDoCardapio item) {
		CategoriaDoCardapio categoria = new CategoriaDoCardapio();
		categoria.setId(item.getCategoria().getId());
		item.setCategoria(categoria);
		itemDoCardapioRepository.persist(item);
		return Response.status(Status.CREATED).build();
	}

	@PUT
	@Path("/{id}")
	public Response atualizar(@PathParam("id") Long id, ItemDoCardapio item) {
		ItemDoCardapio itemDoCardapioSalvo = itemDoCardapioRepository.findByIdOptional(id)
				.orElseThrow(() -> new ResourceNotFoundException());

		itemDoCardapioSalvo.setId(item.getId());
		itemDoCardapioSalvo.setNome(item.getNome());
		itemDoCardapioSalvo.setDescricao(item.getDescricao());
		itemDoCardapioSalvo.setPreco(item.getPreco());
		itemDoCardapioSalvo.setPrecoPromocional(item.getPrecoPromocional());

		itemDoCardapioRepository.persist(item);
		return Response.status(Status.CREATED).build();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ItemDoCardapio buscarPorId(@PathParam("id") Long id) {
		return itemDoCardapioRepository.findByIdOptional(id).orElseThrow(() -> new ResourceNotFoundException());
	}

	@DELETE
	@Path("/{id}")
	@Transactional
	public void remover(@PathParam("id") Long id) {
		itemDoCardapioRepository.deleteById(id);
	}
}
