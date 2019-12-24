package Interbank.Benefit.pageobject;

import net.thucydides.core.annotations.DefaultUrl;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;


@DefaultUrl("https://saaspp.com/WebSaas/")
public class PageObject_Search extends PageObject {

	public static String SNombre="";
	public static String SNombreMundo="";
	public static String SMensaje="";
	public static int iCantidad=0;
	public boolean bValor=false;
	public static final String SBuscador = "//input[@id='searchAll']";
	private static final String SDesplegar_Buscador = "//ul[@id='myList' and @style='display: block;']";
	private static final String SResultadoBuscador = "//ul[@id='myList']/li";	
	private static final String STitulo_ExplorarBusquedaEn = SResultadoBuscador+"/span";   //ul[@id='myList']/li/span
	private static final String STitulo_BuscarEnProductos = SBuscador+"/../span";
	private static final String SCantidadBotones_Buscador = "//div[@class='div-buscador']/a";
	private static final String SBuscarMundoPor_Nombre = "//li[@class='sub-list opt']/div/a[contains(.,'";	
	private static final String SBusquedaReciente = "//div[@class='div-buscador ng-tns-c0-0 ng-star-inserted']";
	private static final String SLista_BusquedaReciente = "//ul[@class='recientes']";
	private static final String STitulo_BusquedaReciente = SResultadoBuscador+"/div/span";
	private static final String STitulo_MundoPertenece= SResultadoBuscador+"/div/ul/li[last()]/a/span[contains(@class,'gray')]";	
	private static final String SCantidadListaBusquedas = SLista_BusquedaReciente+"/li";
	private static final String SCantidadSugerencia_Buscador = 	SResultadoBuscador+"[contains(@class,'resultado')]/a";
	private static final String SClick_VerMasResultados = "//a[@id='masResultados']";
	private static final String SMallaResultados = "//div[@id='busqueda-resultados-page']";
	private static final String STituloSubTitulo = "//div[contains(@class,'empty-all')]";
	private static final String SClickLimpiar = "//i[contains(@class,'limpiar')]";
	private static final String SCerrarPopUpVale = "//div[@id='evale-detalle']/div/i";
	
	@FindBy(xpath = SBuscador)
	WebElementFacade Buscador;

	@FindBy(xpath = SDesplegar_Buscador)
	WebElementFacade Desplegar_Buscador;

	@FindBy(xpath = STitulo_ExplorarBusquedaEn)
	WebElementFacade Titulo_ExplorarBusquedaEn;

	@FindBy(xpath = SCantidadBotones_Buscador)
	WebElementFacade CantidadBotones_Buscador;
	
	@FindBy(xpath = SBusquedaReciente)
	WebElementFacade BusquedaReciente;	

	@FindBy(xpath = SLista_BusquedaReciente)
	WebElementFacade Lista_BusquedaReciente;
	
	@FindBy(xpath = SClick_VerMasResultados)
	WebElementFacade Click_VerMasResultados;
	
	@FindBy(xpath = SMallaResultados)
	WebElementFacade MallaResultados;	
		
	@FindBy(xpath = SClickLimpiar)
	WebElementFacade ClickLimpiar;
	
	@FindBy(xpath = SCerrarPopUpVale)
	WebElementFacade CerrarPopUpVale;
	
	public void ClickEn_Buscador() throws Exception {
		Thread.sleep(1000);
		Buscador.click();
	}

	public boolean Desplegar_BuscadorAllMundos() {
		return Desplegar_Buscador.isPresent();
	}

	public boolean ValidarTexto_ExplorarEn() {
		return Titulo_ExplorarBusquedaEn.isDisplayed();
	}

	public String getTexto_BuscarEnProductos() throws Exception{
		try {
			String SNombre_="";
			SNombre_=findBy(STitulo_BuscarEnProductos)
					.then()
					.getText();
			SNombre=SNombre_.replace("\"", "");		

			
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo getTexto_BuscarEnProductos", false);			
		}
		return SNombre;
	
	}
	
	
	
	public String getTexto_ExplorarBusquedaEn() throws Exception{
		try {
			SNombre=findBy(STitulo_ExplorarBusquedaEn)
					.then()
					.getText();			
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo getTexto_ExplorarEn", false);			
		}
		return SNombre;
	
	}
	
	public int getCantidadBotones_Buscador() throws Exception{
		try {
			iCantidad=getDriver().findElements(By.xpath(SCantidadBotones_Buscador)).size();			
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo getCantidadBotones_Buscador", false);			
		}
		return iCantidad;
	}

	public void iClickMundoPor_Nombre(String sNombreMundo) throws Exception{
		try {
			SNombre=sNombreMundo;
			SNombreMundo=sNombreMundo;
			getDriver().findElement(By.xpath(SBuscarMundoPor_Nombre+sNombreMundo+"')]")).click();			
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo iClickMundoPor_Nombre", false);			
		}	
	}

	public boolean SeccionBusquedasRecientes() throws Exception{
		try {
			Buscador.click();
			return BusquedaReciente.isVisible();			
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo SeccionBusquedasRecientes", false);			
		}	
		return true;// Debe ser false ya que la seccion no debe de existir
	}

	public void setTextoEn_Buscador(String sTexto) throws Exception{
		try {
			Buscador.sendKeys(sTexto);					
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo setTextoEn_Buscador", false);			
		}			
	}

