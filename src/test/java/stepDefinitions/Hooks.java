package stepDefinitions;

import commons.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends BaseTest {

    @Before(order = 0)
    public void beforeScenario() {
        setUp();
    }

    @After(order = 0)
    public void afterScenario() {
        tearDown();
    }

}
