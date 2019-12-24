Feature: Proyecto Benefit - Buscador en cabecera de navegación

Background:                                                                                                                                                                              
            Given Usuario se encuentra logeado en Interbank Benefit con la cuenta "cliente002" y contrasenia "abc12345"                                                                                                                                                                      
            When Selecciona la caja de texto del Motor de búsqueda del encabezado                                                                                                                                                                                     
			Then Verificar Motor de búsqueda                                                                                                                                                                                    

@Test
Scenario: 	Verificar la estructura del Motor de búsqueda                                               
            And Verificar el fondo del texto de la caja del buscador "Buscar en Productos"                                                                                                                                                                                                                                                                                                                                               
            And Verificar el titulo "Explorar búsqueda en"                                                                                                                                                                                 
            When Visualiza 5 botones de los mundos           
            Then Visualiza el boton "Productos"
            And Visualiza el boton "Vales de Consumo"  
            And Visualiza el boton "Entretenimiento"
            And Visualiza el boton "Canje en Tiendas"              
            And Visualiza el boton "Vuelos"            
            But No visualiza listado de búsquedas recientes                                                                                                                                                                                           

@Test
Scenario Outline:  Validar la funcionalidad al realizar una búsqueda de Producto                                                                                                                                                                                                       
            And Selecciona el botón "<Mundos>"                                                                                                                                                                              
            And Usuario ingresa "<caracteres>"                                                                                                                                                                                  
            When carga el buscador                                                                                                                                                                                           
            Then muestra Resultados "<Resultados>"                                                                                                                                                                                      		                                                                                                                                                          
Examples:                                                                                                                                                                                                     
|Mundos   |caracteres         |Resultados                             |                                                                                                                 
|Productos|b                  |                                       |                                                                                 
|Productos|bl                 |                                       |                                                                                                                                                                                    
|Productos|blanco             |Muestra lista de resultados de búsqueda|                                                                  
|Productos|chico              |Muestra lista de resultados de búsqueda|                                                                  
|Productos|cargador           |Muestra lista de resultados de búsqueda|                                                                  
|Productos|black label        |Muestra lista de resultados de búsqueda|                                                            
|Productos|3                  |                                       |                                                                                
|Productos|19                 |                                       |                                                                                
|Productos|750                |Muestra lista de resultados de búsqueda|                          
|Productos|750 ml             |Muestra lista de resultados de búsqueda|                                                                  
|Productos|12 años 750ml      |No se encontraron resultados           |                                                            
|Productos|Litt 2.0 24        |No se encontraron resultados           |                                                                  
|Productos|El Hornero         |No se encontraron resultados           |                                                            
|Productos|Mr. Grill          |No se encontraron resultados           |                                                      
|Productos|caja    china      |Muestra lista de resultados de búsqueda|                                                
|Productos|  camara           |Muestra lista de resultados de búsqueda|    
|Productos|Cámara             |Muestra lista de resultados de búsqueda|                                                                  
|Productos|x 24 mod.250 marrón|No se encontraron resultados           |  
|Productos|Vales              |No se encontraron resultados           |  
|Productos|hola mundo         |No se encontraron resultados           | 
 
@Test
Scenario Outline: Validar la funcionalidad al realizar una búsqueda de Vales de Consumo                                                                                                                                                                                                    
                And Selecciona el botón "<Mundos>"                                                                                                                                                                              
                And Usuario ingresa "<caracteres>"                                                                                                                                                                                  
                When carga el buscador                                                                                                                                                                                           
                Then muestra Resultados "<Resultados>"                                                                                                                                                                                      
Examples:                                                                                                                                                                                                     
                                                                                                                                                                                        
