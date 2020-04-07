package ru.andrey.kvstorage.console;

import ru.andrey.kvstorage.exception.DatabaseException;
import ru.andrey.kvstorage.logic.Database;

import java.util.Optional;

public class CommandUpdateKey implements DatabaseCommand {
    private Optional<Database> database;
    private String tableName;
    private String key;
    private String value;

    public CommandUpdateKey(Optional<Database> database, String tableName, String key, String value) {
        this.database = database;
        this.tableName = tableName;
        this.key = key;
        this.value = value;
    }

    @Override
    public DatabaseCommandResult execute() throws DatabaseException {
        database.get().write(tableName, key, value);
        return DatabaseCommandResult.success("Key " + key +
                " in table " + tableName + "has been updated. Value: " + value);
    }
}
