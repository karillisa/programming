package command;

import classes.SpaceMarine;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeSet;

public class CommandManager {
    public Map<String, Command> listOfCommands;

    public CommandManager(){
        listOfCommands = new LinkedHashMap<>();
        listOfCommands.put("help", new HelpCommand("help"));
        listOfCommands.put("info", new InfoCommand("info"));
        listOfCommands.put("show", new ShowCommand("show"));
        listOfCommands.put("clear", new ClearCommand("clear"));
        listOfCommands.put("save", new SaveCommand("save"));
        listOfCommands.put("remove_by_id", new RemoveIdCommand("remove_by_id"));
        listOfCommands.put("filter_starts_with_name", new FilterStartsWithNameCommand("filter_starts_with_name"));
        listOfCommands.put("print_field_ascending_health", new PrintFieldAscendingHealthCommand("print_field_ascending_health"));
        listOfCommands.put("add", new AddCommand("add"));
        listOfCommands.put("update", new UpdateByIdCommand("update"));
        listOfCommands.put("count_greater_than_chapter", new CountGreaterThanChapterCommand("count_greater_than_chapter"));
        listOfCommands.put("remove_greater", new RemoveGreaterCommand("remove_greater"));
        listOfCommands.put("remove_lower", new RemoveLowerCommand("remove_lower"));
        listOfCommands.put("execute_script", new ExecuteScriptCommand("execute_script"));
    }
    public boolean mng(String args, TreeSet<SpaceMarine> mySet){
        String[] aaa = args.split(" ");
        try {
            return listOfCommands.get(aaa[0]).doo(args, mySet);
        } catch (Exception e) {
            return false;
        }
    }
}