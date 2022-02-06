package org.fasttrack.features;

import org.fasttrack.utils.EnvConstants;
import org.junit.Test;

public class CheckoutTest extends BaseTest{

    @Test
    public void checkOutWithValidCredentials() {
        loginSteps.setValidCredentials(EnvConstants.USER_EMAIL, EnvConstants.USER_PASS);
        loginSteps.clickLoginButton();
        cartSteps.selectProductFromShop();
        cartSteps.clickAddToCartButton();
        cartSteps.productAddedConfirmation();
        cartSteps.clickOnViewCartButton();
        checkoutSteps.setNames("Daniela", "Stanus", "QA");
        checkoutSteps.selectCountryFromDropdown();
        checkoutSteps.setAddress("Strada Florilor", "numarul 10", "Cluj-Napoca");
        checkoutSteps.selectCountyFromDropdown();
        checkoutSteps.setPostalCodeAndPhoneNumber("248657", "0475654984");
        checkoutSteps.clickPlaceOrderButton();
        checkoutSteps.orderConfirmationMessage();
    }

    @Test
    public void checkOutWithoutEmailAddress(){
        loginSteps.setValidCredentials(EnvConstants.USER_EMAIL, EnvConstants.USER_PASS);
        loginSteps.clickLoginButton();
        cartSteps.selectProductFromShop();
        cartSteps.clickAddToCartButton();
        cartSteps.productAddedConfirmation();
        cartSteps.clickOnViewCartButton();
        checkoutSteps.setNames("Daniela", "Stanus", "QA");
        checkoutSteps.selectCountryFromDropdown();
        checkoutSteps.setAddress("Strada Florilor", "numarul 10", "Cluj-Napoca");
        checkoutSteps.selectCountyFromDropdown();
        checkoutSteps.setPostalCodeAndPhoneNumber("248657", "0475654984");
        checkoutSteps.setEmailField("");
        checkoutSteps.clickPlaceOrderButton();
        checkoutSteps.emailAddressMandatoryAlertMessage();
    }

    @Test
    public void checkoutWithInvalidEmailAddress(){
        loginSteps.setValidCredentials(EnvConstants.USER_EMAIL, EnvConstants.USER_PASS);
        loginSteps.clickLoginButton();
        cartSteps.selectProductFromShop();
        cartSteps.clickAddToCartButton();
        cartSteps.productAddedConfirmation();
        cartSteps.clickOnViewCartButton();
        checkoutSteps.setNames("Daniela", "Stanus", "QA");
        checkoutSteps.selectCountryFromDropdown();
        checkoutSteps.setAddress("Strada Florilor", "numarul 10", "Cluj-Napoca");
        checkoutSteps.selectCountyFromDropdown();
        checkoutSteps.setPostalCodeAndPhoneNumber("248657", "0475654984");
        checkoutSteps.setEmailField(EnvConstants.USER_INVALID_EMAIL);
        checkoutSteps.clickPlaceOrderButton();
        checkoutSteps.emailAddressWrongMessage();

    }
}
