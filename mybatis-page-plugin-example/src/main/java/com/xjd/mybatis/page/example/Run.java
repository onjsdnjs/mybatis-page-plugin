package com.xjd.mybatis.page.example;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xjd.mybatis.page.Page;

/**
 * @author elvis.xu
 * @since 2015-05-19 21:29
 */
public class Run {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-data.xml");

		TestMapper testMapper = context.getBean(TestMapper.class);

		testSelectAll(testMapper);
		testSelectByCity(testMapper);
		testSelectByCityAndOlderThanAge(testMapper);
	}

	public static void testSelectAll(TestMapper testMapper) {
		System.out.print("test selectAll 开始...");
		int total;
		int pageCount;

		List<TestBean> list = testMapper.selectAll();
		total = list.size();
		pageCount = total - 1;

		Page<TestBean> page = new Page<TestBean>(1, pageCount);

		list = testMapper.selectAll(page);

		System.out.println(String.format("总数为: %d, 统计的总数为: %d, 是否相等: %b", total, page.getTotalCount(),
				total == page.getTotalCount()));
		System.out.println(String.format("分页要求数为: %d, 实际查询记录数为: %d, 是否相等: %b", pageCount, list.size(),
				pageCount == list.size()));
	}

	public static void testSelectByCity(TestMapper testMapper) {
		System.out.print("test selectCity 开始...");
		int total;
		int pageCount;
		List<TestBean> list = testMapper.selectByCity("sh");
		total = list.size();
		pageCount = total - 1;

		Page<TestBean> page = new Page<TestBean>(1, pageCount);

		list = testMapper.selectByCity("sh", page);

		System.out.println(String.format("总数为: %d, 统计的总数为: %d, 是否相等: %b", total, page.getTotalCount(),
				total == page.getTotalCount()));
		System.out.println(String.format("分页要求数为: %d, 实际查询记录数为: %d, 是否相等: %b", pageCount, list.size(),
				pageCount == list.size()));
	}

	public static void testSelectByCityAndOlderThanAge(TestMapper testMapper) {
		System.out.print("test selectCity 开始...");
		int total;
		int pageCount;
		List<TestBean> list = testMapper.selectByCityAndOlderThanAge("sh", 29);
		total = list.size();
		pageCount = total - 1;

		Page<TestBean> page = new Page<TestBean>(1, pageCount);

		list = testMapper.selectByCityAndOlderThanAge("sh", 29, page);

		System.out.println(String.format("总数为: %d, 统计的总数为: %d, 是否相等: %b", total, page.getTotalCount(),
				total == page.getTotalCount()));
		System.out.println(String.format("分页要求数为: %d, 实际查询记录数为: %d, 是否相等: %b", pageCount, list.size(),
				pageCount == list.size()));
	}
}
