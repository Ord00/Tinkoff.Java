package edu.hw4.Validation;

import edu.hw4.Animal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import static edu.hw4.Validation.ValidationError.searchForErrors;

public class Task19 {
    private Task19() {

    }

    public static Map<String, Set<ValidationError>> errorsInRecords(List<Animal> animalList) {
        if (animalList.isEmpty()) {
            throw new NullPointerException();
        }
        Map<String, Set<ValidationError>> result = new HashMap<>();
        animalList.stream().forEach(i -> {
            Set<ValidationError> validationErrorSet = searchForErrors(i);
            if (!validationErrorSet.isEmpty()) {
                result.put(i.name(), validationErrorSet);
            }
        });
        return result;
    }
}
