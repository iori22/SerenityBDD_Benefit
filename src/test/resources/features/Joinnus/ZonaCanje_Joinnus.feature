Feature: Proyecto Benefit Zona Canje - Entretenimientos
Como Cliente
Deseo completar los datos necesarios
Para poder canjear el evento que tanto deseo
Background: 
	Given Usuario se encuentra logeado en Interbank Benefit con la cuenta "cliente_ce_06" y el password "abc12345"
	And   selecciona la categoria del evento "Deportes"
	Then  elige el evento de su interes "Fitness Pass" 
	And   selecciona la 1 entrada 
	And   selecciona continuar de la Ficha

#Canje Millas
Scenario: Canje de Evento con Millas	
	Given Usuario ingresa su Nombre completo "Iori" "Yagami" 
	And   ingresa su numero de documento "22082208"
	And   presiona Continuar del primer Paso
	And   presiona Continuar del Segundo Paso 
	And   ingresa codigo SMS
	When  presiona canjear
	Then  se visualiza el comprobante de pago

#Canje PAGO SOLES
@Test
Scenario Outline: Canje de Evento con Pago Soles
	Given Usuario ingresa su Nombre completo "Alexis" "Marquez" 
	And   ingresa su numero de documento "12345678"
	And   presiona Continuar del primer Paso
	And   selecciona el enlace Editar
	And   en el modal ingresa "1000" millas y aceptar
	And   presiona Continuar del Segundo Paso
	And   selecciona la "<Tarjeta>" a utilizar
	And   ingresa el "<Mes_anio>" y "<CVV>" de la tarjeta
	And   se ingresa codigo SMS
    When  presiona canjear
	Then  se visualiza el comprobante de pago
 
 Examples:
    | Tarjeta   			| Mes_anio | CVV     |
    | 377754500181372    	| 0623     | 3480    |
 #   | 377754500181372    	| 0623     | 3480    |