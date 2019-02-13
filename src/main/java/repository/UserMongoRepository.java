package repository;

import model.Todo;
import model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by G510 on 11-02-2019.
 */


public interface UserMongoRepository extends CrudRepository<User, String> {
    public User getUser(String userName);
}