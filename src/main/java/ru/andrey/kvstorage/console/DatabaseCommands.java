package ru.andrey.kvstorage.console;

import ru.andrey.kvstorage.logic.Database;

import java.util.InputMismatchException;

public enum DatabaseCommands implements DatabaseCommandIdentifier{
    CREATE_DATABASE{
        @Override
        public DatabaseCommand getCommand(ExecutionEnvironment env, String[] args) throws Exception {
            if (args.length == 2) {
                return new CommandCreateDatabase(env, args[1]);
            } else {
                throw new Exception("Wrong number of arguments");
            }
        }
    }, CREATE_TABLE {
        @Override
        public DatabaseCommand getCommand(ExecutionEnvironment env, String[] args) throws Exception {
            if (args.length == 3) {
                return new CommandCreateTable(env, args[1], args[2]);
            } else {
                throw new Exception("Wrong number of arguments");
            }
        }
    }, UPDATE_KEY {
        @Override
        public DatabaseCommand getCommand(ExecutionEnvironment env, String[] args) throws Exception {
            if (args.length == 5) {
                return new CommandUpdateKey(env, args[1], args[2], args[3], args[4]);
            } else {
                throw new Exception("Wrong number of arguments");
            }
        }
    }, READ_KEY {
        @Override
        public DatabaseCommand getCommand(ExecutionEnvironment env, String[] args) throws Exception {
            if (args.length == 4) {
                return new CommandReadKey(env, args[1], args[2], args[3]);
            } else {
                throw new Exception("Wrong number of arguments");
            }
        }
    }
}
