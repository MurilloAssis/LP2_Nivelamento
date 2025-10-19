package br.ifsp.gerenciador.controller;

import br.ifsp.gerenciador.dominio.Status;
import br.ifsp.gerenciador.dominio.Tarefa;
import br.ifsp.gerenciador.service.RelatorioService;
import br.ifsp.gerenciador.service.TarefaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @Autowired
    private RelatorioService relatorioService;

    @PostMapping
    public ResponseEntity<Tarefa> create(@Valid @RequestBody Tarefa tarefa) {

        Tarefa novaTarefa = tarefaService.create(tarefa);
        return ResponseEntity.created(URI.create("/tarefas/" + novaTarefa.getId())).body(novaTarefa);
    }

    @GetMapping
    public ResponseEntity<List<Tarefa>> listAll() {
        return ResponseEntity.ok(tarefaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> findById(@PathVariable Long id) {
        return ResponseEntity.ok(tarefaService.findById(id));
    }


    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> update(@PathVariable Long id, @Valid @RequestBody Tarefa tarefa) {
        return ResponseEntity.ok(tarefaService.update(id, tarefa));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        tarefaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/por-status")
    public ResponseEntity<Map<Status, List<Tarefa>>> getTarefasPorStatus() {
        return ResponseEntity.ok(relatorioService.getTarefasPorStatus());
    }


    @GetMapping("/vencidas")
    public ResponseEntity<List<Tarefa>> getTarefasVencidas() {
        return ResponseEntity.ok(relatorioService.getTarefasVencidas());
    }


    @GetMapping("/resumo-projetos-usuarios")
    public ResponseEntity<Map<String, Map<String, Long>>> getResumos() {
        return ResponseEntity.ok(relatorioService.getResumos());
    }
}