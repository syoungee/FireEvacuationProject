package com.jsp.Malcha.dao;

import java.util.List;

import com.google.appengine.api.datastore.DatastoreFailureException;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.SortDirection;

public class PeopleDao{

	public void writeDao(String key, String age, String number, String name) {
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Entity post = new Entity("People", key);
		post.setProperty("age", age);
		post.setProperty("number", number);
		post.setProperty("name", name);

		try {
			datastore.put(post);
		} catch (DatastoreFailureException e) {
			e.printStackTrace();
		}
	}

	public Entity getDao(String key) {
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Key k1 = KeyFactory.createKey("People", key);
		Entity employee = null;
		try {
			employee = datastore.get(k1);
		} catch (EntityNotFoundException e) {
			e.printStackTrace();
		}
		return employee;
	}

	public List<Entity> listDao() {
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Query q = new Query("People").addSort("name", SortDirection.DESCENDING);
		PreparedQuery pq = datastore.prepare(q);
		return pq.asList(FetchOptions.Builder.withDefaults());
	}

	public void deleteDao(String key) {
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Key k1 = KeyFactory.createKey("People", key);
		datastore.delete(k1);
	}
}
