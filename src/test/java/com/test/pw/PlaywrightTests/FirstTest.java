package com.test.pw.PlaywrightTests;

import com.microsoft.playwright.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import java.util.regex.Pattern;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FirstTest {
	
	Playwright playwright;
	Browser browser;
	Page page;
	
	@BeforeTest
	public void setup() {
		playwright = Playwright.create();
     	browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
        		.setHeadless(false));
        
        page = browser.newPage();	
	}
	
	@AfterTest
	public void tearDown() {
		browser.close();
		playwright.close();
	}
	
	@Test
    public void test1() {
            page.navigate("http://playwright.dev");
            System.out.println(page.title());
            
         // Expect a title "to contain" a substring.
            assertThat(page).hasTitle(Pattern.compile("Playwright"));
          
        }
}