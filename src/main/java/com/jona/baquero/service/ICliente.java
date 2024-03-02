package com.jona.baquero.service;

import com.jona.baquero.model.entity.Cliente;

//AQUI DEFINO LOS METODOS Q TENDRA, SOLO EL NOMBRE Y LO Q RECIBE
public interface ICliente {

	//sabe guarda o actualiza, detecta automaticamente si el cliente existe o no
	Cliente save  (Cliente cliente);
	
	Cliente findById(Integer Id);
	
	void delete (Cliente cliente);

}
