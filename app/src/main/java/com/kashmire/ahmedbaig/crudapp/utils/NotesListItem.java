package com.kashmire.ahmedbaig.crudapp.utils;

public class NotesListItem {
    private String head;
    private Boolean completed;


    public NotesListItem(String head, Boolean completed) {
        this.head = head;
        this.completed = completed;
    }

    public String getHead() {
        return head;
    }

    public Boolean getCompleted() {
        return completed;
    }
}
