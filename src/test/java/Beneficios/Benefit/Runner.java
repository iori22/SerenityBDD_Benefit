package Beneficios.Benefit;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		features = "src/test/resources/features/Login/CambioContrasenia.feature"
		,glue= {"Interbank.Benefit.steps"}
		,monochrome = true 
		//,tags = {"@Test"}
		)
public class Runner {	

		//Joinnus
		//features = "src/test/resources/features/Joinnus/Home_Joinnus.feature"
		//features = "src/test/resources/features/Joinnus/FichaEventos_Joinnus.feature"
		//features = "src/test/resources/features/Joinnus/ZonaCanje_Joinnus.feature"

		//Login
		//features = "src/test/resources/features/Login/CambioContrasenia.feature"
		//features = "src/test/resources/features/Login/CambioNumeroCelular.feature"
		//features = "src/test/resources/features/Login/RegistrarUsuario.feature"
	
		//MeshSearch_AllWorlds
		//features = "src/test/resources/features/MeshSearch_AllWorlds/MeshSearch.feature"
	
		//Search_AllWorlds
		//features = "src/test/resources/features/Search_AllWorlds/Search.feature"
}
