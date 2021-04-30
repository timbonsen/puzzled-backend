package bonsen.nl.puzzled.model.user;

import bonsen.nl.puzzled.exceptions.EmptyFieldException;
import bonsen.nl.puzzled.model.address.Address;

public class UserBuilder {

    private String username;
    private String password;
    private String emailAddress;
    private String firstName;
    private String lastName;
    private Address address;

    public UserBuilder() {
    }

    public UserBuilder withUsername(String username) {
        this.username = username;
        return this;
    }
    public UserBuilder withPassword(String password) {
        this.password = password;
        return this;
    }
    public UserBuilder withEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }
    public UserBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }
    public UserBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
    public UserBuilder withAddress(Address address) {
        this.address = address;
        return this;
    }

    public User build() {
        if (username.equals("")) {
            throw new EmptyFieldException();
        } else if (password.equals("")) {
            throw new EmptyFieldException();
        } else if (emailAddress.equals("")) {
            throw new EmptyFieldException();
        }
        return new User(username, password, emailAddress, firstName, lastName, address);
    }
}
