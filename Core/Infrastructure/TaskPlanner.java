package TaskScheduler.Core.Infrastructure;


import TaskScheduler.Core.Models.Task;


import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static TaskScheduler.Config.pathDb;

public class TaskPlanner {
    private List<Task> tasks;

    public TaskPlanner() {
        tasks = new ArrayList<Task>();
    }

    public void add() {
        Scanner sc1 = new Scanner(System.in);
        Task task = new Task();
        System.out.println("Введите название задачи");

        task.setDescription(sc1.nextLine());
        System.out.println("Введите дату завершения задачи в формате dd/MM/yyyy");

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String temp = sc1.nextLine();
        try {
            task.setDeadLine(simpleDateFormat.parse(temp));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("Назначьте приоритет задачи : 1-важная; 2 - средней важности; 3 - менее важная.");
        task.setPriority(Integer.parseInt(sc1.next()));
        System.out.println("Введите имя ответственного лица");
        task.setFullName(sc1.next());
        task.setDateOfAdd(new Date());
        task.setId(task.getDateOfAdd().hashCode() % 100 * (-1));
        Save.write(task);

        return;
    }
        public void remove (int id){
//            System.out.println("Введите id задачи, которую хотите удалить");
//            BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
//            int id = Integer.parseInt(r.readLine());
            ArrayList<Task> lt = (ArrayList)Load.read();
            for (int i=0; i<lt.size();i++){
                if (lt.get(i).getId()==id) lt.remove(i);
            }
            File file = new File(pathDb);
            PrintWriter writer = null;
            try {
                writer = new PrintWriter(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            writer.print("");
            writer.close();
            for (int i=0; i<lt.size();i++){
                Save.write(lt.get(i));
            }
        }
        }


