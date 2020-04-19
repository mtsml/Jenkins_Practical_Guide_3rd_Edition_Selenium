package jp.gihyo.jenkinsbook.page;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class TopPage {
	private WebDriver driver;
	private WebDriverWait wait;

	public TopPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(this.driver, 10);
	}

    public String getFirstNameLabel() {
    	return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/form/label[2]"))).getText();
    }
    
    public String getLastNameLabel() {
		try {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/form/label[1]"))).getText();
		} catch (Exception e) {
			System.out.println("エラー");
			File tempFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.moveFile(tempFile, new File("/var/lib/jenkins/workspace/SeleniumJOB/err.png"));
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}

		return null;
    }
    
    public boolean hasFirstNameInput() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/form/input[2]")));
		} catch(NoSuchElementException e) {
			return false;
		}
		
		return true;
    }
    
    public boolean hasLastNameInput() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/form/input[1]")));
		} catch(NoSuchElementException e) {
			return false;
		}
		
		return true;
    }
    
    public boolean hasSubmit() {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/form/input[4]")));
		} catch(NoSuchElementException e) {
			return false;
		}
		
		return true;
    }
    
    public void setFirstName(String firstName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/form/input[2]"))).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/form/input[2]"))).sendKeys(firstName);
    }
    
    public void setLastName(String lastName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/form/input[1]"))).clear();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/form/input[1]"))).sendKeys(lastName);
    }

    public void submit() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html/body/form/input[4]"))).submit();
	}
}
