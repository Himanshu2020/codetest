package model;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by G510 on 11-02-2019.
 */
@Document(collection = "todo")
public class Todo {

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    private String comments;

}
