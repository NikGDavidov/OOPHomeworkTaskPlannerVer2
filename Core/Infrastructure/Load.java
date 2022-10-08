package TaskScheduler.Core.Infrastructure;

import TaskScheduler.Core.Models.Task;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static TaskScheduler.Config.pathDb;

public class Load {
    public static List<Task> read()  {
        List <Task> lt = new ArrayList<>();
        List<List<String>> records = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(pathDb));) {
            while (scanner.hasNextLine()) {
                records.add(getRecordFromLine(scanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (int i =0; i<records.size(); i++){

            String s = records.get(i).toString();

            String taskField [] = s.split(", ");
            Task t = new Task();
            t.setId(Integer.parseInt(taskField[0].replace("[","")));
            t.setDescription(taskField[1]);

            SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy/hh/mm");
            try {
                t.setDateOfAdd(f.parse(taskField[2]));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            f=new SimpleDateFormat("dd/MM/yyyy");
            try {
                t.setDeadLine(f.parse(taskField[3]));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            t.setPriority(Integer.parseInt(taskField[4]));
            t.setFullName(taskField[5].replace("]",""));
            lt.add(t);
        }
        return lt;
    }

    private static List<String> getRecordFromLine(String line) {
        List<String> values = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(",");
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
        }
        return values;
    }
}

