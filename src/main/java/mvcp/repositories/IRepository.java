package mvcp.repositories;

import mvcp.entities.BaseEntity;

import java.util.Collection;

/**
 * Created by marcelo on 8/10/16.
 */
public interface IRepository<E extends BaseEntity> {
    E get(String id) throws Exception;
    Collection<E> list();
    void add(E entity);
}
