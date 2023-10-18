package entities.button;

import domain.command.Command;

public class MoveRequestButton implements Button<Boolean> {
    private Command<Boolean> command;

    public MoveRequestButton(Command<Boolean> command) {
        this.command = command;
    }

    @Override
    public Boolean pressed() {
        return command.execute();
    }
}
