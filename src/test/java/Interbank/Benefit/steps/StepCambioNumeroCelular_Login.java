package Interbank.Benefit.steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import Interbank.Benefit.pageobject.PageObject_CambioContrasenia_Login;
import Interbank.Benefit.pageobject.PageObject_LoginBenni;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepCambioNumeroCelular_Login {
	
	PageObject_CambioContrasenia_Login pageObject_CambioContrasenia_Login;
	PageObject_LoginBenni  pageObject_LoginBenni;
	
	@Given("^Usuario se encuentra logeado en Interbank Benefit con la cuenta \"([^\"]*)\" y password \"([^\"]*)\" - Perfil$")
	public void usuario_se_encuentra_logeado_en_Interbank_Benefit_con_la_cuenta_y_password_Perfil(String SUsuario, String SPassword) throws Exception {
		pageObject_CambioContrasenia_Login.open();
		pageObject_LoginBenni.IniciarSesion_Login(SUsuario,SPassword);
	}

	@Given("^Usuario se encuentra en Mi Perfil$")
	public void usuario_se_encuentra_en_Mi_Perfil() throws Exception {
		pageObject_CambioContrasenia_Login.ClickMiPerfil();	    
	}

	@When("^selecciona el link de cambiar celular$")
	public void selecciona_el_link_de_cambiar_celular() throws Exception {
		pageObject_CambioContrasenia_Login.ClickCambiarNumeroCelular();
	}

	@When("^ingresa el nuevo numero del celular \"([^\"]*)\"$")
	public void ingresa_el_nuevo_numero_del_celular(String SNumeroCelular) throws Exception {
		pageObject_CambioContrasenia_Login.TxtNuevoNumeroCelular(SNumeroCelular);
	}

	@When("^reingresa el numero del celular \"([^\"]*)\"$")
	public void reingresa_el_numero_del_celular(String SReNumeroCelular) throws Exception {
		pageObject_CambioContrasenia_Login.TxtReIngresoNumeroCelular(SReNumeroCelular);
	}
	

	@When("^selecciona el operador \"([^\"]*)\"$")
	public void selecciona_el_operador(String SOperador) throws Exception {
		pageObject_CambioContrasenia_Login.SeleccionaOperador(SOperador);
	}

	@When("^presiona el boton siguiente$")
	public void presiona_el_boton_siguiente() throws Exception {
		pageObject_CambioContrasenia_Login.ClickContinuar();	    
	}
	
	@When("^ingresa el codigo de seguridad enviado al email registrado y presiona el boton guardar$")
	public void ingresa_el_codigo_de_seguridad_enviado_al_email_registrado() throws Exception {	    
		pageObject_CambioContrasenia_Login.TxtIngresoCodigoSeguridad();
		pageObject_CambioContrasenia_Login.ClickGuardarCambios_NumeroTelefonico();
	}
	
	@Then("^muestra mensaje de error \"([^\"]*)\" debido a que el codigo de seguridad es incorrecto\\.$")
	public void muestra_mensaje_de_error_debido_a_que_el_codigo_de_seguridad_es_incorrecto(String SMensajeCodigoSeguridad) throws Exception {
		pageObject_CambioContrasenia_Login.getMsjErrorCodigoSeguridad(SMensajeCodigoSeguridad);		
	}

	@Then("^muestra el aviso \"([^\"]*)\"$")
	public void muestra_el_aviso(String SMensajeExitoso_NumeroCelular) throws Exception {
		//assertThat(pageObject_CambioContrasenia_Login.getMsjExitoso_NumeroCelular(SMensajeExitoso_NumeroCelular), is(true));		
	}
	
	@Then("^muestra mensaje de error \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void muestra_mensaje_de_error(String Msj_ErrorNumero01, String Msj_ErrorNumero02,String Msj_ErrorOperador) throws Exception {
		pageObject_CambioContrasenia_Login.getMsjErrorAll(Msj_ErrorNumero01,Msj_ErrorNumero02,Msj_ErrorOperador);
	}	
		
	@Then("^muestra mensajes de errores \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void muestra_mensajes_de_errores(String SContraseniaActual, String SContraseniaNueva, String SContraseniaConfirmar) throws Exception {
		pageObject_CambioContrasenia_Login.getMsjErrorAll_CambioContrasenia(SContraseniaActual,SContraseniaNueva,SContraseniaConfirmar);		
	}

	
	
	
	
	
	
	
	
	
	
	
}
