package mvcp.entities;

import mvcp.enums.DocumentType;

/**
 * Created by marcelo on 8/9/16.
 */
public class Document extends BaseEntity {

    private String name;
    private String content;
    private DocumentType type;

    public Document() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public DocumentType getType() {
        return type;
    }

    public void setType(DocumentType type) {
        this.type = type;
    }
}
