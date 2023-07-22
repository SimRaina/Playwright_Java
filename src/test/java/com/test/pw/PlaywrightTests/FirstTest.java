package com.test.pw.PlaywrightTests;

import com.microsoft.playwright.*;

public class FirstTest {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
            		.setHeadless(false).setSlowMo(50));
            
            Page page = browser.newPage();
            page.navigate("http://playwright.dev");
            System.out.println(page.title());
          
        }
    }
}