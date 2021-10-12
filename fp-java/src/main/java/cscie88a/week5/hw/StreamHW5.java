package cscie88a.week5.hw;

import org.apache.kafka.common.protocol.types.Field;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamHW5 {

    private static List<String> characters = Arrays.asList("a", "b", "c", "d");

    private static Predicate<StreamAnimal> HealthyAnimalFilter = new Predicate<StreamAnimal>() {
        @Override
        public boolean test(StreamAnimal streamAnimal) {
            if (streamAnimal.isHasCurrentShots() == true) {
                return true;
            } else {
                return false;
            }
        }
    };

    public static Stream<StreamAnimal> checkForHealthyAnimals() {
        Stream<StreamAnimal> animals = AnimalGenerator.generateStreamOfAnimalsFromCollection(20);
        Stream<StreamAnimal> filtered = animals.filter(HealthyAnimalFilter);
        return filtered;
    }

    public static Stream<StreamAnimal> checkForHealthyCats() {
        Stream<StreamAnimal> animals = AnimalGenerator.generateStreamOfAnimalsFromCollection(20);
        Stream<StreamAnimal> filtered = animals
                .filter(HealthyAnimalFilter)
                .filter(animal -> animal.getAnimalType().equals(AnimalType.CAT));
        return filtered;
    }

    public static Stream<String> getNamesOfHealthyAnimals() {
        Stream<StreamAnimal> animals = AnimalGenerator.generateStreamOfAnimalsFromCollection(20);
        Stream<String> names = animals
                .filter(HealthyAnimalFilter)
                .map(animal -> animal.getName());
        return names;
    }

    public static StreamAnimal getOldestAnimal() {
        Stream<StreamAnimal> animals = AnimalGenerator.generateStreamOfAnimalsFromCollection(40);
        return animals
                .reduce((a, b) -> a.getAge() > b.getAge() ? a : b)
                .get();
    }

    public static float getAverageAgeOfAnimals() {
        Stream<StreamAnimal> animals = AnimalGenerator.generateStreamOfAnimalsFromCollection(40);
        return (float) animals
                .mapToDouble(StreamAnimal::getAge)
                .average()
                .orElse(0);
    }

    public static List<String> getAnimalNamesAsList(){
        Stream<StreamAnimal> animals = AnimalGenerator.generateStreamOfAnimalsFromCollection(20);

        return animals
                .map(animal -> animal.getName())
                .collect(Collectors.toList());
    }

    // Bonus problem 5
    public static Map<AnimalType, Long> getAnimalCountsByType(){
        Stream<StreamAnimal> animals = AnimalGenerator.generateStreamOfAnimalsFromCollection(100);
        return animals
                .parallel()
                .collect(Collectors.groupingBy(StreamAnimal::getAnimalType, Collectors.counting()));
    }

    // Bonus problem 6
    public static String randomizeString(String inputString) {
        List<Character> chars = inputString
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());

        System.out.println(chars);
        return "foo";
    }

    public static Stream<String> getRandomizedInfiniteStream() {
        // TODO implement this and return a correct object
        return null;
    }

    public static String getRandomizedString(String inputString) {
        // TODO implement this and return a correct object
        return null;
    }

}
