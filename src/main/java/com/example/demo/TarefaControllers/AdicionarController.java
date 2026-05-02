package com.example.demo.TarefaControllers;

import java.util.Map;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import com.example.demo.TarefasRepo;
import com.example.demo.Tarefas;


@RestController
public class AdicionarController {

	@Autowired
	private TarefasRepo tarefaRepo;

	@PostMapping("/adicionarTarefa")
	public ResponseEntity<?> criarTarefa(@Valid @RequestBody  Tarefas tarefa) {
		Tarefas response= tarefaRepo.save(tarefa);
		return ResponseEntity.status(HttpStatus.CREATED).body(
				Map.of(
					"message", "Tarefa criada com sucesso",
					"status", 201,
					"data", response
				)
			);	
	
}
}
