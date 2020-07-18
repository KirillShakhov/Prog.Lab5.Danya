package lab.commands;
import lab.Console;

import java.util.ArrayList;

public class HistoryCommand extends Command {
    {
        command_name = new String[]{"history"};
        description = "history - выводит до 9 последних введенных команд.\n" +
                      "Флаги: n - включает нумерацию";
    }
    @Override
    void start_with_arguments(ArrayList<String> args, ArrayList<Character> flags) {
        if(flags.contains('n')){
            for(int i = 0; i < data.getHistory().size(); i++){
                if(!data.getHistory().get(i).equals("")) Console.sendln((i+1)+"-"+data.getHistory().get(i));
            }
        }
        else{
            for(String command : data.getHistory()){
                if(!command.equals("")) Console.sendln("--"+command);
            }
        }
    }

    @Override
    void start_without_arguments() {
        for(String command : data.getHistory()){
            if(!command.equals("")) Console.sendln("--"+command);
        }
    }
}
