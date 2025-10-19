package br.ifsp.gerenciador.repositorio;

import br.ifsp.gerenciador.dominio.Projeto;
import br.ifsp.gerenciador.dominio.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetoRepositorio extends JpaRepository<Projeto, Long> { }

