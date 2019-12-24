package Interbank.Benefit.pageobject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import util.util;

@DefaultUrl("https://saaspp.com/WebSaas/")
public class PageObject_ZonaCanje extends PageObject {

	public static String SNombre = "";
	public static String SMensaje = "";
	public static int iCantidad = 0;
	public boolean bValor = false;

	// Paso 01 - Zona Canje
	public static final String SBtnContinuar_Ficha = "//a[@id='continuar']";
	public static final String SSeccionPaso01 = "//div[contains(@class,'datos-cliente')]";
	public static final String STxtNombre_Paso01 = "//input[@id='txtNombres']";
	public static final String STxtApellidos_Paso01 = "//input[@id='txtApellidos']";
	public static final String SCbo_TipoDocumento = "//select[@id='cboTipodoc']";
	public static final String STxtDNI_Paso01 = "//input[@id='txtNroDocumento']";
	public static final String SBtnContinuar_Paso01 = "//input[@id='guardarDatosCliente']";
	public static final String SlblMensajeError_DNI = "//div[@class='drop-google-group']/span[@class='message-error']";
	public static final String SBtnContinuar_Paso01_Enable_Disable = "//div[@id='ingreso-datos']/input[@class='continue-button disabled']";

	// Paso 02 - Zona Canje
	public static final String SBtnContinuar_Paso02 = "//input[@id='reservarEventoEntradas']";
	public static final String SEnlace_EditarPaso02 = "//li[@class='utilizar-millas']/span/b[contains(@class,'edit')]";
	public static final String SIngresarMillas_Modal = "//input[@id='millasUsar']";
	public static final String SBtnAceptar = "//button[contains(text(),'Aceptar')]";
	public static final String SlblCantidadSoles = "//div[@id='editar-pago']/div/p/span";

	// Pasarela BIM
	public static final String SIFRAMEPASARELA = "iframe-pasarela";
	public static final String STxtMesAnio_Pasarela = "//input[@id='expiracion_tarjeta']";
	public static final String STxtCVV_Pasarela = "//input[@id='cvv-pass']";
	public static final String STxtSMS_Pasarela = "//input[@id='sms-pago']";
	public static final String SCboTarjeta = "//app-combo[@id='dropdown-card']/div";
	public static final String SbtnCanjear = "//input[contains(@class,'payment-submit')]";
	

	// Comprobante de Pago
	//public static final String SComprobantePago = "//div[@id='experiencias-comprobante-page']";
	public static final String SComprobantePago = "experiencias-comprobante-page";

	@FindBy(xpath = SBtnContinuar_Ficha)
	WebElementFacade BtnContinuar_Ficha;

	@FindBy(xpath = SSeccionPaso01)
	WebElementFacade SeccionPaso01;

	@FindBy(xpath = STxtNombre_Paso01)
	WebElementFacade TxtNombre_Paso01;

	@FindBy(xpath = STxtApellidos_Paso01)
	WebElementFacade TxtApellidos_Paso01;

	@FindBy(xpath = STxtDNI_Paso01)
	WebElementFacade TxtDNI_Paso01;

	@FindBy(xpath = SBtnContinuar_Paso01)
	WebElementFacade BtnContinuar_Paso01;

	@FindBy(xpath = SlblMensajeError_DNI)
	WebElementFacade lblMensajeError_DNI;

	@FindBy(xpath = SBtnContinuar_Paso02)
	WebElementFacade BtnContinuar_Paso02;

	@FindBy(xpath = SEnlace_EditarPaso02)
	WebElementFacade Enlace_EditarPaso02;

	@FindBy(xpath = SIngresarMillas_Modal)
	WebElementFacade IngresarMillas_Modal;
	
	@FindBy(xpath = SBtnAceptar)
	WebElementFacade BtnAceptar;
	
	@FindBy(xpath = SCboTarjeta)
	WebElementFacade CboTarjeta;
	
	@FindBy(xpath = STxtMesAnio_Pasarela)
	WebElementFacade TxtMesAnio_Pasarela;
	
	@FindBy(xpath = STxtCVV_Pasarela)
	WebElementFacade TxtCVV_Pasarela;	
	
	@FindBy(xpath = STxtSMS_Pasarela)
	WebElementFacade TxtSMS_Pasarela;

	@FindBy(xpath = SbtnCanjear)
	WebElementFacade btnCanjear;

	@FindBy(xpath = SComprobantePago)
	WebElementFacade ComprobantePago;

