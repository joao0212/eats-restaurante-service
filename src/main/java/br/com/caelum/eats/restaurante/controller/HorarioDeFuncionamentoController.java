package br.com.caelum.eats.restaurante.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
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

import br.com.caelum.eats.restaurante.entidade.HorarioDeFuncionamento;
import br.com.caelum.eats.restaurante.entidade.Restaurante;
import br.com.caelum.eats.restaurante.exception.ResourceNotFoundException;
import br.com.caelum.eats.restaurante.repository.HorarioDeFuncionamentoRepository;

@Path("/horarios-de-funcionamento")
public class HorarioDeFuncionamentoController {

	@Inject
	HorarioDeFuncionamentoRepository horarioDeFuncionamentoRepository;

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)

	public HorarioDeFuncionamento buscarPorId(@PathParam("id") Long id) {
		return horarioDeFuncionamentoRepository.findByIdOptional(id).orElseThrow(() -> new ResourceNotFoundException());
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/restaurantes/{idRestaurante}")
	public List<HorarioDeFuncionamento> listarPorIdRestaurante(@PathParam("idRestaurante") Long idRestaurante) {
		Restaurante restaurante = new Restaurante();
		restaurante.setId(idRestaurante);
		List<HorarioDeFuncionamento> horariosDoRestaurante = horarioDeFuncionamentoRepository
				.findAllByRestaurante(restaurante);
		return horariosDoRestaurante.stream().map(h -> new HorarioDeFuncionamento(h)).collect(Collectors.toList());
	}

	@POST
	@Transactional
	@Consumes(MediaType.APPLICATION_JSON)
	public Response inserir(HorarioDeFuncionamento horarioDeFuncionamento) {
		horarioDeFuncionamentoRepository.persist(horarioDeFuncionamento);
		return Response.status(Status.CREATED).build();
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(@PathParam("id") Long id, HorarioDeFuncionamento horarioDeFuncionamento) {
		HorarioDeFuncionamento horarioDeFuncionamentoSalvo = horarioDeFuncionamentoRepository.findByIdOptional(id)
				.orElseThrow(() -> new ResourceNotFoundException());

		horarioDeFuncionamentoSalvo.setId(horarioDeFuncionamento.getId());
		horarioDeFuncionamentoSalvo.setDiaDaSemana(horarioDeFuncionamento.getDiaDaSemana());
		horarioDeFuncionamentoSalvo.setHorarioDeAbertura(horarioDeFuncionamento.getHorarioDeAbertura());
		horarioDeFuncionamentoSalvo.setHorarioDeFechamento(horarioDeFuncionamento.getHorarioDeFechamento());

		horarioDeFuncionamentoRepository.persist(horarioDeFuncionamentoSalvo);
		return Response.status(Status.CREATED).build();
	}

	@DELETE
	@Path("/{id}")
	@Transactional
	public void remover(@PathParam("id") Long id) {
		horarioDeFuncionamentoRepository.deleteById(id);
	}
}
