package me.dio.santander.domain;

public class Email {

    private String value;

    private Email(String value) {
        this.value = value;
        this.validate();
    }

    public static Email of(String email) {
        return new Email(email);
    }

    public void validate() {

        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("Email is required");
        }

        final var regex = "[^@ \\t\\r\\n]+@[^@ \\t\\r\\n]+\\.[^@ \\t\\r\\n]+";

        if (!value.matches(regex)) {
            throw new IllegalArgumentException("Email is invalid");
        }

    }

    public String value() {
        return value;
    }

    public String toString() {
        return value;
    }

}
