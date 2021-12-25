package com.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class EBaySite {
WebDriver driver;
@FindBy(xpath="/html[1]/body[1]/header[1]/table[1]/tbody[1]/tr[1]/td[3]/form[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[1]/input[1]")
WebElement search;
public WebElement getSerachBox() {
	return search;
}
@FindBy(xpath="/html[1]/body[1]/header[1]/table[1]/tbody[1]/tr[1]/td[3]/form[1]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/select[1]")
WebElement category;
public Select getCategory() {
	Select cat=new Select(category);
	return cat;
}
@FindBy(xpath="/html[1]/body[1]/header[1]/table[1]/tbody[1]/tr[1]/td[3]/form[1]/table[1]/tbody[1]/tr[1]/td[3]/input[1]")
WebElement magnifierButton;
public WebElement getMagnifierButton() {
	return magnifierButton;
}
public void getNthProduct(int pnum) {
	String xpathExp=String.format("//div[@class='srp-river srp-layout-inner']//li[%d]", pnum);
	String details=driver.findElement(By.xpath(xpathExp)).getText();
	System.out.println(details);
}
@FindAll(@FindBy(xpath="//div[@class='srp-river srp-layout-inner']//li"))
List<WebElement> AllItems;
public List<WebElement> getAllItems(){
	return AllItems;
}
public EBaySite(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

}
