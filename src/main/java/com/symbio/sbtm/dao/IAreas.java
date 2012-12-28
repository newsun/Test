package com.symbio.sbtm.dao;

import java.util.ArrayList;

import com.symbio.sbtm.vo.Charter_Area;
import com.symbio.sbtm.vo.Charter;

public interface IAreas {
	public void doCreate(Charter_Area areas) throws Exception;

	public void doDelete(Charter_Area areas) throws Exception;

	public void doUpdate(Charter_Area areas) throws Exception;

	public ArrayList<Charter_Area> getAreas(Charter_Area areas) throws Exception;

	public ArrayList<Charter_Area> getAllAreas(Charter charter) throws Exception;
}
