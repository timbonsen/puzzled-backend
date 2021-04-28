package bonsen.nl.puzzled.model.address;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(bonsen.nl.puzzled.model.address.AddressKey.class)
@Table(name = "addresses")
public class Address implements Serializable {

    @Id
    @Column(nullable = false)
    private String streetName;

    @Id
    @Column(nullable = false)
    private String houseNumber;

    @Id
    @Column(nullable = false)
    private String postalCode;

    @Column
    private String city;

    @Column
    private String country;

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
