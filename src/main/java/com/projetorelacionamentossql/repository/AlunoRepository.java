package com.projetorelacionamentossql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetorelacionamentossql.entity.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{

}
