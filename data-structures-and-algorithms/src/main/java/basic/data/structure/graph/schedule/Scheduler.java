package basic.data.structure.graph.schedule;

import com.google.common.collect.Sets;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 任务调度器
 *
 * @author wangxin
 * 2020/5/10 18:29
 * @since
 **/
public class Scheduler {
    public void shcedule(Set<Task> tasks) {
        while (true) {
            List<Task> todos = new ArrayList<>();
            for (Task task : tasks) {
                if (task.isCanRun()) {
                    todos.add(task);
                }
            }
            if (!todos.isEmpty()) {
                for (Task todo : todos) {
                    todo.execute();
                }
            } else {
                break;
            }
        }
    }



    public static void main(String[] args) {
        Task task1 = new Task("task1");
        Task task2 = new Task("task2");
        Task task3 = new Task("task3");
        Task task4 = new Task("task4");
        Task task5 = new Task("task5");
        Task task6 = new Task("task6");

        task2.addPrev(task3);
        task2.addPrev(task4);
        task6.addPrev(task2);
        task1.addPrev(task2);
        task1.addPrev(task5);

        Set<Task> tasks = Sets.newHashSet(task1, task2, task3, task4, task5, task6);

        Scheduler scheduler = new Scheduler();
        scheduler.shcedule(tasks);
    }
}
