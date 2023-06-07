package stepDef;

import io.cucumber.java.en.Given;

import static org.example.Rover.W;
import static stepDef.Hooks.rover;

public class test2 {
    @Given("moving the rover x={int} and y={int} position and location")
    public void movingTheRoverXAndYPositionAndLocation(int arg0, int arg1) {

//        rover.setPosition(1,2, W);
    }
}
