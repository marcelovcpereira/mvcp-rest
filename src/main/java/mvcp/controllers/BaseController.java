package mvcp.controllers;

import mvcp.entities.BaseEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by marcelo on 8/9/16.
 */
public class BaseController<E extends BaseEntity> {


    protected List<E> repository;

    @PostConstruct
    public void init() {
        repository = new ArrayList<>();
        repository.add((E) new BaseEntity());
        repository.add((E) new BaseEntity());
    }


    @RequestMapping(method = RequestMethod.GET)
    public Collection<E> list() {
        return repository;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody E entity) {
        if (entity != null) {
            this.repository.add(entity);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    private ResponseEntity get(@PathVariable("id") String id) throws Exception {
        if (this.repository != null && this.repository.size() > 0) {
            E doc = repository.stream()
                    .filter(t -> t.getId().equalsIgnoreCase(id))
                    .findFirst()
                    .orElseThrow(() -> new Exception(getGenericClass().getSimpleName() + " not found"));
            return ResponseEntity.ok().body(doc);
        }
        return ResponseEntity.notFound().build();
    }


    /**
     * Método de recuperação da Collection correspondente
     * @return
     */
    public Class<E> getGenericClass() {
        return (Class<E>) ((ParameterizedType)
                getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
}
