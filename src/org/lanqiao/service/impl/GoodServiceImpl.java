package org.lanqiao.service.impl;

import org.lanqiao.dao.GoodsDao;
import org.lanqiao.dao.impl.GoodsDaoImpl;
import org.lanqiao.entity.Good;
import org.lanqiao.entity.PageInfo;
import org.lanqiao.service.GoodService;

public class GoodServiceImpl implements GoodService {
	GoodsDao dao = null;
	public GoodServiceImpl() {
		dao = new GoodsDaoImpl();
	}
	@Override
	public PageInfo<Good> goodList(String cid, int pagesize, int pageindex) {
		return dao.list(cid, pagesize, pageindex);
	}
	@Override
	public Good getGoodById(String gid) {
		return dao.getGood(gid);
	}

}
