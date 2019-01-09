package service;

import java.util.Collections;
import java.util.List;

import dao.CategoryDAO;
import dao.RecordDAO;
import entity.Category;
import entity.Record;

/**
 * ���ѷ������ҵ����--���������ɵĲ���
 * 
 * ��Ҫ���������
 * 1. ��ѯ�����з��࣬���������Ѵ�������
 * 2. ����
 * 3. ����
 * 4. ɾ��
 * @author lzp
 *
 */
public class CategoryService {
	CategoryDAO categoryDao = new CategoryDAO();
	RecordDAO recordDao = new RecordDAO();
	
	// 1. ��ѯ�����з��࣬���������Ѵ�������
	public List<Category> list(){
		List<Category> cs = categoryDao.list();
		for(Category c : cs){
			List<Record> rs = recordDao.list(c.getId()); // ��ȡ�÷�������Ѽ�¼
			c.setRecordNumber(rs.size()); // ͳ�Ƹ÷���ļ�¼����
		}
		// �������--lambda���ʽ��ʹ��
		Collections.sort(cs,(c1,c2)->c2.getRecordNumber()-c1.getRecordNumber());
		
		return cs;
	}
	
	// 2. ����
	public void add(String name){
		Category c = new Category();
		c.setName(name);
		categoryDao.add(c);
	}
	
	// 3. ����
	public void update(int id, String name){
		Category c = new Category();
		c.setName(name);
		c.setId(id);
		categoryDao.update(c);
	}
	
	// 4. ɾ��
	public void delete(int id){
		categoryDao.delete(id);
	}
}
