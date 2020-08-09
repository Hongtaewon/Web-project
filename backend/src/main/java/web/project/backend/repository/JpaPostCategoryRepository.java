package web.project.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import web.project.backend.orm.Post_category;

public interface JpaPostCategoryRepository extends JpaRepository<Post_category, Long>{

}
