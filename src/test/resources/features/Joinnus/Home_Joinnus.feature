Feature: Proyecto Benefit Home Principal - Entretenimientos

Background:
	Given Usuario esta en la pagina principal de Benefit
	When  selecciona el menu de eventos
	Then  visualiza el Home principal
	 
Scenario: Validar la seccion de Categorias
	When  el Home de experiencias termine de cargar 
	Then  visualiza todas las categorías 

Scenario: Navegabilidad a Lista eventos
	When  selecciona la categoria "Arte & Cultura"
	Then  visualiza los Eventos de la categoria.

Scenario: Regresar de Lista Eventos a Homepage
	When  selecciona la categoria "Entretenimiento"
	Then  me mostrara la lista de eventos de la categoria seleccionada.
	And   al presionar regresar me lleva al Home principal
