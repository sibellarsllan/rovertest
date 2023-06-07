package stepDef;

import io.cucumber.java.Before;
import org.example.Rover;

public class Hooks {

    public static Rover rover ;

    @Before
    public void setup(){
        rover = new Rover();


    }




}
