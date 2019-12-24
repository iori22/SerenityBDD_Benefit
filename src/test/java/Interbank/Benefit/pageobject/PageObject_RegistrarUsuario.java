package Interbank.Benefit.pageobject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import util.util;

@DefaultUrl("https://saaspp.com/WebSaas/")
public class PageObject_RegistrarUsuario extends PageObject {

	private static final String SBtnCrearUsuario = "//div[contains(@class,'buttons')]/button[@id='registrar']";
	private static final String STxtNombreUsuario = "//input[@id='input-usuario']";
	private static final String STxtNumeroDocumento = "//input[@id='input-numero-documento']";
	private static final String STxtNumeroOperador = "//input[@id='input-celular']";
	private static final String SBtnSiguiente = "//a[@id='a-sgte']";
	private static final String SIDFrameLogin = "iframe-login";
	private static final String SNuevaContrasenia = "//input[@id='input-clave']";
	private static final String SConfirmarContrasenia = "//input[@id='input-confirma-clave']";	
	private static final String SChkTratamientoDatos = "//input[@id='input-tratamiento']";
	private static final String SChkTerminosCondiciones = "//input[@id='input-terminos']";
	private static final String SBtnContinuarUltimoPaso = "//a[@id='a-sgte']";
	
	//Validacion de Errores.
	private static String SNombre="";
	private static String SValor_Usuario_FeatureValidarError="";
	private static String STipoDocumento_FeatureValidarError="";
	private static String SNumeroDocumento_FeatureValidarError="";
	private static String STipoOperador_FeatureValidarError="";
	private static String SNumeroCelular_FeatureValidarError="";
	
	private static final String SMensajeError_Usuario = "//input[@id='input-usuario']/../p";
	private static final String SMensajeError_CBOTipoDocumento= "//select[@id='select-tipo-documento']/../p";
	private static final String SMensajeError_TxtDocumento= "//input[@id='input-numero-documento']/../p";	
	private static final String SMensajeError_CBOTipoOperador= "//select[@id='select-operador']/../p";
	private static final String SMensajeError_TxtTipoOperador= "//input[@id='input-celular']/../p";
	
	@FindBy(xpath = SBtnCrearUsuario)
	WebElementFacade BtnCrearUsuario;
	
	@FindBy(xpath = STxtNombreUsuario)
	WebElementFacade TxtNombreUsuario;
	
	@FindBy(xpath = STxtNumeroDocumento)
	WebElementFacade TxtNumeroDocumento;
	
	@FindBy(xpath = STxtNumeroOperador)
	WebElementFacade TxtNumeroOperador;
	
	@FindBy(xpath = SBtnSiguiente)
	WebElementFacade BtnSiguiente;

	@FindBy(xpath = SNuevaContrasenia)
	WebElementFacade NuevaContrasenia;	

	@FindBy(xpath = SConfirmarContrasenia)
	WebElementFacade ConfirmarContrasenia;	
	
	@FindBy(xpath = SChkTratamientoDatos)
	WebElementFacade ChkTratamientoDatos;
	
	@FindBy(xpath = SChkTerminosCondiciones)
	WebElementFacade ChkTerminosCondiciones;
	
	@FindBy(xpath = SBtnContinuarUltimoPaso)
	WebElementFacade BtnContinuarUltimoPaso;
	
	
	//Crear Usuario
	public void ClickCrearUsuario() {
		try {
			util.waitForPageLoad(getDriver());
			BtnCrearUsuario.click();
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo ClickCrearUsuario", false);
		}
	}
	
	//Ingresar Usuario
	public void setTxtNombreUsuario(String SUsuario) {
		try {
			SValor_Usuario_FeatureValidarError=SUsuario;
			util.switchToFrame(getDriver(), getDriver().findElement(By.id(SIDFrameLogin)));
			TxtNombreUsuario.typeAndEnter(SUsuario);
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo setTxtNombreUsuario", false);
		}
	}
	
	//Tipo y numero de documento
	public void SeleccionarTipoDocumento(String STipDocu) {
		try {
			STipoDocumento_FeatureValidarError=STipDocu;
			WebElement iSeleccionar_CboTipo=getDriver().findElement(By.xpath("//select[@id='select-tipo-documento']"));
			iSeleccionar_CboTipo.click();
			
			WebElement iSeleccionar_CboTipoDocumento=getDriver().findElement(By.xpath("//select[@id='select-tipo-documento']/option[contains(.,'"+STipDocu+"')]"));
			iSeleccionar_CboTipoDocumento.click();
			
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo SeleccionarTipoDocumento", false);
		}
	}		
	public void setTxtNumeroDocumento(String NumeroDocumento) {
		try {			
			SNumeroDocumento_FeatureValidarError=NumeroDocumento;
			TxtNumeroDocumento.typeAndEnter(NumeroDocumento);
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo setTxtNumeroDocumento", false);
		}
	}
	public void IngresarTipo_NumeroDocumento(String STipDocu, String NumeroDocumento) {
		try {
			SeleccionarTipoDocumento(STipDocu);
			setTxtNumeroDocumento(NumeroDocumento);
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo IngresarTipo_NumeroDocumento", false);
		}
	}
	
