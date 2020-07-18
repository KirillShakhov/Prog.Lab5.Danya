package lab.commands;
import lab.Console;

import java.util.ArrayList;

public class InfoCommand extends Command {
    {
        command_name = new String[]{"info"};
        description = "info - выводит информацию о коллекции.";
    }
    @Override
    void start_with_arguments(ArrayList<String> args, ArrayList<Character> flags) {
        Console.sendln("Коллекция типа: ArrayList\nДата инициализации: "+data.getCreateTime()+"\nКоличество элементов: "+data.size());
    }

    @Override
    void start_without_arguments() {
        Console.sendln("Коллекция типа: ArrayList\nДата инициализации: "+data.getCreateTime()+"\nКоличество элементов: "+data.size());
    }
}
