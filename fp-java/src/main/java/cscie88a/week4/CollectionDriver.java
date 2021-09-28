package cscie88a.week4;

import java.util.*;

public class CollectionDriver {

    public void playWithMutability(){
        Cat cat1 = new Cat("george", "green", "grey", 1, false);
        Cat cat2 = new Cat("alfred", "brown", "grey", 6, false);
        Cat cat3 = new Cat("albert", "yellow", "black", 3, true);
        Cat cat4= new Cat("harry", "brown", "white", 10, true);

        List<Cat> originalCats = new ArrayList<>(Arrays.asList(cat1, cat2, cat3));
        List<Cat> unmodifiableCats = Collections.unmodifiableList(originalCats);
        List<Cat> immutableCats = List.of(cat1, cat2, cat3);

        originalCats.add(cat4);

        System.out.println("originalCats : " + originalCats.toString());
        System.out.println("unmodifiableCats : " + unmodifiableCats.toString());
        System.out.println("immutableCats : " + immutableCats.toString());

        unmodifiableCats.get(0).setName("bobby");
        immutableCats.get(0).setName("meow");
        System.out.println(cat1);
    }

    // naive implementation of reduce()
    public float findAvgAge(Collection<Cat> allCats){
        int sumAge = 0;
        for (Cat cat: allCats) {
            sumAge += cat.age;
        }
        float mean = sumAge / allCats.size();
        return mean;
    }

    // naive implementation of map()
    public Collection<Cat> changeHealthStatus(Collection<Cat> allCats, boolean healthCheckDone){
        for (Cat cat: allCats) {
            cat.setHealthCheckDone(healthCheckDone);
        }
        return null;
    }

    // naive implementation of filter()
    public Collection<Cat> findCatsWithGreenEyes(Collection<Cat> allCats){
        List greenEyed = new ArrayList();
        for (Cat cat: allCats) {
            if (cat.getEyeColor() == "green") {
                greenEyed.add(cat);
            }
        }
        return greenEyed;
    }

}
