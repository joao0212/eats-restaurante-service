package br.com.caelum.eats.restaurante.entidade;

import java.time.DayOfWeek;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "horario_de_funcionamento")
public class HorarioDeFuncionamento {

	public HorarioDeFuncionamento() {

	}

	public HorarioDeFuncionamento(HorarioDeFuncionamento horarioDeFuncionamento) {
		this.id = horarioDeFuncionamento.id;
		this.diaDaSemana = horarioDeFuncionamento.diaDaSemana;
		this.horarioDeAbertura = horarioDeFuncionamento.horarioDeAbertura;
		this.horarioDeFechamento = horarioDeFuncionamento.horarioDeFechamento;
		this.restaurante = horarioDeFuncionamento.restaurante;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(name = "dia_da_semana")
	@Enumerated(EnumType.STRING)
	private DayOfWeek diaDaSemana;

	@NotNull
	@Column(name = "horario_de_abertura")
	private LocalTime horarioDeAbertura;

	@NotNull
	@Column(name = "horario_de_fechamento")
	private LocalTime horarioDeFechamento;

	@ManyToOne
	private Restaurante restaurante;

	public DayOfWeek getDiaDaSemana() {
		return diaDaSemana;
	}

	public LocalTime getHorarioDeAbertura() {
		return horarioDeAbertura;
	}

	public LocalTime getHorarioDeFechamento() {
		return horarioDeFechamento;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setDiaDaSemana(DayOfWeek diaDaSemana) {
		this.diaDaSemana = diaDaSemana;
	}

	public void setHorarioDeAbertura(LocalTime horarioDeAbertura) {
		this.horarioDeAbertura = horarioDeAbertura;
	}

	public void setHorarioDeFechamento(LocalTime horarioDeFechamento) {
		this.horarioDeFechamento = horarioDeFechamento;
	}

	public Long getId() {
		return id;
	}

	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}

}
