package ru.andrey.kvstorage.console;

import ru.andrey.kvstorage.exception.DatabaseException;
import ru.andrey.kvstorage.logic.Database;

import java.util.Optional;

public class CommandReadKey implements DatabaseCommand {
    private Optional<Database> database;
    private String tableName;
    private String key;

    public CommandReadKey(Optional<Database> database, String tableName, String key) {
        this.database = database;
        this.tableName = tableName;
        this.key = key;
    }

    @Override
    public DatabaseCommandResult execute() throws DatabaseException {
        return DatabaseCommandResult.success(database.get().read(tableName, key));
    }
}
