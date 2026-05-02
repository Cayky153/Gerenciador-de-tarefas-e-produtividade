package com.example.demo.TarefaControllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Tarefas;
import com.example.demo.TarefasRepo;

import jakarta.validation.Valid;


@RestController
public class EditarController {
	@Autowired
	private TarefasRepo tarefaRepo;
	
	@PutMapping("/editar/{id}")
	public ResponseEntity<?> editarTarefa(@PathVariable Long id,@Valid @RequestBody Tarefas tarefa) {
		
		
		Tarefas existingData = tarefaRepo.findById(id)
				.orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
		
			existingData.setTitulo(tarefa.getTitulo());
			existingData.setDescricao(tarefa.getDescricao());
			existingData.setTipo(tarefa.getTipo());
			existingData.setPrioridade(tarefa.getPrioridade());
			
			tarefaRepo.save(existingData);
			return ResponseEntity.ok(Map.of(
	                "message", "Tarefa atualizada com sucessp",
	                "status", 200,
	                "data", existingData
	        ));
	}
}
