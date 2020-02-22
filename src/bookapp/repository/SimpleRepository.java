package bookapp.repository;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

public abstract class SimpleRepository<T, ID extends Number> implements Repository<T, ID> {

    protected List<T> items;

    public SimpleRepository() {
        items = new ArrayList<>();
    }

    @Override
    public T save(T t) {
        if (items.size() == 0) {
            items.add(t);
            return t;
        }
        for (T item: items) {
            if (getValueFromField(item, "id") == getValueFromField(t, "id")) {
                return null;
            }
        }
        items.add(t);
        return t;
    }

    @Override
    public T update(T t) {
        return null;
    }

    @Override
    public boolean delete(T t) {
        if (items.size() == 0) return false;
        return items.remove(t);
    }

    @Override
    public boolean deleteById(ID id) {
        T t = items.remove(id.intValue());
        return t != null;
    }

    @Override
    public List<T> findAll() {
        return this.items;
    }

    @Override
    public Optional<T> findById(ID id) {
        T t = items.get(id.intValue());
        return Optional.of(t);
    }

    private Object getValueFromField(T t, String fieldName) {
        Class<?> clazz = t.getClass();
        Field field = null;
        try {
            field = clazz.getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        for (Method method : clazz.getMethods()) {
            String methodName = method.getName();
            if ((methodName.startsWith("get") && methodName.length() == field.getName().length() + 3)
                || (methodName.startsWith("is")) && methodName.length() == field.getName().length() + 2) {

                if (methodName.toLowerCase().endsWith(field.getName().toLowerCase())) {
                    try {
                        return method.invoke(t);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return null;
    }
}
