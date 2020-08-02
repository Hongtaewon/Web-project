package project.backend;

import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<userDto, Integer> {
}
