package service;

import java.util.Date;

import dao.RecordDAO;
import entity.Category;
import entity.Record;

/**
 * 消费记录业务类，只有一个方法add
 * 
 * @author lzp
 *
 */
public class RecordService {
	RecordDAO recordDao = new RecordDAO();

	public void add(int spend, Category c, String comment, Date date) {
		Record r = new Record();
		r.setSpend(spend);
		r.setCid(c.getId());
		r.setComment(comment);
		r.setDate(date);
		recordDao.add(r);
	}
}
