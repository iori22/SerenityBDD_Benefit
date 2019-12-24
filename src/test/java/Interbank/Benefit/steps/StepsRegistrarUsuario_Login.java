package Interbank.Benefit.steps;

import Interbank.Benefit.pageobject.PageObject_RegistrarUsuario;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepsRegistrarUsuario_Login {

	PageObject_RegistrarUsuario pageObject_RegistrarUsuario;
	
	@Given("^Usuario se encuentra en Interbank Benefit y desea crear una cuenta nueva$")
	public void usuario_se_encuentra_en_Interbank_Benefit_y_desea_crear_una_cuenta_nueva() {
		pageObject_RegistrarUsuario.open();
		pageObject_RegistrarUsuario.ClickCrearUsuario();
	}

	@When("^ingresa el nombre de usuario \"([^\"]*)\"$")
	public void ingresa_el_nombre_de_usuario(String SNombreUsuario) {
		pageObject_RegistrarUsuario.setTxtNombreUsuario(SNombreUsuario);
	}

	@When("^selecciona el tipo de documento \"([^\"]*)\" e ingresa el numero \"([^\"]*)\"$")
	public void selecciona_el_tipo_de_documento_e_ingresa_el_numero(String STipoDocumento, String SNumeroDocumento) {
		pageObject_RegistrarUsuario.IngresarTipo_NumeroDocumento(STipoDocumento,SNumeroDocumento);
	}

	@When("^selecciona el operador \"([^\"]*)\" e ingresa el numero de celular \"([^\"]*)\"$")
	public void selecciona_el_operador_e_ingresa_el_numero_de_celular(String STipoOperador, String SNumeroOperador) {
		pageObject_RegistrarUsuario.IngresarTipo_NumeroOperador(STipoOperador,SNumeroOperador);
	}

	@When("^presiona el boton siguiente del primer paso de registro$")
	public void presiona_el_boton_siguiente() {
		pageObject_RegistrarUsuario.ClickSiguiente_PrimerParte();
	}

	@When("^ingresa la contrasenia \"([^\"]*)\" y la confirmacion de la nueva contrasenia \"([^\"]*)\"$")
	public void ingresa_la_contrasenia_y_la_confirmacion_de_la_nueva_contrasenia(String SContrasenia, String SConfirmacionContrasenia) {
		pageObject_RegistrarUsuario.setTxtContrasenia_ConfirmacionContrasenia(SContrasenia,SConfirmacionContrasenia);
	}

	@When("^activa la seccion de tratamiento de mis datos personales y la seccion de terminos y condiciones$")
	public void activa_la_seccion_de_tratamiento_de_mis_datos_personales_y_la_seccion_de_terminos_y_condiciones() {
		pageObject_RegistrarUsuario.SeleccionarChecked_AmbosTerminos();
	}

	@When("^oprime el boton siguiente$")
	public void oprime_el_boton_siguiente() {
	//	pageObject_RegistrarUsuario.ClickSiguiente_UltimoPaso();
	}

	@Then("^muestra el mensaje de \"([^\"]*)\"$")
	public void muestra_el_mensaje_de(String arg1) {
    // CUANDO TENGAMOS ACCESO A LA BASE DE DATOS PARA BORRAR USUARIOS CREAREMOS USUARIO
	}

	@Then("^muestra mensajes de errores \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void muestra_mensajes_de_errores(String SNombreUsuario, String STipoDocumento, String SNumeroDocumento, String STipoOperador, String SNumeroCelular) throws Exception {
		pageObject_RegistrarUsuario.getMsjErrorAll_RegistrarUsuario(SNombreUsuario,STipoDocumento,SNumeroDocumento,STipoOperador,SNumeroCelular);
		
	}	
}
