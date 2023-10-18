package domain.command;

public interface Command<T> {
    T execute();
}
