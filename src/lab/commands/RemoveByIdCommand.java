package lab.commands;
import java.util.ArrayList;

public class RemoveByIdCommand extends Command {
    {
        command_name = new String[]{"remove_by_id"};
        description = "remove_by_id id - удалить элемент из коллекции по его id. Можно указать несколько id.\n" +
                      "Например: remove_by_id 1 2 3\n" +
                      "Тогда команда удалить элементы с 1, 2 и 3 ID";
    }
    @Override
    void start_with_arguments(ArrayList<String> args, ArrayList<Character> flags) {
        try {
            for (String arg : args) {
                data.remove(Integer.parseInt(arg));
            }
            System.out.println("Удаление успешно");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Элемента с таким ID нет в списке");
        }catch (Exception e) {
            System.out.println("Произошло что-то очень страшное.");
        }
    }

    @Override
    void start_without_arguments() {
        System.out.println("Введите команду с аргументом id. Например: remove_by_id 1");
    }
}
