package Interbank.Benefit.steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import Interbank.Benefit.pageobject.PageObject_FichaEventos_Joinnus;
import Interbank.Benefit.pageobject.PageObject_Home_Joinnus;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepFichaEventos_Joinnus {

	PageObject_FichaEventos_Joinnus pageObject_Ficha;
	PageObject_Home_Joinnus pageObject_Home;

	@Given("^Usuario esta en la pagina principal de entretenimiento$")
	public void usuario_esta_en_la_pagina_principal_de_entretenimiento() {
		pageObject_Ficha.open();
		pageObject_Home.SelectedEvents();
	}

	@Given("^Usuario selecciona la categoria \"([^\"]*)\"$")
	public void selecciona_la_categoria(String iNameCategory) {
		pageObject_Home.SelectOne_Category(iNameCategory);
	}

	@When("^selecciona evento \"([^\"]*)\"$")
	public void selecciona_evento(String sNombreEvento) throws Exception {
		pageObject_Ficha.iClickEventoPor_Nombre(sNombreEvento);
	}

	@Then("^visualiza seccion de descripcion$")
	public void visualiza_seccion_de_descripcion() throws Exception {
		assertThat(pageObject_Ficha.ValidarSeccionDescripcion(), is(true));
	}

	@Then("^seccion zona entradas$")
	public void seccion_zona_entradas() throws Exception {
		assertThat(pageObject_Ficha.ValidarSeccionEntradas(), is(true));
	}

	@Then("^seccion zona de ubicacion$")
	public void seccion_zona_de_ubicacion() throws Exception {
		assertThat(pageObject_Ficha.ValidarSeccionUbicacion(), is(true));
	}

	@When("^selecciona el enlace Mostrar todo$")
	public void selecciona_el_enlace_Mostrar_todo() throws Exception {
		pageObject_Ficha.iClickMostrar_Todo();
	}

	@Then("^visualiza la descripcion completa del evento$")
	public void visualiza_la_descripcion_completa_del_evento() throws Exception {
		assertThat(pageObject_Ficha.ObtenerDescripcionCompleta(), is(true));		
	}

	@Then("^visualiza el enlace Mostrar menos$")
	public void visualiza_el_enlace_Mostrar_menos() throws Exception {
		assertThat(pageObject_Ficha.iValidarMostrar_Menos(), is(true));
	}

	@When("^selecciona el enlace de direccion que aparece en la seccion Ubicacion$")
	public void selecciona_el_enlace_de_direccion_que_aparece_en_la_seccion_Ubicacion() throws Exception {
		pageObject_Ficha.iClickUbicacion();
	}

	@Then("^visualiza en otra pestaña el mapa de google maps$")
	public void visualiza_en_otra_pestaña_el_mapa_de_google_maps() throws Exception {		
		assertThat(pageObject_Ficha.Visualizar_PestañaGoogleMaps(), is(true));
	}

	@When("^selecciona (\\d+) entrada por cada tipo que exista para el evento$")
	public void selecciona_entrada_por_cada_tipo_que_exista_para_el_evento(int iCantidadEntradas) throws Exception {
		pageObject_Ficha.Seleccionar_DiferentesTipos_Entradas(iCantidadEntradas);
	}

	@Then("^visualiza en la zona racional el total de Millas y Soles actualizados$")
	public void visualiza_en_la_zona_racional_el_total_de_Millas_y_Soles_actualizados() throws Exception {
		assertThat(pageObject_Ficha.ZonaRacional_Actualizado(), is(true));
	}

	@When("^selecciona continuar$")
	public void selecciona_continuar() throws Exception {
		pageObject_Ficha.iClick_ContinuarFicha();
	}

	@Then("^visualiza un formulario de logeo$")
	public void visualiza_un_formulario_de_logeo() throws Exception {
		assertThat(pageObject_Ficha.VerForm_Login(), is(true));
	}

	@When("^selecciona Ingresar$")
	public void selecciona_Ingresar() throws Exception {
		pageObject_Ficha.iClick_ContinuarFicha();
	}

	@When("^ingresa el usuario \"([^\"]*)\" y password \"([^\"]*)\"$")
	public void ingresa_el_usuario_y_password(String SUsuario, String SPassword) throws Exception {
		pageObject_Ficha.IniciarSesion_Login(SUsuario,SPassword);
	}

	@Then("^visualiza la seccion \"([^\"]*)\"$")
	public void visualiza_la_seccion(String SNombreFormulario) throws Exception {
		assertThat(pageObject_Ficha.Seccion_CompletaTuCanje(SNombreFormulario), is(true));
	}

}
