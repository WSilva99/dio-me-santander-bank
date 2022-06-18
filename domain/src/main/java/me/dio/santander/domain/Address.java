package me.dio.santander.domain;

public class Address {

    private String street;

    private String number;
    private String city;
    private String state;
    private String zip;

    private Address(
            final String street,
            final String number,
            final String city,
            final String state,
            final String zip
    ) {

        this.street = street;
        this.number = number;
        this.city = city;
        this.state = state;
        this.zip = zip;

        this.validate();
    }

    public static Address of(
            final String street,
            final String number,
            final String city,
            final String state,
            final String zip
    ) {

        return new Address(street, number, city, state, zip);

    }

    public void validate() {

        if (street == null || street.isEmpty()) {
            throw new IllegalArgumentException("Street is required");
        }

        if (city == null || city.isEmpty()) {
            throw new IllegalArgumentException("City is required");
        }

        if (state == null || state.isEmpty()) {
            throw new IllegalArgumentException("State is required");
        }

        if (zip == null || zip.isEmpty()) {
            throw new IllegalArgumentException("Zip is required");
        }

    }

    public String toString() {
        return "%s %s, %s, %s, %s".formatted(street, number, city, state, zip);
    }

}
