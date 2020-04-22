package ru.andrey.kvstorage.console;

import ru.andrey.kvstorage.exception.DatabaseException;
import ru.andrey.kvstorage.logic.Database;

import java.util.Optional;

public class CommandUpdateKey implements DatabaseCommand {
    private ExecutionEnvironment environment;
    private String databaseName;
    private String tableName;
    private String key;
    private String value;

    public CommandUpdateKey(ExecutionEnvironment env, String database,
                            String tableName, String key, String value) {
        this.environment = env;
        this.databaseName = database;
        this.tableName = tableName;
        this.key = key;
        this.value = value;
    }

    @Override
    public DatabaseCommandResult execute() throws DatabaseException {
        Optional<Database> database = this.environment.getDatabase(this.databaseName);
        if (database.isPresent()) {
            database.get().write(tableName, key, value);
            return DatabaseCommandResult.success("Key " + key +
                    " in table " + tableName + "has been updated. Value: " + value);
        } else {
            return DatabaseCommandResult.error("Database" + databaseName + " doesn't exist");
        }

    }
}