|Mundos           |caracteres         |Resultados                              |     
|Vales de Consumo|s                   |										   |                                                                       
|Vales de Consumo|se                  |										   |                                                                       
|Vales de Consumo|señor               |Muestra lista de resultados de búsqueda |                                                                             
|Vales de Consumo|limon               |Muestra lista de resultados de búsqueda |                                                                             
|Vales de Consumo|ilaria        	  |Muestra lista de resultados de búsqueda |                                                                             
|Vales de Consumo|plaza vea     	  |Muestra lista de resultados de búsqueda |                                                                             
|Vales de Consumo|Combo grande  	  |No se encontraron resultados       	   |                                                                                                                   
|Vales de Consumo|100           	  |No se encontraron resultados      	   |                                                 
|Vales de Consumo|casa de fuego 	  |Muestra lista de resultados de búsqueda |                                                                             
|Vales de Consumo|02 entradas   	  |No se encontraron resultados       	   |                                                                                                                                
|Vales de Consumo|Baby Club Chic	  |Muestra lista de resultados de búsqueda |                                                                             
|Vales de Consumo|Popeyes       	  |Muestra lista de resultados de búsqueda |                                                                                                                                                                           
|Vales de Consumo|  vea     		  |Muestra lista de resultados de búsqueda |                                                                                                                                                                     
|Vales de Consumo|Perfumerías Unidas  |Muestra lista de resultados de búsqueda |     
|Vales de Consumo|productos           |No se encontraron resultados      	   |
|Vales de Consumo|hola mundo          |No se encontraron resultados      	   | 
                

Scenario Outline: Validar la funcionalidad al realizar una búsqueda de Eventos                                                                                                                                                                                                          
                And Selecciona el botón "<Mundos>"                                                                                                                                                                              
                And Usuario ingresa "<caracteres>"                                                                                                                                                                                  
                When carga el buscador                                                                                                                                                                                           
                Then muestra Resultados "<Resultados>"                                                                                                                                                                                      
Examples:                                                                                                                                                                                                     
|Mundos 		|caracteres             |Resultados         					|                                                                    
|Entretenimiento|t                      | 										|                                                                          
|Entretenimiento|tri                    |No se encontraron resultados			|         		                                  
|Entretenimiento|mana ( barranco)       |No se encontraron resultados			|                                                                                
|Entretenimiento|a mana 1234            |No se encontraron resultados			|                                                                                   
|Entretenimiento|masacre                |No se encontraron resultados			|                                                                            
|Entretenimiento|plaza vea              |No se encontraron resultados			|                                                                                   
|Entretenimiento|70s 80s 90s            |No se encontraron resultados			|                                                                                
|Entretenimiento|51                     |										|         		                                                                        
|Entretenimiento|2019                   |No se encontraron resultados			|                                                                                   
|Entretenimiento|AMÉRICA                |No se encontraron resultados			|                                                                            
|Entretenimiento|AMERICA EN CLAVE SOL   |No se encontraron resultados			|                                                                                                                                                              
|Entretenimiento|Baby                   |No se encontraron resultados			|                                          
|Entretenimiento|Inicio/Invertir        |No se encontraron resultados			|                                                                                
|Entretenimiento|Stand Up - Amor del Mar|No se encontraron resultados			|                                                                                
|Entretenimiento|estacion               |No se encontraron resultados			|                                                                                   
|Entretenimiento|CERATI 60 + Soda       |No se encontraron resultados     		|                                                                          
|Entretenimiento|vales                  |No se encontraron resultados     		|                                                                    
|Entretenimiento|hola mundo             |No se encontraron resultados     		|                                                                                  

@Test
Scenario Outline: Validar la funcionalidad al realizar una búsqueda de Eventos                                                                                                                                                                                                          
                And Selecciona el botón "<Mundos>"                                                                                                                                                                              
                And Usuario ingresa "<caracteres>"                                                                                                                                                                                  
                When carga el buscador                                                                                                                                                                                           
                Then muestra Resultados "<Resultados>"                                                                                                                                                                                      
