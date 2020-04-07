package ru.andrey.kvstorage.console;

import ru.andrey.kvstorage.exception.DatabaseException;
import ru.andrey.kvstorage.logic.Database;

import java.util.Optional;

public class CommandCreateTable implements DatabaseCommand {
    private Optional<Database> database;
    private String tableName;

    public CommandCreateTable(Optional<Database> database, String tableName) {
        this.database = database;
        this.tableName = tableName;
    }

    @Override
    public DatabaseCommandResult execute() throws DatabaseException {
        database.get().createTableIfNotExists(tableName);
        return DatabaseCommandResult.success("Table " + tableName + " in database " +
                database.get().getName() + " has been created successfully");
    }
}
