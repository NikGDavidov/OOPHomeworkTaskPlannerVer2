package TaskScheduler.Core.MVP;
import TaskScheduler.Core.Infrastructure.Load;
import TaskScheduler.Core.Infrastructure.Save;
import TaskScheduler.Core.Infrastructure.TaskPlanner;
import TaskScheduler.Core.Models.Task;

import java.util.List;


public class Model {

    TaskPlanner taskPlanner;
    private String path;

    public Model(String path) {
        taskPlanner = new TaskPlanner();
        this.path = path;
    }



    public List<Task> load() {
          return  Load.read();
    }


    public void save(Task task) {
                Save.write(task);
            }

    public void add (){
        taskPlanner.add();

    }
    public void remove(int id){
        taskPlanner.remove(id);
    }

    public TaskPlanner taskPlanner() {
        return this.taskPlanner;
    }

}
