package bonsen.nl.puzzled.model.user;

import bonsen.nl.puzzled.model.Authority;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(nullable = false, unique = true)
    private String username;

    @Column
    private String password;

/*    @Column(nullable = false)
    private boolean active = true;*/

    @Column
    private String apikey;

    @Column
    private String emailAddress;

    @OneToMany(
            targetEntity = bonsen.nl.puzzled.model.Authority.class,
            mappedBy = "username",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    private Set<bonsen.nl.puzzled.model.Authority> authorities = new HashSet<>();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

/*    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }*/

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Set<Authority> getAuthorities() { return authorities; }
    public void addAuthority(Authority authority) {
        this.authorities.add(authority);
    }
    public void removeAuthority(Authority authority) {
        this.authorities.remove(authority);
    }
}
