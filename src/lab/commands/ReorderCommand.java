package lab.commands;
import lab.Console;

import java.util.ArrayList;

public class ReorderCommand extends Command {
    private boolean reverse = false;
    {
        command_name = new String[]{"reorder"};
        description = "reorder - отсортировать коллекцию в порядке, обратном нынешнему\n" +
                      "Флаги: n - отсортировать по возрастанию\n" +
                      "       r - отсортировать по убыванию";
    }
    @Override
    void start_with_arguments(ArrayList<String> args, ArrayList<Character> flags) {
        if(flags.contains('r')) {
            data.sort(true);
            Console.sendln("Коллекция отсортирована по убыванию");
        }
        else if(flags.contains('n')){
            data.sort(false);
            Console.sendln("Коллекция отсортирована по возрастанию");
        }
        else{
            Console.sendln("Команда введена неправильно. Введите: help reorder");
        }
    }

    @Override
    void start_without_arguments() {
        reverse = !reverse;
        data.sort(reverse);
        Console.sendln("Коллекция отсортирована");
    }
}
