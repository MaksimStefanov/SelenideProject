package com.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class InitialPage {
    @FindBy(xpath = "//div[@class='button'][text()='gummies']/parent::a")
    private SelenideElement gummies;


    @Step
    public GummiesPage clickGummies() {
        gummies.click();
        return page(GummiesPage.class);
    }
}
