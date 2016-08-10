package mvcp.controllers;

import mvcp.entities.Document;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by marcelo on 8/9/16.
 */
@RestController
@RequestMapping(value = "/documents")
public class DocumentController extends BaseController<Document> {
}
