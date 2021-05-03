package bonsen.nl.puzzled.model;

import bonsen.nl.puzzled.model.address.Address;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AddressTest {
    private Address address;

    @BeforeEach
    void setUp() {
        this.address = new Address("Pandastraat", "19", "1234AB", "Pandastad", "Pandaland");
    }

    @Test
    void testGetId() {
        assertNotNull(this.address.getId());
    }

    @Test
    void testGetStreetname() {
        String expectedStreetName = "Pandastraat";
        String actualStreetName = this.address.getStreetName();
        assertEquals(expectedStreetName, actualStreetName);
    }

    @Test
    void testGetHouseNumber() {
        String expectedHouseNumber = "19";
        String actualHouseNumber = this.address.getHouseNumber();
        assertEquals(expectedHouseNumber, actualHouseNumber);
    }

    @Test
    void testGetPostalCode() {
        String expectedPostalCode = "1234AB";
        String actualPostalCode = this.address.getPostalCode();
        assertEquals(expectedPostalCode, actualPostalCode);
    }

    @Test
    void testGetCity() {
        String expectedCity = "Pandastad";
        String actualCity = this.address.getCity();
        assertEquals(expectedCity, actualCity);
    }

    @Test
    void testGetCountry() {
        String expectedCountry = "Pandaland";
        String actualCountry = this.address.getCountry();
        assertEquals(expectedCountry, actualCountry);
    }

    @Test
    void testSetStreetName() {
        String expectedStreetName = "Berenlaan";
        this.address.setStreetName("Berenlaan");
        String actualStreetName = this.address.getStreetName();
        assertEquals(expectedStreetName, actualStreetName);
    }

    @Test
    void testSetHouseNumber() {
        String expectedHouseNumber = "420";
        this.address.setHouseNumber("420");
        String actualHouseNumber = this.address.getHouseNumber();
        assertEquals(expectedHouseNumber, actualHouseNumber);
    }

    @Test
    void testSetPostalCode() {
        String expectedPostalCode = "4567YZ";
        this.address.setPostalCode("4567YZ");
        String actualPostalCode = this.address.getPostalCode();
        assertEquals(expectedPostalCode, actualPostalCode);
    }

    @Test
    void testSetCity() {
        String expectedCity = "Berenstad";
        this.address.setCity("Berenstad");
        String actualCity = this.address.getCity();
        assertEquals(expectedCity, actualCity);
    }

    @Test
    void testSetCountry() {
        String expectedCountry = "Berenland";
        this.address.setCountry("Berenland");
        String actualCountry = this.address.getCountry();
        assertEquals(expectedCountry, actualCountry);
    }
}
