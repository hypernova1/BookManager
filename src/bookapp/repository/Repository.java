package bookapp.repository;

import java.util.List;

public interface Repository<T> {

    void save(T t);
    boolean update(T t);
    boolean delete(Long id);
    List<T> findAll();

}
