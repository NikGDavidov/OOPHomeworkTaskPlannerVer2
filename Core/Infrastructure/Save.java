package TaskScheduler.Core.Infrastructure;



import TaskScheduler.Core.Models.Task;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static TaskScheduler.Config.pathDb;

public class Save {
    public static void write(Task task) {


    String fileName = pathDb;

    StringBuilder sb = new StringBuilder();
    sb.append(task.getId());
    sb.append(',');
    sb.append(task.getDescription());
    sb.append(',');

    Date dt = task.getDateOfAdd();
    SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy/hh/mm");
    sb.append(f.format(dt));
    sb.append(',');
    dt = task.getDeadLine();
    f = new SimpleDateFormat("dd/MM/yyyy");
    sb.append(f.format(dt));
    sb.append(',');
    sb.append(task.getPriority());
    sb.append(',');
    sb.append(task.getFullName());
    sb.append('\n');

    try( FileWriter fw = new FileWriter(fileName, true)){

        fw.write(sb.toString());
    } catch (IOException e) {
        e.printStackTrace();
    }

}
}
