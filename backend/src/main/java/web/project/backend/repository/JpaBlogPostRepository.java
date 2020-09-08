package web.project.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import web.project.backend.entity.Blog_post;

@Repository
public interface JpaBlogPostRepository extends JpaRepository<Blog_post, Long>{

}
