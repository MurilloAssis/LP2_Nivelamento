package br.ifsp.gerenciador.repositorio;

import br.ifsp.gerenciador.dominio.Categoria;
import br.ifsp.gerenciador.dominio.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepositorio extends JpaRepository<Categoria, Long> { }

