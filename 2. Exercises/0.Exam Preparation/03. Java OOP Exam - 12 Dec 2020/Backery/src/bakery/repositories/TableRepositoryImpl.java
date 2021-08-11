package bakery.repositories;

import bakery.entities.tables.interfaces.Table;
import bakery.repositories.interfaces.TableRepository;

public class TableRepositoryImpl extends RepositoryImpl<Table> implements TableRepository<Table> {
    public TableRepositoryImpl() {
        super();
    }

    @Override
    public Table getByNumber(int number) {
        return null;
    }
}
