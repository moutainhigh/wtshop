package com.wtshop.template.directive;

import java.io.IOException;
import java.io.StringReader;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import com.jfinal.aop.Enhancer;
import com.jfinal.render.FreeMarkerRender;
import com.wtshop.model.AdPosition;
import com.wtshop.service.AdPositionService;

import freemarker.core.Environment;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

/**
 * 模板指令 - 广告位
 * 
 * 
 */
public class AdPositionDirective extends BaseDirective {

	/** 变量名称 */
	private static final String VARIABLE_NAME = "adPosition";

	private Configuration cfg = FreeMarkerRender.getConfiguration();
	private AdPositionService adPositionService = Enhancer.enhance(AdPositionService.class);

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
		Long id = getId(params);
		boolean useCache = useCache(env, params);
		AdPosition adPosition = adPositionService.find(id, useCache);
		if (body != null) {
			setLocalVariable(VARIABLE_NAME, adPosition, env, body);
		} else {
			if (adPosition != null && adPosition.getTemplate() != null) {
				try {
					Map<String, Object> model = new HashMap<String, Object>();
					model.put(VARIABLE_NAME, adPosition);
					Writer out = env.getOut();
					new Template("adTemplate", new StringReader(adPosition.getTemplate()), cfg).process(model, out);
				} catch (TemplateException e) {
					throw new RuntimeException(e.getMessage(), e);
				} catch (IOException e) {
					throw new RuntimeException(e.getMessage(), e);
				}
			}
		}
	}

}