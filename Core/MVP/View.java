package TaskScheduler.Core.MVP;

import TaskScheduler.Core.Models.Task;

import java.util.Collection;

public interface View {
    public void print(Collection<Task> task);
}
