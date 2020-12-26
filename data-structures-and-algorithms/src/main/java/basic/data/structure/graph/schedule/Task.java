package basic.data.structure.graph.schedule;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author wangxin
 * 2020/5/10 18:23
 * @since
 **/
public class Task implements Executable{

    private boolean isFinish;
    private String name;
    private Set<Task> prevs;


    public Task(String name) {
        this.name = name;
        this.prevs = new HashSet<>();
        this.isFinish = false;
    }

    public void addPrev(Task prev) {
        checkState();
        prevs.add(prev);
    }

    public void removePrev(Task prev) {
        checkState();
        prevs.remove(prev);
    }

    private void checkState() {
        if (isFinish) {
            throw new IllegalStateException("task is finish");
        }
    }

    public boolean isCanRun() {
        if (isFinish) {
            return false;
        }
        boolean isCanRun = true;
        for (Task prev : prevs) {
            if (!prev.isFinish) {
                isCanRun = false;
                break;
            }
        }
        return isCanRun;
    }


    @Override
    public boolean execute() {
        if (isFinish) {
            return false;
        }
        System.out.println(toString());
        isFinish = true;
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return isFinish == task.isFinish &&
            Objects.equals(name, task.name) &&
            Objects.equals(prevs, task.prevs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isFinish, name, prevs);
    }

    @Override
    public String toString() {
        return "Task{" +
            "name='" + name + '\'' +
            '}';
    }

    public boolean isFinish() {
        return isFinish;
    }

    public String getName() {
        return name;
    }

    public Set<Task> getPrevs() {
        return prevs;
    }
}
