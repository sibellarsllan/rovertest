package stepDef;

import io.cucumber.java.en.Given;
import org.junit.Assert;

import static stepDef.Hooks.rover;


public class test1 {
    @Given("^Rover lands on mars and assert its coordination and position$")
    public void roverLandsOnMarsAndAssertItsCoordinationAndPosition() {
        Assert.assertEquals("0 0 N", rover.getPosition());
        System.out.println("actual :"+rover.getPosition());
        System.out.println("expected : 0 0 N");





    }


}
