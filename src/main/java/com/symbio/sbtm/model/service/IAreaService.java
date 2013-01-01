package com.symbio.sbtm.model.service;

import com.symbio.sbtm.model.*;

public interface IAreaService {

	public void save(Area area) throws Exception;

	public void delete(Area area) throws Exception;

	public void update(Area area) throws Exception;

	public Area getAreaByName(String name) throws Exception;
}
