package TaskScheduler.Core.MVP;

import TaskScheduler.Core.Models.Task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Presenter {
    private Model model;
    private View view;

    public Presenter(View view, String pathDb) {
        this.view = view;
        model = new Model(pathDb);
    }

    public void LoadFromFile() {
        List<Task> lt = model.load();
        view.print(lt);
        }

    public void add() {
        model.add();
               // new Contact(view.getFirstName(), view.getLastName(), view.getDescription()));
    }
    public void remove() {
        System.out.println("Введите id задачи, которую хотите удалить");
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int id=0;
        try {
            id = Integer.parseInt(r.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        model.remove(id);
    }






}


