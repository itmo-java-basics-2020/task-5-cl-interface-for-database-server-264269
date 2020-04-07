package ru.andrey.kvstorage.console;

import ru.andrey.kvstorage.logic.Database;

import java.util.InputMismatchException;

public enum DatabaseCommands implements DatabaseCommandIdentifier{
    CREATE_DATABASE{
        @Override
        public DatabaseCommand getCommand(ExecutionEnvironment env, String[] args) {
            return new CommandCreateDatabase(env, args[1]);
        }
    }, CREATE_TABLE {
        @Override
        public DatabaseCommand getCommand(ExecutionEnvironment env, String[] args) {
            return new CommandCreateTable(env.getDatabase(args[1]), args[2]);
        }
    }, UPDATE_KEY {
        @Override
        public DatabaseCommand getCommand(ExecutionEnvironment env, String[] args) {
            return new CommandUpdateKey(env.getDatabase(args[1]), args[2], args[3], args[4]);
        }
    }, READ_KEY {
        @Override
        public DatabaseCommand getCommand(ExecutionEnvironment env, String[] args) {
            return new CommandReadKey(env.getDatabase(args[1]), args[2], args[3]);
        }
    }
}
