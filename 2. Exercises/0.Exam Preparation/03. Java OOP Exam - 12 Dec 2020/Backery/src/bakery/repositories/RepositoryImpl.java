package bakery.repositories;

import bakery.repositories.interfaces.Repository;

import java.util.Collection;

public abstract class RepositoryImpl<T> implements Repository<T> {

    private Collection<T> models;

    protected RepositoryImpl() {

    }

    @Override
    public Collection<T> getAll() {
        return null;
    }

    @Override
    public void add(T t) {

    }
}
