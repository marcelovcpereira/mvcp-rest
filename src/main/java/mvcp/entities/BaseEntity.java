package mvcp.entities;

import java.util.UUID;

/**
 * Created by marcelo on 8/9/16.
 */
public class BaseEntity {

    private String id;

    public BaseEntity() {
        this.id = generateRandomId();
    }

    private static String generateRandomId() {
        return String.valueOf(UUID.randomUUID());
    }

    public BaseEntity(String id) {
        this.id = id;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
