package cibertec.edu.pe.dwcl02.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cibertec.edu.pe.dwcl02.model.Proveedor;
import cibertec.edu.pe.dwcl02.service.ProveedorService;

@Controller
@RequestMapping("/Proveedor")
public class ProveedorController {

	@Autowired
	private ProveedorService proveedorsevice;

	 @GetMapping("/listadoProveedor")
	    public String listadoProveedor(Model model){
	        Proveedor proveedor= new Proveedor();
	        model.addAttribute("lstProveedor",proveedorsevice.getAllProveedores());
	        model.addAttribute("proveedor",proveedor);
	        return "Proveedor/ListarProveedor";
	    }

	    @PostMapping("/saveProveedor")
	    public String saveProveedor(@ModelAttribute("proveedor")Proveedor proveedor){
	        proveedorsevice.saveProveedor(proveedor);
	        return "redirect:/Proveedor/listadoProveedor";
	    }
	    
	   
	    @GetMapping("/updateProveedor/{idprov}")
	    public ResponseEntity<Proveedor> updateProveedor(@PathVariable(value = "idprov") String idprov) {
	        // Get the product from the service
	        Proveedor proveedor = proveedorsevice.getProveedorById(idprov);

	        if (proveedor == null) {
	            // Return an appropriate response if the product is not found
	            return ResponseEntity.notFound().build();
	        }

	        // Return the product in the response body
	        return ResponseEntity.ok(proveedor);
	    }
	    
	    
	    	   

	    @GetMapping("/deleteProveedor/{idprov}")
	    public String deleteProveedor(@PathVariable(value="idprov") String idprov) {
	        this.proveedorsevice.deleteProveedorById(idprov);
	        return "redirect:/Proveedor/listadoProveedor";
	    }
	    
	  
}
