package cscie88a.week2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AllAnimalTests {

	private Cat3 sneaky;
	private Dog bolt;
	private Toy ball;
	private Toy mouse;
	private Cat3 other_cat;
	private Dog other_dog;
	private HedgeHog hog;

	@BeforeEach
	void setUp() throws Exception {
		sneaky = new Cat3("Sneaky", "blue", "gray");
		bolt = new Dog("Bolt", "brown", "whity");
		ball = new Toy("Ball", false);
		mouse = new Toy("Mouse", true);
		other_cat = new Cat3();
		other_dog = new Dog();
		hog = new HedgeHog();
	}

	@Test
	void testTakeMedicine() {		
		assertTrue(bolt.takeMedicine(true));
		assertFalse(bolt.takeMedicine(false));
		assertFalse(sneaky.takeMedicine(true));
		assertFalse(sneaky.takeMedicine(false));
	}

	@Test
	public void testDoTrick() {
		assertFalse(sneaky.doTrick("sit"));
		assertTrue(bolt.doTrick("sit"));
	}

	@Test
	public void testPlayWithToy1() {
		assertTrue(sneaky.playWithToy(ball));
		assertTrue(bolt.playWithToy(ball));
	}

	@Test
	public void testPlayWithToy2() {
		assertTrue(sneaky.playWithToy(mouse));	// squeaky toy
		assertFalse(sneaky.playWithToy(ball));	// not squeaky toy
		assertTrue(bolt.playWithToy(mouse));
		assertTrue(bolt.playWithToy(ball));
	}

	@Test
	public void testSingWithFriend() {
		assertFalse(sneaky.singWithFriend(other_cat));
		assertFalse(sneaky.singWithFriend(other_dog));
		assertTrue(bolt.singWithFriend(other_cat));
		assertTrue(bolt.singWithFriend(other_dog));
	}

	@Test
	public void testHedgehodPlayWithToy() {
		assertTrue(hog.playWithToy(ball));
		assertTrue(hog.playWithToy(mouse));
	}

	@Test
	public void testGuardHome() {
		assertTrue(bolt.guardHome());
		assertFalse(sneaky.guardHome());
		assertFalse(hog.guardHome());
	}

}
