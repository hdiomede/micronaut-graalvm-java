package com.github.hdiomede.micronaut;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Produces;

@Controller("/todos")
public class TodoListController {
    
    private AtomicInteger counter = new AtomicInteger(0);
    private TodoList itemsList = new TodoList(new ArrayList<TodoItem>());

    @Get
    @Produces(MediaType.APPLICATION_JSON)
    public TodoList index() {
        return itemsList;
    }

    @Get("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public TodoItem getItem(Long id) {
        return itemsList.getItem(id);
    }

    @Post
    @Produces(MediaType.APPLICATION_JSON)
    public TodoItem addTodoItem(@Body TodoItem item) {
        Long count = Long.valueOf(counter.incrementAndGet());
        TodoItem newItem = new TodoItem(count, item.title());
        itemsList.addItem(newItem);
        return newItem;
    }
}
