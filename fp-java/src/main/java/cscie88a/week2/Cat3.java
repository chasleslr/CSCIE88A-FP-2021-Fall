package cscie88a.week2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Cat3 extends Animal implements ITrainable, Guard {

	private static final Logger logger = LoggerFactory.getLogger(Cat3.class);
	public static String whatISay = "I don't care what you asked me to say - I say MEOW only";

	public Cat3() {}

	public Cat3(String name, String eyeColor, String bodyColor) {
		super(name, eyeColor, bodyColor);
	}

	// this method is overwritten !
	public boolean takeMedicine(boolean withTreat) {
		logger.info(name + " says: you won't trick me - I'm not taking it!");
		return false;		
	}

	@Override
	public boolean doTrick(String trickName) {
		logger.info(name + " says: cats do NOT do tricks");
		return false;
	}

	public boolean doTrickForTreat(String trickName, String treatName) {
		logger.info(name + " says: cats do NOT do tricks");
		return false;
	}

	@Override
	public boolean singWithFriend(Animal aFriend) {
		logger.info("I won't do it");
		return false;
	}

	public static String saySomething(String somethingToSay){
		return whatISay;
	}

	@Override
	public String toString() {
		return "Cat [name=" + name + ", eyeColor=" + eyeColor + ", bodyColor=" + bodyColor + "]";
	}

	@Override
	public boolean playWithToy(Toy toy) {
		if (toy.isSqueaky()) {
			logger.info("Looks likea mouse... I'll play");
			toy.doFunStuff();
			return true;
		} else {
			logger.info("don't feel like playing");
			return false;
		}
	}

	@Override
	public boolean guardHome() {
		return false;
	}
}
