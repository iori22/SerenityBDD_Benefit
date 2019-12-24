Feature: Proyecto Benefit - Mesh Search All Worlds 

Background:                                                                                                                                                                              
        Given Usuario se encuentra logeado en Interbank Benefit (Mesh Search) con el usuario "cliente002" y contrasenia "abc12345"   
	
@Test	
Scenario: Verificar todos los filtros de la malla de productos
		Given Usuario selecciona el buscador y elige el boton "Productos"
		And  ingresa "VINO CAMA 750 EDT PRO POP" la caja de texto del Motor de búsqueda y oprime ENTER
		And  Selecciona el boton pagar solo con mis millas
		And  Selecciona 2 categorias
		When se selecciona el precio menor y mayor de la barra de millas
		Then muestra el total de productos de las categorias seleccionadas y se comprueba que el precio en millas de los productos mostrados se encuentran dentro del intervalo de la barra deslizante en la malla de resultados 
		
@Test	
Scenario Outline: Verificar todos los filtros de la malla de Vales
		Given Usuario selecciona el buscador y elige el boton "Vales de Consumo"
		And  ingresa "CIN ACH PER BAB CAS" la caja de texto del Motor de búsqueda y oprime ENTER
		And  Selecciona el boton pagar solo con mis millas
		And  Selecciona 2 categorias
		And  Selecciona "<Tipo_Vale>"
		When se selecciona el precio menor y mayor de la barra de millas
		Then muestra el total de vales de las categorias seleccionadas y se comprueba que el precio en millas de los productos mostrados se encuentran dentro del intervalo de la barra deslizante en la malla de resultados 
Examples:
    | Tipo_Vale   	      |
    | Digitales    	      |
    | Enviados a domicilio|
    | Giftcards           |
         

Scenario Outline: Verificar todos los filtros de la malla de Entretenimiento
		Given Usuario selecciona el buscador y elige el boton "Entretenimiento"
		And  ingresa "BIG MAN TRI EVE" la caja de texto del Motor de búsqueda y oprime ENTER
		And  Selecciona el boton pagar solo con mis millas
		And  Selecciona 3 categorias
		And  Selecciona "<Fechas>" en el filtro de fechas
		When se selecciona el precio menor y mayor de la barra de millas
		Then muestra el total de eventos de las categorias seleccionadas asi como el filtro de fecha seleccionado y se comprueba que el precio en millas de los  eventos mostrados se encuentran dentro del intervalo de la barra deslizante en la malla de resultados
Examples:
    | Fechas	   	    |
    | Este mes          |
    | Próximo mes       |
    | Todos    	      	|

