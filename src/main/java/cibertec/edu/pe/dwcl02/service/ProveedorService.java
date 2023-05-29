package cibertec.edu.pe.dwcl02.service;

import java.util.List;

import cibertec.edu.pe.dwcl02.model.Proveedor;

public interface ProveedorService {

	List<Proveedor> getAllProveedores();
	
	void saveProveedor(Proveedor proveedor);
	
	void deleteProveedorById(String idprov);
		 
	Proveedor getProveedorById(String idprov);


	



	
}
