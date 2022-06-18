package me.dio.santander.domain;

public class Email {

    private String email;

    private Email(String email) {
        this.email = email;
        this.validate();
    }

    public static Email of(String email) {
        return new Email(email);
    }

    public void validate() {

        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email is required");
        }

        final var regex = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";

        if (!email.matches(regex)) {
            throw new IllegalArgumentException("Email is invalid");
        }

    }

    public String email() {
        return email;
    }

}
