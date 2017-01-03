package com.github.carter659.spring08;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 博客出处：http://www.cnblogs.com/GoodHelper/
 * 
 * @author 刘冬
 *
 */
@Controller
public class MainController {

	private static final String STR_REDIS_KEY = "key:name";

	@Autowired
	private StringRedisTemplate redisTemplate;

	@Autowired
	private OrderDao orderDao;

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@PostMapping("/setString")
	public @ResponseBody Map<String, Object> setString(String value) {
		redisTemplate.opsForValue().set(STR_REDIS_KEY, value);
		Map<String, Object> map = new HashMap<>();
		map.put("msg", "ok");
		return map;
	}

	@PostMapping("/getString")
	public @ResponseBody Map<String, Object> getString() {
		String value = redisTemplate.opsForValue().get(STR_REDIS_KEY);
		Map<String, Object> map = new HashMap<>();
		map.put("value", value);
		map.put("msg", "ok");
		return map;
	}

	@PostMapping("/get")
	public @ResponseBody Order get(@RequestParam String id) {
		return orderDao.get(id);
	}

}
