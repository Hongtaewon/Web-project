package project.backend;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;



@Getter
@Setter
@AllArgsConstructor
public class userDto {
	
	
	private long idx;
	@NonNull private String id;
	@NonNull private String name;
	@NonNull private String phone_number;
	@NonNull private String email;
	
}
