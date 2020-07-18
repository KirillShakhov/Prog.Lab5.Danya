package lab.commands;
import lab.Console;

import java.util.ArrayList;

public class ShowCommand extends Command {
    {
        command_name = new String[]{"show"};
        description = "show - выводит в стандартный поток вывода все элементы коллекции в строковом представлении";
    }
    @Override
    void start_with_arguments(ArrayList<String> args, ArrayList<Character> flags) {
        Console.sendln("У данной команды нет аргументов.");
        start_without_arguments();
    }

    @Override
    void start_without_arguments() {
        //data.sort();
        if(data.size() != 0) {
            for (int i = 1; i <= data.size(); i++) {
                Console.sendln(data.get(i).toString());
            }
        }
        else{
            Console.sendln("Элементы отсутствуют");
        }
    }
}
