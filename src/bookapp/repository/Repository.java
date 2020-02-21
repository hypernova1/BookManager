package bookapp.repository;

import java.util.List;
import java.util.Optional;

public interface Repository<T, ID> {

    T save(T t);
    T update(T t);
    boolean delete(T t);
    boolean deleteById(ID id);
    List<T> findAll();
    Optional<T> findById(ID id);

}
