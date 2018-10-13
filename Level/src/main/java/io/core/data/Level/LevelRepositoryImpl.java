package io.core.data.Level;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import io.core.data.Level.LevelModel;

@Repository
public class LevelRepositoryImpl implements LevelRepositoryCustom {

	private final MongoTemplate mongoTemplate;
	 
	@Autowired
	public LevelRepositoryImpl(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
	
	@Override
	public List<LevelModel> getLevelModel(String id) {
		
		final Query query = new Query();
		
		final List<Criteria> criteria = new ArrayList<>();
		
		if(id != null) {
			criteria.add(Criteria.where("id").is(id));
		}	
		
		if(!criteria.isEmpty()) {
			query.addCriteria(new Criteria().andOperator(criteria.toArray(new Criteria[criteria.size()])));
		}
		
		return mongoTemplate.find(query, LevelModel.class);

	}

	public List<LevelModel> getLevelModels() {
	
		return mongoTemplate.findAll(LevelModel.class);

	}
	
	@Override
	public LevelModel saveLevelModel(LevelModel entity) {
		
		mongoTemplate.save(entity);

		return entity;
		
	}

}