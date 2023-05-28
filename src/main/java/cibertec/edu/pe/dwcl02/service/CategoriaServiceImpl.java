package cibertec.edu.pe.dwcl02.service;

import cibertec.edu.pe.dwcl02.model.Categorias;
import cibertec.edu.pe.dwcl02.repository.ICategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService{

    @Autowired
    private ICategoriaRepository categoriaRepository;
    @Override
    public List<Categorias> getAllCategorias() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categorias getCategoriaById(int idtipo) {
        Optional<Categorias> optional=categoriaRepository.findById(idtipo);
        Categorias categorias=null;
        if(optional.isPresent()){
            categorias=optional.get();
        }else{
            throw new RuntimeException("Categoria no encontrado con el ID::"+idtipo);
        }
        return categorias;
    }

    @Override
    public void saveCategoria(Categorias categorias) {
         this.categoriaRepository.save(categorias);
    }

    @Override
    public void deleteCategoryById(int idtipo) {
        this.categoriaRepository.deleteById(idtipo);
    }
}
