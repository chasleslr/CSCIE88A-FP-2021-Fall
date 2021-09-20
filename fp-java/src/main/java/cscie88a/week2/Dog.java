package cscie88a.week2;

public class Dog extends Animal implements ITrainable, Guard {

	public Dog() {
	}

	public Dog(String name, String eyeColor, String bodyColor) {
		super(name, eyeColor, bodyColor);
	}

	@Override
	public boolean doTrick(String trickName) {
		System.out.println(name + " says: I LOVE doing tricks! I'm doing "
				+ trickName + " now!");
		return true;
	}

	@Override
	public boolean singWithFriend(Animal aFriend) {
		System.out.println("I am singing with my friend " + aFriend.getName());
		return true;
	}

	@Override
	public boolean playWithToy(Toy toy) {
		System.out.println("I love the toy! Yeah!!!");
		toy.doFunStuff();
		return true;
	}

	@Override
	public boolean guardHome() {
		return true;
	}
}
