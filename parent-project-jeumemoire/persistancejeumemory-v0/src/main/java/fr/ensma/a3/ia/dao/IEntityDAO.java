/**
 * 
 */
package fr.ensma.a3.ia.dao;

import java.util.List;
import java.util.Optional;

/**
 * @author alvaresn
 *
 */
public interface IEntityDAO<T> {

	public Optional<T> getById(int id);
	public Optional<T> getByValue(T elem);
	List<T> getAll();
	public int lastId();
	void create(T elem);
	void update(T elem);
	void delete(T elem);
	
}