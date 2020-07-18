package lab.commands;
import lab.Console;

import java.util.ArrayList;

public class RemoveAllByDescriptionCommand extends Command {
    {
        command_name = new String[]{"remove_all_by_description"};
        description = "remove_all_by_description описание - удаляет все элементы с таким же описанием.";
    }
    @Override
    void start_with_arguments(ArrayList<String> args, ArrayList<Character> flags) {
        StringBuilder des = new StringBuilder();
        for(int i = 1; i < args.size(); i++){
            des.append(args.get(i));
        }
        int j = 0;
        for(int i = 1; i <= data.size(); i++){
            if(data.get(i).getDescription().equals(des.toString())){
                data.remove(i);
                j++;
            }
        }
        if(j == 0){Console.sendln("Таких элементов нет");}
        else{Console.sendln("Удалено "+j+" объектов");}
    }

    @Override
    void start_without_arguments() {
        Console.sendln("У команды должен быть аргумент description. Пример: remove_all_by_description описание");
    }
}
