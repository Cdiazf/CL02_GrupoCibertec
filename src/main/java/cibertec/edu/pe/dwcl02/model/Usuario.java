package cibertec.edu.pe.dwcl02.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "tb_usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private String idusu;
    @Column(name ="nombre")
    private String nombre;
    
    @Column(name ="apellido")
    private String apellido;
    
    @Column(name ="email")
    private double email;
    
    @Column(name ="contraseña")
    private double contraseña;
    
}