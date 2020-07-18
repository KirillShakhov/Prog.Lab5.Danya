package lab.commands;
import lab.Console;

import java.util.ArrayList;

public class ExitCommand extends Command {
    {
        command_name = new String[]{"exit"};
        description = "exit - выод без сохранения\n" +
                      "Флаги: s - выход с сохранением\n" +
                      "       f - выход без подтверждения";
    }
    @Override
    void start_with_arguments(ArrayList<String> args, ArrayList<Character> flags) {
        if(flags.contains('s')){
            if(data.save()){
                Console.sendln("Данные созранены");
            }
            else {
                Console.sendln("Данные не уалось сохранить");
            }
        }
        if(flags.contains('f')){
            System.exit(0);
        }
        else{
            start_without_arguments();
        }
    }

    @Override
    void start_without_arguments() {
        if(Console.getAnswer("Вы уверены, что хотите выйти без сохранения?")){
            System.exit(0);
        }
        else{
            if(Console.getAnswer("Вы хотите сохранить данные?")){
                data.save();
                if(Console.getAnswer("Данные сохранены, хотите выйти?")){
                    System.exit(0);
                }
            }
        }
    }
}
