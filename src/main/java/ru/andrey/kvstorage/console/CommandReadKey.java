package ru.andrey.kvstorage.console;

import ru.andrey.kvstorage.exception.DatabaseException;
import ru.andrey.kvstorage.logic.Database;

import java.util.Optional;

public class CommandReadKey implements DatabaseCommand {
    private ExecutionEnvironment environment;
    private String databaseName;
    private String tableName;
    private String key;

    public CommandReadKey(ExecutionEnvironment env, String database, String tableName, String key) {
        this.environment = env;
        this.databaseName = database;
        this.tableName = tableName;
        this.key = key;
    }

    @Override
    public DatabaseCommandResult execute() throws DatabaseException {
        Optional<Database> database = this.environment.getDatabase(this.databaseName);
        if (database.isPresent()) {
            return DatabaseCommandResult.success(database.get().read(tableName, key));
        } else {
            return DatabaseCommandResult.error("Database" + databaseName + " doesn't exist");
        }
    }
}
