package Interbank.Benefit.pageobject;

import java.awt.Robot;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Locale;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import util.util;

@DefaultUrl("https://www.interbankbenefit.pe")
public class PageObject_MeshSearch extends PageObject {
	PageObject_Search pageObject_Search;

	public boolean bValor = false;
	public String SNombre = "", SMillasProd = "",SNombreFiltro = "";
	public int iTotalCantidadProductosCate = 0, iFiltroTotalCantidadValeCate = 0, iTotalProductosResult = 0;
	public int iCantidadInicio = 0;
	public int iCantidadFin = 0;
	private static final String SMalla = "//div[@id='busqueda-resultados-page']";
	private static final String SCantidadMillas = "//p[contains(@class,'rango')]";
	private static final String SBtnDesplizante = "//div[@class='noUi-handle noUi-handle-lower']";
	private static final String SSeleccionarCate = "//div[contains(@class,'filtro-categorias')]/label[";
	private static final String SBtnPaginacion = "//div[@class='paginador ng-star-inserted']/button[contains(@class,'page')]";
	private static final String SCantProductos = "//div[contains(@class,'articles')]/article";//// div[@class='articles
																								//// art-productos']/article
	private static final String SBtnSiguiente = "//button[@class='next']";
	private static final String SBtbPagarConMillas = "//div[contains(@class,'switcher')]";

	private static final String SCantVales = "//div[contains(@class,'lista')]/section[contains(@style,'block;')]//article";
	private static final String SFichaCantMillasVales = "//div[@class='white-modal']//div[contains(@class,'visible')]//p[contains(.,'Millas Benefit')]";

	@FindBy(xpath = SMalla)
	WebElementFacade Malla;

	@FindBy(xpath = SBtnDesplizante)
	WebElementFacade BtnDesplizante;

	@FindBy(xpath = SBtnPaginacion)
	WebElementFacade BtnPaginacion;

	@FindBy(xpath = SBtnSiguiente)
	WebElementFacade BtnSiguiente;

	@FindBy(xpath = SBtbPagarConMillas)
	WebElementFacade BtbPagarConMillas;

	public boolean ValidarSeccionMalla() {
		try {
			bValor = Malla.isDisplayed();
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo ValidarSeccionMalla", false);
			System.out.println("Error en el metodo ValidarSeccionMalla");
		}
		return bValor;
	}

	public boolean setTextoEn_Buscador(String sTexto_Caracteres) {
		try {
			pageObject_Search.Buscador.typeAndEnter(sTexto_Caracteres);
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo setTextoEn_Buscador", false);
		}
		return bValor;
	}

	public String getTexto_CantidadMillasBarra() throws Exception {
		try {
			//
			WebElement SliderMenor = getDriver().findElement(By.xpath("//div[@class='noUi-handle noUi-handle-lower']"));
			//util.dragAndDropBy(getDriver(), SliderMenor, -20, 0);

			WebElement we = getDriver().findElement(By.xpath("//div[@class='noUi-handle noUi-handle-lower']"));
			Actions clickTriangle= new Actions(getDriver());
			clickTriangle.moveToElement(we).moveByOffset(50, 0).click().perform();
			
			//
			
			String SNombre_ = "";
			SNombre_ = findBy(SCantidadMillas).then().getText();
			System.out.println("SNombre_: " + SNombre_.toString());

			String[] parts = SNombre_.split("-");
			String SMillasInicio = parts[0];
			String SMillasFin = parts[1];

			iCantidadInicio = (int) util.ObtenerValorSoloNumero(SMillasInicio.replace(",", ""));
			iCantidadFin = (int) util.ObtenerValorSoloNumero(SMillasFin.replace(",", ""));
			System.out.println("dCantidadInicio " + iCantidadInicio);
			System.out.println("dCantidadFin " + iCantidadFin);
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo getTexto_CantidadMillas", false);
		}
		return SNombre;
	}

	public boolean ClickPagarSoloConMillas() {
		try {
			BtbPagarConMillas.click();
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo ClickPagarSoloConMillas", false);
			System.out.println("Error en el metodo ClickPagarSoloConMillas");
		}
		return bValor;
	}

