package Interbank.Benefit.pageobject;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import util.util;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;

@DefaultUrl("https://saaspp.com/WebSaas/")
public class PageObject_CambioContrasenia_Login extends PageObject{
	
	public boolean bFlag = false;
	public boolean bvalor = false;
	public String SNombre = "";
	public String SValor_Numero01_Feature = "";
	public String SValor_Numero02_Feature = "";
	private static String SValor_Numero01_Feature_ValidarError = "";
	private static String SValor_Numero02_Feature_ValidarError = "";
	private static String SValor_Numero03_Feature_ValidarError = "";
	public String SValor_Operador_Feature = "";
	private static final String SBtnNombreUsuario = "//button[@class='drop-button usuario']";
	private static final String SBtnMiPerfil = "//ul[@class='drop-list']/li/a[contains(.,'Mi perfil')]";	
	private static final String SIfPerfil = "ifPerfil";

	//Cambiar Numero Celular
	private static final String SPosicionCambioContrasenia = "//div[@id='perfil']/section[@class='izquierda']";
	private static final String SLinkCambiarContrasenia = "//a[@id='cambiar-contrasena']";
	private static final String STxtClaveActual = "//input[@id='input-clave-actual']";
	private static final String STxtNuevaContrasenia = "//input[@id='input-clave']";
	private static final String STxtConfirmaContrasenia = "//input[@id='input-confirma-clave']";
	private static final String SBtnGuardarClave = "//input[@id='a-guardarClave']";
	private static final String SLblMensajeExito = "//div[@id='p-mensaje-exito-pass']/p";
	private static final String SNivelSeguridad_Bajo = "//div[@id='div-seguridad']/ul/li[@class='bajo']";
	private static final String SNivelSeguridad_Medio = "//div[@id='div-seguridad']/ul/li[@class='medio']";
	private static final String SNivelSeguridad_Alto = "//div[@id='div-seguridad']/ul/li[@class='alto']";
	private static final String SlblMensajeSeguridad= "//div[@id='div-seguridad']/div";
	private static final String SMsjError_ContraseniaActual= STxtClaveActual+"/../p";
	private static final String SMsjError_NuevaContrasenia= STxtNuevaContrasenia+"/../p";
	private static final String SMsjError_ConfirmarContrasenia= STxtConfirmaContrasenia+"/../p";

	
	//Cambiar Numero Celular
	private static final String SLinkCambiarNumeroCelular= "//a[@id='cambiar-celular']";
	private static final String SNuevoNumeroCelular= "//input[@id='input-numero-nuevo']";
	private static final String SReIngresoNumeroCelular= "//input[@id='input-numero-reingresar']";
	private static final String SCboOperador= "//select[@id='select-operador']";
	private static final String SBtnSiguiente= "//input[contains(@id,'a-sgte')]";
	private static final String STxtCodigoSeguridad= "//input[@id='input-codigo-seguridad']";
	private static final String SBtnGuardarCambios= "//input[@id='a-guardarCelular']";	
	private static final String SMsjError_NumeroCelular= SNuevoNumeroCelular+"/../p";
	private static final String SMsjError_ReIngresa= SReIngresoNumeroCelular+"/../p";
	private static final String SMsjError_Operador= SCboOperador+"/../p";
	private static final String SLblMensajeExito_NumeroCelular = "//div[@id='mensaje-exito-contact']/p";
	private static final String SMsjError_CodigoSeguridad= "//p[@id='p-error-codigo-seguridad']";
	
	
	
	
	
	@FindBy(xpath = SBtnNombreUsuario)
	WebElementFacade BtnNombreUsuario;

	@FindBy(xpath = SBtnMiPerfil)
	WebElementFacade BtnMiPerfil;
	
	@FindBy(xpath = SPosicionCambioContrasenia)
	WebElementFacade PosicionCambioContrasenia;
	
	@FindBy(xpath = SLinkCambiarContrasenia)
	WebElementFacade LinkCambiarContrasenia;
	 
	@FindBy(xpath = STxtClaveActual)
	WebElementFacade TxtClaveActual;
	
	@FindBy(xpath = STxtNuevaContrasenia)
	WebElementFacade TxtNuevaContrasenia;
	
	@FindBy(xpath = STxtConfirmaContrasenia)
	WebElementFacade TxtConfirmaContrasenia;
	
	@FindBy(xpath = SBtnGuardarClave)
	WebElementFacade BtnGuardarClave;	
	
	@FindBy(xpath = SNivelSeguridad_Bajo)
	WebElementFacade NivelSeguridad_Bajo;
	
	@FindBy(xpath = SNivelSeguridad_Medio)
	WebElementFacade NivelSeguridad_Medio;
	
	@FindBy(xpath = SNivelSeguridad_Alto)
	WebElementFacade NivelSeguridad_Alto;
 	
