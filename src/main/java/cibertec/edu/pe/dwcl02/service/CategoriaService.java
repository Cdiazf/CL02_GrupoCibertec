package cibertec.edu.pe.dwcl02.service;

import cibertec.edu.pe.dwcl02.model.Categorias;

import java.util.List;

public interface CategoriaService {
    List<Categorias> getAllCategorias();
    Categorias getCategoriaById(int idtipo);
    void saveCategoria(Categorias categorias);
    void deleteCategoryById(int idtipo);

}
