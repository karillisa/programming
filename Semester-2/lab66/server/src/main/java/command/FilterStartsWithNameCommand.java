package command;

import classes.SpaceMarine;
import objectResAns.ObjectResAns;

import java.util.TreeSet;

public class FilterStartsWithNameCommand extends AbsCommand{
    public FilterStartsWithNameCommand(String name) {
        super(name);
    }

    @Override
    public ObjectResAns doo(String args, TreeSet<SpaceMarine> mySet){
        String nameArg = args.split(" ")[1];
        int cnt = 0;

        if(nameArg.isEmpty()){
            return new ObjectResAns("Argument Name should be not null or empty!", true);
        }

        for(SpaceMarine s: mySet){
            if(s.getName().startsWith(nameArg)){
                System.out.println(s.toString());
                cnt = cnt + 1;
            }
        }

        if(cnt == 0){
            System.out.println("Not found Object with name start with " + nameArg);
            return new ObjectResAns("Not found Object with name start with " + nameArg, true);
        }

        return new ObjectResAns("Count : " + cnt, true);
    }

    @Override
    public String des(){
        return "filter_starts_with_name name : вывести элементы, значение поля name которых начинается с заданной подстроки";
    }
}
