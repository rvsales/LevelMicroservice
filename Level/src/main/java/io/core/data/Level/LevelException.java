package io.core.data.Level;

import io.core.data.Level.ErrorModel;

public class LevelException extends RuntimeException {


private static final long serialVersionUID = 1L;
	
	private final ErrorModel error;
	
	public LevelException(ErrorModel error){
		
		super( error.getCode() + " - " + error.getMessage());
		
		this.error = error;
		
	}
	
	public LevelException(ErrorModel error, Throwable cause ){
		
		super( error.getCode() + " - " + error.getMessage(), cause);
		
		this.error = error;
		
	}
	
	public ErrorModel getError(){
		
		return error;
		
	}	
	
}
