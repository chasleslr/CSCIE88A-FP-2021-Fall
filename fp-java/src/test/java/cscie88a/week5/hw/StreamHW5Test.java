package cscie88a.week5.hw;

import org.apache.kafka.common.protocol.types.Field;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class StreamHW5Test {

    @Test
    void testCheckForHealthyAnimals() {
        List<StreamAnimal> animals = StreamHW5.checkForHealthyAnimals().collect(Collectors.toList());
        int animalsCount = animals.size();

        assert animals.stream().filter(animal -> animal.isHasCurrentShots() == true).count() == animalsCount;
    }

    @Test
    void testCheckForHealthyCats() {
        List<StreamAnimal> animals = StreamHW5.checkForHealthyCats().collect(Collectors.toList());
        int animalsCount = animals.size();

        assert animals.stream()
                .filter(
                        animal -> animal.isHasCurrentShots() == true
                                & animal.getAnimalType().equals(AnimalType.CAT)
                )
                .count() == animalsCount;
    }

    @Test
    void testGetNamesOfHealthyAnimals() {
        Stream<String> names = StreamHW5.getNamesOfHealthyAnimals();
        assert names.count() > 0;
    }

    @Test
    void testGetOldestAnimal() {
        StreamAnimal oldest = StreamHW5.getOldestAnimal();
        assert oldest.getAge() > 0;
    }

    @Test
    void testGetAverageAgeOfAnimals() {
        float age = StreamHW5.getAverageAgeOfAnimals();
        System.out.println(age);
    }

    @Test
    void testGetAnimalNamesAsList() {
        List<String> names = StreamHW5.getAnimalNamesAsList();
        assert names.size() == 20;

        assert names
                .stream()
                .filter(name -> name.startsWith("Generated"))
                .count() == 20;
    }

    @Test
    void testGetAnimalCountsByType() {
        Map<AnimalType, Long> counts = StreamHW5.getAnimalCountsByType();

        assert counts.get(AnimalType.CAT) > 0;
        assert counts.get(AnimalType.DOG) > 0;
        assert counts.get(AnimalType.HEDGEHOG) > 0;
    }

    @Test
    void testRandomizeString() {
        StreamHW5.randomizeString("hello");
    }

    @Test
    void testGetAnimalCountsByType2() {
        //TODO implement this
    }

    @Test
    void testGetRandomizedInfiniteStream() {
        //TODO implement this
    }

}