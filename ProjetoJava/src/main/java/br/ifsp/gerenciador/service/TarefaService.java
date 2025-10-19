package br.ifsp.gerenciador.service;

import br.ifsp.gerenciador.dominio.Tarefa;
import br.ifsp.gerenciador.repositorio.TarefaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {
    @Autowired
    private TarefaRepositorio tarefaRepositorio;

    public List<Tarefa> findAll() {
        return tarefaRepositorio.findAll();
    }

    public Tarefa findById(Long id) {
        return tarefaRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada com id: " + id));
    }

    public Tarefa create(Tarefa tarefa) {
        return tarefaRepositorio.save(tarefa);
    }

    public Tarefa update(Long id, Tarefa tarefaDetails) {
        Tarefa tarefa = findById(id);
        tarefa.setTitulo(tarefaDetails.getTitulo());
        tarefa.setDescricao(tarefaDetails.getDescricao());
        tarefa.setProjeto(tarefaDetails.getProjeto());
        tarefa.setResponsavel(tarefaDetails.getResponsavel());
        tarefa.setCategoria(tarefaDetails.getCategoria());
        tarefa.setPrioridade(tarefaDetails.getPrioridade());
        tarefa.setStatus(tarefaDetails.getStatus());
        tarefa.setPrazo(tarefaDetails.getPrazo());

        return tarefaRepositorio.save(tarefa);
    }

    public void delete(Long id) {
        Tarefa tarefa = findById(id);
        tarefaRepositorio.delete(tarefa);
    }
}
