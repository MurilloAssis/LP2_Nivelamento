package br.ifsp.gerenciador.controller;

import br.ifsp.gerenciador.dominio.Projeto;
import br.ifsp.gerenciador.service.ProjetoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;


    @PostMapping
    public ResponseEntity<Projeto> create(@Valid @RequestBody Projeto Projeto) {
        Projeto novoUsuario = projetoService.create(Projeto);
        return ResponseEntity.created(URI.create("/usuarios/" + novoUsuario.getId())).body(novoUsuario);
    }


    @GetMapping
    public ResponseEntity<List<Projeto>> listAll() {
        return ResponseEntity.ok(projetoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Projeto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(projetoService.findById(id));
    }


    @PutMapping("/{id}")
    public ResponseEntity<Projeto> update(@PathVariable Long id, @Valid @RequestBody Projeto Projeto) {
        return ResponseEntity.ok(projetoService.update(id, Projeto));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        projetoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}