package io.core.data.Level;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import io.core.data.Level.LevelModel;

@Repository
public interface LevelRepository extends MongoRepository<LevelModel,String>, LevelRepositoryCustom {

}
