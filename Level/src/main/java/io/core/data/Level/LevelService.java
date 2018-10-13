package io.core.data.Level;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import  io.core.data.Level.LevelRepository;
import  io.core.data.Level.LevelModel;
import  io.core.data.Level.LevelException;
import  io.core.data.Level.ErrorType;
import  io.core.data.Level.ErrorModel;

@Service
public class LevelService {

	private static final String LEVEL_NOT_FOUND = "Level does not exists!!";
	private static final String INVALID_PARAMETER = "Invalid Parameter!!";
	private static final String ERROR_DURING_UPDATE_PROCESS = "We could not confirm your update request, please try again :(";
	
	@Autowired
	LevelRepository levelRepository;

	public List<LevelModel> getLevelModel(String id) throws LevelException{
		
		List<LevelModel> levels = levelRepository.getLevelModel(id);
		
		if(!levels.isEmpty()){
			
			 return levels;
			
		} else {
				
		throw new LevelException(new ErrorModel(ErrorType.DATA.getTitle(), LEVEL_NOT_FOUND, HttpStatus.NOT_FOUND.value()));
	
		}
	}	
	
	public List<LevelModel> getLevelModels() throws LevelException{
		
		List<LevelModel> levels = levelRepository.getLevelModel();
		
		if(!levels.isEmpty()){
			
			 return levels;
			
		} else {
				
		throw new LevelException(new ErrorModel(ErrorType.DATA.getTitle(), LEVEL_NOT_FOUND, HttpStatus.NOT_FOUND.value()));
	
		}
	}	
	
	public LevelModel saveLevelModel(LevelModel entity) throws LevelException{
	
		if(entity == null) {
	
			throw new LevelException(new ErrorModel(ErrorType.BUSINESS.getTitle(), INVALID_PARAMETER, HttpStatus.BAD_REQUEST.value()));
		}
		
		LevelModel level = new LevelModel();
		
		try {
			
			level = levelRepository.saveLevelModel(entity);
	
			if(level==null) {
	
				throw new LevelException(new ErrorModel(ErrorType.DATA.getTitle(), ERROR_DURING_UPDATE_PROCESS, HttpStatus.NO_CONTENT.value()));
							
			}
	
		} catch (Exception e) {
		
			throw new LevelException(new ErrorModel(ErrorType.DATA.getTitle(), ERROR_DURING_UPDATE_PROCESS, HttpStatus.NO_CONTENT.value()));
		
		}
				
		return level;
	}
	
}
