package com.qa.locators;

import org.openqa.selenium.By;

public class ContactPageLocators {

    public static final By polandAddress = By.xpath("//h3[normalize-space(.)='BTCBIT Sp. z o.o. Ul. Gesia 8 - 205, 31-535 Krakow, Poland']");
    public static final By emailInPolandModule = By.xpath("//h3[normalize-space(.)='BTCBIT Sp. z o.o. Ul. Gesia 8 - 205, 31-535 Krakow, Poland']//parent::div//div//a[@href='mailto:info@btcbit.net']");
    public static final By polandPhoneNumber = By.xpath("//h4[text()='Phone']//following-sibling::a[text()='+48 588 813 222']");
    public static final By estoniaAddress = By.xpath("//h3[normalize-space(.)='BTCBIT OÜ Pikk tn 33-3, 10133 Tallinn, Estonia']");
    public static final By emailInEstoniaModule = By.xpath("//h3[normalize-space(.)='BTCBIT OÜ Pikk tn 33-3, 10133 Tallinn, Estonia']//parent::div//div//a[@href='mailto:info@btcbit.net']");
    public static final By estoniaPhoneNumber = By.xpath("//h4[text()='Phone']//following-sibling::a[text()='+372 8 803 222']");
}
