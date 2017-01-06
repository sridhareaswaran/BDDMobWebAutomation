package org.sri.app.screen;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by sridhar.easwaran on 12/28/2016.
 */
public class ResultsScreen {

    By resultsWrapper = new By.ByCssSelector("div#links_wrapper");

    public void is_ResultsWrapper_Displayed() {
        $(resultsWrapper).isDisplayed();
    }
}
