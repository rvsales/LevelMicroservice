package io.core.data.Level;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Document(collection = "level")
@AllArgsConstructor @NoArgsConstructor
public class LevelModel {
	
	@Id
	@Getter @Setter
	private String id; 		
	
	@Getter @Setter
	private String description;
	
	@Getter @Setter
	private String limit;
	
	@Override
	public String toString() {
	    return "level [id= " + id + ", description= " + description + ", limit= " + limit + "]";
	}	

	   @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        LevelModel levelModel = (LevelModel) o;
	        return Objects.equals(id, levelModel.id);
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(id);
	    }

	
}
