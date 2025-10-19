package br.ifsp.gerenciador.repositorio;

import br.ifsp.gerenciador.dominio.Tarefa;
import br.ifsp.gerenciador.dominio.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> { }