	public void SeleccionarUnTipo_Entrada(int iPosEntrada) throws Exception {
		try {
			Thread.sleep(5000);
			getDriver().findElement(By.xpath("//li[contains(@class,'entrada')][" + iPosEntrada + "]/div/select"))
					.click();
			getDriver().findElement(By.xpath("//li[contains(@class,'entrada')][" + iPosEntrada
					+ "]/div/select/option[contains(@class,'option1')]")).click();
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo SeleccionarUnTipo_Entrada", false);
			System.out.println("Error en el metodo SeleccionarUnTipo_Entrada");
		}
	}

	public void ClickContinuarFicha() throws Exception {
		try {
			BtnContinuar_Ficha.click();
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo ClickContinuarFicha", false);
			System.out.println("Error en el metodo ClickContinuarFicha");
		}
	}

	public void setDatosCompletos(String sNombre, String sApellidos) throws Exception {
		try {
			util.scrollToElement(SeccionPaso01);
			TxtNombre_Paso01.sendKeys(sNombre);
			TxtApellidos_Paso01.sendKeys(sApellidos);
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo setDatosCompletos", false);
			System.out.println("Error en el metodo setDatosCompletos");
		}
	}

	public void setDNI(String SNumDoc) throws Exception {
		try {
			TxtDNI_Paso01.sendKeys(SNumDoc);
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo setDNI", false);
			System.out.println("Error en el metodo setDNI");
		}
	}

	public void ClickContinuarPaso01() throws Exception {
		try {
			BtnContinuar_Paso01.click();
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo ClickContinuar_Paso01", false);
			System.out.println("Error en el metodo ClickContinuar_Paso01");
		}
	}

	public void ClickContinuarPaso02() throws Exception {
		try {
			BtnContinuar_Paso02.click();
			Thread.sleep(25000);
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo ClickContinuar_Paso02", false);
			System.out.println("Error en el metodo ClickContinuar_Paso02");
		}
	}

	public void IngresaCodigoSMSPasarelaMillas() throws Exception {
		try {
			
			util.switchToFrame(getDriver(), getDriver().findElement(By.id(SIFRAMEPASARELA)));
			TxtSMS_Pasarela.sendKeys("12346578");
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo IngresaCodigoSMSPasarela", false);
			System.out.println("Error en el metodo IngresaCodigoSMSPasarela");
		}
	}

	public void ClickCanjearPasarelaSoloMillas() throws Exception {
		try {
			btnCanjear.click();
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo ClickCanjearPasarelaSoloMillas", false);
			System.out.println("Error en el metodo ClickCanjearPasarelaSoloMillas");
		}
	}

	public void ComprobantePagoJoinnus() throws Exception {
		try {
			Thread.sleep(10000);
			ComprobantePago.isPresent();
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo ComprobantePagoJoinnus", false);
			System.out.println("Error en el metodo ComprobantePagoJoinnus");
		}
	}

	public void ClickEnlace_EditarPaso02() throws Exception {
		try {
			Enlace_EditarPaso02.click();
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo ClickEnlace_EditarPaso02", false);
		}
	}

	public void IngresarMillas_ModalPaso02(String iCantidadMillas) throws Exception {
		try {

			IngresarMillas_Modal.typeAndEnter(iCantidadMillas);
			
			SNombre = findBy(SlblCantidadSoles)
					.then()
					.getText();

			System.out.println("Cantidad diferencia en Soles: " + SNombre);
			BtnAceptar.click();
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo IngresarMillas_ModalPaso02", false);
		}
	}
	
	public void SeleccionarTarjeta_PasarelaPago(String sNumeroTarjeta) throws Exception {
		try {
			util.switchToFrame(getDriver(), getDriver().findElement(By.id(SIFRAMEPASARELA)));
			CboTarjeta.click();
			Thread.sleep(2000);
			String iValorTC=sNumeroTarjeta.substring(12,15);
			System.out.println("La tarjeta de texto es: "+iValorTC);
			WebElement iCboSeleccionar_Tarjeta = getDriver().findElement(By.xpath("//ul[@class='drop-list']/li/span[contains(.,'"+iValorTC+"')]"));
			iCboSeleccionar_Tarjeta.click();			
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo SeleccionarTarjeta_PasarelaPago", false);
		}
	}
	
	public void setMesAnio_CVV_PasarelaPago(String sMesAnioPasarela,String sCVVPasarela) throws Exception {
		try {						
			TxtMesAnio_Pasarela.typeAndEnter(sMesAnioPasarela);
			TxtCVV_Pasarela.typeAndEnter(sCVVPasarela);
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo setMesAnio_CVV_PasarelaPago", false);		}
	}

	public void IngresaCodigoSMSPasarelaPagoSoles_Mixto() throws Exception {
		try {			
			TxtSMS_Pasarela.sendKeys("12346578");
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo IngresaCodigoSMSPasarelaPagoSoles_Mixto", false);
		}
	}
	
}
	
	
	