	public void getCantidadCateTotal(int ICantidadCategorias) {
		int iCantidad = 0;
		try {
			for (int i = 1; i <= ICantidadCategorias; i++) {
				Thread.sleep(1000);
				WebElement Seleccionar_Categorias = getDriver().findElement(By.xpath(SSeleccionarCate + i + "]"));
				Seleccionar_Categorias.click();

				SNombre = findBy(SSeleccionarCate + i + "]//i[@class='cantidad active']").then().getText();
				iCantidad = Integer.parseInt(SNombre.toString());
				iTotalCantidadProductosCate = iTotalCantidadProductosCate + iCantidad;
				System.out.println("Total Categoria: " + iTotalCantidadProductosCate);
			}
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo SelectCantidadCate", false);
		}
	}

	public boolean ValidarRangoMillas() {
		int iCantProductos = 0, iCantidadPaginas = 0, SMillasProd_ = 0;
		try {
			iCantidadPaginas = getDriver().findElements(By.xpath(SBtnPaginacion)).size();
			iCantidadPaginas = (iCantidadPaginas == 0) ? 1 : iCantidadPaginas;
			for (int iPaginacion = 1; iPaginacion <= iCantidadPaginas; iPaginacion++) {
				Thread.sleep(1000);
				iCantProductos = getDriver().findElements(By.xpath(SCantProductos)).size();
				iTotalProductosResult = iTotalProductosResult + iCantProductos;
				for (int i = 1; i <= iCantProductos; i++) {
					Thread.sleep(1000);
					util.scrollToElement(getDriver(), "//div[contains(@class,'art-productos')]/article[" + i + "]");
					SMillasProd = findBy("//div[contains(@class,'art-productos')]/article[" + i
							+ "]//p[contains(@class,'millas-ahora')]").then().getText();
					SMillasProd_ = (int) util.ObtenerValorSoloNumero(SMillasProd.replace(",", ""));
					System.out.println("SMillasProd:  " + SMillasProd_);

					if (!(iCantidadInicio <= SMillasProd_ && SMillasProd_ <= iCantidadFin)) {
						Assert.assertTrue("Error, el producto numero: " + i + " de la pagina: " + iPaginacion
								+ " no se encuentra en el rango de millas", false);
					}
				}
				SNombre = findBy("//button[contains(@class,'next')]").then().getAttribute("class");
				if (SNombre.equals("next")) {
					BtnSiguiente.click();
				}
			}
			bValor = (iTotalCantidadProductosCate == iTotalProductosResult) ? true : false;
		} catch (Exception e) {
			System.out.println("Error: " + e);
			Assert.assertTrue("Error en el metodo ValidarRangoMillas", false);
		}
		return bValor;
	}

	public void ClickFiltroVale(String STipoVale) {
		try {
			WebElement TipoVale = getDriver().findElement(
					By.xpath("//div[contains(@class,'filtro-vale')]//label[contains(.,'" + STipoVale + "')]"));
			TipoVale.click();

			WebElement iCantidadVale = getDriver().findElement(
					By.xpath("//div[contains(@class,'filtro-vale')]//label[contains(.,'" + STipoVale + "')]/span/i"));
			iFiltroTotalCantidadValeCate = Integer.parseInt(iCantidadVale.getText());
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo ClickTipoVale", false);
			System.out.println("Error en el metodo ClickTipoVale");
		}
	}

	public boolean ValidarRangoMillasVales() {
		int iCantVales = 0, iCantidadPaginas = 0, SMillasProd_ = 0;
		try {
			iCantidadPaginas = getDriver().findElements(By.xpath(SBtnPaginacion)).size();
			iCantidadPaginas = (iCantidadPaginas == 0) ? 1 : iCantidadPaginas;
			for (int iPaginacion = 1; iPaginacion <= iCantidadPaginas; iPaginacion++) {
				Thread.sleep(1000);
				iCantVales = getDriver().findElements(By.xpath(SCantVales)).size();
				iTotalProductosResult = iTotalProductosResult + iCantVales;
				for (int i = 1; i <= iCantVales; i++) {
					Thread.sleep(1000);
					WebElement ClickVale = getDriver().findElement(By.xpath("(" + SCantVales + ")[" + i + "]"));
					ClickVale.click();

					// Obtener las millas de la ficha del vale
					SMillasProd = findBy(SFichaCantMillasVales).then().getText();
					SMillasProd_ = (int) util.ObtenerValorSoloNumero(SMillasProd.replace(",", ""));
					System.out.println("SMillasProd:  " + SMillasProd_);

					if (!(iCantidadInicio <= SMillasProd_ && SMillasProd_ <= iCantidadFin)) {
						Assert.assertTrue("Error, el producto numero: " + i + " de la pagina: " + iPaginacion
								+ " no se encuentra en el rango de millas", false);
					}
					getDriver().navigate().back();

					if (!getDriver().findElements(By.xpath("//button[contains(@class,'next')]")).isEmpty()) {
						SNombre = findBy("//button[contains(@class,'next')]").then().getAttribute("class");
						if (SNombre.equals("next")) {
							BtnSiguiente.click();
						}
					}
				}
			}
			Thread.sleep(1000);
			bValor = (iFiltroTotalCantidadValeCate == iTotalProductosResult) ? true : false;
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo ValidarRangoMillasVales", false);
		}
		return bValor;
	}

