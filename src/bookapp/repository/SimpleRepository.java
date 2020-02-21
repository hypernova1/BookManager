package bookapp.repository;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public abstract class SimpleRepository<T, ID extends Number> implements Repository<T, ID> {

    protected List<T> items;

    public SimpleRepository() {
        items = new ArrayList<>();
    }

    @Override
    public T save(T t) {
        for (T item : items) {
            System.out.println(equalsFieldValue("id", t, item));
            if (equalsFieldValue("id", t, item)) {
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
        for (T item : items) {
            if (!equalsFieldValue("id", t, item)) {
                return false;
            }
        }
        return items.remove(t);
    }

    @Override
    public T deleteById(ID id) {
        return items.remove(id.intValue());
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

    private Object getValueFromField(Field field, Object obj) {
        Class<?> clazz = obj.getClass();
        for (Method method : clazz.getMethods()) {
            String methodName = method.getName();
            if ((methodName.startsWith("get") && methodName.length() == field.getName().length() + 3)
                || (methodName.startsWith("is")) && methodName.length() == field.getName().length() + 2) {

                if (methodName.toLowerCase().endsWith(field.getName().toLowerCase())) {
                    try {
                        return method.invoke(obj);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return null;
    }

    private boolean equalsFieldValue(String fieldName, T t, T t2) {
        Class<?> vo = t2.getClass();
        Field field = null;
        try {
            field = vo.getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        String idStr = (String) getValueFromField(field, vo);
        for (T item : items) {
            Class<?> vo2 = item.getClass();
            String idStr2 = (String) getValueFromField(field, vo2);
            if (Objects.equals(idStr, idStr2)) {
                return true;
            }
        }
        return false;
    }
}
