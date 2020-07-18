package lab.commands;
import lab.BD;
import lab.Console;
import java.util.ArrayList;

/**
 * Класс от которого наследуються все команды и в котором заложен основной функционал команд. Нужен при создании новых команд.
 * @autor Шахов Кирилл Андреевич P3132
 * @version 1.1
 */
public abstract class Command implements ICommand {
    /** Поле в котором храниться база данных */
    protected BD data;
    protected Console user;
    protected String[] command_name = {"command_test"};
    protected String origin_line;
    protected String description = "Описания нет";


    /** Конструктор команды*/
    Command() {}

    /** Метод, который будет выполняться, если команда введена с аргументами.
     *
     * @param args ArrayList<String> аргументы
     * @param flags ArrayList<Character> флаги
     */
    abstract void start_with_arguments(ArrayList<String> args, ArrayList<Character> flags);

    /** Метод, который будет выполняться, если команда введена без аргументов. */
    abstract void start_without_arguments();

    public void initialization(BD bd, Console user){
        this.data = bd;
        this.user = user;
    }

    /** Метод, который запускает команду
     *
     * @param line String - кракозыбры пользователя
     * @return boolean выполнилась ли команда
     */
    public boolean execute(String line) {
        line = line.trim();
        origin_line = line;
        for(String cname : command_name) {
            if (line.indexOf(cname) == 0) {
                data.log(cname);
                if (line.equals(cname)) {
                    start_without_arguments();
                } else {
                    char[] temp = line.toCharArray();
                    ArrayList<String> args = new ArrayList<>();
                    ArrayList<Character> flags = new ArrayList<>();
                    ArrayList<Character> tmp = new ArrayList<>();
                    StringBuilder b = new StringBuilder();
                    // Старый парсер без экронирования
                    //tmp.remove(0);
                    /*
                    boolean is = false;
                    for (String s : tmp) {
                        if (s.indexOf('-') == 0 && !is) {
                            char[] fl = s.toCharArray();
                            for (char c : fl) {
                                flags.add(c);
                            }
                        } else {
                            is = true;
                            args.add(s);
                        }
                    }
                    for (int i = 0; i < flags.size(); i++) {
                        if (flags.get(i) == '-') {
                            flags.remove(i);
                        }
                    }
                     */
                    int mod = 1;
                    boolean isString = false;

                    for (char c : temp){
                        switch (mod) {
                            case 1:
                                if(c == ' '){
                                    mod = 2;
                                }
                                break;
                            case 2:
                                if(isString){
                                    if(c == ' '){
                                        isString = false;
                                        mod = 3;
                                    }
                                    else{
                                        flags.add(c);
                                    }
                                }
                                else {
                                    if (c == '-') {
                                        isString = true;
                                    }
                                    else{
                                        mod = 4;
                                        tmp.add(c);
                                    }
                                }
                                break;
                            case 3:
                                if(c == '-'){
                                    mod = 2;
                                    isString = true;
                                }
                                else{
                                    mod = 4;
                                    tmp.add(c);
                                }
                                break;
                            case 4:
                                tmp.add(c);
                                break;
                        }
                    }
                    tmp.add(' ');
                    isString = false;
                    for(Character c : tmp){
                        if(isString) {
                            if (c == '"') {
                                isString = false;
                            } else {
                                b.append(c);
                            }
                        }
                        else{
                            if (c == '"') {
                                isString = true;
                            }
                            else if(c == ' '){
                                args.add(b.toString());
                                b = new StringBuilder();
                            }
                            else{
                                b.append(c);
                            }
                        }
                    }
                    start_with_arguments(args, flags);
                }
                return true;
            }
        }
        return false;
    }

    public String[] getCommand_name() {
        return command_name;
    }

    public String getDescription() {
        return description;
    }
}
