package com.example.demo.TarefaControllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Tarefas;
import com.example.demo.TarefasRepo;

@RestController
public class DeletarController {
	@Autowired
	private TarefasRepo tarefaRepo;
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deletarTarefa(@PathVariable Long id){
		Tarefas tarefa = tarefaRepo.findById(id)
		            .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));	
		
		tarefaRepo.deleteById(id);
		
		List<Tarefas> tarefasLista = tarefaRepo.findAll();	
		
		
		return ResponseEntity.ok(Map.of(
	                "message", "Tarefa deletada com sucesso",
	                "status", 200,
	                "data", tarefasLista
	        ));
	}
}
