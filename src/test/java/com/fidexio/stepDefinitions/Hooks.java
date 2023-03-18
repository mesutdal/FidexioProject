package com.fidexio.stepDefinitions;


import com.fidexio.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/*
In this class we will be able to pass pre- & post- conditions to each scenario and each step
 */
public class Hooks {

    // import from io.cucumber.java not from junit
    // @Before (order = 0) // order ile aynı tür metodların sırası spesifikleştirilebilir.
    public void setupScenario() { // Hooksta senaryo gerçekleşmeden önce olmasını istediğimiz metodu ekleriz. Feature sınıfındaki Background da ise "Given" vb keyword ek
        System.out.println("========Setting up browser using cucumber @Before");
    }

    // @Before ("@login") // sadece @login ile işaretlenmiş senaryoların öncesinde çalışır
    public void setupScenarioForLogins() {
        System.out.println("========this will only apply to scenarios with @login_tag");

    }

    //  @Before ("@db") // sadece @db ile işaretlenmiş senaryoların öncesinde çalışır
    public void setupScenarioForScenarios() {
        System.out.println("========this will only apply to scenarios with @db_tag");
    }

    @After
    public void teardownScenario(Scenario scenario) {


        // scenari.isFailed() --> if scenario fails this method will return TRUE boolean value

        if(scenario.isFailed()){
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png",scenario.getName());

        }

        Driver.closeDriver();

    }


    // @BeforeStep
    public void setupStep () {
        System.out.println("------->applying setup using @BeforeStep");
    }

    //  @AfterStep
    public void afterStep () {
        System.out.println("-------->applying tearDown using @AfterStep");
    }
}
