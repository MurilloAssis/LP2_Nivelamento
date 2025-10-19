package br.ifsp.gerenciador.service;

import br.ifsp.gerenciador.dominio.Status;
import br.ifsp.gerenciador.dominio.Tarefa;
import br.ifsp.gerenciador.repositorio.TarefaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RelatorioService {
    @Autowired
    private TarefaRepositorio tarefaRepositorio;


    public Map<Status, List<Tarefa>> getTarefasPorStatus() {
        Map<Status, List<Tarefa>> tarefasPorStatus = new HashMap<>();
        for (Status status : Status.values()) {
            tarefasPorStatus.put(status, tarefaRepositorio.findByStatus(status));
        }
        return tarefasPorStatus;
    }

    public List<Tarefa> getTarefasVencidas() {
        return tarefaRepositorio.findByPrazoBefore(LocalDate.now());
    }


    public Map<String, Map<String, Long>> getResumos() {
        Map<String, Long> resumoPorProjeto = tarefaRepositorio.countTarefasPorProjeto().stream()
                .collect(Collectors.toMap(
                        result -> (String) result[0],
                        result -> (Long) result[1]
                ));

        Map<String, Long> resumoPorUsuario = tarefaRepositorio.countTarefasPorUsuario().stream()
                .collect(Collectors.toMap(
                        result -> (String) result[0],
                        result -> (Long) result[1]
                ));

        Map<String, Map<String, Long>> resumos = new HashMap<>();
        resumos.put("porProjeto", resumoPorProjeto);
        resumos.put("porUsuario", resumoPorUsuario);

        return resumos;
    }
}
