package ru.andrey.kvstorage.console;

import ru.andrey.kvstorage.exception.DatabaseException;
import ru.andrey.kvstorage.logic.Database;

import java.util.Optional;

public class CommandCreateTable implements DatabaseCommand {
    private ExecutionEnvironment environment;
    private String databaseName;
    private String tableName;

    public CommandCreateTable(ExecutionEnvironment env, String database, String tableName) {
        this.environment = env;
        this.databaseName = database;
        this.tableName = tableName;
    }

    @Override
    public DatabaseCommandResult execute() throws DatabaseException {
        Optional<Database> database = this.environment.getDatabase(this.databaseName);
        if (database.isPresent()) {
            database.get().createTableIfNotExists(tableName);
            return DatabaseCommandResult.success("Table " + tableName + " in database " +
                    database.get().getName() + " has been created successfully");
        } else {
            return DatabaseCommandResult.error("Database" + databaseName + " doesn't exist");
        }
    }
}
