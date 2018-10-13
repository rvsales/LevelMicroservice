package io.core.data.Level;

import lombok.Getter;
import lombok.Setter;

public enum ErrorType {

	
	BUSINESS("Business Exception",1), GENERIC("Generic Exception",2), DATA("Data Exception",3), COMM("Comunication Exception",4);
	
	@Getter @Setter
	private String title;

	@Getter @Setter
	private Integer code;
	
	ErrorType(String title, Integer code){
		this.setTitle(title);
		this.setCode(code);
		
	}
	
	
}
