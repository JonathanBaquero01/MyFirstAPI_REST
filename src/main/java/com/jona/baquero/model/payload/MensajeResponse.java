package com.jona.baquero.model.payload;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder


//ESTA CLASE ES PARA GENERAR MENSAJES DE ERRORES PERSONALIZADOS ()
public class MensajeResponse {

	private String mensaje;
	private Object object;
}
