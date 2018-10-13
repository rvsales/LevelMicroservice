package io.core.data.Level;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor
public class ErrorModel {

	@Getter @Setter
	private String code;
	
	@Getter @Setter
	private String message;
	
	@Getter @Setter
	private int httpStatus;
	
	@Override
	public boolean equals(Object obj) {
		
		return EqualsBuilder.reflectionEquals(this, obj);
	}
	
	@Override
	public int hashCode() {
		
		return HashCodeBuilder.reflectionHashCode(this);
	}
	
	
	
}
