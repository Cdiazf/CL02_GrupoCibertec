package cibertec.edu.pe.dwcl02.repository;

import cibertec.edu.pe.dwcl02.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductoRepository extends JpaRepository<Producto,String> {
}
