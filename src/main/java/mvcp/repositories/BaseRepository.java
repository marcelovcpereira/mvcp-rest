package mvcp.repositories;

import mvcp.entities.BaseEntity;
import mvcp.entities.Document;
import mvcp.enums.DocumentType;

import javax.annotation.PostConstruct;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author marcelo
 * @since 8/9/16.
 */
public class BaseRepository<E extends BaseEntity> implements IRepository<E> {

    protected List<E> repository;

    @PostConstruct
    public void init() {
        repository = new ArrayList<>();
    }


    public E get(String id) throws Exception {
        if (this.repository != null && this.repository.size() > 0) {
            E doc = repository.stream()
                    .filter(t -> t.getId().equalsIgnoreCase(id))
                    .findFirst()
                    .orElseThrow(() -> new Exception(getGenericClass().getSimpleName() + " not found"));
            return doc;
        }
        return null;
    }


    @Override
    public Collection<E> list() {
        return repository;
    }

    @Override
    public void add(E entity) {
        this.repository.add((E) entity);
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
