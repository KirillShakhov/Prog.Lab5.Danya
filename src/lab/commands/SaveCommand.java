package lab.commands;
import lab.Console;

import java.util.ArrayList;

public class SaveCommand extends Command {
    {
        command_name = new String[]{"save"};
        description = "save - просто сохраняет коллекцию в файл.\n" +
                      "Флаги: тут нет флага, который меняет расположения файла, иначе можно будет делать бэкапы.\n" +
                      "Долой бэкапы, только хардкор.";
    }
    @Override
    void start_with_arguments(ArrayList<String> args, ArrayList<Character> flags) {
        start_without_arguments();
    }

    @Override
    void start_without_arguments() {
        if (data.save()) {
            Console.sendln("Сохранение успешно.");
        } else {
            Console.sendln("Произошла ошибка при сохранении файла");
            Console.sendln("Попробуйте использовать команду save file, где файл это название файла в который сохраняться данные. Например: save data1.json");
        }
    }
}
