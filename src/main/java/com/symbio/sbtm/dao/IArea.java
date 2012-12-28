package com.symbio.sbtm.dao;

import java.util.ArrayList;

import com.symbio.sbtm.vo.Area;
import com.symbio.sbtm.vo.Build;

public interface IArea {

	public void doCreate(Area area) throws Exception;

	public void doDelete(Area area) throws Exception;

	public void doUpdate(Area area) throws Exception;

	public ArrayList<Area> getArea(Area area) throws Exception;

	public ArrayList<Area> getAllAreas(Build build) throws Exception;
}
