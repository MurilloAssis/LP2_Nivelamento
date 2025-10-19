package br.ifsp.gerenciador.service;

import br.ifsp.gerenciador.dominio.Projeto;
import br.ifsp.gerenciador.dominio.Usuario;
import br.ifsp.gerenciador.repositorio.ProjetoRepositorio;
import br.ifsp.gerenciador.repositorio.TarefaRepositorio;
import br.ifsp.gerenciador.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetoService {
    @Autowired
    private ProjetoRepositorio projetoRepositorio;

    @Autowired
    private TarefaRepositorio tarefaRepositorio;

    public List<Projeto> findAll() {
        return projetoRepositorio.findAll();
    }

    public Projeto findById(Long id) {
        return projetoRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado com id: " + id));
    }

    public Projeto create(Projeto projeto) {
        return projetoRepositorio.save(projeto);
    }

    public Projeto update(Long id, Projeto projetoDetails) {
        Projeto projeto = findById(id);
        projeto.setNome(projetoDetails.getNome());
        projeto.setDescricao(projetoDetails.getDescricao());
        return projetoRepositorio.save(projeto);
    }

    public void delete(Long id) {

        if (tarefaRepositorio.existsByProjetoId(id)) {
            throw new RuntimeException("Não é possível excluir projeto. Existem tarefas associadas.");
        }
        projetoRepositorio.deleteById(id);
    }
}
