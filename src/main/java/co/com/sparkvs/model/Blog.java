package co.com.sparkvs.model;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity
public class Blog {

    @Id
    private ObjectId id;
    private Long idBlog;
    private String title;
    private String description;
    private String oth;

    public Blog() {
    }

    public Blog(Long idBlog, String title, String description, String oth) {
        this.idBlog = idBlog;
        this.title = title;
        this.description = description;
        this.oth = oth;

    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }
}
