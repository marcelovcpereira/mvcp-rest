package mvcp.controllers;

import mvcp.entities.BaseEntity;
import mvcp.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.reflect.ParameterizedType;
import java.util.Collection;

/**
 * Created by marcelo on 8/9/16.
 */
public class BaseController<E extends BaseEntity> {

    @Autowired
    protected BaseRepository<E> repository;


    @RequestMapping(method = RequestMethod.GET)
    public Collection<E> list() {
        return repository.list();
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
        if (this.repository != null) {
            E doc = repository.get(id);
            if (doc != null) {
                return ResponseEntity.ok().body(doc);
            }
        }
        return ResponseEntity.notFound().build();
    }


    /**
     * Método de recuperação da Collection correspondente
     *
     * @return
     */
    public Class<E> getGenericClass() {
        return (Class<E>) ((ParameterizedType)
                getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
}
