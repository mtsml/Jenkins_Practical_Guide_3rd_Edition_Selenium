package jp.gihyo.jenkinsbook.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ResultPage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	public ResultPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(this.driver, 10);
	}
	
    public String getText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/p"))).getText();
    }
}
