package edu.hw4.Validation;

import edu.hw4.Animal;
import java.util.HashSet;
import java.util.Set;

public class ValidationError {

    protected ValidationError() {

    }

    private ValidationError(String errorMessage) {
    }

    public static Set<ValidationError> searchForErrors(Animal animal) {
        Set<ValidationError> validationErrorSet = new HashSet<>();
        if (animal.name() == null) {
            validationErrorSet.add(new ValidationError("Null name"));
        } else if (animal.name().isEmpty()) {
            validationErrorSet.add(new ValidationError("Empty name"));
        }
        if (animal.type() == null) {
            validationErrorSet.add(new ValidationError("Null type"));
        }
        if (animal.sex() == null) {
            validationErrorSet.add(new ValidationError("Null sex"));
        }
        if (animal.age() < 0) {
            validationErrorSet.add(new ValidationError("Negative age"));
        }
        if (animal.height() == 0) {
            validationErrorSet.add(new ValidationError("Zero height"));
        } else if (animal.height() < 0) {
            validationErrorSet.add(new ValidationError("Negative height"));
        }
        if (animal.weight() == 0) {
            validationErrorSet.add(new ValidationError("Zero weight"));
        } else if (animal.weight() < 0) {
            validationErrorSet.add(new ValidationError("Negative weight"));
        }
        return validationErrorSet;
    }

    public static String improvedSearchForErrors(Animal animal) {
        String result = " ";
        if (animal.name() == null) {
            result += "Name: Null, ";
        } else if (animal.name().isEmpty()) {
            result += "Name: Empty, ";
        }
        if (animal.type() == null) {
            result += "Type: Null, ";
        }
        if (animal.sex() == null) {
            result += "Sex: Null, ";
        }
        if (animal.age() < 0) {
            result += "Age: Negative, ";
        }
        if (animal.height() == 0) {
            result += "Height: Zero, ";
        } else if (animal.height() < 0) {
            result += "Height: Negative, ";
        }
        if (animal.weight() == 0) {
            result += "Weight: Zero, ";
        } else if (animal.weight() < 0) {
            result += "Weight: Negative, ";
        }
        if (result.length() == 1) {
            return "";
        }
        return result.substring(0, result.length() - 2);
    }
}
