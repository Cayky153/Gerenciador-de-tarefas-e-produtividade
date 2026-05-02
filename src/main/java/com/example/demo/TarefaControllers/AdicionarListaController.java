package com.example.demo.TarefaControllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Tarefas;
import com.example.demo.TarefasRepo;

import jakarta.validation.Valid;

@RestController
public class AdicionarListaController {
	@Autowired
	private TarefasRepo tarefaRepo;

	@PostMapping("/adicionarListaTarefa")
	public ResponseEntity<?> criarTarefa(@Valid @RequestBody List<Tarefas> tarefaLista) {
		List response= tarefaRepo.saveAll(tarefaLista);
		return ResponseEntity.status(HttpStatus.CREATED).body(
				Map.of(
					"message","Múltiplas tarefas criadas com sucesso",
					"status", 201,
					"data", response
				)
			);	
	
}
}
