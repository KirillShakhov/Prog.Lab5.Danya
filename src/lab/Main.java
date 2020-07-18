package lab;


import lab.commands.*;

class Main {
    public static void main(String[] args) {

        BD bd = null;
        if(args.length > 0) {
            bd = new BD(args[0]);
        }
        else {
            System.out.println("Имя файла не введено в аргумент командной строки");
        }
        Console user = new Console(bd);
        user.addCommand(new AddCommand(), new ClearCommand(), new CountGreaterThanBestAlbum(), new ExecuteScriptCommand(), new ExitCommand());
        user.addCommand(new FilterContainsNameCommand(), new HelpCommand(), new HistoryCommand(), new InfoCommand());
        user.addCommand(new RemoveAllByDescriptionCommand(), new RemoveByIdCommand(), new RemoveLowerCommand(), new ReorderCommand());
        user.addCommand(new SaveCommand(), new ShowCommand(), new UpdateCommand(), new TestCommand());
        user.start();
    }
}