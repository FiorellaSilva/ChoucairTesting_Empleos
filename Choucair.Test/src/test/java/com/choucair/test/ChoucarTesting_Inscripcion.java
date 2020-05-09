package com.choucair.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class ChoucarTesting_Inscripcion {
	
	private WebDriver driver;
	By aceptarBtnLocator= By.xpath("//a[@id='cookie_action_close_header']");

	By trabajoPageLocator = By.xpath("//img[@src='https://www.choucairtesting.com/wp-content/uploads/2019/07/analista_pruebas.jpg']");
	
	By inscribirseBtnLocator = By.xpath("//input[@value='Inscribirse al trabajo']");
	
	By nameLocator = By.name("your-name");	
	By emailLocator = By.name("your-email");	
	By telefonoLocator = By.name("tel");	
	By estudiosLocator = By.name("estudios");	
	By experienciaLocator = By.name("exp");		
	By autoLocator = By.name("auto");		
	By salarioLocator = By.name("salario");	
	By disponiLocator = By.name("curso");
	By selectdisponiLocator = By.xpath("//option[@value='Inmediata']");
	By mensajeLocator = By.name("your-message");
	
	String filepath="C:\\CV_FiorellaSilvaJara_Analyst-QA.pdf";
	
	By enviarBtnLocator = By.xpath("//input[@value='Enviar']");
	
	@Before
	public void setUp() throws Exception {
		
		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver/geckodriver.exe");
		FirefoxOptions options = new FirefoxOptions();
		options.setCapability("marionette", true);
		driver = new FirefoxDriver(options);
		driver.manage().window().maximize();
		driver.navigate().to("https://www.choucairtesting.com/job/analista-de-pruebas-lima/");
		driver.findElement(aceptarBtnLocator).click();
	}

	@After
	public void tearDown() throws Exception {
		//driver.quit();
	}

	@Test
	public void InscribirTrabajo() throws InterruptedException {
		
		if (driver.findElement(trabajoPageLocator).isDisplayed()) {
			driver.findElement(inscribirseBtnLocator).click();	
			driver.findElement(nameLocator).sendKeys("Alessandra");
			driver.findElement(emailLocator).sendKeys("aluna@choucair.com");
			driver.findElement(telefonoLocator).sendKeys("987654321");
			driver.findElement(estudiosLocator).sendKeys("Título en Ingenería de Sistemas");
			driver.findElement(experienciaLocator).sendKeys("3 años como Analista QA");
			driver.findElement(autoLocator).sendKeys("Básico. Sí.");
			driver.findElement(salarioLocator).sendKeys("S/3.800");
			driver.findElement(disponiLocator).click();
			driver.findElement(selectdisponiLocator).click();
			driver.findElement(mensajeLocator).sendKeys("Ingeniera de Sistemas con 03 años de experiencia en pruebas de calidad de software. Partícipe en diferentes grandes proyectos definiendo casos de prueba en base a los requisitos funcionales, no funcionales y técnicos. Familiarizada a la práctica de RUP y Agile.");
			
			WebElement uploadButton = driver.findElement(By.name("file-736"));
			uploadButton.sendKeys(filepath);
			
			driver.findElement(enviarBtnLocator).click();					
			Thread.sleep(2000);
	}
		
		else
			
			System.out.println("Inscribirse button was not present");
	
	}
}
