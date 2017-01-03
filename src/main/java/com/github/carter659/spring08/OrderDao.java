package com.github.carter659.spring08;

import java.util.Date;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * 博客出处：http://www.cnblogs.com/GoodHelper/
 * 
 * @author 刘冬
 *
 */
@Component
public class OrderDao {

	/**
	 * 假设从数据库获取的订单数据
	 * 
	 * @param id
	 * @return
	 */
	@Cacheable(value = "order", key = "'.id.'+#id")
	public Order get(String id) {
		Order order = new Order();
		order.id = id;
		order.no = "No.00001";
		order.date = new Date();
		order.quantity = 100;
		return order;
	}
}
