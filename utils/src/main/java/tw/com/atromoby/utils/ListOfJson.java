package tw.com.atromoby.utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import androidx.annotation.NonNull;


public class ListOfJson<T> implements ParameterizedType
{
    private Class<?> wrapped;

    ListOfJson(Class<T> wrapper)
    {
        this.wrapped = wrapper;
    }

    @NonNull
    @Override
    public Type[] getActualTypeArguments()
    {
        return new Type[] { wrapped };
    }

    @NonNull
    @Override
    public Type getRawType()
    {
        return List.class;
    }

    @Override
    public Type getOwnerType()
    {
        return null;
    }
}
