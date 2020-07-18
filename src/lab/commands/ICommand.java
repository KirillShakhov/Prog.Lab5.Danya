package lab.commands;

import lab.BD;
import lab.Console;

public interface ICommand {
    void initialization(BD bd, Console user);
    boolean execute(String line);
}
