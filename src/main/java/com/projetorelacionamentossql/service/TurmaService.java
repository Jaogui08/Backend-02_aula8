package com.projetorelacionamentossql.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.projetorelacionamentossql.entity.Turma;
import com.projetorelacionamentossql.repository.TurmaRepository;

@Service
public class TurmaService {
	private final TurmaRepository turmaRepository;

	public TurmaService(TurmaRepository turmaRepository) {
		this.turmaRepository = turmaRepository;
	}
	
	public List<Turma> findAllClasses() {
		return turmaRepository.findAll();
	}
	
	public Turma findClassById(Long id) {
		Optional<Turma> existClass = turmaRepository.findById(id);
		return existClass.orElse(null);
	}
	
	public Turma saveClass(Turma turma) {
		return turmaRepository.save(turma);
	}
	
	public Turma updateClass(Turma turma, Long id) {
		Optional<Turma> existClass = turmaRepository.findById(id);
		if (existClass.isPresent()) {
			Turma updClass = existClass.get();
			BeanUtils.copyProperties(turma, updClass, "id");
			return turmaRepository.save(updClass);
		}
		return null;
	}
	
	public boolean deleteClass(Long id) {
		Optional<Turma> existClass = turmaRepository.findById(id);
		if (existClass.isPresent()) {
			turmaRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
