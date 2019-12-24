Feature: Proyecto Benefit Home Mi Perfil

Background:
	Given Usuario se encuentra logeado en Interbank Benefit con la cuenta "cliente002" y password "abc12345"
	And Usuario se encuentra en la seccion Mi Perfil
	And selecciona el link de cambiar contrasenia
	And ingresa la contraseña actual "abc12345"
	And ingresa la nueva contrasenia "abc12345" 
	And ingresa la confirmacion de la nueva contrasenia "abc12345" 
	When presiona el boton de cambiar contrasenia
	Then muestra el mensaje "Tu contraseña se ha cambiado exitosamente"
	
Scenario: Cambio de contrasenia desde Perfil
	When selecciona el link de cambiar contrasenia
	And ingresa la contraseña actual "abc123456"
	And ingresa la nueva contrasenia "contrasenia" 
	And muestra el nivel bajo de Seguridad "Poco seguro"
	And ingresa la nueva contrasenia "benefit1" 
	And muestra el nivel Medio de Seguridad "Medio seguro"
	And ingresa la nueva contrasenia "Abc1235$"
	And muestra el nivel mas Alto de Seguridad "Muy seguro"
	
@Test	
Scenario Outline: Mensajes de Error en cambio de Contrasenia desde Mi Perfil	
	When selecciona el link de cambiar contrasenia
	And  ingresa la contraseña actual "<ContraseniaActual>"
	And  ingresa la nueva contrasenia "<ContraseniaNueva>"
	And  ingresa la confirmacion de la nueva contrasenia "<ContraseniaConfirmar>"
	And  presiona el boton de cambiar contrasenia
	Then muestra mensajes de errores "<Msj_ContraseniaActual>" "<Msj_ErrorContraseniaNueva>" "<Msj_ErrorContraseniaConfirmar>"
Examples:
    | ContraseniaActual  | ContraseniaNueva  | ContraseniaConfirmar | Msj_ContraseniaActual 			| Msj_ErrorContraseniaNueva    | Msj_ErrorContraseniaConfirmar |    
	| 			   		 | abc12345          | abc12345          	| Debe ingresar una contraseña		| 							   | 						       |
	| abc12345           | 					 | abc12345          	| 									| Debe ingresar una contraseña |    						   |
	| abc12345           | abc12345          | 						| 									| 							   | Debe ingresar una contraseña  |
	| 					 |					 | 						| Debe ingresar una contraseña		| Debe ingresar una contraseña | Debe ingresar una contraseña  |	