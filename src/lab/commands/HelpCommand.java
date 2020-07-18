package lab.commands;
import lab.Console;

import java.util.ArrayList;

public class HelpCommand extends Command {
    {
        command_name = new String[]{"help", "man"};
        description = "help - общяя информация о командах\n" +
                      "help command_name - информация о команде";
    }

    @Override
    void start_with_arguments(ArrayList<String> args, ArrayList<Character> flags) {
        if(!args.isEmpty()){
            for(String s : args){
                for(Command c : user.getCommands()){// getCommand возвращает String[] c именами команды.
                    for(String m : c.getCommand_name()){
                        if(s.equals(m)){
                            Console.sendln(c.getDescription());
                        }
                    }
                }
            }
        }
        else {
            Console.sendln("У этой команд нет флагов. Введите help");
        }
    }

    @Override
    void start_without_arguments() {
        Console.sendln("help : выводит справку о командах\n" +
                            "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)\n" +
                            "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n" +
                            "add {element} : добавить новый элемент в коллекцию.\n" +
                            "update id {element} : обновить значение элемента коллекции, id которого равен заданному\n" +
                            "remove_by_id id : удалить элемент из коллекции по его id\n" +
                            "clear : очистить коллекцию\n" +
                            "save : сохранить коллекцию в файл\n" +
                            "execute_script file_name : считать и исполнить скрипт из указанного файла. Можно указать несколько файлов через пробел.\n" +
                            "exit : завершить программу (без сохранения в файл)\n" +
                            "remove_lower {element} : удалить из коллекции все элементы, меньшие, чем заданный\n" +
                            "reorder : отсортировать коллекцию в порядке, обратном нынешнему\n" +
                            "history : вывести последние 9 команд (без их аргументов)\n" +
                            "remove_all_by_description description : удалить из коллекции все элементы, значения поле description которого эквивалентно заданному\n" +
                            "count_greater_than_best_album bestAlbum : вывести количество элементов, значение поля bestAlbum которых больше заданного\n" +
                            "filter_contains_name name : вывести элементы, значения поля name которых содержит заданную подстроку\n" +
                            "Если нужна более подробное описание команды и её флагов, введите: help название_команды\n" +
                            "Также вместо help можно писать man, в данном контексте они равноценны.");
    }
}