	@FindBy(xpath = SLinkCambiarNumeroCelular)
	WebElementFacade LinkCambiarNumeroCelular;
	
	@FindBy(xpath = SNuevoNumeroCelular)
	WebElementFacade NuevoNumeroCelular;
	
	@FindBy(xpath = SReIngresoNumeroCelular)
	WebElementFacade ReIngresoNumeroCelular;
	
	@FindBy(xpath = SCboOperador)
	WebElementFacade CboOperador;
	
	@FindBy(xpath = SBtnSiguiente)
	WebElementFacade BtnSiguiente;
	
	@FindBy(xpath = STxtCodigoSeguridad)
	WebElementFacade TxtCodigoSeguridad;
	
	@FindBy(xpath = SBtnGuardarCambios)
	WebElementFacade BtnGuardarCambios;
	
	
	public void ClickMiPerfil() throws Exception{
		try {
			BtnNombreUsuario.click();
			BtnMiPerfil.click();	
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo ClickMiPerfil", false);
		}				
	}
	
	public void ClickCambiarContrasenia() throws Exception{
		try {
			if (bFlag) {
				LinkCambiarContrasenia.click();
			}else {
				util.switchToFrame(getDriver(), getDriver().findElement(By.id(SIfPerfil)));//SIfPerfil						
				((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", PosicionCambioContrasenia);
				LinkCambiarContrasenia.click();			
				bFlag=true;
			}
			
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo ClickCambiarContrasenia", false);
		}				
	}
	
	public void TxtContraseniaActual(String SContraseniaActual) throws Exception{
		try {
			SValor_Numero01_Feature_ValidarError=SContraseniaActual;
			TxtClaveActual.clear();
			TxtClaveActual.sendKeys(SContraseniaActual);
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo TxtContraseniaActual", false);
		}				
	}
	
	public void TxtContraseniaNueva(String SContraseniaNueva) throws Exception{
		try {
			SValor_Numero02_Feature_ValidarError=SContraseniaNueva;
			TxtNuevaContrasenia.clear();			
			TxtNuevaContrasenia.sendKeys(SContraseniaNueva);
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo TxtContraseniaNueva", false);
		}				
	}
	
	public void ClickConfirmarContrasenia(String SConfirmarContrasenia) throws Exception{
		try {
			SValor_Numero03_Feature_ValidarError=SConfirmarContrasenia;
			TxtConfirmaContrasenia.clear();
			TxtConfirmaContrasenia.sendKeys(SConfirmarContrasenia);
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo ClickConfirmarContrasenia", false);
		}				
	}
	
	public void ClickBotonGuardarClave() throws Exception{
		try {
			BtnGuardarClave.click();
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo ClickBotonGuardarClave", false);
		}				
	}
	
	
	public boolean getMsjExitoso(String SMsjExitoso) throws Exception{
		try {
			SNombre = findBy(SLblMensajeExito)
				    .then()
				    .getAttribute("innerHTML");

			String[] parts = SNombre.split("(?=<br>)");
			String SMensajeHtml01 = parts[0];
			String SMensajeHtml02= parts[1]; 			
 			
			String[] parts02 = SMsjExitoso.split("(?=exitosamente)");
			String SMsjExitoso01 = parts02[0];
			String SMsjExitoso02= parts02[1]; 			
 
			bvalor=(SMensajeHtml01.trim().contains(SMsjExitoso01.trim()) && SMensajeHtml02.trim().contains(SMsjExitoso02.trim()))?true:false;			
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo getMsjExitoso", false);
		}
		return bvalor;				
	}
	
	
	
	public String SeguridadBajo() throws Exception{
		try {
			NivelSeguridad_Bajo.isDisplayed();			
			SNombre = findBy(SlblMensajeSeguridad)
				    .then()
				    .getAttribute("innerHTML");			
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo SeguridadBajo", false);
		}
		return SNombre;				
	}
	
	public String SeguridadMedio() throws Exception{
		try {
			NivelSeguridad_Medio.isDisplayed();
			SNombre = findBy(SlblMensajeSeguridad)
				    .then()
				    .getAttribute("innerHTML");			
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo SeguridadMedio", false);
		}
		return SNombre;				
	}
	
	
	public String SeguridadAlto() throws Exception{
		try {
			NivelSeguridad_Alto.isDisplayed();
			SNombre = findBy(SlblMensajeSeguridad)
				    .then()
				    .getAttribute("innerHTML");			
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo SeguridadAlto", false);
		}
		return SNombre;				
	}
	
	public void ClickCambiarNumeroCelular() throws Exception{
		try {
			util.switchToFrame(getDriver(), getDriver().findElement(By.id(SIfPerfil)));//SIfPerfil						
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", PosicionCambioContrasenia);
			LinkCambiarNumeroCelular.click();			
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo ClickCambiarNumeroCelular", false);
		}					
	}
	
	
	public void TxtNuevoNumeroCelular(String SNumeroCelular) throws Exception{
		try {
			SValor_Numero01_Feature=SNumeroCelular;
			NuevoNumeroCelular.typeAndEnter(SNumeroCelular);
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo TxtNuevoNumeroCelular", false);
		}					
	}
	
	public void TxtReIngresoNumeroCelular(String SReNumeroCelular) throws Exception{
		try {
			SValor_Numero02_Feature=SReNumeroCelular;
			ReIngresoNumeroCelular.typeAndEnter(SReNumeroCelular);			
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo TxtReIngresoNumeroCelular", false);
		}					
	}
	
	
	public void SeleccionaOperador(String SOperador) throws Exception{
		try {
			//CboOperador.click();		
			SValor_Operador_Feature=SOperador;
			WebElement iSeleccionar_CboOperador = getDriver().findElement(By.xpath(SCboOperador+"/option[contains(.,'"+SOperador+"')]"));
			iSeleccionar_CboOperador.click();
			
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo TxtReIngresoNumeroCelular", false);
		}					
	}

	public void ClickContinuar() throws Exception{
		try {
			BtnSiguiente.click();			
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo ClickContinuar", false);
		}					
	}

	public void TxtIngresoCodigoSeguridad() throws Exception{
		try {
			TxtCodigoSeguridad.typeAndEnter("88888888");			
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo TxtIngresoCodigoSeguridad", false);
		}					
	}
	
	public void ClickGuardarCambios_NumeroTelefonico() throws Exception{
		try {
			BtnGuardarCambios.click();			
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo ClickGuardarCambios_NumeroTelefonico", false);
		}					
	}
	
	
	public void getMsjErrorCodigoSeguridad(String SMensajeError) throws Exception{
		try {
			SNombre = findBy(SMsjError_CodigoSeguridad)
					  .then()
					  .getAttribute("innerHTML");					
			Assert.assertEquals("El mensaje de Error es diferente al esperado, Campo: Codigo de Seguridad", SMensajeError, SNombre);	
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo ClickGuardarCambios_NumeroTelefonico", false);
		}					
	}
	
	
	
	public void getMsjErrorAll(String Msj_ErrorNumero01, String Msj_ErrorNumero02,String Msj_ErrorOperador) throws Exception{
		try {
			
			if (SValor_Numero01_Feature.isEmpty()) {
				SNombre = findBy(SMsjError_NumeroCelular).then().getAttribute("innerHTML");
				Assert.assertEquals("El mensaje de Error es diferente al esperado, Campo: Numero Celular", Msj_ErrorNumero01, SNombre);
			}

			if (SValor_Numero02_Feature.isEmpty()) {
				SNombre = findBy(SMsjError_ReIngresa).then().getAttribute("innerHTML");	
				Assert.assertEquals("El mensaje de Error es diferente al esperado, Campo: ReIngresa tu  numero celular", Msj_ErrorNumero02, SNombre);					
			}
						
			if (SValor_Operador_Feature.equals("Selecciona")) {
				SNombre = findBy(SMsjError_Operador).then().getAttribute("innerHTML");
				Assert.assertEquals("El mensaje de Error es diferente al esperado, Campo: Operador", Msj_ErrorOperador, SNombre);
			}					
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo getMsjErrorAll", false);
		}					
	}
	
	
	public String getMsjExitoso_NumeroCelular() throws Exception{
		try {		
			SNombre = findBy(SLblMensajeExito_NumeroCelular)
				    .then()
				    .getAttribute("innerHTML");			
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo getMsjExitoso_NumeroCelular", false);
		}
		return SNombre;				
	}
	
	
	public void getMsjErrorAll_CambioContrasenia(String SContraseniaActual, String SContraseniaNueva,String SContraseniaConfirmar) throws Exception{
		try {
			
			if (SValor_Numero01_Feature_ValidarError.isEmpty()) {
				SNombre = findBy(SMsjError_ContraseniaActual).then().getAttribute("innerHTML");
				System.out.println("SNombre "+SNombre);
				System.out.println("SContraseniaActual "+SContraseniaActual);
				Assert.assertEquals("El mensaje de Error es diferente al esperado, Campo: ", SContraseniaActual, SNombre);
			}

			if (SValor_Numero02_Feature_ValidarError.isEmpty()) {
				SNombre = findBy(SMsjError_NuevaContrasenia).then().getAttribute("innerHTML");	
				Assert.assertEquals("El mensaje de Error es diferente al esperado, Campo: ", SContraseniaNueva, SNombre);					
			}
						
			if (SValor_Numero03_Feature_ValidarError.isEmpty()) {
				SNombre = findBy(SMsjError_ConfirmarContrasenia).then().getAttribute("innerHTML");
				Assert.assertEquals("El mensaje de Error es diferente al esperado, Campo: ", SContraseniaConfirmar, SNombre);
			}					
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo getMsjErrorAll", false);
		}					
	}
	
} 

