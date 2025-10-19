package br.ifsp.gerenciador.controller;

import br.ifsp.gerenciador.dominio.Categoria;
import br.ifsp.gerenciador.service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;


    @PostMapping
    public ResponseEntity<Categoria> create(@Valid @RequestBody Categoria Categoria) {
        Categoria novoUsuario = categoriaService.create(Categoria);
        return ResponseEntity.created(URI.create("/usuarios/" + novoUsuario.getId())).body(novoUsuario);
    }


    @GetMapping
    public ResponseEntity<List<Categoria>> listAll() {
        return ResponseEntity.ok(categoriaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Long id) {
        return ResponseEntity.ok(categoriaService.findById(id));
    }


    @PutMapping("/{id}")
    public ResponseEntity<Categoria> update(@PathVariable Long id, @Valid @RequestBody Categoria Categoria) {
        return ResponseEntity.ok(categoriaService.update(id, Categoria));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        categoriaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}