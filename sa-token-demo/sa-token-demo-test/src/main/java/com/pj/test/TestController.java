package com.pj.test;

import cn.dev33.satoken.stp.SaLoginConfig;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaFoxUtil;
import cn.dev33.satoken.util.SaResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 测试专用Controller 
 * @author click33
 *
 */
@RestController
@RequestMapping("/test/")
public class TestController {

	// 测试登录  ---- http://localhost:8081/test/login
	@RequestMapping("login")
	public SaResult login(@RequestParam(defaultValue = "10001") long id) {
		StpUtil.login(id, SaLoginConfig.setActiveTimeout(20));
		return SaResult.ok("登录成功");
	}

	// 测试   浏览器访问： http://localhost:8081/test/test
	@RequestMapping("test")
	public SaResult test() {
		System.out.println("------------进来了 " + SaFoxUtil.formatDate(new Date()));
		StpUtil.checkLogin();
		// 返回
		return SaResult.data(null);
	}
	
	// 测试   浏览器访问： http://localhost:8081/test/test2
	@RequestMapping("test2")
	public SaResult test2() {
		return SaResult.ok();
	}

}
