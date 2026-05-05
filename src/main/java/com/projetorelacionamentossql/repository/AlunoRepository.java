package com.projetorelacionamentossql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetorelacionamentossql.entity.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{
	List<Aluno> findByCidade(String cidade);
	List<Aluno> findByNome(String nome);
}
