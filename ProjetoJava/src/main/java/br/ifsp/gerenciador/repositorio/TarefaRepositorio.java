package br.ifsp.gerenciador.repositorio;


import br.ifsp.gerenciador.dominio.Status;
import br.ifsp.gerenciador.dominio.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TarefaRepositorio extends JpaRepository<Tarefa, Long> {


    boolean existsByProjetoId(Long projetoId);

    boolean existsByResponsavelId(Long usuarioId);

    boolean existsByCategoriaId(Long categoriaId);


    List<Tarefa> findByStatus(Status status);


    List<Tarefa> findByPrazoBefore(LocalDate hoje);


    @Query("SELECT t.projeto.nome, COUNT(t) FROM Tarefa t GROUP BY t.projeto.nome")
    List<Object[]> countTarefasPorProjeto();


    @Query("SELECT t.responsavel.nome, COUNT(t) FROM Tarefa t GROUP BY t.responsavel.nome")
    List<Object[]> countTarefasPorUsuario();
}

