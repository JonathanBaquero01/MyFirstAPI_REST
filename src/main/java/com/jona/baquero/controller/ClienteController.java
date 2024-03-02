package com.jona.baquero.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jona.baquero.model.entity.Cliente;
import com.jona.baquero.service.ICliente;

//EL CONTROLLER ES EL Q PIDE LOS DATOS DEL FRONT END

@RestController //le digo q esta clase es u controlador
@RequestMapping("/api/v1") //le digo q es un recurso q trabajara con las URL

public class ClienteController {
	
	
	@Autowired //inyeccion de dependencias
	private ICliente iclienteService;
	
	
	@PostMapping("cliente")
	@ResponseStatus(HttpStatus.CREATED)//ME DARA LA RESPUESTA ESPECIFICA SI HAY UN ERROR O ALGO.SON RESPUESTAS POR DEFECTO QUE CREO
    //@RequestBody ->>indica q va a recibir datos del frondEnd, en este caso los recibe de DatosRegistroMedico, q es el q pide los datos
	public Cliente create (@RequestBody Cliente cliente) {
	
		 return iclienteService.save(cliente);
		 
		 
	/*	return  ClienteDto.builder()
                .idCliente(cliente.getIdCliente())
                .nombre(cliente.getNombre())
                .apellido(cliente.getApellido())
                .correo(cliente.getCorreo())
                .fechaRegistro(cliente.getFechaRegistro())
                .build();*/
		
		//return iclienteService.save(clienteDto);
	}
	
	@PutMapping("cliente")
	@ResponseStatus(HttpStatus.CREATED)//ME DARA LA RESPUESTA ESPECIFICA SI HAY UN ERROR O ALGO.SON RESPUESTAS POR DEFECTO QUE CREO
	public Cliente update (@RequestBody Cliente cliente) {
		 
		return iclienteService.save(cliente);
		
		 /*return ClienteDto.builder()
		        .idCliente(cliente.getIdCliente())
		        .nombre(cliente.getNombre())
		        .apellido(cliente.getApellido())
		        .correo(cliente.getCorreo())
		        .fechaRegistro(cliente.getFechaRegistro())
		        .build();*/
	}
	
	@PutMapping("cliente/{Id}")//en postman le doy el id por la URL y el resto en formato Json(lo q actualizara)
	@ResponseStatus(HttpStatus.CREATED)//ME DARA LA RESPUESTA ESPECIFICA SI HAY UN ERROR O ALGO.SON RESPUESTAS POR DEFECTO QUE CREO
	public ResponseEntity<?> update(@RequestBody Cliente cliente, @PathVariable Integer Id) {
	
		  Cliente clienteExistente = iclienteService.findById(Id);
		if (clienteExistente != null) {
	        Cliente updatedCliente = iclienteService.save(cliente);
	        return ResponseEntity.ok(updatedCliente);
	    } else {
	        String errorMessage = "El registro que está actualizando no existe";
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
	    }
		
		 /*return ClienteDto.builder()
		        .idCliente(cliente.getIdCliente())
		        .nombre(cliente.getNombre())
		        .apellido(cliente.getApellido())
		        .correo(cliente.getCorreo())
		        .fechaRegistro(cliente.getFechaRegistro())
		        .build();*/
	}
	
	
	
	
	@DeleteMapping("cliente/{Id}")//cojo el id de la URL
	//recibe el Id solamente del cliente
	public ResponseEntity<?> delete (@PathVariable Integer Id) {
	                           	//@PathVariable le digo  q el id que le doy viene de una variable de la URL
		 //ResponseEntity me dice la respuesta q genero el metodo, si fue exitosa  o que. maneja toda la respeusta HTTP (EL <?> es q objeto no se sabe cual es)
		
		try {
			//busco el cliente por el id
			Cliente cliente = iclienteService.findById(Id);
			 iclienteService.delete(cliente);
			 return new ResponseEntity<>(cliente, HttpStatus.NO_CONTENT);
			 
			 
		} catch (Exception e) {
			String errorMessage = "Hubo un error al procesar la solicitud: " + e.getMessage();
		    return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		 
	//	 return ResponseEntity.noContent().build();
	}
	
	
	
	
	
	//EN POSTMAN PUEDES PONER CON EL METODO GET localhost:8080/api/v1/cliente/1 Y TE DA EL USUARIO
	@GetMapping("cliente/{Id}")//cojo el id de la URL
	@ResponseStatus(HttpStatus.OK)//ME DARA LA RESPUESTA ESPECIFICA SI HAY UN ERROR O ALGO.SON RESPUESTAS POR DEFECTO QUE CREO
	public Cliente showById(@PathVariable Integer Id) {
	                      	//@PathVariable le digo  q el id que le doy viene de una variable de la URL
		return iclienteService.findById(Id);
		
		/*return  ClienteDto.builder()
                .idCliente(cliente.getIdCliente())
                .nombre(cliente.getNombre())
                .apellido(cliente.getApellido())
                .correo(cliente.getCorreo())
                .fechaRegistro(cliente.getFechaRegistro())
                .build();*/
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
