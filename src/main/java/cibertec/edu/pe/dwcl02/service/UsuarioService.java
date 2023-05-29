package cibertec.edu.pe.dwcl02.service;

import cibertec.edu.pe.dwcl02.model.Usuario;

import java.util.List;

public interface UsuarioService {

    List<Usuario> getAllUsuarios();

    void saveUsuario(Usuario usuario);

    Usuario getUsuarioById(int idusu);

    void deleteUsuarioById(int idusu);

}
