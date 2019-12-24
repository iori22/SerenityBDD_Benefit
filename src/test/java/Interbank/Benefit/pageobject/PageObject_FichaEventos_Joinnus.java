package Interbank.Benefit.pageobject;

import net.thucydides.core.annotations.DefaultUrl;
import util.util;

import java.util.ArrayList;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

@DefaultUrl("https://saaspp.com/WebSaas/")
public class PageObject_FichaEventos_Joinnus extends PageObject {
	public String SNombre = "";
	public boolean bvalor = false;
	public int iCantidad = 0;
	public int iCantidadEntradas = 0;
	private static final String SNombreEvento = "//section[@class='article-list']/article/a/div/span/p[contains(.,'";
	private static final String SSeccion_Descripcion = "//div[@class='zona-descripcion']";
	private static final String SSeccion_Entradas = "//div[@class='zona-canje']";
	private static final String SSeccion_Ubicacion = "//div[@class='zona-ubicacion']";
	private static final String SEnlace_MostrarTodo = "//span[@class='mostrar']";
	private static final String SObtenerDescripcionCompleta = "//div[@class='contain-detail']";
	private static final String SEnlace_MostrarMenos = "//span[@class='mostrar']";
	private static final String SEnlaceUbicacion = "//div[@class='detalle']/div/a";
	private static final String SCantidadEntradas = "//ul[contains(@class,'lista-entradas')]/li[contains(@class,'entrada')]";
	private static final String SCantidadEntradas_2 = "//li[contains(@class,'entrada')]";
	private static final String SCantidadMillas_Total = "//li[@class='total ng-star-inserted']/span/b";
	private static final String SBtnContinuarFicha = "//a[@id='continuar']";
	private static final String SIDFrameLogin = "iframe-login";
	private static final String STxtUsuario_login = "//input[@id='username']";
	private static final String STxtPassword_login = "//input[@id='password']";
	private static final String SBtnLogin_login = "//a[@id='btnlogin']";
	private static final String SSeccion_CompletaTuCanje = "//div[@id='experiencias-reserva']//div[@class='container-error']/../h2";
	
	@FindBy(xpath = SSeccion_Descripcion)
	WebElementFacade Seccion_Descripcion;

	@FindBy(xpath = SSeccion_Entradas)
	WebElementFacade Seccion_Entradas;

	@FindBy(xpath = SSeccion_Ubicacion)
	WebElementFacade Seccion_Ubicacion;

	@FindBy(xpath = SEnlace_MostrarTodo)
	WebElementFacade Enlace_MostrarTodo;

	@FindBy(xpath = SObtenerDescripcionCompleta)
	WebElementFacade ObtenerDescripcionCompleta;

	@FindBy(xpath = SEnlace_MostrarMenos)
	WebElementFacade Enlace_MostrarMenos;

	@FindBy(xpath = SEnlaceUbicacion)
	WebElementFacade EnlaceUbicacion;

	@FindBy(xpath = SCantidadMillas_Total)
	WebElementFacade CantidadMillas_Total;

	@FindBy(xpath = SBtnContinuarFicha)
	WebElementFacade BtnContinuarFicha;

	@FindBy(xpath = STxtUsuario_login)
	WebElementFacade TxtUsuario_login;
	
	@FindBy(xpath = STxtPassword_login)
	WebElementFacade TxtPassword_login;
	
	@FindBy(xpath = SBtnLogin_login)
	WebElementFacade BtnLogin_login;
	

	
	/*
	 * 
	 * public void ClickEn_Buscador() { Buscador.click(); }
	 * 
	 * public boolean Desplegar_BuscadorAllMundos() { return
	 * Desplegar_Buscador.isPresent(); }
	 * 
	 * public boolean ValidarTexto_ExplorarEn() { return
	 * Titulo_ExplorarBusquedaEn.isDisplayed(); }
	 */

	public void iClickEventoPor_Nombre(String sNombreEvento) throws Exception {
		try {						
			Thread.sleep(2000);
			getDriver().findElement(By.xpath("("+SNombreEvento + sNombreEvento + "')])[1]")).click();
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo iClickEventoPor_Nombre", false);
			System.out.println("Error en el metodo iClickEventoPor_Nombre");
		}
	}

	public boolean ValidarSeccionDescripcion() throws Exception {
		return Seccion_Descripcion.isDisplayed();
	}

	public boolean ValidarSeccionEntradas() throws Exception {
		return Seccion_Entradas.isDisplayed();
	}

	public boolean ValidarSeccionUbicacion() throws Exception {
		util.scrollToElement(getDriver(), SSeccion_Ubicacion);
		return Seccion_Ubicacion.isDisplayed();
	}

	public void iClickMostrar_Todo() throws Exception {
		try {
			Thread.sleep(2000);
			util.scrollToElement(getDriver(), SEnlace_MostrarTodo);
			Enlace_MostrarTodo.click();
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo iClickMostrar_Todo", false);
			System.out.println("Error en el metodo iClickMostrar_Todo");
		}
	}

	public boolean ObtenerDescripcionCompleta() throws Exception {
		return ObtenerDescripcionCompleta.isPresent();
	}

	public boolean iValidarMostrar_Menos() throws Exception {
		util.scrollToElement(getDriver(), SEnlace_MostrarMenos);
		return Enlace_MostrarMenos.isPresent();
	}

