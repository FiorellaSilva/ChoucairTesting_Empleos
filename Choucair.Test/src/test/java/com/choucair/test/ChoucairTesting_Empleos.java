package com.choucair.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class ChoucairTesting_Empleos {

	private WebDriver driver;
	By aceptarBtnLocator= By.xpath("//a[@id='cookie_action_close_header']");
	
	By empleosLinkLocator = By.linkText("Empleos");
	By empleosPageLocator = By.xpath("//h2[@class='elementor-heading-title elementor-size-default']"); 
	
	By palabrasclavesLocator = By.id("search_keywords");
	By ubicacionLocator = By.id("search_location");
	
	By buscartrabajosBtnLocator = By.xpath("//input[@value='Buscar trabajos']");
	
	By trabajoLinkLocator = By.xpath("//a[@href='https://www.choucairtesting.com/job/analista-de-pruebas-lima/']");
		
	@Before
	public void setUp() throws Exception {
		
		System.setProperty("webdriver.gecko.driver", "drivers/geckodriver/geckodriver.exe");
		FirefoxOptions options = new FirefoxOptions();
		options.setCapability("marionette", true);
		driver = new FirefoxDriver(options);
		driver.manage().window().maximize();
		driver.navigate().to("https://www.choucairtesting.com/");
		driver.findElement(aceptarBtnLocator).click();
	}

	@After
	public void tearDown() throws Exception {
		
		//driver.quit();
	}

	@Test
	public void BuscarTrabajo() throws InterruptedException {
		
		driver.findElement(empleosLinkLocator).click();
		Thread.sleep(2000);
		if(driver.findElement(empleosPageLocator).isDisplayed()) {
			driver.findElement(palabrasclavesLocator).sendKeys("Analista");
			driver.findElement(ubicacionLocator).sendKeys("Lima");
						
			driver.findElement(buscartrabajosBtnLocator).click();
			
			driver.findElement(trabajoLinkLocator).click();
						
		}
		
		else {
			System.out.print("Register pages was not found");
		}
		
	}
			
}
