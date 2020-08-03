package web.project.backend.orm;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@Entity
@AllArgsConstructor
@Table(name="user")
public class User implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(nullable = false, length=20)
	private String id;
	@Column(nullable = false, length=20)
	private String name;
	@Column(nullable = false, length=20)
	private String phone_number;
	@Column(nullable = false, length=20)
	private String email;
	
}
