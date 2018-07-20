package com.yui.boot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yui.boot.common.persistence.web.BaseController;

@Controller
@RequestMapping("/decorator")
public class DecoratorController extends BaseController {
	
	@RequestMapping("default")
	public String defaultDecorator() {
		return "decorator/default";
	}
}
