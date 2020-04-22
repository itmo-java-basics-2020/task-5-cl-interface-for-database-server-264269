package ru.andrey.kvstorage.console;

import java.util.Optional;

public interface DatabaseCommandResult {
    Optional<String> getResult();

    DatabaseCommandStatus getStatus();

    boolean isSuccess();

    String getErrorMessage();

    enum DatabaseCommandStatus {
        SUCCESS, FAILED
    }

    static DatabaseCommandResult success(String result) {
        return new ConcreteResult(result, DatabaseCommandStatus.SUCCESS, null);
    }

    static DatabaseCommandResult error(String message) {
        return new ConcreteResult(null, DatabaseCommandStatus.FAILED, message);
    }

    class ConcreteResult implements DatabaseCommandResult {

        private final String result;
        private final DatabaseCommandStatus status;
        private final String message;

        private ConcreteResult(String result, DatabaseCommandStatus status, String message) {
            this.result = result;
            this.status = status;
            this.message = message;
        }

        @Override
        public Optional<String> getResult() {
            return Optional.ofNullable(result);
        }

        @Override
        public DatabaseCommandStatus getStatus() {
            return status;
        }

        @Override
        public boolean isSuccess() {
            return status.equals(DatabaseCommandStatus.SUCCESS);
        }

        @Override
        public String getErrorMessage() {
            return message;
        }
    }

    /*static DatabaseCommandResult success(String message) {
        return new DatabaseCommandResult() {
            @Override
            public Optional<String> getResult() {
                return Optional.of(message);
            }

            @Override
            public DatabaseCommandStatus getStatus() {
                return DatabaseCommandStatus.SUCCESS;
            }

            @Override
            public boolean isSuccess() {
                return true;
            }

            @Override
            public String getErrorMessage() {
                return null;
            }
        };
    }*/

    /*static DatabaseCommandResult error(String message) {
        return new DatabaseCommandResult() {
            @Override
            public Optional<String> getResult() {
                return Optional.empty();
            }

            @Override
            public DatabaseCommandStatus getStatus() {
                return DatabaseCommandStatus.FAILED;
            }

            @Override
            public boolean isSuccess() {
                return false;
            }

            @Override
            public String getErrorMessage() {
                return message;
            }
        };
    }*/
}