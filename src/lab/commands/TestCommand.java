package lab.commands;

import java.util.ArrayList;

public class TestCommand extends Command {
    {
        command_name = new String[]{"test"};
    }


    @Override
    void start_with_arguments(ArrayList<String> args, ArrayList<Character> flags) {
        System.out.println(args);
        System.out.println(flags);
    }

    @Override
    void start_without_arguments() {
        user.update("execute_script a");
        user.update("add -j {name:\"Twenty One Pilots\", coordinates:[x: 38 ,y:97.0], numberOfParticipants:2, description:\"американский дуэт из Колумбуса, штат Огайо. Группа образовалась в 2009 году и на данный момент состоит из Тайлера Джозефа и Джоша Дана.\", establishmentDate:2009-12-29 12:30, genre:POP, bestAlbum:[name:\"Trench\", tracks:14, length:3364, sales:1079000]}\n");
        user.update("show");
        user.update("reorder");
        user.update("clear -fs");
        user.update("save");
        user.update("save 1");
        user.update("srh2 o3w6 ");
        user.update("info f");

    }
}
