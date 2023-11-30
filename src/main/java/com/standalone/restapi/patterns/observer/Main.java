package com.standalone.restapi.patterns.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Main {

    public static void main(String[] args) {
        Subject s = new Subject();
        subscriber1 sub1 = new subscriber1(s);
        subscriber2 sub2 = new subscriber2(s);
        s.subscribe(sub1);
        s.subscribe(sub2);
        s.updateSubscribers();
        s.setMessage("New Message");
        s.updateSubscribers();
    }
}

class Subject {

    List<Observer> observers = new ArrayList<>();
    String message = "";

    void subscribe(Observer observer) {
        observers.add(observer);
    }

    void updateSubscribers() {
        observers.forEach(Observer::update);
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}


interface Observer {

    void update();
}

class subscriber1 implements Observer {

    Subject subject;
    String oldMessage = "";

    subscriber1(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void update() {
        if (!Objects.equals(oldMessage, subject.getMessage())) {
            oldMessage = subject.getMessage();
            System.out.println("Updated Message Sub1:" + subject.getMessage());
        } else {
            System.out.println("No new message");
        }
    }
}

class subscriber2 implements Observer {

    Subject subject;
    String oldMessage = "";

    subscriber2(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void update() {
        if (!Objects.equals(oldMessage, subject.getMessage())) {
            oldMessage = subject.getMessage();
            System.out.println("Updated Message Sub2:" + subject.getMessage());
        } else {
            System.out.println("No new message");
        }
    }
}