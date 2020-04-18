package jp.gihyo.jenkinsbook.page;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class TopPage {
	private WebDriver driver;
	
	public TopPage(WebDriver driver) {
		this.driver = driver;
	}

    public String getFirstNameLabel() {
    	return driver.findElement(By.xpath("/html/body/form/label[2]")).getText();
    }
    
    public String getLastNameLabel() {
    	return driver.findElement(By.xpath("/html/body/form/label[1]")).getText();
    }
    
    public boolean hasFirstNameInput() {
		try {
			driver.findElement(By.xpath("/html/body/form/input[2]"));
		} catch(NoSuchElementException e) {
			return false;
		}
		
		return true;
    }
    
    public boolean hasLastNameInput() {
		try {
			driver.findElement(By.xpath("/html/body/form/input[1]"));
		} catch(NoSuchElementException e) {
			return false;
		}
		
		return true;
    }
    
    public boolean hasSubmit() {
		try {
			driver.findElement(By.xpath("/html/body/form/input[4]"));
		} catch(NoSuchElementException e) {
			return false;
		}
		
		return true;
    }
    
    public void setFirstName(String firstName) {
        driver.findElement(By.xpath("/html/body/form/input[2]")).clear();
        driver.findElement(By.xpath("/html/body/form/input[2]")).sendKeys(firstName);
    }
    
    public void setLastName(String lastName) {
        driver.findElement(By.xpath("/html/body/form/input[1]")).clear();
        driver.findElement(By.xpath("/html/body/form/input[1]")).sendKeys(lastName);
    }

    public void submit() {
		driver.findElement(By.xpath(
				"/html/body/form/input[4]")).submit();
	}
}
