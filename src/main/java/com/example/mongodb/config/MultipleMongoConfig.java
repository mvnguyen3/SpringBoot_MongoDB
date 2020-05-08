package com.example.mongodb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.DbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

import com.mongodb.MongoClient;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties(MultipleMongoProperties.class)
public class MultipleMongoConfig {
	
	private final MultipleMongoProperties mongoProperties;

	@Primary
	@Bean(name = "primaryMongoTemplate")
	public MongoTemplate primaryMongoTemplate() throws Exception {

		DbRefResolver dbRefResolver = new DefaultDbRefResolver(primaryFactory(this.mongoProperties.getPrimary()));
		MappingMongoConverter mappingConverter = new MappingMongoConverter(dbRefResolver, new MongoMappingContext());
		mappingConverter.setTypeMapper(new DefaultMongoTypeMapper(null));
		mappingConverter.setMapKeyDotReplacement(".");
		return new MongoTemplate(primaryFactory(this.mongoProperties.getPrimary()), mappingConverter);
	}

	@Primary
	@Bean	
	public MongoDbFactory primaryFactory(final MongoProperties mongo) throws Exception {
		return new SimpleMongoDbFactory(new MongoClient(mongo.getHost(), mongo.getPort()), mongo.getDatabase());
	}
}
