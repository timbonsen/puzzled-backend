package bonsen.nl.puzzled.model.image;

import javax.persistence.*;

import static java.util.UUID.randomUUID;

@Entity
@Table(name = "images")
public class Image {

    @Id
    @Column(nullable = false, unique = true)
    private String id = randomUUID().toString();

    @Column
    private String name;

    @Column
    private String type;

    @Lob
    private byte[] data;

    public Image() {}

    public Image(String name, String type, byte[] data) {
        this.name = name;
        this.type = type;
        this.data = data;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public byte[] getData() {
        return data;
    }
    public void setData(byte[] data) {
        this.data = data;
    }
}
