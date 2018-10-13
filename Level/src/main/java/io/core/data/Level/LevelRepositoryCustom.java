package io.core.data.Level;

import java.util.List;

import org.springframework.stereotype.Repository;

import io.core.data.Level.LevelModel;

@Repository
public interface LevelRepositoryCustom {

	List<LevelModel> getLevelModel();
	List<LevelModel> getLevelModel(String id);
	LevelModel saveLevelModel(LevelModel entity);
	
}
