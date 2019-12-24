package Interbank.Benefit.pageobject;

import net.thucydides.core.annotations.DefaultUrl;

import org.junit.Assert;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

@DefaultUrl("https://saaspp.com/WebSaas/")
public class PageObject_Home_Joinnus extends PageObject {

	public int iCantidad = 0;
	public String SNombre = "";

	private static final String SMenuEventos = "//ul[@class='menu']/li[5]";
	private static final String SMenuEventos2 = "(//ul[@class='menu']/li//a[@class='titulo'])[2]";
	private static final String SPaginaEventos = "//div[@id='page-experiencias-home']";
	private static final String SAll_Categorys = "//section[@class='article-list']/article";
	private static final String SSelectOne_Category = "//section[@class='article-list']/article/a/span[contains(.,'";
	private static final String SListEvent_Category = "//section[@class='article-list']/article";
	private static final String SNombreCategoria = "//div[@class='title-zone']/h2";

	@FindBy(xpath = SMenuEventos)
	WebElementFacade menuEventos;

	@FindBy(xpath = SMenuEventos2)
	WebElementFacade menuEventos2;

	@FindBy(xpath = SPaginaEventos)
	WebElementFacade PaginaEventos;

	@FindBy(xpath = SAll_Categorys)
	WebElementFacade All_Categorias;

	public void SelectedEvents()  {
		
		menuEventos.click();
		
		menuEventos2.click();
	}

	public boolean ValidateHomeMain() {
		return PaginaEventos.isDisplayed();
	}

	public boolean ValidateAllCategory() {
		return All_Categorias.isDisplayed();
	}

	public void SelectOne_Category(String iNameCategory) {
		// driver.findElement(By.xpath(tabxpath)).click();
		SNombre = iNameCategory;
		getDriver().findElement(By.xpath(SSelectOne_Category + iNameCategory + "')]")).click();
	}

	public int ValidateEvents_Category() {
		try {
			iCantidad = getDriver().findElements(By.xpath(SListEvent_Category)).size();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return iCantidad;
	}

	public boolean getStringNombreCategoria() throws Exception {
		boolean bValor=false;
		try {
			String SgetNombreCategoria = "";
			SgetNombreCategoria = findBy(SNombreCategoria)
								.then()
								.getText();			
			bValor = (SNombre.equals(SgetNombreCategoria))?true:false;			
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo getStringNombreCategoria", false);
			System.out.println("Error en el metodo getStringNombreCategoria");
		}
		return bValor;
	}
	
	public boolean Retroceder_ValidarHome() throws Exception {
		boolean bValor=false;
		try {
			getDriver().navigate().back();
			bValor=ValidateAllCategory();
			
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo Retroceder_ValidarHome", false);
			System.out.println("Error en el metodo Retroceder_ValidarHome");
		}
		return bValor;
	}
}
