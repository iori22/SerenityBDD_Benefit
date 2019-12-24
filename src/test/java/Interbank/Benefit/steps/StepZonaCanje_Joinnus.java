package Interbank.Benefit.steps;

import Interbank.Benefit.pageobject.PageObject_FichaEventos_Joinnus;
import Interbank.Benefit.pageobject.PageObject_Home_Joinnus;
import Interbank.Benefit.pageobject.PageObject_LoginBenni;
import Interbank.Benefit.pageobject.PageObject_Search;
import Interbank.Benefit.pageobject.PageObject_ZonaCanje;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepZonaCanje_Joinnus {

	PageObject_ZonaCanje pageObject_ZonaCanje; 
	PageObject_Search pageObject_Search;
	PageObject_Home_Joinnus pageObject_Home;
	PageObject_FichaEventos_Joinnus pageObject_Ficha;
	PageObject_LoginBenni  pageObject_LoginBenni;
	
	@Given("^Usuario se encuentra logeado en Interbank Benefit con la cuenta \"([^\"]*)\" y el password \"([^\"]*)\"$")
	public void usuario_se_encuentra_logeado_en_Interbank_Benefit_con_la_cuenta_y_el_password(String SUsuario, String SPassword) throws Exception {
		pageObject_Search.open();
		pageObject_LoginBenni.IniciarSesion_Login(SUsuario,SPassword);
		pageObject_Home.SelectedEvents();
	}

	@Given("^selecciona la categoria del evento \"([^\"]*)\"$")
	public void selecciona_la_categoria(String iNameCategory) {
		pageObject_Home.SelectOne_Category(iNameCategory);
	}

	@Then("^elige el evento de su interes \"([^\"]*)\"$")
	public void elige_el_evento(String sNombreEvento) throws Exception {
		pageObject_Ficha.iClickEventoPor_Nombre(sNombreEvento);
	}
	
	@Then("^selecciona la (\\d+) entrada$")
	public void selecciona_la_entrada(int iPosEntrada) throws Exception {
		pageObject_ZonaCanje.SeleccionarUnTipo_Entrada(iPosEntrada);
	}

	@Then("^selecciona continuar de la Ficha$")
	public void selecciona_continuar_de_la_Ficha() throws Exception {
		pageObject_ZonaCanje.ClickContinuarFicha();
	}
		
	@Given("^Usuario ingresa su Nombre completo \"([^\"]*)\" \"([^\"]*)\"$")
	public void usuario_ingresa_su_Nombre_completo(String SNombre, String SApellido) throws Exception {
		pageObject_ZonaCanje.setDatosCompletos(SNombre, SApellido);
	}
	
	@Given("^ingresa su numero de documento \"([^\"]*)\"$")
	public void ingresa_su_numero_de_documento(String SNumeroDocumento) throws Exception {
		pageObject_ZonaCanje.setDNI(SNumeroDocumento);
	}

	@Given("^presiona Continuar del primer Paso$")
	public void presiona_Continuar_del_primer_Paso() throws Exception {
		pageObject_ZonaCanje.ClickContinuarPaso01();
	}

	@Given("^presiona Continuar del Segundo Paso$")
	public void presiona_Continuar_del_Segundo_Paso() throws Exception {
		pageObject_ZonaCanje.ClickContinuarPaso02();
	}

	@Given("^ingresa codigo SMS$")
	public void ingresa_codigo_SMS() throws Exception {
		pageObject_ZonaCanje.IngresaCodigoSMSPasarelaMillas();
	}

	@When("^presiona canjear$")
	public void presiona_canjear() throws Exception {
		pageObject_ZonaCanje.ClickCanjearPasarelaSoloMillas();		
	}

	@Then("^se visualiza el comprobante de pago$")
	public void se_visualiza_el_comprobante_de_pago() throws Exception {
		pageObject_ZonaCanje.ComprobantePagoJoinnus();
	}

	@Given("^selecciona el enlace Editar$")
	public void selecciona_el_enlace_Editar() throws Exception {
		pageObject_ZonaCanje.ClickEnlace_EditarPaso02();
	}

	@Given("^en el modal ingresa \"([^\"]*)\" millas y aceptar$")
	public void en_el_modal_ingresa_millas_y_aceptar(String ICantidadMillas) throws Exception {
		pageObject_ZonaCanje.IngresarMillas_ModalPaso02(ICantidadMillas);
	}

	@Given("^selecciona la \"([^\"]*)\" a utilizar$")
	public void selecciona_la_a_utilizar(String SNumero_Tarjeta) throws Exception {
		pageObject_ZonaCanje.SeleccionarTarjeta_PasarelaPago(SNumero_Tarjeta);
	}

	@Given("^ingresa el \"([^\"]*)\" y \"([^\"]*)\" de la tarjeta$")
	public void ingresa_el_y_de_la_tarjeta(String SMesAnio, String SCVV) throws Exception {
		pageObject_ZonaCanje.setMesAnio_CVV_PasarelaPago(SMesAnio,SCVV);
	}

	@Given("^se ingresa codigo SMS$")
	public void se_ingresa_codigo_SMS() throws Exception {
		pageObject_ZonaCanje.IngresaCodigoSMSPasarelaPagoSoles_Mixto();
	}


}
