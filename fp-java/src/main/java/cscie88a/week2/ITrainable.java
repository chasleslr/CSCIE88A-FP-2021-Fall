package cscie88a.week2;

public interface ITrainable {
	
	public boolean doTrick(String trickName);

	public default boolean doTrickForTreat(String trickName, String treatName){
		System.out.println(" I LOVE the " + treatName + " and will happily do the "
				+ trickName + " now!");
		return true;
	}

	public boolean singWithFriend(Animal aFriend);
}
