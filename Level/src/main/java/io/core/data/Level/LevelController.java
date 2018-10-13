package io.core.data.Level;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.core.data.Level.ErrorModel;
import io.core.data.Level.LevelException;
import io.core.data.Level.LevelModel;
import io.core.data.Level.LevelService;

@RestController
@RequestMapping(path = "/v1/Level",
			consumes = MediaType.APPLICATION_JSON_VALUE, 
	        produces = MediaType.APPLICATION_JSON_VALUE) 
public class LevelController {

	@Autowired
	LevelService levelSvc;
	
	@RequestMapping(value = "/getLevel", method = RequestMethod.POST)
	public List<LevelModel> getLevel( @Valid @RequestBody LevelModel level) {
		
		if(level.getId() == null){

			return  levelSvc.getLevelModels();
			
		}else {
		
			return  levelSvc.getLevelModel(level.getId());
		
		}
	}

	@RequestMapping(value = "/saveLevel", method = RequestMethod.POST)
	public ResponseEntity <LevelModel> saveLevel(@Valid @RequestBody LevelModel level) {
		
		return ResponseEntity.ok(levelSvc.saveLevelModel(level));
	}

	@ExceptionHandler({LevelException.class})
	public ResponseEntity <ErrorModel> handleException(LevelException e)
	{
		return new ResponseEntity<>(e.getError(), HttpStatus.valueOf(e.getError().getHttpStatus()));
		
	}
	
}