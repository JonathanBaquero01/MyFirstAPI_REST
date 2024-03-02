package com.jona.baquero.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.jona.baquero.model.entity.Cliente;


                                                  //clase  //Tipo ID
public interface ClienteDao extends CrudRepository<Cliente, Integer> {

}
