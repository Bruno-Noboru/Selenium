package massa;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.CharSet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import com.opencsv.exceptions.CsvValidationException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Entao;
import entities.Linha;






public class Massatest<Leitura>  {

	String url;
	WebDriver driver;

	@Before
	public void iniciar() {

		url = "https://www.salesforce.com/br/form/signup/freetrial-sales-pe/?d=70130000000EqoP";
		System.setProperty("webdriver.chrome.driver",
				"c:\\users\\BRUNO\\.jenkins\\workspace\\Consulta\\Yahoo\\Drivers\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
		driver.get(url);
		driver.findElement(By.id("onetrust-accept-btn-handler")).click();
	}

	
	  @After public void encerrar() { 
		  driver.quit(); 
		  }	 
	
	
	
	 @Entao("^usuario digita o nome$") 
	 public void usuario_digita_o_nome() throws InterruptedException, CsvValidationException, IOException{ 
		 
		 try {
		
		 FileInputStream arquivo=new FileInputStream("C:\\Users\\Noboru\\eclipse-workspace\\CSV\\Yahoo\\Dados\\dados.csv");
         InputStreamReader input = new InputStreamReader(arquivo);         
         FileOutputStream grava=new FileOutputStream("C:\\Users\\Noboru\\eclipse-workspace\\CSV\\Yahoo\\Dados\\arquivo.txt");
         PrintWriter pr= new PrintWriter(grava);         
         
     
		 
		 BufferedReader br = new BufferedReader(input);
         List<Linha> list = new ArrayList<Linha>();
        
       String line =br.readLine();
     
         if(line !=null){
        	 
        	 
             
             
             while (line != null) {	

            	 line =br.readLine();
            	
            	 
            		 String[]  palavras =line.split(";");
                        String nome=palavras[0];
                        String sobrenome =palavras[1];
                        String cargo =palavras[2];
                        String email=palavras[3];
                        String telefone=palavras[4];
                        String empresa=palavras[5];
                        String recebe=palavras[6];
                        String comp=palavras[7];
                        String paises=palavras[8];
                       
                      
           Linha leitura= new Linha(nome, sobrenome, cargo,email, telefone, empresa,recebe, comp, paises);
           list.add(leitura);
           
          
           //String str = new String(bytes, StandardCharsets.UTF_8)
           
     
      
      
            
           pr.format("UTF-8", nome, sobrenome, cargo,email, telefone, empresa,recebe, comp, paises);
          
           pr.close();
           grava.close(); 
      
	   
		driver.findElement(By.name("UserFirstName")).sendKeys(nome);
		Thread.sleep(1000);

		Thread.sleep(4000);
		
		Thread.sleep(1000);
		driver.findElement(By.name("UserLastName")).click();
		driver.findElement(By.name("UserLastName")).sendKeys(sobrenome);
		Thread.sleep(1000);
		
		Thread.sleep(1000);
	
		
		driver.findElement(By.name("UserTitle")).click();
		driver.findElement(By.name("UserTitle")).sendKeys(cargo);
			
		Thread.sleep(4000);
		
		
		driver.findElement(By.name("UserEmail")).sendKeys(email);
		Thread.sleep(1000);
		
		
		driver.findElement(By.name("UserPhone")).sendKeys(telefone);
		Thread.sleep(1000);
		
		
		
		driver.findElement(By.name("CompanyName")).sendKeys(empresa);
		Thread.sleep(1000);		
		
				
		Select segmento = new Select(driver.findElement(By.name("Lead.Industry")));
		segmento.selectByVisibleText(recebe);
		Thread.sleep(3000);
		
		
		Select t_empresa = new Select(driver.findElement(By.name("CompanyEmployees")));
		t_empresa.selectByVisibleText(comp);
		Thread.sleep(2000);
		
		
		Select pais = new Select(driver.findElement(By.name("CompanyCountry")));
		pais.selectByVisibleText(paises);
		
	
		Thread.sleep(2000);
		
		
		/*
		 * Select pais_est = new Select(driver.findElement(By.name("CompanyState")));
		 * pais_est.selectByVisibleText(estado); Thread.sleep(3000);
		 */
		 
		
		driver.findElement(By.name("Iniciar teste gratuito")).click();
		Thread.sleep(1000);		  
		
		
		
		
		
		  driver.findElement(By.cssSelector("div.row.columns-wrapper"));
		  driver.findElement(By.cssSelector( "div.col.text-left.col-xs-12.col-sm-12.col-md-12.col-lg-12"));
		  driver.findElement(By.cssSelector("div.formContainerV2.parbase.section"));
		  driver.findElement(By.cssSelector( "div.form-container-v2.sfdc-form-day.sfdc-form-closed.sfdc-form-small.bg-default"));
		  driver.findElement(By.cssSelector("div.field.error"));
		  driver.findElement(By.cssSelector("label.sr-only"));
		  driver.findElement(By.name("SubscriptionAgreement"));
		  driver.findElement(By.className("checkbox-ui-label"));
		  driver.findElement(By.className("error-msg-block"));
		  
		
		    
  
		
	       
		  
		
	 
	           if(nome.equals("Luis")) {
		 	
	    //assertEquals("Please read and agree to the Master Subscription Agreement", driver.findElement(By.className("error-msg-block")).getText());
		assertEquals("Pleas read and agree to the Master Subscription Agreement", driver.findElement(By.className("error-msg-block")).getText());
		 }
		 
	           
	           System.out.print("passando aqui");
		 
		//File file = new File("C:\\Users\\Noboru\\eclipse-workspace\\CSV\\Yahoo\\Dados\\arquivo.txt" ); 
		//grava.delete();
		 
		driver.findElement(By.name("UserFirstName")).clear();
		driver.findElement(By.name("UserLastName")).clear();
		driver.findElement(By.name("UserTitle")).clear();
		driver.findElement(By.name("UserEmail")).clear();
		driver.findElement(By.name("UserPhone")).clear();
		driver.findElement(By.name("CompanyName")).clear();
		
		
		Thread.sleep(3000);	
		
	        }
         }
         
         br.close();
         arquivo.close();
     
       
         
		 }
		 
		  
             catch (IOException e) {
     			System.out.println("Error: " + e.getMessage());
		
	     
	 } 
	 }
}
	 

         
      
     







