package controllers;

import model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import repository.TodoMongoRepository;

/**
 * Created by G510 on 11-02-2019.
 */

@RestController
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    TodoMongoRepository todoMongoRepository;

    @RequestMapping(value = "/getTodos", method = RequestMethod.DELETE)
    public void getAllTodos() {
        todoMongoRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody Todo todo) {
        todoMongoRepository.save(todo);
    }

    @RequestMapping(value = "/{id}")
    public Todo read(@PathVariable String id) {
        return todoMongoRepository.findOne(id);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody Todo todo) {
        todoMongoRepository.save(todo);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id) {
        todoMongoRepository.delete(id);
    }

}
