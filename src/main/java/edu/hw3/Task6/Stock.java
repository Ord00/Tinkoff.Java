package edu.hw3.Task6;

record Stock(String companyName, Double cost) {
    public String toString() {
        return "(" + companyName() + ", " + cost() + ")";
    }
}
