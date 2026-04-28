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

import com.projetorelacionamentossql.entity.Aluno;
import com.projetorelacionamentossql.service.AlunoService;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
	private final AlunoService alunoService;

	public AlunoController(AlunoService alunoService) {
		this.alunoService = alunoService;
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Aluno>> findAllStudents() {
		List<Aluno> aluno = alunoService.findAllStudents();
		return ResponseEntity.ok(aluno);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Aluno> findStudentById(@PathVariable Long id) {
		Aluno aluno = alunoService.findStudentById(id);
		if (aluno != null) {
			return ResponseEntity.ok(aluno);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/")
	public ResponseEntity<Aluno> saveStudent(@RequestBody Aluno aluno) {
		Aluno saveAluno = alunoService.saveStudent(aluno);
		return ResponseEntity.status(HttpStatus.CREATED).body(saveAluno);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Aluno> updatePhone(@RequestBody Aluno aluno, @PathVariable Long id) {
		Aluno updAluno = alunoService.updateStudent(aluno, id);
		if (updAluno != null) {
			return ResponseEntity.ok(updAluno);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Aluno> deleteStudent(@PathVariable Long id) {
		boolean delAluno = alunoService.deleteStudent(id);
		if (delAluno) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
