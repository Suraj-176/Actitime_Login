package pom_webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Actitime_loginPage {
	
	@FindBy(id="username")
	private WebElement username;
	
	@FindBy(name="pwd")
	private WebElement password;
	
	@FindBy(id="keepLoggedInCheckBox")
	private WebElement Checkbox;
	
	@FindBy(id="loginButton")
	private WebElement loginButton;
	
	public Actitime_loginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void setCredentials(String user,String pass)
	{
		username.sendKeys(user);
		password.sendKeys(pass);
	}
	
	public void clickCheckbox()
	{
		Checkbox.click();
	}
	public void clickLoginButton()
	{
		loginButton.click();
	}

}
