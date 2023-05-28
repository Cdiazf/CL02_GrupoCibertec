package cibertec.edu.pe.dwcl02.service;

import cibertec.edu.pe.dwcl02.model.Producto;

import java.util.List;

public interface ProductoService {

    List<Producto> getAllProductos();

    void saveProducto(Producto proveedor);

    Producto getProductoById(String idprod);

    void deleteProductoById(String idprod);

}