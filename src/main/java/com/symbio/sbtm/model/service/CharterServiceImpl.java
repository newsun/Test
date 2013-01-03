package com.symbio.sbtm.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.symbio.sbtm.model.*;
import com.symbio.sbtm.model.dao.*;

@Service("charterService")
public class CharterServiceImpl implements CharterService {

	@Autowired
	private CharterDao charterDao;

	@Override
	@Transactional
	public void save(Charter charter) {
		charterDao.save(charter);
	}

	@Override
	@Transactional
	public void delete(Charter charter) {
		charterDao.delete(charter);
	}

	@Override
	@Transactional
	public void update(Charter charter) {
		charterDao.update(charter);
	}

	@Override
	public Charter getCharter(long charterId) {
		return charterDao.getCharter(charterId);
	}
}
