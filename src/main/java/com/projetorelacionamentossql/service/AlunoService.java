package com.projetorelacionamentossql.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.projetorelacionamentossql.entity.Aluno;
import com.projetorelacionamentossql.repository.AlunoRepository;

@Service
public class AlunoService {
	private final AlunoRepository alunoRepository;

	public AlunoService(AlunoRepository alunoRepository) {
		this.alunoRepository = alunoRepository;
	}
	
	public List<Aluno> findAllStudents() {
		return alunoRepository.findAll();
	}
	
	public Aluno findStudentById(Long id) {
		Optional<Aluno> existStudent = alunoRepository.findById(id);
		return existStudent.orElse(null);
	}
	
	public Aluno saveStudent(Aluno aluno) {
		return alunoRepository.save(aluno);
	}
	
	public Aluno updateStudent(Aluno aluno, Long id) {
		Optional<Aluno> existStudent = alunoRepository.findById(id);
		if (existStudent.isPresent()) {
			Aluno updStudent = existStudent.get();
			BeanUtils.copyProperties(aluno, updStudent, "id");
			return alunoRepository.save(updStudent);
		}
		return null;
	}
	
	public boolean deleteStudent(Long id) {
		Optional<Aluno> existStudent = alunoRepository.findById(id);
		if (existStudent.isPresent()) {
			alunoRepository.deleteById(id);
			return true;
		}
		return false;
	}
	
	public List<Aluno> findByCidade(String cidade) {
		return alunoRepository.findByCidade(cidade);
	}
	
	public List<Aluno> findByNome(String nome) {
		return alunoRepository.findByNome(nome);
	}
}
