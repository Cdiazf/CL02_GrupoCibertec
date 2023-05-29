package cibertec.edu.pe.dwcl02.repository;

import cibertec.edu.pe.dwcl02.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepository extends JpaRepository<Usuario,Integer> {
}
