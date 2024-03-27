package ru.netology;

import java.util.Objects;

public class Epic extends Task {
    private String subtasks[];

    public Epic(int id, String[] subtasks) {
        super(id); // вызов родительского конструктора
        this.subtasks = subtasks; // заполнение своих полей
    }

    public String[] getSubtask() {

        return subtasks;
    }

    @Override
    public boolean matches(String query) {
        for (String result : subtasks) {
            if (result.contains(query)) {
                return true;
            }
        }
        return false;

    }
}

