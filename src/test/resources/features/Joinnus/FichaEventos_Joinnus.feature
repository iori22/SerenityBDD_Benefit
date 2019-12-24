Feature: Proyecto Benefit Ficha de Eventos

Background: 
	Given Usuario esta en la pagina principal de entretenimiento
	And   Usuario selecciona la categoria "Deportes"
	When  selecciona evento "Fitness Pass" 	  

Scenario: Estructura Ficha Evento 	 
	Then  visualiza seccion de descripcion 
	And   seccion zona entradas  
	And   seccion zona de ubicacion
 
Scenario: Validar el enlace mostrar todo de la Ficha Evento 
	When selecciona el enlace Mostrar todo 
	Then visualiza la descripcion completa del evento 
	And  visualiza el enlace Mostrar menos 

@Test
Scenario: Validar el enlace de Ubicacion 
	When selecciona el enlace de direccion que aparece en la seccion Ubicacion 
	Then visualiza en otra pestaña el mapa de google maps 
	
Scenario: Ver actualizacion de Millas y Dinero en la zona racional al seleccionar entradas 
	When   selecciona 1 entrada por cada tipo que exista para el evento 
	Then   visualiza en la zona racional el total de Millas y Soles actualizados 
	
Scenario: Ir a la pantalla completa tu canje Login Off 
	And    selecciona 1 entrada por cada tipo que exista para el evento
	When   selecciona continuar 
	Then   visualiza un formulario de logeo 


Scenario: Ir a la pantalla completa tu canje Login On 
	And    selecciona 1 entrada por cada tipo que exista para el evento
	And    selecciona continuar
	When   ingresa el usuario "cliente002" y password "abc12345" 	
	Then   visualiza la seccion "Completa tu canje" 