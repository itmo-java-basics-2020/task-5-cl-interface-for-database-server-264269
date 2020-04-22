package ru.andrey.kvstorage.console;

public interface DatabaseCommandIdentifier {
    DatabaseCommand getCommand(ExecutionEnvironment env, String[] args) throws Exception;
}