Examples:                                                                                                                                                                                                     
|Mundos          |caracteres             |Resultados                             |                                                                     
|Canje en Tiendas|t                      |                                       |                                                                   
|Canje en Tiendas|Now                    |Muestra lista de resultados de búsqueda|                                                   
|Canje en Tiendas|cineplanet             |Muestra lista de resultados de búsqueda|                                                                                
|Canje en Tiendas|47 Street              |Muestra lista de resultados de búsqueda|                                                                                   
|Canje en Tiendas|Diportto               |Muestra lista de resultados de búsqueda|                                                                            
|Canje en Tiendas|plaza vea              |No se encontraron resultados           |                                                                                                                                   
|Canje en Tiendas|M.bö                   |                                       |                                                                                       
|Canje en Tiendas|Mi Mar                 |Muestra lista de resultados de búsqueda|                                                     
|Canje en Tiendas|Mágico                 |Muestra lista de resultados de búsqueda|                                              
|Canje en Tiendas|Melissa Zapatos        |Muestra lista de resultados de búsqueda|                                                                                                                                
|Canje en Tiendas|Mr. Grill              |No se encontraron resultados           |                   
|Canje en Tiendas|Prüne                  |No se encontraron resultados           |

@Test
Scenario Outline: Validar la funcionalidad de búsquedas recientes / Validar la estructura de listado de búsquedas recientes por cada mundo     
                And Selecciona el botón "<Mundos1>"                                                                                                                                                                                 
                And Usuario ingresa "<Buscar1>"                                                                                                                                                                                       
                And Verificar listado de búsquedas                                                                                                                                                                                    
                And Selecciona la "<opcion1>" opción del resultado de la búsqueda          
                And Muestra la ficha del producto o evento
                And Selecciona la caja de texto del Motor de búsqueda del encabezado
                And Selecciona el botón "<Mundos2>"                                                                                                                                                                                 
                And Usuario ingresa "<Buscar2>"                                                                                                                                                                                       
                And Verificar listado de búsquedas                                                                                                                                                                                    
                And Selecciona la "<opcion2>" opción del resultado de la búsqueda
                And Muestra la ficha del producto o evento               
                And Selecciona la caja de texto del Motor de búsqueda del encabezado
                And Selecciona el botón "<Mundos3>"                                                                                                                                                                                 
                And Usuario ingresa "<Buscar3>"                                                                                                                                                                                       
                And Verificar listado de búsquedas                                                                                                                                                                                    
                And Selecciona la "<opcion3>" opción del resultado de la búsqueda
                And Muestra la ficha del producto o evento               
                And Selecciona la caja de texto del Motor de búsqueda del encabezado
                And Selecciona el botón "<Mundos4>"                                                                                                                                                                                 
                And Usuario ingresa "<Buscar4>"                                                                                                                                                                                       
                And Verificar listado de búsquedas                                                                                                                                                                                    
                And Selecciona la "<opcion4>" opción del resultado de la búsqueda
                And Muestra la ficha del producto o evento               
                And Selecciona la caja de texto del Motor de búsqueda del encabezado
                And Selecciona el botón "<Mundos5>"                                                                                                                                                                                 
                And Usuario ingresa "<Buscar5>"                                                                                                                                                                                       
                And Verificar listado de búsquedas                                                                                                                                                                                    
                And Selecciona la "<opcion5>" opción del resultado de la búsqueda
                And Muestra la ficha del producto o evento               
                And Selecciona la caja de texto del Motor de búsqueda del encabezado
                And Selecciona el botón "<Mundos6>"                                                                                                                                                                                 
                And Usuario ingresa "<Buscar6>"                                                                                                                                                                                       
                And Verificar listado de búsquedas                                                                                                                                                                                   
                And Selecciona la "<opcion6>" opción del resultado de la búsqueda
                When Muestra la ficha del producto o evento               
                Then Selecciona la caja de texto del Motor de búsqueda del encabezado                                                                                                                                                                                       
                And Verificar el titulo del listado de "Búsquedas recientes"                       
				And Verificar el nombre del mundo en la caja del buscador "Buscar en " "<Mundos6>"		                                                                                                                                                                                                                                                                                                                                     
                And Verificar como máximo "5" búsquedas recientes
                And Selecciona el "<Lista>" elemento de la lista de búsquedas recientes
                And Muestra la ficha del producto o evento o vale seleccionado 
                                                                                                                                                                                                            
  Examples:                                                                                                                                                                                                    
