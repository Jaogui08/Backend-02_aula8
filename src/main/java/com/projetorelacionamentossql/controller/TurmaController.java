package com.projetorelacionamentossql.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetorelacionamentossql.entity.Turma;
import com.projetorelacionamentossql.service.TurmaService;

@RestController
@RequestMapping("/turma")
public class TurmaController {
	private final TurmaService turmaService;

	public TurmaController(TurmaService turmaService) {
		this.turmaService = turmaService;
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Turma>> findAllClasses() {
		List<Turma> turma = turmaService.findAllClasses();
		return ResponseEntity.ok(turma);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Turma> findClassById(@PathVariable Long id) {
		Turma turma = turmaService.findClassById(id);
		if (turma != null) {
			return ResponseEntity.ok(turma);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/")
	public ResponseEntity<Turma> saveClass(@RequestBody Turma turma) {
		Turma saveTurma = turmaService.saveClass(turma);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveTurma);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Turma> updatePhone(@RequestBody Turma turma, @PathVariable Long id) {
		Turma updTurma = turmaService.updateClass(turma, id);
		if (updTurma != null) {
			return ResponseEntity.ok(updTurma);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Turma> deleteClass(@PathVariable Long id) {
		boolean delTurma = turmaService.deleteClass(id);
		if (delTurma) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
