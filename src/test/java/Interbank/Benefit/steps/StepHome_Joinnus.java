package Interbank.Benefit.steps;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import Interbank.Benefit.pageobject.PageObject_Home_Joinnus;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepHome_Joinnus {
    
    PageObject_Home_Joinnus pageHome_Joinnus;
    //BenefitPaginaResultado paginaResultado;

    @Given("^Usuario esta en la pagina principal de Benefit$")
    public void usuario_esta_en_la_pagina_principal_de_Benefit() {
    	pageHome_Joinnus.open();
    }

    @When("^selecciona el menu de eventos$")
    public void selecciona_el_menu_de_eventos() {pageHome_Joinnus.SelectedEvents();}

    @Then("^visualiza el Home principal$")
    public void visualiza_el_Home_principal() {assertThat(pageHome_Joinnus.ValidateHomeMain(), is(true)); }

    @When("^el Home de experiencias termine de cargar$")
    public void el_Home_de_experiencias_termine_de_cargar() {
        //in comming....	withTimeoutOf(60, TimeUnit.SECONDS).waitFor(Element_for_displayed);
    }

    @Then("^visualiza todas las categorías$")
    public void visualiza_todas_las_categorías() {assertThat(pageHome_Joinnus.ValidateAllCategory(), is(true)); }

    @When("^selecciona la categoria \"([^\"]*)\"$")
    public void selecciona_la_categoria(String iNameCategory) {
    	pageHome_Joinnus.SelectOne_Category(iNameCategory);
    }

    @Then("^visualiza los Eventos de la categoria\\.$")
    public void visualiza_los_Eventos_de_la_categoria() {    	
    	assertThat(pageHome_Joinnus.ValidateEvents_Category(), not(0));
    }

    @Then("^me mostrara la lista de eventos de la categoria seleccionada\\.$")
    public void me_mostrara_la_lista_de_eventos_de_la_categoria_seleccionada() throws Exception {
    	assertThat(pageHome_Joinnus.getStringNombreCategoria(), is(true));
    }

    @Then("^al presionar regresar me lleva al Home principal$")
    public void al_presionar_regresar_me_lleva_al_Home_principal() throws Exception {
    	assertThat(pageHome_Joinnus.Retroceder_ValidarHome(), is(true)); 
    }
}
