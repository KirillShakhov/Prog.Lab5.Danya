package lab.commands;
import lab.Console;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ExecuteScriptCommand extends Command {
    {
        command_name = new String[]{"execute_script"};
        description = "execute_script file - выполняет построчно файл с защитой от рекурсии";
                    //не используется из-за возможной рекурси  "execute_script file1 file2 file3 и тд. - выполняет построчно файлы с защитой от рекурсии";
    }

    @Override
    void start_with_arguments(ArrayList<String> args, ArrayList<Character> flags) {
        if (args.isEmpty()) {
            start_without_arguments();
        } else {
            try {
                String[] lines = Console.readFile(args.get(0)).split("\\r?\\n");
                user.addLevel_list("execute_script " + args.get(0));
                for(String line : lines) {
                    if(!user.check_list(line)) {
                        Console.sendln(">" + line);
                        user.update(line);
                    }
                    else{
                        Console.sendln("Файл вызывает сам себя");
                    }
                }
                user.remove_list();

            }
            catch (FileNotFoundException e) {
                Console.sendln("Файл отсутствует или нет прав на чтение.");
            } catch (Exception e) {
                //TODO подобных страшных сообщений не должно быть
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    void start_without_arguments() {
        Console.sendln(getDescription());
    }
}
