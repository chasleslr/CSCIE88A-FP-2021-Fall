package cscie88a.week2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Toy {

    private static final Logger logger = LoggerFactory.getLogger(Toy.class);

    public String name;
    private Boolean squeaky;

    public Toy() {}

    public Toy(String name, Boolean squeaky) {
        this.name = name;
        this.squeaky = squeaky;
    }

    public void doFunStuff() {
        System.out.println("I am playing with my fun toy: " + name);
    }

    public Boolean isSqueaky() {
        if (squeaky) {
            return true;
        } else {
            return false;
        }
    }
}
