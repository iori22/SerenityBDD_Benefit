Feature: Proyecto Benefit Home Mi Perfil

Background:
	Given Usuario se encuentra logeado en Interbank Benefit con la cuenta "cliente002" y password "abc12345" - Perfil
	And Usuario se encuentra en Mi Perfil
	

Scenario: Cambio de Numero Celular desde Mi Perfil
	When selecciona el link de cambiar celular	
	And  ingresa el nuevo numero del celular "989989898"
	And  reingresa el numero del celular "989989898"
	And  selecciona el operador "Claro" 
	And  presiona el boton siguiente
	And  ingresa el codigo de seguridad enviado al email registrado y presiona el boton guardar
	Then muestra el aviso "Tu celular se ha cambiado exitosamente" 	

@Test
Scenario: Mensajes de Error en el ingreso de Codigo de Seguridad
	When selecciona el link de cambiar celular	
	And  ingresa el nuevo numero del celular "989989898"
	And  reingresa el numero del celular "989989898"
	And  selecciona el operador "Claro" 
	And  presiona el boton siguiente
	And  ingresa el codigo de seguridad enviado al email registrado y presiona el boton guardar
	Then muestra mensaje de error "Ingresa un código de seguridad válido." debido a que el codigo de seguridad es incorrecto.


Scenario Outline: Mensajes de Error en cambio de Numero Celular desde Mi Perfil	
	When selecciona el link de cambiar celular	
	And  ingresa el nuevo numero del celular "<Numero01>"
	And  reingresa el numero del celular "<Numero02>"
	And  selecciona el operador "<Operador>" 
	And  presiona el boton siguiente	
	Then muestra mensaje de error "<Msj_ErrorNumero>" "<Msj_ErrorNumero02>" "<Msj_ErrorOperador>"
Examples:
    | Numero01  | Numero02   | Operador     | Msj_ErrorNumero 			| Msj_ErrorNumero02 		 | Msj_ErrorOperador	   |    
	| 989989898 |            | Selecciona   | 							| Debe ingresar un teléfono  | Debe elegir un operador |
	| 			|989989898   | Selecciona   | Debe ingresar un teléfono | 						 	 | Debe elegir un operador |
	| 989989898 | 989989898  | Selecciona   | 							|                            | Debe elegir un operador |
    | 			| 989989898  | Claro        | Debe ingresar un teléfono	| 							 | 						   | 
	| 			| 			 | Selecciona   | Debe ingresar un teléfono | Debe ingresar un teléfono  | Debe elegir un operador |