package designPattern.observerDemo;

import java.util.ArrayList;
import java.util.List;

/**
 * 行为型设计模式
 * 观察者模式：
 * 定义对象间的一种一对多的依赖关系，当一个对象的状态发生改变时，所有依赖于它的对象都得到通知并被自动更新。
 *
 * 主要解决：一个对象状态改变给其他对象通知的问题，而且要考虑到易用和低耦合，保证高度的协作。
 * 何时使用：一个对象（目标对象）的状态发生改变，所有的依赖对象（观察者对象）都将得到通知，进行广播通知。
 * 关键代码：在抽象类里有一个 ArrayList 存放观察者们。
 */

public class ObserverDemo {
    public static void main(String[] args) {
        Subject subject = new Subject();
        new BinaryObserver(subject);
        new OctalObserver(subject);
        System.out.println("First state change: 15");
        subject.setState(15);
        System.out.println("Second state change: 10");
        subject.setState(10);
    }
}

abstract class Observer {
    protected Subject subject;
    public abstract void update();
}

class BinaryObserver extends Observer {
    public BinaryObserver(Subject subject) {
        this.subject = subject;
        this.subject.add(this);
    }

    @Override
    public void update() {
        System.out.println( "Binary String: "
                + Integer.toBinaryString( subject.getState() ) );
    }
}

class OctalObserver extends Observer {
    public OctalObserver(Subject subject) {
        this.subject = subject;
        this.subject.add(this);
    }

    @Override
    public void update() {
        System.out.println( "octal String: "
                + Integer.toOctalString( subject.getState() ) );
    }
}

class Subject {
    private List<Observer> observers = new ArrayList<Observer>();

    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        broadCast();
    }

    public void add(Observer observer) {
        observers.add(observer);
    }

    public void broadCast () {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}


