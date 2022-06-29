package com.agendamigo.services;

import com.agendamigo.models.Usuario;
import com.agendamigo.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;
    public void guardarUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario buscarId(Long id) {
        return usuarioRepository.findById(id).get();
    }

    public void eliminarPorId(Long id) {
        usuarioRepository.deleteById(id);
    }
}
