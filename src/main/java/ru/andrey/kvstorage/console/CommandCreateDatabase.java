package ru.andrey.kvstorage.console;

import ru.andrey.kvstorage.exception.DatabaseException;
import ru.andrey.kvstorage.logic.Database;

import java.util.Optional;

public class CommandCreateDatabase implements DatabaseCommand{
    private String databaseName;
    private ExecutionEnvironment env;

    public CommandCreateDatabase(ExecutionEnvironment env, String databaseName) {
        this.env = env;
        this.databaseName = databaseName;
    }

    @Override
    public DatabaseCommandResult execute() {
        if (env.getDatabase(databaseName) == null) {
            env.addDatabase(new Database() {
                @Override
                public String getName() {
                    return null;
                }

                @Override
                public void createTableIfNotExists(String tableName) throws DatabaseException {

                }

                @Override
                public void write(String tableName, String objectKey, String objectValue) throws DatabaseException {

                }

                @Override
                public String read(String tableName, String objectKey) throws DatabaseException {
                    return null;
                }
            });
            return DatabaseCommandResult.success("Database " + databaseName + " has been created successfully");
        } else {
            return DatabaseCommandResult.error("Database " + databaseName + "does exist already");
        }
    }
}
