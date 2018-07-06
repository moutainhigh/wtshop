package com.wtshop.template.directive;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.jfinal.aop.Enhancer;
import com.wtshop.Filter;
import com.wtshop.Order;
import com.wtshop.model.Tag;
import com.wtshop.service.TagService;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

/**
 * 模板指令 - 标签列表
 * 
 * 
 */
public class TagListDirective extends BaseDirective {

	/** 变量名称 */
	private static final String VARIABLE_NAME = "tags";

	private TagService tagService = Enhancer.enhance(TagService.class);

	/**
	 * 执行
	 * 
	 * @param env
	 *            环境变量
	 * @param params
	 *            参数
	 * @param loopVars
	 *            循环变量
	 * @param body
	 *            模板内容
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException, IOException {
		Integer count = getCount(params);
		List<Filter> filters = getFilters(params, Tag.class);
		List<Order> orders = getOrders(params);
		boolean useCache = useCache(env, params);
		List<Tag> tags = tagService.findList(count, filters, orders, useCache);
		setLocalVariable(VARIABLE_NAME, tags, env, body);
	}

}