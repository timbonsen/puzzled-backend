package bonsen.nl.puzzled.model.address;

import javax.persistence.*;
import java.util.UUID;

import static java.util.UUID.randomUUID;

@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @Column(nullable = false)
    private UUID id = randomUUID();

    @Column(nullable = false)
    private String streetName;

    @Column(nullable = false)
    private String houseNumber;

    @Column(nullable = false)
    private String postalCode;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String country;

    public Address(String streetName, String houseNumber, String postalCode, String city, String country) {
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.postalCode = postalCode;
        this.city = city;
        this.country = country;
    }

    public UUID getId() {
        return id;
    }

    public String getStreetName() {
        return streetName;
    }
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getHouseNumber() {
        return houseNumber;
    }
    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
}
