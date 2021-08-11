package bakery.repositories;

import bakery.entities.tables.interfaces.Table;
import bakery.repositories.interfaces.TableRepository;

public class TableRepositoryImpl<Table> extends RepositoryImpl<Table> implements TableRepository<Table> {


    @Override
    public Table getByNumber(int number) {
        return null;
    }
}
