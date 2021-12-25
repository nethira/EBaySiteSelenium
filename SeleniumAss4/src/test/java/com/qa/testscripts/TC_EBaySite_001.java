package com.qa.testscripts;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TC_EBaySite_001 extends TestBase {
    @Test
    public void searchItems(){
    	ebay.getSerachBox().sendKeys("Apple Watches");
    	ebay.getCategory().selectByVisibleText("Consumer Electronics");
    	ebay.getMagnifierButton().click();
    	ebay.getNthProduct(3);
    	System.out.println("\n");
    	System.out.println("Printing the products in 1st page");
    	List<WebElement> allItems=ebay.getAllItems();
    			for(WebElement items:allItems) {
			System.out.println(items.getText());
			System.out.println("\n");
			
		}
    }
	
}
