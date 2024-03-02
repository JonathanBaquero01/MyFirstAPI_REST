package com.jona.baquero.model.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data //Es pa que Lombok haga los getters y setters pero igual los hago manual
@AllArgsConstructor //q genere el constructor con todos los argumentos
@NoArgsConstructor// genere cosntructor vacio
@ToString
@Entity//le digo q esta clase es una entidad, osea q esta clase es una tabla en la BD

@Table(name = "cliente") //le digo como esta nombrada en la BD
public class Cliente {

	
	 @Id//le digo q el sgte atributo es el ID
	 @Column (name = "id")//nombre de como esta la columna del id en la BD
	 @GeneratedValue(strategy = GenerationType.IDENTITY)//Es una forma de decir:cuando guarde este objeto en la BD,dame un número único para él, y déja que la BD se encargue de eso
	    //GenerationType.IDENTITY, es Déjale el trabajo a la base de datos. Ella sabrá cómo hacerlo.
	private Integer  Id;
	
	 @Column (name = "nombre")
	private String Nombre;
	
	 @Column (name = "apellido")
	private String Apellido;
	
	 @Column (name = "correo")
	private String Correo;
	
	 @Column (name = "fecharegistro")
	private Date FechaRegistro;

	 
	 
	 //CONSTRUCTOR
	 public Cliente(Integer id, String nombre, String apellido, String correo, Date fechaRegistro) {
		super();
		Id = id;
		Nombre = nombre;
		Apellido = apellido;
		Correo = correo;
		FechaRegistro = fechaRegistro;
	}

	//CONSTRUCTOR VACIO
	 public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	//GETTERS Y SETTERS
	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	public String getCorreo() {
		return Correo;
	}

	public void setCorreo(String correo) {
		Correo = correo;
	}

	public Date getFechaRegistro() {
		return FechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		FechaRegistro = fechaRegistro;
	}

	
	 
	 
	 
	 
	 
	 
	 
	 
}
