package com.wtshop.service;

import com.jfinal.aop.Enhancer;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;
import com.wtshop.Filter;
import com.wtshop.Order;
import com.wtshop.Pageable;
import com.wtshop.dao.IdentifierDao;
import com.wtshop.dao.SpecialPersonnelDao;
import com.wtshop.model.Identifier;
import com.wtshop.model.ProductCategory;
import com.wtshop.model.SpecialPersonnel;
import com.wtshop.util.PinYinUtil;
import com.wtshop.util.StringUtils;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * Service - 品牌
 * 
 * 
 */
public class IdentifierService extends BaseService<Identifier> {

	public IdentifierService() {
		super(Identifier.class);
	}
	
	private IdentifierDao brandDao = Enhancer.enhance(IdentifierDao.class);




	public Map<String,List> findBrandSort(){
		List<Record> brandSort = brandDao.findBrandSort();
		Collections.sort(brandSort, new Comparator<Record>() {
			@Override
			public int compare(Record o1, Record o2) {
				String name1 = StringUtils.isEmpty(o1.get("name"))?o1.get("name").toString():o1.get("name").toString();
				String name2 = StringUtils.isEmpty(o2.get("name"))?o2.get("name").toString():o2.get("name").toString();
				String zm1 = PinYinUtil.getPinYinHeadChar(name1.substring(0,1)).toUpperCase();
				String zm2 = PinYinUtil.getPinYinHeadChar(name2.substring(0,1)).toUpperCase();
				return zm1.compareTo(zm2);
			}
		});
		Map<String, List> stringListMap = PinYinUtil.groupByUserName(brandSort);
		return stringListMap;
	}
	public Identifier save(Identifier brand) {
		return super.save(brand);
	}

	public Identifier update(Identifier brand) {
		return super.update(brand);
	}

//	public Brand update(Brand brand, String... ignoreProperties) {
//		return super.update(brand, ignoreProperties);
//	}

	public void delete(Long id) {
		super.delete(id);
	}

	public void delete(Long... ids) {
		super.delete(ids);
	}

	public void delete(Identifier brand) {
		super.delete(brand);
	}
	/**
	 * 获取最后一条记录
	 */
	public Identifier findBySql(){
		return  brandDao.findBySql("SELECT MAX(id),* FROM identifier");
	}
	public Page<Identifier> findPage(String sql, Pageable pageable){
		return brandDao.findPage(sql,pageable);
	}
}