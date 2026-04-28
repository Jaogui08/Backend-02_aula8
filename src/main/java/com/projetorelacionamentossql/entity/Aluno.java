package com.projetorelacionamentossql.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "aluno")
public class Aluno {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@NotBlank
	@Size(min = 1, max = 255)
	private String nome;
	
	@NotNull
	@NotBlank
	@Email
	@Size(min = 1, max = 255)
	private String email;
	
	@NotNull
	@NotBlank
	@Size(min = 1, max = 255)
	private String cidade;
	
	@NotNull
	@NotBlank
	@Size(min = 1, max = 255)
	private String ra;
	
	@NotNull
	@NotBlank
	@Size(min = 1, max = 255)
	private String telefone;
	
	@NotNull
	private double renda;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "id_turma")
	private Turma turma;
}
