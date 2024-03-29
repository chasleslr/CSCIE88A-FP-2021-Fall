package cscie88a.week5.hw;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class AnimalGeneratorTest {

    @Test
    void testGenerateListOfAnimals() throws Exception {
        int numberOfAnimals = 30;
        List<StreamAnimal> resultAnimals = AnimalGenerator.generateListOfAnimals(numberOfAnimals);
        assertEquals(numberOfAnimals, resultAnimals.size());
        // verify we have animals of each type, with a correct age;
        // this is not the most elegant way to do this - you will implement a much better way
        // of counting animals by type in the bonus problem 5
        int numOfCats = 0;
        int numOfDogs = 0;
        int numOfHedgehogs = 0;
        for (StreamAnimal resultAnimal : resultAnimals) {
            assertTrue(resultAnimal.getAge() >= 0);
            if (resultAnimal.getAnimalType().equals(AnimalType.CAT))
                numOfCats++;
            else if (resultAnimal.getAnimalType().equals(AnimalType.DOG))
                numOfDogs++;
            else if (resultAnimal.getAnimalType().equals(AnimalType.HEDGEHOG))
                numOfHedgehogs++;
            else
                throw new Exception("Unexpected animals type ");
        }
        assertTrue(numOfCats > 0);
        assertTrue(numOfDogs > 0);
        assertTrue(numOfHedgehogs > 0);
    }

    @Test
    void testGetNewAnimal() {
        StreamAnimal resultAnimal = AnimalGenerator.getNewAnimal();
        assertNotNull(resultAnimal);
    }

    @Test
    void testGetNewAnimalByTypeFlag() {
        int animalTypeFlag = 0;
        int nameSuffix = 100;
        // test creation of a Cat
        StreamAnimal resultAnimal = AnimalGenerator.getNewAnimalByTypeFlag(animalTypeFlag, nameSuffix);
        assertNotNull(resultAnimal);
        assertEquals(resultAnimal.getAnimalType(), AnimalType.CAT);
        assertTrue(resultAnimal.getAge() >= 0);
        assertEquals(resultAnimal.getName(), "GeneratedCat100");

        // test creation of a Dog
        animalTypeFlag = 1;
        resultAnimal = AnimalGenerator.getNewAnimalByTypeFlag(animalTypeFlag, nameSuffix);
        assertNotNull(resultAnimal);
        assertEquals(resultAnimal.getAnimalType(), AnimalType.DOG);
        assertTrue(resultAnimal.getAge() >= 0);
        assertEquals(resultAnimal.getName(), "GeneratedDog100");

        // test creation of a Hedgehog
        animalTypeFlag = 2;
        resultAnimal = AnimalGenerator.getNewAnimalByTypeFlag(animalTypeFlag, nameSuffix);
        assertNotNull(resultAnimal);
        assertEquals(resultAnimal.getAnimalType(), AnimalType.HEDGEHOG);
        assertTrue(resultAnimal.getAge() >= 0);
        assertEquals(resultAnimal.getName(), "GeneratedHedgehog100");
    }

    @Test
    void testGenerateStreamOfAnimalsFromCollection() {
        Stream<StreamAnimal> animals = AnimalGenerator.generateStreamOfAnimalsFromCollection(10);
        assertEquals(10, animals.count());

        Stream<StreamAnimal> animals2 = AnimalGenerator.generateStreamOfAnimalsFromCollection(25);
        assertEquals(25, animals2.count());
    }

    @Test
    void testGenerateStreamOfAnimals_lambda() {
        Stream<StreamAnimal> animalStream = AnimalGenerator.generateStreamOfAnimals_lambda();
        List<StreamAnimal> animals = animalStream.limit(20).collect(Collectors.toList());
        assertEquals(20, animals.size());

        List<StreamAnimal> ageFiltered = animals
                .stream()
                .filter(animal -> animal.getAge() >= 0 & animal.getAge() <= 20)
                .collect(Collectors.toList());

        assert ageFiltered
                .stream()
                .filter(animal -> animal.getAnimalType().equals(AnimalType.CAT))
                .count() > 0;

        assert ageFiltered
                .stream()
                .filter(animal -> animal.getAnimalType().equals(AnimalType.DOG))
                .count() > 0;

        assert ageFiltered
                .stream()
                .filter(animal -> animal.getAnimalType().equals(AnimalType.HEDGEHOG))
                .count() > 0;
    }

}