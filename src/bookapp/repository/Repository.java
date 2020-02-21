package bookapp.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface Repository<T, ID extends Serializable> {

    T save(T t);
    T update(T t);
    boolean delete(T t);
    T deleteById(ID id);
    List<T> findAll();
    Optional<T> findById(ID id);

}
