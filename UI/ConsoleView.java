package TaskScheduler.UI;

import TaskScheduler.Core.MVP.View;
import TaskScheduler.Core.Models.Task;

import java.util.Collection;
import java.util.TreeSet;

public class ConsoleView implements View {
    public void print(Collection<Task> task) {
        TreeSet<Task> ts = new TreeSet<>(task);
        for (Task el : ts) {
            System.out.println(el);
        }
        return;
    }
}


