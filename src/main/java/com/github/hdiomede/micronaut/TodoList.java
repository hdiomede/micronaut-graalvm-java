package com.github.hdiomede.micronaut;

import com.fasterxml.jackson.annotation.JsonClassDescription;

import java.util.List;

@JsonClassDescription
public record TodoList(
    List<TodoItem> items
) {
    public void addItem(TodoItem item) {
        items.add(item);
    }

    public TodoItem getItem(Long id) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).id() == id) {
                return items.get(i);
            }
        }

        return null;
    }
}
