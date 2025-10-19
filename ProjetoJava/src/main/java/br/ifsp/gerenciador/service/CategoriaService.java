package br.ifsp.gerenciador.service;

import br.ifsp.gerenciador.dominio.Categoria;
import br.ifsp.gerenciador.repositorio.CategoriaRepositorio;
import br.ifsp.gerenciador.repositorio.TarefaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepositorio categoriaRepositorio;

    @Autowired
    private TarefaRepositorio tarefaRepositorio;

    public List<Categoria> findAll() {
        return categoriaRepositorio.findAll();
    }

    public Categoria findById(Long id) {
        return categoriaRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada com id: " + id));
    }

    public Categoria create(Categoria categoria) {
        return categoriaRepositorio.save(categoria);
    }

    public Categoria update(Long id, Categoria categoriaDetails) {
        Categoria categoria = findById(id);
        categoria.setNome(categoriaDetails.getNome());
        return categoriaRepositorio.save(categoria);
    }

    public void delete(Long id) {
        if (tarefaRepositorio.existsByCategoriaId(id)) {
            throw new RuntimeException("Não é possível excluir categoria. Existem tarefas associadas.");
        }
        categoriaRepositorio.deleteById(id);
    }
}
