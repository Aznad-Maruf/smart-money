package hood.robin.smartmoney.service;

import hood.robin.smartmoney.entity.BaseEntity;
import java.util.List;
import java.util.UUID;

public interface BaseService<T extends BaseEntity> {

    T save(T entity);

    T update(T entity);

    List<T> findAll();

    T find(UUID uuid);

    T delete(T entity);
}
