package service;

import java.util.Collections;
import java.util.List;

import dao.CategoryDAO;
import dao.RecordDAO;
import entity.Category;
import entity.Record;

/**
 * 消费分类面板业务类--该面板能完成的操作
 * 
 * 主要有四项工作：
 * 1. 查询出所有分类，并根据消费次数排序
 * 2. 增加
 * 3. 更新
 * 4. 删除
 * @author lzp
 *
 */
public class CategoryService {
	CategoryDAO categoryDao = new CategoryDAO();
	RecordDAO recordDao = new RecordDAO();
	
	// 1. 查询出所有分类，并根据消费次数排序
	public List<Category> list(){
		List<Category> cs = categoryDao.list();
		for(Category c : cs){
			List<Record> rs = recordDao.list(c.getId()); // 获取该分类的消费记录
			c.setRecordNumber(rs.size()); // 统计该分类的记录条数
		}
		// 排序过程--lambda表达式的使用
		Collections.sort(cs,(c1,c2)->c2.getRecordNumber()-c1.getRecordNumber());
		
		return cs;
	}
	
	// 2. 增加
	public void add(String name){
		Category c = new Category();
		c.setName(name);
		categoryDao.add(c);
	}
	
	// 3. 更新
	public void update(int id, String name){
		Category c = new Category();
		c.setName(name);
		c.setId(id);
		categoryDao.update(c);
	}
	
	// 4. 删除
	public void delete(int id){
		categoryDao.delete(id);
	}
}
