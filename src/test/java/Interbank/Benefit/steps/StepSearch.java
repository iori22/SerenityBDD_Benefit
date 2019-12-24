package Interbank.Benefit.steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.Is.is;
import Interbank.Benefit.pageobject.PageObject_LoginBenni;
import Interbank.Benefit.pageobject.PageObject_Search;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepSearch {

	PageObject_Search pageObject_Search;
	PageObject_LoginBenni  pageObject_LoginBenni;
	@Given("^Usuario se encuentra logeado en Interbank Benefit con la cuenta \"([^\"]*)\" y contrasenia \"([^\"]*)\"$")
	public void usuario_esta_en_la_pagina_de_home_de_Benefit(String SUsuario,String SPassword) throws Exception {
		pageObject_Search.open();
		pageObject_LoginBenni.IniciarSesion_Login(SUsuario,SPassword);
	}

	@When("^Selecciona la caja de texto del Motor de búsqueda del encabezado$")
	public void selecciona_la_caja_de_texto_del_Motor_de_búsqueda_del_encabezado() throws Exception {
		pageObject_Search.ClickEn_Buscador();
	}

	@Then("^Verificar Motor de búsqueda$")
	public void visualiza_Motor_de_búsqueda() {
		assertThat(pageObject_Search.Desplegar_BuscadorAllMundos(), is(true));
	}
	
	@Then("^Verificar el fondo del texto de la caja del buscador \"([^\"]*)\" \"([^\"]*)\"$")
	public void verificar_el_fondo_del_texto_de_la_caja_del_buscador(String STextoBuscarEn,String SMundo) throws Exception {		
		assertThat(pageObject_Search.getTexto_BuscarEnProductos(), containsString(STextoBuscarEn+SMundo));
	}
	
	
	@Then("^Verificar el fondo del texto de la caja del buscador \"([^\"]*)\"$")
	public void verificar_el_fondo_del_texto_de_la_caja_del_buscador(String STextoBuscarEnProductos) throws Exception {
		assertThat(pageObject_Search.getTexto_BuscarEnProductos(), containsString(STextoBuscarEnProductos));
	}
	
	
	@Given("^Verificar el titulo \"([^\"]*)\"$")
	public void visualiza_el_titulo_Explorar_en(String STextoExplorarBusquedaEn) throws Exception {						
		assertThat(pageObject_Search.getTexto_ExplorarBusquedaEn(), is(STextoExplorarBusquedaEn));
	}

	@When("^Visualiza (\\d+) botones de los mundos$")
	public void visualiza_botones_de_los_mundos(int iCantidadBotones) throws Exception {
		assertThat(pageObject_Search.getCantidadBotones_Buscador(), is(iCantidadBotones));	    
	}

	@Then("^Visualiza el boton \"([^\"]*)\"$")
	public void visualiza_el_primer_boton_seleccionado_con_texto_de_color_blanco_y_fondo_azul(String sNombProductos) throws Exception {
		pageObject_Search.iClickMundoPor_Nombre(sNombProductos);		
	}

	@Then("^Visualiza el segundo boton \"([^\"]*)\"$")
	public void visualiza_el_segundo_boton_con_texto_de_color_negro_y_fondo_blanco(String sNombVales) throws Exception {
		pageObject_Search.iClickMundoPor_Nombre(sNombVales);
	}

	@Then("^Visualiza el tercero boton \"([^\"]*)\"$")
	public void visualiza_el_tercero_boton_con_texto_de_color_negro_y_fondo_blanco(String sNombEntre) throws Exception {
		pageObject_Search.iClickMundoPor_Nombre(sNombEntre);	    
	}

	@Then("^Visualiza el cuarto boton \"([^\"]*)\"$")
	public void visualiza_el_cuarto_boton_con_texto_de_color_negro_y_fondo_blanco(String sNombViajes) throws Exception {
		pageObject_Search.iClickMundoPor_Nombre(sNombViajes);	
		Thread.sleep(2000);
	}

	
	@Then("^No visualiza listado de búsquedas recientes$")
	public void no_visualiza_listado_de_búsquedas_recientes() throws Exception {							
		assertThat(pageObject_Search.SeccionBusquedasRecientes(), is(false));
	}

	@Given("^Selecciona el botón \"([^\"]*)\"$")
	public void selecciona_el_botón(String sNombreMundo) throws Exception {
		pageObject_Search.iClickMundoPor_Nombre(sNombreMundo);	    	    
	}

	@Given("^Usuario ingresa \"([^\"]*)\"$")
	public void usuario_ingresa(String sTexto_Caracteres) throws Exception {
		pageObject_Search.setTextoEn_Buscador(sTexto_Caracteres);
	}

	@When("^carga el buscador$")
	public void carga_el_buscador() throws Exception {
		Thread.sleep(1000);	    
	}

	@Then("^muestra Resultados \"([^\"]*)\"$")
	public void muestra_resultados(String iResultados) throws Exception {
		assertThat(pageObject_Search.getStringResultadoBuscador(), is(iResultados));
	}
		
	@Then("^Verificar listado de búsquedas$")
	public void verifica_listado_de_búsquedas() throws Exception {
		pageObject_Search.Desplegar_BuscadorAllMundos();    
	}
		
	@Then("^Selecciona la \"([^\"]*)\" opción del resultado de la búsqueda$")
	public void selecciona_la_opción_del_resultado_de_la_búsqueda(String SPosicion) throws Exception {
		pageObject_Search.ClickPosicion_ListaBusqueda(SPosicion);
	}
		
	@When("^Muestra la ficha del producto o evento$")
	public void muestra_la_ficha_del_producto_o_evento() throws Exception {
		Thread.sleep(1000);
	}
	
	@Then("^Verificar el titulo del listado de \"([^\"]*)\"$")
	public void verificar__listado_de_búsquedas_recientes(String STextoBusquedaRecientes) {
		assertThat(pageObject_Search.getStringTituloBusquedas_Recientes(), is(STextoBusquedaRecientes));	
	}
	
	@Then("^Verificar el nombre del mundo en la caja del buscador \"([^\"]*)\" \"([^\"]*)\"$")
	public void verificar_el_nombre_del_mundo_en_la_caja_del_buscador(String SBuscarEn,String SMundo) throws Exception {			
		String SMundo_=(SMundo.equals("Canje en Tiendas")?"Canje en tiendas":(SMundo.equals("Vales de Consumo"))?"Vales de consumo":SMundo);
		assertThat(pageObject_Search.getTexto_BuscarEnProductos(), containsString(SBuscarEn+SMundo_));		
	}
	
	@Then("^Verificar como máximo \"([^\"]*)\" búsquedas recientes$")
	public void visualiza_como_máximo_búsquedas_recientes(int iCantidadElementos) throws Exception {
		assertThat(pageObject_Search.getCantidadListaBusquedas_Recientes(), is(iCantidadElementos));		
	}

	@Then("^Selecciona el \"([^\"]*)\" elemento de la lista de búsquedas recientes$")
	public void selecciona_la_lista_de_búsquedas_recientes(String iPosicion) throws Exception {
		pageObject_Search.iClickUltimoElemento(iPosicion);
	}
	
	@Then("^Muestra la ficha del producto o evento o vale seleccionado$")
	public void muestra_la_ficha_del_producto_o_evento_o_vale_seleccionado() throws Exception {		
		assertThat(pageObject_Search.ValidarProducto_Evento_Vale(), is(true));
	}
	
	@Then("^Muestra mas de \"([^\"]*)\" resultados$")
	public void muestra_mas_de_resultados(int iCantidadMaxima) throws Exception {
		assertThat(pageObject_Search.getCantidadSugerenciasBuscador(), is(true));	
	}

	@When("^Selecciona la opción \"([^\"]*)\"$")
	public void selecciona_la_opción(String arg1) throws Exception {
		pageObject_Search.iClick_VerMasResultados();
	}

	@Then("^Muestra la malla de resultados$")
	public void muestra_la_malla_de_resultados() throws Exception {
		assertThat(pageObject_Search.ValidarMallaResultados(), is(true));
	}

	@Then("^Verificar que la caja del buscador este presente el texto \"([^\"]*)\"$")
	public void verificar_que_la_caja_del_buscador_este_presente_el_texto(String SCajaBuscador) throws Exception {
		assertThat(pageObject_Search.getTexto_BuscarEnProductos(), is(SCajaBuscador));	
	}
	
	
	@Then("^Muestra el mensaje \"([^\"]*)\"$")
	public void muestra_el_mensaje(String SResultados) throws Exception {
		assertThat(pageObject_Search.getStringResultadoBuscador(), is(SResultados));	    
	}

	@When("^usuario presiona enter para buscar$")
	public void usuario_presiona_enter_para_buscar() throws Exception {
		pageObject_Search.PresionarKeysEnter();
	}

	@Then("^Muestra un mensaje: \"([^\"]*)\" \"([^\"]*)\"$")
	public void muestra_un_mensaje(String arg1, String arg2) throws Exception {				
		assertThat(pageObject_Search.getStringTitulo_SinResultadosPara(), is(arg1+arg2));
	    
	}

	@Then("^sub mensaje: \"([^\"]*)\"$")
	public void sub_mensaje(String arg1) throws Exception{
		assertThat(pageObject_Search.getStringSubTitulo_NoEncontramosNingunResultado(), is(arg1));	
	}


	@When("^Selecciona la opción limpiar$")
	public void selecciona_la_opción_limpiar() throws Exception {
		pageObject_Search.iClick_Limpiar();
	}

	@Then("^Visualiza la caja de texto en blanco$")
	public void visualiza_la_caja_de_texto_en_blanco() throws Exception {
		pageObject_Search.getStringCajadelBuscador();
	}

	@Then("^Visualiza resultado en blanco$")
	public void visualiza_resultado_en_blanco() throws Exception {
		assertThat(pageObject_Search.getStringCajadelBuscador(), is(""));
	}

	@Then("^Visualiza el titulo \"([^\"]*)\"$")
	public void visualiza_el_titulo(String iTexto) throws Exception {
		assertThat(pageObject_Search.getTexto_ExplorarBusquedaEn(), is(iTexto));
	}


}
