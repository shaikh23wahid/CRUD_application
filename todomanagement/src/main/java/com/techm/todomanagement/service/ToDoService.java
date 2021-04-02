package com.techm.todomanagement.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.FindOneAndUpdateOptions;
import com.mongodb.client.model.ReturnDocument;
import com.techm.todomanagement.model.ToDoBean;

@Service
public class ToDoService {

	@Autowired
	private MongoOperations mongoOperations;
	
	private String collectionName = "ToDos";
	
	public Map<String, Object> getAllToDo() {
		Query strQuery = new Query();
		List<Object> lst = mongoOperations.find(strQuery, Object.class, collectionName);
		Map<String, Object> objMap = new HashMap<>();
		objMap.put("todoList", lst);
		return objMap;		
	}

	public Map<String, Object> getToDoById(int _id) {
		Query strQuery = new Query().addCriteria(Criteria.where("_id").is(_id));
		Map<String, Object> objMap= mongoOperations.findOne(strQuery, Map.class, collectionName);
		return objMap;		
	} 
	
	public Map<String, Object> SaveToDo(ToDoBean todoBean) {
		if(todoBean.get_id() == 0) {
			todoBean.set_id(getLatestId(collectionName));		
		}
		mongoOperations.save(todoBean, collectionName);
		Map<String , Object> newlyCreatedToDo = new HashMap<>();
		newlyCreatedToDo.put("message", "New Todo " + todoBean.get_id()+ " Succesfully created");
		return newlyCreatedToDo;
	}
	
	public Map<String, Object> UpdateToDo(ToDoBean todoBean) {
		Query strQuery = new Query().addCriteria(Criteria.where("_id").is(todoBean.get_id()));
		Object objMap = mongoOperations.findOne(strQuery, Object.class, collectionName);
		Map<String , Object> newlyCreatedToDo = new HashMap<>();
		
		if(objMap == null) {
			newlyCreatedToDo.put("message", "Todo Id " + todoBean.get_id()+ " does not exists");
			return newlyCreatedToDo;
		} 
		
		mongoOperations.save(todoBean, collectionName);
		newlyCreatedToDo.put("message", "Todo " + todoBean.get_id()+ " updated uccesfully");
		return newlyCreatedToDo;
	}
	
	public Map<String, Object> deleteTodoById(int _id) {
		Query strQuery = new Query().addCriteria(Criteria.where("_id").is(_id));
		mongoOperations.remove(strQuery, collectionName);
		Map<String , Object> deletedToDo = new HashMap<>();
		deletedToDo.put("message", "Todo " + _id+ " deleted succesfully");
		return deletedToDo;
	} 
	
	public Map<String, Object> deleteAll() {
		Query strQuery = new Query();
		mongoOperations.remove(strQuery, collectionName);
		Map<String , Object> deletedToDo = new HashMap<>();
		deletedToDo.put("message", "Todos deleted succesfully");
		return deletedToDo;
	} 	
	
	private int getLatestId(String IdName) {
		Bson query = new Document("_id", IdName);
		MongoCollection<Document> coll = mongoOperations.getCollection("todoSequence");
		Bson update = new Document("$inc", new Document("seq", 1));
		FindOneAndUpdateOptions options = new FindOneAndUpdateOptions();
		options.returnDocument(ReturnDocument.AFTER);
		options.upsert(true);
		return coll.findOneAndUpdate(query, update, options).getInteger("seq");
	}

}
