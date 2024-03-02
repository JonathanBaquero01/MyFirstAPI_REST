package com.jona.baquero.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jona.baquero.model.dao.ClienteDao;
import com.jona.baquero.model.entity.Cliente;
import com.jona.baquero.service.ICliente;

import jakarta.transaction.Transactional;

//AQUI A LOS METODOS DE ICLIENTE, YA LOS PROGRAMO

@Service //le digo q esta clase trabajara como servicio
public class ClienteImlp implements ICliente {
	@Autowired//inyeccion de dependencias
	private ClienteDao clientedao;
	
	
	
	
	@Transactional //para q maneje todos los errores cuando se caiga, y haga todo automatico
	@Override
	public Cliente save(Cliente cliente) {
		
		
		return clientedao.save(cliente);
	}

	
	
	@Transactional //para q maneje todos los errores cuando se caiga, y haga todo automatico
	@Override
	public Cliente findById(Integer Id) {

		return  clientedao.findById(Id).orElse(null);//si no enceuntra el Id, pues q traiga nulo
	}
	
	
	
	
	@Transactional //para q maneje todos los errores cuando se caiga, y haga todo automatico
	@Override
	public void delete(Cliente cliente) {
		 clientedao.delete(cliente);
		
	}

}