|Mundos1            |Buscar1   |opcion1|Mundos2         |Buscar2  |opcion2 |Mundos3   |Buscar3|opcion3|Mundos4           |Buscar4 |opcion4|Mundos5         |Buscar5  |opcion5 |Mundos6   |Buscar6 |opcion6|Lista|
|Vales de Consumo   |ACH       |1      |Productos       |MAN      |2       |Productos |swi    |3      |Canje en Tiendas  |Diportto|1      |Productos       |cas      |2       |Productos |man     |1      |1    |

@Test
Scenario Outline: Validar la opción "Ver mas resultados" de resultado de búsqueda por cada mundo                                                                                                                                                                                                            
                And Selecciona el botón "<Mundos>"                                                                                                                                                                                    
                And Usuario ingresa "<Palabra>"                                                                                                                                                                               
                And carga el buscador                                                                                                                                                                               
                And Muestra mas de "5" resultados
                                                                                                                                                                                                 
                When Selecciona la opción "Ver más resultados"                                                                                                                                                                             
                Then Muestra la malla de resultados
                And Verificar que la caja del buscador este presente el texto "Buscar"                                                                                                                                                                                                                                                                                                                                                                            
Examples:                                                                                                                                                                                                     
                |Mundos           |Palabra |                                                                                                                                                                                                    
                |Productos        |bla     |                                                                                            
                |Productos        |man     | 


Scenario Outline: Validar una búsqueda errada o sin resultados por cada mundo                                                                                                                                                                                                     
                And Selecciona el botón "<Mundos>"                                                                                                                                                                                    
                And Usuario ingresa "<Palabra>"                                                                                                                                                                                                                                                                                                                                                                         
                And Muestra el mensaje "No se encontraron resultados"     
                                                                                                                                                                                               
                When usuario presiona enter para buscar                                                                                                                                                                                                                                                                                                                                                                          
                Then Muestra un mensaje: "Sin resultados para " "<Palabra>"                                                                                                                                                 
                And  sub mensaje: "No encontramos ningún resultado para lo que buscaste. Intenta con otros términos de búsqueda."                                                                                                                                                                                                                                                                                                                                                                                      
Examples:                                                                                                                                                                                                      
                |Mundos           |Palabra |                                                                            
                |Vales de Consumo |mascota |                                                                                                                           
                |Productos        |fiestas |                                                                                            
                |Entretenimiento  |vales   |
                |Canje en Tiendas |everis  |  
 

Scenario Outline: Validar la funcionalidad de limpiar "X" la caja de texto del buscador                                                                                                                                                                                                         
                And Selecciona el botón "<Mundos>"                         
                And Verificar el nombre del mundo en la caja del buscador "Buscar en " "<Mundos>"                                                                                                                                                                          
                And Usuario ingresa "<Palabra>"                                                                                                                                                                               
                And carga el buscador                                                                                                                                                                                 
                When Selecciona la opción limpiar                                                                                                                                                                                 
                Then Visualiza la caja de texto en blanco                                                                                                                                                                                         
                And Visualiza resultado en blanco
				And Verificar el nombre del mundo en la caja del buscador "Buscar en " "<Mundos>"                                                                                         
                And Visualiza el titulo "Explorar búsqueda en"                                                                                                                                                                                   
                And Visualiza 5 botones de los mundos                         
Examples:                                                                                                                                                                                            
                |Mundos           |Palabra  |                                                                                            
                |Productos        |blan     |                                                                                                                                                                                                                                       
                |Entretenimiento  |mana     |
                |Canje en Tiendas |Diportto |
                |Vales de Consumo |mascota  |