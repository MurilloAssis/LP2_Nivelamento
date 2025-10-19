package br.ifsp.gerenciador.service;

import br.ifsp.gerenciador.dominio.Usuario;
import br.ifsp.gerenciador.repositorio.TarefaRepositorio;
import br.ifsp.gerenciador.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private TarefaRepositorio tarefaRepositorio;

    public List<Usuario> findAll() {
        return usuarioRepositorio.findAll();
    }

    public Usuario findById(Long id) {
        return usuarioRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com id: " + id));
    }

    public Usuario create(Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }

    public Usuario update(Long id, Usuario usuarioDetails) {
        Usuario usuario = findById(id);
        usuario.setNome(usuarioDetails.getNome());
        usuario.setEmail(usuarioDetails.getEmail());
        return usuarioRepositorio.save(usuario);
    }

    public void delete(Long id) {

        if (tarefaRepositorio.existsByResponsavelId(id)) {
            throw new RuntimeException("Não é possível excluir usuário. Existem tarefas associadas.");
        }
        usuarioRepositorio.deleteById(id);
    }
}
