package Interbank.Benefit.steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import Interbank.Benefit.pageobject.PageObject_LoginBenni;
import Interbank.Benefit.pageobject.PageObject_MeshSearch;
import Interbank.Benefit.pageobject.PageObject_Search;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepMeshSearch {

	PageObject_MeshSearch pageObject_MeshSearch;
	PageObject_Search pageObject_Search;
	PageObject_LoginBenni  pageObject_LoginBenni;

	@Given("^Usuario se encuentra logeado en Interbank Benefit \\(Mesh Search\\) con el usuario \"([^\"]*)\" y contrasenia \"([^\"]*)\"$")
	public void usuario_se_encuentra_logeado_en_Interbank_Benefit_Mesh_Search_con_el_usuario_y_contrasenia(String SUsuario, String SPassword) throws Exception {
		pageObject_Search.open();
		//pageObject_LoginBenni.IniciarSesion_Login(SUsuario,SPassword);	    
	}

	@Given("^Usuario selecciona el buscador y elige el boton \"([^\"]*)\"$")
	public void usuario_selecciona_el_buscador_y_selecciona_el_boton(String sNombProductos) throws Exception {
		pageObject_Search.ClickEn_Buscador();
		pageObject_Search.iClickMundoPor_Nombre(sNombProductos);
	}
	
	@When("^ingresa \"([^\"]*)\" la caja de texto del Motor de búsqueda y oprime ENTER$")
	public void usuario_ingresa_la_caja_de_texto_del_Motor_de_búsqueda_y_oprime_ENTER(String sTexto_Caracteres) throws Exception {
		pageObject_MeshSearch.setTextoEn_Buscador(sTexto_Caracteres);		
	}

	@Given("^Selecciona el boton pagar solo con mis millas$")
	public void selecciona_el_boton_pagar_solo_con_millas() {
		//pageObject_MeshSearch.ClickPagarSoloConMillas();
	}
	
	@Then("^Selecciona (\\d+) categorias$")
	public void selecciona_categorias(int ICantidadCategoriasSelect) {
		pageObject_MeshSearch.getCantidadCateTotal(ICantidadCategoriasSelect);
	}

	@When("^se selecciona el precio menor y mayor de la barra de millas$")
	public void se_desliza_los_botones_de_inicio_y_fin() throws Exception {
		pageObject_MeshSearch.getTexto_CantidadMillasBarra();
	}

	@Given("^Selecciona \"([^\"]*)\"$")
	public void selecciona(String STipoVale) {
		pageObject_MeshSearch.ClickFiltroVale(STipoVale);
	}
	
	@Then("^muestra el total de productos de las categorias seleccionadas y se comprueba que el precio en millas de los productos mostrados se encuentran dentro del intervalo de la barra deslizante en la malla de resultados$")
	public void muestra_los_productos_ordenados_desde_el_precio_mayor_en_millas_hasta_el_menor_respectivamente() {		
		assertThat(pageObject_MeshSearch.ValidarRangoMillas(), is(true));
	}

	@Then("^muestra el total de vales de las categorias seleccionadas y se comprueba que el precio en millas de los productos mostrados se encuentran dentro del intervalo de la barra deslizante en la malla de resultados$")
	public void muestra_los_vales_ordenados_desde_el_precio_mayor_en_millas_hasta_el_menor_respectivamente() {
		assertThat(pageObject_MeshSearch.ValidarRangoMillasVales(), is(true));		
	}
	
	@Given("^Selecciona \"([^\"]*)\" en el filtro de fechas$")
	public void selecciona_en_el_filtro_de_fechas(String SFiltroFecha) {
		pageObject_MeshSearch.ClickFiltroFecha(SFiltroFecha);
	}

	@Then("^muestra el total de eventos de las categorias seleccionadas asi como el filtro de fecha seleccionado y se comprueba que el precio en millas de los  eventos mostrados se encuentran dentro del intervalo de la barra deslizante en la malla de resultados$")
	public void muestra_el_total_de_eventos_de_las_categorias_seleccionadas_asi_como_el_filtro_de_fecha_seleccionado_y_se_comprueba_que_el_precio_en_millas_de_los_eventos_mostrados_se_encuentran_dentro_del_intervalo_de_la_barra_deslizante_en_la_malla_de_resultados() {
		pageObject_MeshSearch.ValidarRangoMillasEventos();
	}
	
}
