package com.rev.dao;

import java.util.List;

public interface CrudRepository<T, I> {
	T save(T t);
	List<T> findAll();
	T findById(I id);
	T update(T t);
	T deleteById(I id);
}
