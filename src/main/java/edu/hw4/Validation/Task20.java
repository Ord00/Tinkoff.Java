package edu.hw4.Validation;

import edu.hw4.Animal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static edu.hw4.Validation.ValidationError.improvedSearchForErrors;

public class Task20 {
    private Task20() {

    }

    public static Map<String, String> improvedErrorsInRecords(List<Animal> animalList) {
        if (animalList.isEmpty()) {
            throw new NullPointerException();
        }
        Map<String, String> result = new HashMap<>();
        animalList.stream()
            .forEach(i -> {
                String validationErrorSet = improvedSearchForErrors(i);
                if (!validationErrorSet.isEmpty()) {
                    result.put(i.name(), validationErrorSet);
                }
            });
        return result;
    }
}
