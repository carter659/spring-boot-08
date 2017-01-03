package com.github.carter659.spring08;

import java.io.Serializable;
import java.util.Date;

/**
 * 博客出处：http://www.cnblogs.com/GoodHelper/
 * 
 * @author 刘冬
 *
 */
public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String id;

	public String no;

	public Date date;

	public int quantity;

	/**
	 * 省略 get set
	 */
}
