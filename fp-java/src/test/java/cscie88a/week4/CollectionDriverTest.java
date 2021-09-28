package cscie88a.week4;

import cscie88a.week3.AdoptionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class CollectionDriverTest {

    private Cat cat1;
    private Cat cat2;
    private Cat cat3;
    private Cat cat4;

    @BeforeEach
    void setUp() throws Exception {
        cat1 = new Cat("george", "green", "grey", 1, false);
        cat2 = new Cat("alfred", "brown", "grey", 5, false);
        cat3 = new Cat("albert", "yellow", "black", 3, true);
        cat4 = new Cat("harry", "brown", "white", 10, true);
    }

    @Test
    public void testPlayWithMutability(){
        CollectionDriver driver = new CollectionDriver();
        driver.playWithMutability();
    }

    @Test
    public void testFindAvgAge(){
        CollectionDriver driver = new CollectionDriver();
        List<Cat> allCats = new ArrayList<>(Arrays.asList(cat1, cat2, cat3));
        assert driver.findAvgAge(allCats) == 3;
    }

    @Test
    public void testChangeHealthStatus(){
        CollectionDriver driver = new CollectionDriver();
        List<Cat> allCats = new ArrayList<>(Arrays.asList(cat1, cat2, cat3));
        driver.changeHealthStatus(allCats, true);
        for (Cat cat: allCats) {
            assert cat.getHealthCheckDone() == true;
        }
        driver.changeHealthStatus(allCats, false);
        for (Cat cat: allCats) {
            assert cat.getHealthCheckDone() == false;
        }
    }

    @Test
    public void testFindCatsWithGreenEyes(){
        CollectionDriver driver = new CollectionDriver();
        List<Cat> allCats = new ArrayList<>(Arrays.asList(cat1, cat2, cat3));
        List<Cat> greenEyed = (List<Cat>) driver.findCatsWithGreenEyes(allCats);
        assert greenEyed.size() == 1;
        assert greenEyed.get(0) == cat1;
    }
}