	public String getStringResultadoBuscador() throws Exception{
		try {
			SNombre=findBy(SResultadoBuscador)
					.then()
					.getText();		

			SMensaje = (SNombre.equals("No se encontraron resultados"))?"No se encontraron resultados":(SNombre.contains("Explorar"))?"":"Muestra lista de resultados de búsqueda";
			
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo Validar_Resultado", false);
		}
		return SMensaje;			
	}
	
	
	public String getStringTextoFondoDelBuscador() throws Exception{
		try {
			SNombre=findBy("//ul[@id='myList']/li")
					.then()
					.getText();		

			SMensaje = (SNombre.equals("No se encontraron resultados"))?"No se encontraron resultados":(SNombre.contains("Explorar"))?"":"Muestra lista de resultados de búsqueda";
			
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo Validar_Resultado", false);
		}
		return SMensaje;			
	}
	
	
		
	public void ClickPosicion_ListaBusqueda(String iPosicion) throws Exception{
		try {			
			getDriver().findElement(By.xpath("(//ul[@id='myList']/li/a)["+iPosicion+"]")).click();		
			
			if (SNombreMundo.contains("Vales")) {
				//waitForRenderedElements(By.xpath(SCerrarPopUpVale));
				//CerrarPopUpVale.waitUntilClickable();
				Thread.sleep(5000);
				CerrarPopUpVale.click();		
			}
			
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo ClickPosicion_ListaBusqueda", false);		
		}						
	}
	
	/*public boolean SeccionLista_BusquedaReciente(){					
		return Lista_BusquedaReciente.isPresent();		
		}*/
	
	public String getStringTituloBusquedas_Recientes(){					
		String STituloBusquedasRecientes="";
		STituloBusquedasRecientes=findBy(STitulo_BusquedaReciente)
				.then()
				.getText();		
		return STituloBusquedasRecientes;
		}
	
	public String getStringMundoPertenece_BusquedasRecientes() throws Exception{
		String SEn_Mundo="";

		try {			
			SEn_Mundo=findBy(STitulo_MundoPertenece)
					.then()
					.getText();
										
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo getStringMundoPertenece_BusquedasRecientes", false);			
		}
		return SEn_Mundo;
	}
	
	public int getCantidadListaBusquedas_Recientes() throws Exception{
		try {
			iCantidad=getDriver().findElements(By.xpath(SCantidadListaBusquedas)).size();				
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo getCantidadListaBusquedas_Recientes", false);			
		}
		return iCantidad;
	}
	
	
	public void iClickUltimoElemento(String sPosicionElement) throws Exception{
		try {					
			Thread.sleep(2000);			
			getDriver().findElement(By.xpath(SCantidadListaBusquedas+"["+sPosicionElement+"]/a")).click();			
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo iClickUltimoElemento", false);			
		}	
	}
		
	public boolean ValidarProducto_Evento_Vale() throws Exception{
			String xpathMundo="";
			
			switch(SNombreMundo) {
			  case "Productos":
				  xpathMundo="//div[@id='ficha-producto-page']";
			    break;
			  case "Vales de consumo":
				  xpathMundo="//div[@id='evale-modal']";
			    break;
			  default: 
				  xpathMundo="//div[@id='page-experiencias-evento']";
			}			
			System.out.println("getDriver().findElement(By.xpath(xpathMundo)).isDisplayed();  ->"+getDriver().findElement(By.xpath(xpathMundo)).isDisplayed());
			return getDriver().findElement(By.xpath(xpathMundo)).isDisplayed();			
	}	

	public boolean getCantidadSugerenciasBuscador() throws Exception{//CORREGIR		
		try {
			iCantidad=getDriver().findElements(By.xpath(SCantidadSugerencia_Buscador)).size();	
			bValor=(iCantidad>=5)?true:false;
			
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo getCantidadSugerenciasBuscador", false);
			}
		return bValor;
	}

	public void iClick_VerMasResultados() throws Exception{
		try {
			Click_VerMasResultados.click();			
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo iClick_VerMasResultados", false);			
		}		
	}
	
	public boolean ValidarMallaResultados() throws Exception{				
		return MallaResultados.isPresent();			
	}

	public void PresionarKeysEnter() throws Exception{			
		Thread.sleep(1000);
		getDriver().findElement(By.id("searchAll")).sendKeys(Keys.ENTER);		
	}
	
	public String getStringTitulo_SinResultadosPara() throws Exception{
		try {
			Thread.sleep(1000);
			SNombre=findBy(STituloSubTitulo+"/h2")
					.then()
					.getText();			
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo getString_SinResultadosPara", false);			
		}
		return SNombre.replace("\"", "");			
	}
			
	public String getStringSubTitulo_NoEncontramosNingunResultado() throws Exception{

		try {
			SNombre=findBy(STituloSubTitulo+"/p")
					.then()
					.getText();			
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo getStringSubTitulo_NoEncontramosNingunResultado", false);			
		}
		return SNombre;			
	}

	public void iClick_Limpiar() throws Exception{
		try {
		   ClickLimpiar.click();			
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo iClick_Limpiar", false);			
		}		
	}

	
	public String getStringCajadelBuscador() throws Exception{
		try {
			SNombre=(String) evaluateJavascript("return document.getElementById('searchAll').value");			
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo getStringCajadelBuscador", false);		
		}
		return SNombre;			
	}
}
