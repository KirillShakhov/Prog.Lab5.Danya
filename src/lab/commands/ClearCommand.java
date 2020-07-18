package lab.commands;
import lab.Console;

import java.util.ArrayList;

public class ClearCommand extends Command {
    {
        command_name = new String[]{"clear"};
        description = "clear - очищает коллекцию." +
                      "Флаги: f - сделать все действия без подтверждения" +
                      "       s - сохранить коллекцию после очистки";
    }
    @Override
    void start_with_arguments(ArrayList<String> args, ArrayList<Character> flags) {
        if(flags.contains('f')) {
            if(flags.contains('s')){
                if (data.clean()) {
                    Console.sendln("Колекция очищена");
                    if (data.save()) {
                        Console.sendln("Колекция сохранена");
                    }
                    else{
                        Console.sendln("Колекция не сохранена");
                    }
                } else {
                    throw new RuntimeException("Коллекция не очищается");
                }
            }
            else {
                if (data.clean()) {
                    Console.sendln("Колекция очищена");
                    Console.sendln("Не забудте сохранить изменения с помощью команды save");
                } else {
                    throw new RuntimeException("Коллекция не очищается");
                }
            }
        }

        else{
            start_without_arguments();
        }
    }

    @Override
    void start_without_arguments() {
        if (Console.getAnswer("Уверены, что хотите очистить коллекцию?")) {
            if(data.clean()){
                Console.sendln("Колекция очищена");
                Console.sendln("Не забудте сохранить изменения с помощью команды save");
            }
            else{
                throw new RuntimeException("Коллекция не очищается");
            }
        }
        else{
            Console.sendln("Задача отклонена.");
        }
    }
}
