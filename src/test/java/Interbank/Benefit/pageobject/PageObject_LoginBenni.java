package Interbank.Benefit.pageobject;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import util.util;

public class PageObject_LoginBenni extends PageObject{
	
	private static final String SBtnIngresar = "//div[contains(@class,'buttons')]/button[@id='ingresar']";
	private static final String SIDFrameLogin = "iframe-login";
	private static final String STxtUsuario_login = "//input[@id='username']";
	private static final String STxtPassword_login = "//input[@id='password']";
	private static final String SBtnLogin_login = "//a[@id='btnlogin']";
	
	@FindBy(xpath = SBtnIngresar)
	WebElementFacade BtnIngresar;

	@FindBy(xpath = STxtUsuario_login)
	WebElementFacade TxtUsuario_login;
	
	@FindBy(xpath = STxtPassword_login)
	WebElementFacade TxtPassword_login;
	
	@FindBy(xpath = SBtnLogin_login)
	WebElementFacade BtnLogin_login;
	
	
	
	
	
	
	
	
	
	
	public void IniciarSesion_Login(String Usuario, String Password) throws Exception {
		try {			
			util.waitForPageLoad(getDriver());
			WebElement iSeleccionar_CboEntrada = getDriver().findElement(By.xpath("//input[@id='searchAll']"));
			util.waitUntilElementDisplayed(iSeleccionar_CboEntrada,getDriver());
			Thread.sleep(10000);
			BtnIngresar.click();			
			//getDriver().findElement(By.xpath(SBtnIngresar)).click();
			Thread.sleep(10000);
			util.switchToFrame(getDriver(), getDriver().findElement(By.id(SIDFrameLogin)));				
			TxtUsuario_login.sendKeys(Usuario);
			TxtPassword_login.sendKeys(Password);	
			BtnLogin_login.click();
			Thread.sleep(20000);
			//util.waitForPageLoad(getDriver());
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo PageObject_LoginBenni/IniciarSesion_Login", false);
			System.out.println("Error en el metodo PageObject_LoginBenni/IniciarSesion_Login");
		}
	}
	
}
