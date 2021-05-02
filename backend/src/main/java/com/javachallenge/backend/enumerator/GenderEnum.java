package com.javachallenge.backend.enumerator;

public enum GenderEnum {
    MALE("M", "Masculino"),
    FEMALE("F", "Feminino"),
    OTHER("O", "Outro");

    private final String identifier;
    private final String description;

    GenderEnum(String identifier, String description) {
        this.identifier = identifier;
        this.description = description;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getDescription() {
        return description;
    }
}
