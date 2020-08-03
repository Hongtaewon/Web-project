package web.project.backend.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import web.project.backend.orm.User;


@Repository
public interface UserDao extends JpaRepository<User, String> {
}
