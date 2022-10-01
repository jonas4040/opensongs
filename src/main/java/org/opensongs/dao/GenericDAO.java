package org.opensongs.dao;

import java.util.List;

public interface GenericDAO {
	public void create(Object objeto);
	public List<Object> read(Object objCriterio);//faz algum select
	public void update(Object objeto);
	public void delete(Object objeto);
}
