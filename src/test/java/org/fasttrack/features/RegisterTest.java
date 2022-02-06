package org.fasttrack.features;

import org.assertj.core.internal.bytebuddy.utility.RandomString;
import org.fasttrack.steps.RegisterSteps;
import org.fasttrack.utils.EnvConstants;
import org.junit.Test;

public class RegisterTest extends BaseTest{

    RandomString randomString = new RandomString();

    String  random = randomString.nextString();

    @Test
    public void registerWithValidCredentials(){
        registerSteps.setValidCredentials("danielaaa.stanus"+ random + "@mailinator.com", EnvConstants.USER_PASS);
        registerSteps.clickRegisterButton();
        registerSteps.registerConfirmation("danielaaa.stanus" + random);
    }

    @Test
    public void registerWithAnExistentEmailAddress(){
        registerSteps.setValidCredentials(EnvConstants.USER_EMAIL, EnvConstants.USER_PASS);
        registerSteps.clickRegisterButton();
        registerSteps.registerError();
    }

    @Test
    public void registerWithInvalidEmailAddress(){
        registerSteps.setEmailAddress(EnvConstants.USER_INVALID_EMAIL);
        registerSteps.setPassword(EnvConstants.USER_PASS);
        registerSteps.clickRegisterButton();
        registerSteps.invalidEmailErrorIsDisplayed();
    }
}
