package bonsen.nl.puzzled.model.address;

import bonsen.nl.puzzled.exceptions.EmptyFieldException;

import java.util.UUID;

public class AddressBuilder {

    private UUID id;
    private String streetName;
    private String houseNumber;
    private String postalCode;
    private String city;
    private String country;

    public AddressBuilder() {

    }

    public AddressBuilder withStreetName(String streetName) {
        this.streetName = streetName;
        return this;
    }
    public AddressBuilder withHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
        return this;
    }
    public AddressBuilder withPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }
    public AddressBuilder withCity(String city) {
        this.city = city;
        return this;
    }
    public AddressBuilder withCountry(String country) {
        this.country = country;
        return this;
    }

    public Address build() {
        if (streetName.equals("")) {
            throw new EmptyFieldException();
        } else if (houseNumber.equals("")) {
            throw new EmptyFieldException();
        } else if (postalCode.equals("")) {
            throw new EmptyFieldException();
        } else if (city.equals("")) {
            throw new EmptyFieldException();
        } else if (country.equals("")) {
            throw new EmptyFieldException();
        }
        return new Address(streetName, houseNumber, postalCode, city, country);
    }
}