	public void iClickUbicacion() throws Exception {
		util.scrollToElement(getDriver(), SEnlaceUbicacion);
		Thread.sleep(2000);
		getDriver().findElement(By.xpath(SEnlaceUbicacion)).click();

	}

	public boolean Visualizar_PestañaGoogleMaps() throws Exception {
		try {
			bvalor = true;
			Thread.sleep(1000);
			Set<String> tab_handles = getDriver().getWindowHandles();
			int iCant_Tabs = tab_handles.size();
			System.out.println("Numero de Pestañas: " + iCant_Tabs);
			Thread.sleep(1000);
			ArrayList<String> tabs_windows = new ArrayList<String>(getDriver().getWindowHandles());
			getDriver().switchTo().window(tabs_windows.get(iCant_Tabs - 1));
			String iPestañaGoogleMaps = getDriver().getTitle();
			System.out.println("Titulo: " + iPestañaGoogleMaps);

			if (!iPestañaGoogleMaps.contains("Google Maps")) {
				bvalor = false;
			}
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo Visualizar_PestañaGoogleMaps", false);
			System.out.println("Error en el metodo Visualizar_PestañaGoogleMaps");
		}
		return bvalor;
	}

	public void Seleccionar_DiferentesTipos_Entradas(int iCantEntrada) throws Exception {
		try {
			iCantidadEntradas = iCantEntrada;
			iCantidad = getDriver().findElements(By.xpath(SCantidadEntradas)).size();
			System.out.println("La cantidad de paginas es: " + iCantidad);

			for (int i = 1; i <= iCantidad; i++) {
				WebElement iSeleccionar_CboEntrada = getDriver().findElement(By.xpath(SCantidadEntradas_2 + "[" + i + "]/div/select"));
				iSeleccionar_CboEntrada.click();

				WebElement iCbo_Entrada01 = getDriver().findElement(By.xpath(SCantidadEntradas_2 + "[" + i + "]/div/select/option[contains(@class,'option" + iCantEntrada + "')]"));
				iCbo_Entrada01.click();
			}
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo Seleccionar_DiferentesTipos_Entradas", false);
			System.out.println("Error en el metodo Seleccionar_DiferentesTipos_Entradas");
		}
	}

	public boolean ZonaRacional_Actualizado() throws Exception {
		try {
			double dPrecioMillas = 0.0, iPrecioFinal = 0.0;
			String sPrecioMillas_TipoEntrada = "", sPrecioMillas_TipoEntrada_ = "", sCantMillas_TotalHTML = "",
					iPrecioEntrada_iCantEntrada = "";

			for (int i = 1; i <= iCantidad; i++) {
				// Obtener el precio
				WebElement iCantMillas_TipoEntrada = getDriver().findElement(By.xpath(SCantidadEntradas_2 + "[" + i + "]/span"));
				sPrecioMillas_TipoEntrada = iCantMillas_TipoEntrada.getAttribute("innerHTML").toString();
				sPrecioMillas_TipoEntrada_ = sPrecioMillas_TipoEntrada.replace("<!---->", "");
				dPrecioMillas = util.ObtenerValorSoloNumero(sPrecioMillas_TipoEntrada_.replace(",", "."));
				System.out.println("Precio en double: " + dPrecioMillas);
				iPrecioFinal = dPrecioMillas + iPrecioFinal;
			}

			iPrecioEntrada_iCantEntrada = String.format("%.3f", iPrecioFinal * iCantidadEntradas);
			System.out.println("Precio final 01: " + iPrecioEntrada_iCantEntrada);

			sCantMillas_TotalHTML = findBy(SCantidadMillas_Total)
								    .then()
								    .getAttribute("innerHTML");

			// System.out.println("sCantMillas_TotalHTML: "+sCantMillas_TotalHTML);
			// System.out.println("iPrecioEntrada_iCantEntrada
			// "+iPrecioEntrada_iCantEntrada);
			bvalor = (!sCantMillas_TotalHTML.contains(iPrecioEntrada_iCantEntrada)) ? false : true;

		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo ZonaRacional_Actualizado", false);
		}
		return bvalor;
	}

	public void iClick_ContinuarFicha() throws Exception {
		try {
			BtnContinuarFicha.click();
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo iClick_ContinuarFicha", false);
		}
	}

	public boolean VerForm_Login() throws Exception {
		try {
			util.switchToFrame(getDriver(), getDriver().findElement(By.id(SIDFrameLogin)));
			bvalor = TxtUsuario_login.isDisplayed();
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo VerForm_Login", false);
		}
		return bvalor;
	}
	
	
	
	public void IniciarSesion_Login(String Usuario, String Password) throws Exception {
		try {
			Thread.sleep(1000);
			VerForm_Login();		
			TxtUsuario_login.sendKeys(Usuario);
			TxtPassword_login.sendKeys(Password);	
			BtnLogin_login.click();
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo IniciarSesion_Login", false);
			System.out.println("Error en el metodo IniciarSesion_Login");
		}
	}
	
	public boolean Seccion_CompletaTuCanje(String SNombreSeccion) throws Exception {
		try {
		
			SNombre=findBy(SSeccion_CompletaTuCanje)
					.then()
					.getAttribute("innerHTML");
			
			System.out.println("SNombre: "+SNombre);
			bvalor=(SNombre.equals(SNombreSeccion)?true:false);
			
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo Seccion_CompletaTuCanje", false);
			System.out.println("Error en el metodo Seccion_CompletaTuCanje");
		}
		return bvalor;
	}
	
	
	
}
