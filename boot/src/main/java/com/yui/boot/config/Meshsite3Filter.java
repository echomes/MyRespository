package com.yui.boot.config;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;

/**
 * SiteMesh
 * 
 * @author Echo
 *
 */
public class Meshsite3Filter extends ConfigurableSiteMeshFilter {
	
	@Override
	protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
		builder.addDecoratorPath("/*", "/decorator/default")// 拦截规则，/decorator/default 会被转发
				.addExcludedPath("/static/**"); // 白名单
	}
}
