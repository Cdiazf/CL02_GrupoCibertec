package cibertec.edu.pe.dwcl02.controller;

import cibertec.edu.pe.dwcl02.model.Producto;
import cibertec.edu.pe.dwcl02.service.CategoriaService;
import cibertec.edu.pe.dwcl02.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/Producto")
public class ProductosController {

    @Autowired
    private ProductoService productoService;
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/listadoProductos")
    public String listadoProductos(Model model){
        Producto producto= new Producto();
        model.addAttribute("lstProductos",productoService.getAllProductos());
        model.addAttribute("lstCategoria",categoriaService.getAllCategorias());
        model.addAttribute("producto",producto);
        return "Producto/ListarProductos";
    }

    @PostMapping("/saveProducto")
    public String saveProducto(@ModelAttribute("producto") Producto producto){
        productoService.saveProducto(producto);
        return "redirect:/Producto/listadoProductos";
    }


    @GetMapping("/updateProducto/{idprod}")
    public ResponseEntity<Producto> updateProducto(@PathVariable(value = "idprod") String idprod) {
        // Get the product from the service
        Producto producto = productoService.getProductoById(idprod);

        if (producto == null) {
            // Return an appropriate response if the product is not found
            return ResponseEntity.notFound().build();
        }

        // Return the product in the response body
        return ResponseEntity.ok(producto);
    }


    @GetMapping("/deleteProducto/{idprod}")
    public String deleteProducto(@PathVariable(value="idprod") String idprod) {
        this.productoService.deleteProductoById(idprod);
        return "redirect:/Producto/listadoProductos";
    }



}
