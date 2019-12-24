Feature: Proyecto Benefit Crear Registro de Usuarios

Background:
	Given Usuario se encuentra en Interbank Benefit y desea crear una cuenta nueva


Scenario: Crear nuevo usuario
	When ingresa el nombre de usuario "IoriYagami"
	And selecciona el tipo de documento "Pasaporte" e ingresa el numero "111111111111111" 
	And selecciona el operador "Bitel" e ingresa el numero de celular "987654213"
	And presiona el boton siguiente del primer paso de registro
	And ingresa la contrasenia "Abc12345" y la confirmacion de la nueva contrasenia "Abc12345"
	And activa la seccion de tratamiento de mis datos personales y la seccion de terminos y condiciones
	And oprime el boton siguiente
	Then muestra el mensaje de "Ha sido registrado exitosamente"
	
@Test
Scenario Outline: Validacion del formulario Crear nuevo usuario
	When ingresa el nombre de usuario "<NombreUsuario>"
	And selecciona el tipo de documento "<TipoDocumento>" e ingresa el numero "<NumeroDocumento>" 
	And selecciona el operador "<TipoOperador>" e ingresa el numero de celular "<NumeroCelular>"
	And presiona el boton siguiente del primer paso de registro
	Then muestra mensajes de errores "<Msj_ErrorNombreUsuario>" "<Msj_ErrorTipoDocumento>" "<Msj_ErrorNumeroDocumento>" "<Msj_ErrorTipoOperador>" "<Msj_ErrorNumeroOperador>"
Examples:
    | NombreUsuario | TipoDocumento | NumeroDocumento | TipoOperador	| NumeroCelular    | Msj_ErrorNombreUsuario   | Msj_ErrorTipoDocumento        | Msj_ErrorNumeroDocumento              | Msj_ErrorTipoOperador  | Msj_ErrorNumeroOperador   |    
	| 				| 	  DNI       | 47541286	      | Claro		    | 935985500		   | Debe ingresar un usuario | 							  |										  |						   | 						   |
	| AnthonyLight  | 				| 47541286   	  | Claro   	    | 935985500		   | 						  | Debe elegir un tipo documento |										  |						   | 						   |
	| AnthonyLight  | 	  DNI		|				  | Claro   	    | 935985500		   | 						  | 						  	  |	Debes ingresar tu número de documento | 					   | 						   |	
	| AnthonyLight  | 	  DNI		| 47541286		  | 			    | 935985500		   | 					      | 							  |										  |	Debe elegir un operador| 						   |
	| AnthonyLight  | 	  DNI		| 47541286  	  | Claro   	    | 				   | 						  | 							  |										  |						   | Debe ingresar un teléfono |		