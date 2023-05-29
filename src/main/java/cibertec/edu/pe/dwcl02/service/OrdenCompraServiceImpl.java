package cibertec.edu.pe.dwcl02.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cibertec.edu.pe.dwcl02.model.OrdenCompra;
import cibertec.edu.pe.dwcl02.repository.IOrdenCompraRepository;

@Service
public class OrdenCompraServiceImpl implements OrdenCompraService{
	@Autowired
	private IOrdenCompraRepository ordenCompraRepository;
	@Override
	public List<OrdenCompra> getAllOrdenCompras(){
		return ordenCompraRepository.findAll();
	}
	
	@Override
	public void saveOrden(OrdenCompra ordenCompra) {
		this.ordenCompraRepository.save(ordenCompra);
	}
	
	@Override
	public OrdenCompra getOrdenById(String idorden) {
		Optional<OrdenCompra>optional=ordenCompraRepository.findById(idorden);
		OrdenCompra ordenCompra=null; 
		if(optional.isPresent()) {
			ordenCompra=optional.get();
		} else {
			throw new RuntimeException("Orden de compra no encontrado con el ID::"+idorden);			
		}
		return ordenCompra;
	}
	
	@Override
	public void deleteOrdenById(String idorden) {
		this.ordenCompraRepository.deleteById(idorden);
	}

}
