package algorithm.Aleetcode7_栈队列;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 设计一个排队系统，让每个入队列的用户都能看到自己在队列中所处位置；队列随时都能有人加入和退出，当有人退出时，其余用户的
 * 队列所处位置也要相应变化。
 *
 * 精髓就在：系统中有人离开的时候，需要进行下标的更新
 */

public class QueueingSystem {
    private Queue<User> queue = new LinkedList<>();

    // 从队尾入队列
    public void add(User user) {
        user.setSeq(queue.size() + 1);
        queue.offer(user);
    }

    // 从队头出队列
    public void remove() {
        queue.poll();
        updateSeq();
    }

    // 用户随机出队列
    public void remove(User user) {
        queue.remove(user);
        updateSeq();
    }

    // 有人离队之后更新其余人的下标
    private void updateSeq() {
        int i = 1;
        for (User user : queue) {
            user.setSeq(i ++);
        }
    }

    @Override
    public String toString() {
        return "QueueingSystem{" +
                "queue=" + queue +
                '}';
    }
}


class User {
    private int id;
    private String name;
    private int seq;

    public User(int id, String name, int seq) {
        this.id = id;
        this.name = name;
        this.seq = seq;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", seq=" + seq +
                '}';
    }
}