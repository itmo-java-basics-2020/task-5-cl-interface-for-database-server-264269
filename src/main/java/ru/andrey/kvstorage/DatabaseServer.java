package ru.andrey.kvstorage;

import ru.andrey.kvstorage.console.*;
import ru.andrey.kvstorage.exception.DatabaseException;
import ru.andrey.kvstorage.logic.Database;

import java.io.Console;

public class DatabaseServer {

    private final ExecutionEnvironment env;

    public DatabaseServer(ExecutionEnvironment env) {
        this.env = env;
    }

    public static void main(String[] args) {    }

    DatabaseCommandResult executeNextCommand(String commandText) {
        try {
            String[] commandParameters = commandText.split(" ");
            return DatabaseCommands.
                    valueOf(commandParameters[0]).
                    getCommand(this.env, commandParameters).
                    execute();
        } catch (Exception e) {
            return DatabaseCommandResult.error(e.getMessage());
        }
    }
}
