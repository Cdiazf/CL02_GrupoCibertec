package cibertec.edu.pe.dwcl02.service;

import java.util.List;

import cibertec.edu.pe.dwcl02.model.OrdenCompra;

public interface OrdenCompraService {
	
	List<OrdenCompra> getAllOrdenCompras();
	
	void saveOrden(OrdenCompra ordenCompra);
	
	OrdenCompra getOrdenById(String idorden);
	
	void deleteOrdenById(String idorden);

}
