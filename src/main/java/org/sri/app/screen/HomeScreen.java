package org.sri.app.screen;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;

/**
 * Created by sridhar.easwaran on 12/28/2016.
 */
public class HomeScreen {

    By SearchBox= new By.ById("search_form_input_homepage");
    By SearchButton= new By.ById("search_button_homepage");
    By HomePageLogo= new By.ByCssSelector("a.logo_homepage");

    public void visit(){

    }
}
