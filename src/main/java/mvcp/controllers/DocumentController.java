package mvcp.controllers;

import mvcp.entities.Document;
import mvcp.enums.DocumentType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * Created by marcelo on 8/9/16.
 */
@RestController
@RequestMapping(value = "/documents")
public class DocumentController extends BaseController<Document> {

    @Override
    public void init() {
        super.init();
        System.out.println("Initializing document repository...");
        repository = new ArrayList<>();
        Document d = new Document();
        d.setId("1");
        d.setName("CPF");
        d.setContent("05619294404");
        d.setType(DocumentType.CPF);
        repository.add(d);


        Document d2 = new Document();
        d2.setId("2");
        d2.setName("RG");
        d2.setContent("6941722");
        d2.setType(DocumentType.RG);
        repository.add(d2);
        System.out.println("Done.");
    }

}
