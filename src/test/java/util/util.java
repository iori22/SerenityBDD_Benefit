package util;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class util {

	WebDriver driver;
	static JavascriptExecutor jse;
	
	
	public static boolean scrollToElement(WebDriver driver, String xpath) {
		jse = ((JavascriptExecutor) driver);
		try {
			jse.executeScript("scroll(0, arguments[0].offsetTop-100)", driver.findElement(By.xpath(xpath)));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	
	public static boolean scrollToElement(WebElement element){
		try {
			jse.executeScript("scroll(0, arguments[0].offsetTop-100)", element);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	 public static boolean scrollToElementJS(WebElement element){
		try {			
			//((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", PosicionCambioContrasenia);
			jse.executeScript("arguments[0].scrollIntoView(true);", element);
			return true;
		} catch (Exception e) {
			return false;
		}
	}	
	
	public static double ObtenerValorSoloNumero(String Cadena) {
		String regexp = "([\\-?0-9.]+)";
		String cadena = Cadena;
		Pattern pattern = Pattern.compile(regexp);
		Matcher matcher = pattern.matcher(cadena);
		matcher.find(); // Encuentra la primera coincidencia del patron
		String strNumero = matcher.group();
		double dNumero = Double.parseDouble(strNumero);
		return dNumero;
	}
	
	
	public static boolean dragAndDropBy(WebDriver driver_,WebElement element, int x, int y) throws Exception {
		try {
			Actions actions=new Actions(driver_);
			actions.dragAndDropBy(element, x, y).build().perform();
			element.click();			
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean switchToFrame(WebDriver driver_, WebElement frame) {
		try {
			driver_.switchTo().defaultContent();
			if (frame != null)
				driver_.switchTo().frame(frame);
			return true;
		} catch (Exception e) {
			return false;
		}
	}


	public static boolean isElementPresent(WebDriver driver_,String xpath){
        try{
        	driver_.findElements(By.xpath(xpath));
            return true;
        }
        catch(NoSuchElementException e){
            return false;
        }
    }
	
	
	public static void waitForPageLoad(WebDriver driver_) {
	    Wait<WebDriver> wait = new WebDriverWait(driver_, 30);
	    wait.until(new Function<WebDriver, Boolean>() {
	        public Boolean apply(WebDriver driver) {
	            System.out.println("Current Window State       : "
	                + String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState")));
	            return String
	                .valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
	                .equals("complete");
	        }
	    });
	}
	
	//PROBANDO TIEMPO DE ESPERA.
	private static final int TIMEOUT = 20;
	
	public static void waitUntilElementDisplayed(final WebElement webElement, WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
		ExpectedCondition<Boolean> elementIsDisplayed = new ExpectedCondition<Boolean>() {
		public Boolean apply(WebDriver arg0) {
		  try {
		     webElement.isDisplayed();
		     return true;
		  }
		  catch (NoSuchElementException e ) {
		    return false;
		  }
		  catch (StaleElementReferenceException f) {
		    return false;
		  }
		    }
		};
		wait.until(elementIsDisplayed);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
}
