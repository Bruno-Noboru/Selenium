package Iterasys;

import static org.junit.Assert.assertEquals;
import java.awt.Desktop.Action;
import java.io.File;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class Consulta  {
		
		String url;
		WebDriver driver;
		Action Actions;	

	@Before
	public void iniciar() {
		
		url="https://iterasys.com.br/";
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Noboru\\eclipse-workspace\\Iterasys\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60000,TimeUnit.MILLISECONDS);	
		
	}

	@After
	public void finalizar() {
		driver.quit();		
	}	
	
	@Dado("^o cliente acessa site da iterasys$")
	public void o_cliente_acessa_site_da_iterasys() throws Throwable {
		driver.get(url);
			
	}
	
	@Quando("^realizo uma consulta por \"([^\"]*)\"$")
	public void realizo_uma_consulta_por(String termo) throws Throwable{
			     
		driver.findElement(By.id("searchtext")).clear();		
		driver.findElement(By.id("searchtext")).sendKeys(Keys.chord(termo));
		driver.findElement(By.id("searchtext")).sendKeys(Keys.ENTER);		 
	      driver.findElement(By.id("all_courses_search")).click();
	      
	      
	 //validando informacao no centro da imagem o texto depois da imagem relogio
	    assertEquals("060 horas",driver.findElement(By.cssSelector("span.subtitulo")).getText());  
	}

	@Entao("^exibe o cursos$")
	public void exibe_um_conjunto_de_cursos() throws Throwable {
		
		// Estamos validando um cursos
		{assertEquals("Iterasys - Cursos de Teste e QA", driver.getTitle());			
		
		}
	}

	@Quando("^clico no curso inicio rapido em Teste de sofftware$")
	public void clico_no_curso_inicio_rapido_em_Teste_de_sofftware() throws Throwable {
		
		driver.findElement(By.cssSelector("li.item")).click();    
	}

	@Entao("^valido que a duracao do curso sera de \"([^\"]*)\" hora$")
	public void valido_que_a_duracao_do_curso_sera_de_horas(String hora) throws Throwable {
		
		
		assertEquals(hora, driver.findElement(By.cssSelector("li.carga-horaria")).getText());
			
		//screenshot imagem 
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./Screenshots/Screenshot.png"));
		System.out.println("sucesso imagem");
		
		driver.get(url);
		
		
	}	 

}