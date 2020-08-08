package web.project.backend.orm;

import javax.persistence.*;


import lombok.Getter;

@Getter
@Entity(name="category")
public class Blog_category extends BaseEntity{

	@Column(nullable = false)
	private String name; // 카테고리 이름
}
