package Interbank.Benefit.steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import Interbank.Benefit.pageobject.PageObject_CambioContrasenia_Login;
import Interbank.Benefit.pageobject.PageObject_LoginBenni;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepCambioContrasenia_Login {
	
	PageObject_CambioContrasenia_Login pageObject_CambioContrasenia_Login;
	PageObject_LoginBenni  pageObject_LoginBenni;
	
	@Given("^Usuario se encuentra logeado en Interbank Benefit con la cuenta \"([^\"]*)\" y password \"([^\"]*)\"$")
	public void usuario_se_encuentra_logeado_en_Interbank_Benefit_con_el_usuario_y_password(String SUsuario, String SPassword) throws Exception {
		pageObject_CambioContrasenia_Login.open();
		pageObject_LoginBenni.IniciarSesion_Login(SUsuario,SPassword);	    
	}

	@Given("^Usuario se encuentra en la seccion Mi Perfil$")
	public void usuario_se_encuentra_en_la_seccion_Mi_Perfil() throws Exception {	    
		pageObject_CambioContrasenia_Login.ClickMiPerfil();
	}

	@When("^selecciona el link de cambiar contrasenia$")
	public void selecciona_el_link_de_cambiar_contrasenia() throws Exception {
		pageObject_CambioContrasenia_Login.ClickCambiarContrasenia();	    
	}

	@Given("^ingresa la contraseña actual \"([^\"]*)\"$")
	public void ingresa_la_contraseña_actual(String SContraseniaActual) throws Exception {
		pageObject_CambioContrasenia_Login.TxtContraseniaActual(SContraseniaActual);	    
	}
 
	@Given("^ingresa la nueva contrasenia \"([^\"]*)\"$")
	public void ingresa_la_nueva_contrasenia(String SContraseniaNueva) throws Exception {
		pageObject_CambioContrasenia_Login.TxtContraseniaNueva(SContraseniaNueva);	    
	}

	@Given("^ingresa la confirmacion de la nueva contrasenia \"([^\"]*)\"$")
	public void ingresa_la_confirmacion_de_la_nueva_contrasenia(String SConfirmarContrasenia) throws Exception {
		pageObject_CambioContrasenia_Login.ClickConfirmarContrasenia(SConfirmarContrasenia);
	}

	@When("^presiona el boton de cambiar contrasenia$")
	public void presiona_el_boton_de_cambiar_contrasenia() throws Exception {
		pageObject_CambioContrasenia_Login.ClickBotonGuardarClave();
	}

	@Then("^muestra el mensaje \"([^\"]*)\"$")
	public void muestra_el_mensaje(String SMensajeExitoso) throws Exception {
		assertThat(pageObject_CambioContrasenia_Login.getMsjExitoso(SMensajeExitoso), is(true));	    
	}
	
	@Then("^muestra el nivel bajo de Seguridad \"([^\"]*)\"$")
	public void muestra_el_nivel_de_Seguridad_y_en_color_rojo(String SPocoSeguro) throws Exception {
		assertThat(pageObject_CambioContrasenia_Login.SeguridadBajo(), is(SPocoSeguro));
	}

	@Then("^muestra el nivel Medio de Seguridad \"([^\"]*)\"$")
	public void muestra_el_nivel_de_Seguridad_y_en_color_Verde_claro(String SMedio) throws Exception {		
		assertThat(pageObject_CambioContrasenia_Login.SeguridadMedio(), is(SMedio));
	}

	@Then("^muestra el nivel mas Alto de Seguridad \"([^\"]*)\"$")
	public void muestra_el_nivel_de_Seguridad_y_en_color_Verde_oscuro(String SAlto) throws Exception {		
		assertThat(pageObject_CambioContrasenia_Login.SeguridadAlto(), is(SAlto));
	}	
}
