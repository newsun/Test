package com.symbio.sbtm.model.service;

import com.symbio.sbtm.model.*;

public interface CharterService {
	public void save(Charter charter);

	public void delete(Charter charter);

	public void update(Charter charter);

	public Charter getCharter(long charterId);
}
