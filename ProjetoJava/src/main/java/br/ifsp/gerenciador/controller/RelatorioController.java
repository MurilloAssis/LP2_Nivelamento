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
@RequestMapping("/relatorios")
public class RelatorioController {

    @Autowired
    private RelatorioService relatorioService;


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