package repository;

import model.Todo;
import model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by G510 on 11-02-2019.
 */

public interface TodoMongoRepository extends CrudRepository<Todo, String> {

    Todo findOne(String id);
    Todo delete(String id);
}