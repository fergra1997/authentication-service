package com.auth.spring.service;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.auth.spring.dto.ReturnCode;
/**
 * The class for CRUD
 * 
 * @author Fernando Granato
 *
 */
public class ManagerCRUD {

	private ReturnCode daoReturnCode;
	
	/**
	 * The method used to read into the DB
	 * 
	 * @param <T> type of object to read
	 * @param <K> type of primary key
	 * @param <D> type of dao
	 * @param id  the id used for search
	 * @param dao the dao used for work
	 * @return the T object
	 */
	public <T, K, D extends CrudRepository<T, K>> T read(K id, D dao) {
		ReturnCode returnCode = ReturnCode.ERROR;
		Optional<T> entity = dao.findById(id);
		T response = null;
		if (entity.isEmpty()) {
			returnCode = ReturnCode.NOT_FOUND;
		} else {
			response = entity.get();
			returnCode = ReturnCode.OK;
		}
		setDaoReturnCode(returnCode);
		return response;
	}

	/**
	 * The method used to insert into the DB
	 * 
	 * @param <T> type of object to insert
	 * @param <K> type of primary key
	 * @param <D> type of dao
	 * @param entity tyhe entity to insert
	 * @param id the entity id
	 * @param dao the dao to use
	 */
	public <T, K, D extends CrudRepository<T, K>> void create(T entity, K id, D dao) {
		ReturnCode returnCode = ReturnCode.ERROR;
		try {
			//if (!dao.existsById(id)) {
				dao.save(entity);
				returnCode = ReturnCode.CREATED;
//			} else {
//				returnCode = ReturnCode.ALREDY_EXIST;
//			}
		} catch (IllegalArgumentException e) {
			returnCode = ReturnCode.ERROR;
		}
		setDaoReturnCode(returnCode);
	}

	/**
	 * The method used to update an entity into the DB
	 * 
	 * @param <T> type of object to update
	 * @param <K> type of primary key
	 * @param <D> type of dao
	 * @param entity the entity to update
	 * @param id the entity id
	 * @param dao the dao to use
	 */
	public <T, K, D extends CrudRepository<T, K>> void update(T entity, K id, D dao) {
		ReturnCode returnCode = ReturnCode.ERROR;
		try {
			dao.save(entity);
			returnCode = ReturnCode.OK;
		} catch (IllegalArgumentException e) {
			returnCode = ReturnCode.ERROR;
		}

		setDaoReturnCode(returnCode);
	}
	
	/**
	 * The method to delete into the DB
	 * 
	 * @param <T> type of object to delete
	 * @param <K> type of primary key
	 * @param <D> type of dao
	 * @param id the entity id 
	 * @param dao the dao to use
	 */
	public <T, K, D extends CrudRepository<T, K>> void delete(K id, D dao) {
		ReturnCode returnCode = ReturnCode.ERROR;
		try {
			dao.deleteById(id);;
			returnCode = ReturnCode.DELETED;
		} catch (IllegalArgumentException e) {
			returnCode = ReturnCode.ERROR;
		}

		setDaoReturnCode(returnCode);
	}


	public ReturnCode getDaoReturnCode() {
		return daoReturnCode;
	}

	public void setDaoReturnCode(ReturnCode daoReturnCode) {
		this.daoReturnCode = daoReturnCode;

	}

}
