package cibertec.edu.pe.dwcl02.controller;

import cibertec.edu.pe.dwcl02.model.Usuario;
import cibertec.edu.pe.dwcl02.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/Usuario")

public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    @GetMapping("/listarUsuarios")
    public String listarUsuarios(Model model){
        Usuario usuario = new Usuario();
        model.addAttribute("lstusuario",usuarioService.getAllUsuarios());
        model.addAttribute("usuario",usuario);
        return "Usuario/ListarUsuarios";
    }

    @PostMapping("/saveUsuario")
    public String saveUsuario(@ModelAttribute("usuario") Usuario usuario){
        usuarioService.saveUsuario(usuario);
        return "redirect:/Usuario/listarUsuarios";
    }
    
    @GetMapping("/updateUsuario/{idusu}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable(value = "idusu") int idusu) {
        // Get the product from the service
    	Usuario usuario = usuarioService.getUsuarioById(idusu);

        if (usuario == null) {
            // Return an appropriate response if the product is not found
            return ResponseEntity.notFound().build();
        }

        // Return the product in the response body
        return ResponseEntity.ok(usuario);
    }

    @GetMapping("/deleteUsuario/{idusu}")
    public String usuarioCategoria(@PathVariable(value = "idusu") int idusu){
        this.usuarioService.deleteUsuarioById(idusu);
        return "redirect:/Usuario/listarUsuarios";
    }
}