	//Tipo y numero de Operador
	public void SeleccionarTipoOperador(String STipoOpe) {
		try {
			STipoOperador_FeatureValidarError=STipoOpe;
			WebElement iSeleccionar_CboTipoOperador=getDriver().findElement(By.xpath("//select[@id='select-operador']/option[contains(.,'"+STipoOpe+"')]"));
			iSeleccionar_CboTipoOperador.click();			
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo SeleccionarTipoOperador", false);
		}
	}		
	public void setTxtNumeroOperador(String Operador) {
		try {
			SNumeroCelular_FeatureValidarError=Operador;
			TxtNumeroOperador.typeAndEnter(Operador);
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo setTxtNumeroOperador", false);
		}
	}
	public void IngresarTipo_NumeroOperador(String STipoOperador, String NumeroOperador) {
		try {
			SeleccionarTipoOperador(STipoOperador);
			setTxtNumeroOperador(NumeroOperador);
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo IngresarTipo_NumeroOperador", false);
		}
	}
	
	//Siguiente
	public void ClickSiguiente_PrimerParte() {
		try {
			BtnSiguiente.click();
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo ClickSiguiente_PrimerParte", false);
		}
	}
	
	//Ingreso y confirmacion de contrasenia
	public void setTxtContrasenia_ConfirmacionContrasenia(String SContrasenia,String SConfirmarContrasenia) {
		try {			
			NuevaContrasenia.typeAndEnter(SContrasenia);
			ConfirmarContrasenia.typeAndEnter(SConfirmarContrasenia);
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo setTxtContrasenia_ConfirmacionContrasenia", false);
		}
	}
	
	
	//Seleccionar Ambos Checked
	public void SeleccionarCheckedTratamientoDatos() {
		try {
			ChkTratamientoDatos.click();
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo SeleccionarCheckedTratamientoDatos", false);
		}
	}
	public void SeleccionarCheckedTerminosCondiciones() {
		try {
			ChkTerminosCondiciones.click();
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo SeleccionarCheckedTerminosCondiciones", false);
		}
	}
	
	public void SeleccionarChecked_AmbosTerminos() {
		try {
			SeleccionarCheckedTratamientoDatos();
			SeleccionarCheckedTerminosCondiciones();
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo SeleccionarChecked_TodosTerminos", false);
		}
	}
	
	public void ClickSiguiente_UltimoPaso() {
		try {
			BtnContinuarUltimoPaso.click();
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo ClickSiguiente_UltimoPaso", false);
		}
	}


	
	public void getMsjErrorAll_RegistrarUsuario(String SNombreUsuario, String STipoDocumento, String SNumeroDocumento, String STipoOperador, String SNumeroCelular) throws Exception{
		try {
			
			if (SValor_Usuario_FeatureValidarError.isEmpty()) {
				SNombre = findBy(SMensajeError_Usuario).then().getAttribute("innerHTML");
				System.out.println("SNombre "+SNombre);
				System.out.println("SContraseniaActual "+SNombreUsuario);
				Assert.assertEquals("El mensaje de Error es diferente al esperado, Campo: ", SNombreUsuario, SNombre);
			}

			if (STipoDocumento_FeatureValidarError.isEmpty()) {
				SNombre = findBy(SMensajeError_CBOTipoDocumento).then().getAttribute("innerHTML");
				System.out.println("SNombre "+SNombre);
				System.out.println("SContraseniaActual "+STipoDocumento);
				Assert.assertEquals("El mensaje de Error es diferente al esperado, Campo: ", STipoDocumento, SNombre);					
			}
						
			if (SNumeroDocumento_FeatureValidarError.isEmpty()) {
				SNombre = findBy(SMensajeError_TxtDocumento).then().getAttribute("innerHTML");
				System.out.println("SNombre "+SNombre);
				System.out.println("SContraseniaActual "+SNumeroDocumento);
				Assert.assertEquals("El mensaje de Error es diferente al esperado, Campo: ", SNumeroDocumento, SNombre);
			}					
			
			if (STipoOperador_FeatureValidarError.isEmpty()) {
				SNombre = findBy(SMensajeError_CBOTipoOperador).then().getAttribute("innerHTML");
				System.out.println("SNombre "+SNombre);
				System.out.println("SContraseniaActual "+STipoOperador);
				Assert.assertEquals("El mensaje de Error es diferente al esperado, Campo: ", STipoOperador, SNombre);
			}	
			
			if (SNumeroCelular_FeatureValidarError.isEmpty()) {
				SNombre = findBy(SMensajeError_TxtTipoOperador).then().getAttribute("innerHTML");
				System.out.println("SNombre "+SNombre);
				System.out.println("SContraseniaActual "+SNumeroCelular);
				Assert.assertEquals("El mensaje de Error es diferente al esperado, Campo: ", SNumeroCelular, SNombre);
			}	
			
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo getMsjErrorAll_RegistrarUsuario", false);
		}					
	}




}