	public void ClickFiltroFecha(String SFecha) {
		try {
			SNombreFiltro=SFecha;
			WebElement Fecha = getDriver().findElement(
					By.xpath("//div[contains(@class,'filtro filtro-fecha')]/label/span[contains(.,'" + SFecha + "')]"));
			Fecha.click();
		} catch (Exception e) {
			Assert.assertTrue("Error en el metodo ClickFiltroFecha", false);
			System.out.println("Error en el metodo ClickFiltroFecha");
		}
	}

	public boolean ValidarRangoMillasEventos() {
		int iCantProductos = 0, iCantidadPaginas = 0, SMillasProd_ = 0,iValorMes=0;
		String SNombreMes_metodo="",SNombreMes_HTML="";
		try {
			iValorMes=(SNombreFiltro.equals("Próximo mes"))?1:0;
			SNombreMes_metodo=CalcularMeses(iValorMes);
			System.out.println("SNombreMes_metodo "+ SNombreMes_metodo);
			
			iCantidadPaginas = getDriver().findElements(By.xpath(SBtnPaginacion)).size();
			iCantidadPaginas = (iCantidadPaginas == 0) ? 1 : iCantidadPaginas;
			for (int iPaginacion = 1; iPaginacion <= iCantidadPaginas; iPaginacion++) {
				Thread.sleep(1000);
				iCantProductos = getDriver().findElements(By.xpath(SCantProductos)).size();
				iTotalProductosResult = iTotalProductosResult + iCantProductos;
				for (int i = 1; i <= iCantProductos; i++) {
					Thread.sleep(1000);
					util.scrollToElement(getDriver(), SCantProductos + "[" + i + "]");
					SMillasProd = findBy(SCantProductos + "[" + i + "]//p[contains(@class,'data-miles')]").then().getText();
					SMillasProd_ = (int) util.ObtenerValorSoloNumero(SMillasProd.replace(",", ""));
					System.out.println("SMillasProd:  " + SMillasProd_);

					if (!(iCantidadInicio <= SMillasProd_ && SMillasProd_ <= iCantidadFin)) {
						Assert.assertTrue("Error, el producto numero: " + i + " de la pagina: " + iPaginacion + " no se encuentra en el rango de millas", false);
					}
				
					if (SNombreFiltro.equalsIgnoreCase("Próximo mes")||SNombreFiltro.equalsIgnoreCase("Este mes")) {						
					SNombreMes_HTML = findBy("//div[contains(@class,'articles')]/article["+i+"]//div[@class='month']").then().getText();										
					if (!SNombreMes_metodo.toUpperCase().toString().contains((SNombreMes_HTML))) {
						Assert.assertTrue("Error, los meses de los eventos no coinciden con el filtro seleccionado", false);
						}					
					}
				
				}
				if (!getDriver().findElements(By.xpath("//button[contains(@class,'next')]")).isEmpty()) {
					SNombre = findBy("//button[contains(@class,'next')]").then().getAttribute("class");
					if (SNombre.equals("next")) {
						BtnSiguiente.click();
					}
				}
			}
			bValor = (iTotalCantidadProductosCate == iTotalProductosResult) ? true : false;
		} catch (Exception e) {
			System.out.println("Error: " + e);
			Assert.assertTrue("Error en el metodo ValidarRangoMillas", false);
		}
		return bValor;
	}

	public String CalcularMeses(int iMes) {
		Calendar mCalendar = Calendar.getInstance();
		Locale localeSpanish = new Locale("es", "ES");
		mCalendar.add(Calendar.MONTH, iMes);
		return mCalendar.getDisplayName(Calendar.MONTH, Calendar.LONG, localeSpanish);
	}

}
