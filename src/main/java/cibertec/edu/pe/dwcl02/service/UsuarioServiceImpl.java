package cibertec.edu.pe.dwcl02.service;

import cibertec.edu.pe.dwcl02.model.Usuario;
import cibertec.edu.pe.dwcl02.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService{
    @Autowired
    private IUsuarioRepository usuarioRepository;
    @Override
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public void saveUsuario(Usuario usuario) {
        this.usuarioRepository.save(usuario);
    }

    @Override
    public Usuario getUsuarioById(int idusu) {
        Optional<Usuario> optional=usuarioRepository.findById(idusu);
        Usuario usuario=null;
        if(optional.isPresent()){
        	usuario=optional.get();
        }else{
            throw new RuntimeException("Usuario no encontrado con el ID::"+idusu);
        }
        return usuario;
    }

    @Override
    public void deleteUsuarioById(int idusu) {
        this.usuarioRepository.deleteById(idusu);
    }


}
