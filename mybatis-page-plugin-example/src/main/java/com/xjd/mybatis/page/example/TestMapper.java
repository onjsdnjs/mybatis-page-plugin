package com.xjd.mybatis.page.example;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xjd.mybatis.page.Pagination;

/**
 * @author elvis.xu
 * @since 2015-05-19 21:08
 */
public interface TestMapper {

	List<TestBean> selectAll();

	List<TestBean> selectAll(Pagination page);

	List<TestBean> selectByCity(String city);

	List<TestBean> selectByCity(@Param("city") String city, Pagination page);

	List<TestBean> selectByCityAndOlderThanAge(@Param("city") String city, @Param("age") int age);

	List<TestBean> selectByCityAndOlderThanAge(@Param("city") String city, @Param("age") int age, Pagination page);
}
