package bakery.repositories;

import bakery.entities.tables.BaseTable;
import bakery.entities.tables.interfaces.Table;
import bakery.repositories.interfaces.TableRepository;

import java.util.Collection;

public class TableRepositoryImpl<BaseTable> extends RepositoryImpl<Table> implements TableRepository<Table> {


    @Override
    public Table getByNumber(int number) {
        return getAll().stream()
                .filter(e -> e.getTableNumber() == number)
                .findFirst()
                .orElse(null);
    }
}
