package entity;

import java.util.Date;

/*
 * 消费信息实体类--ORM 中Record对象
 */
public class Record {
	private int id;
	private int spend;
	private int cid;
	private String comment;
	private Date date;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSpend() {
		return spend;
	}

	public void setSpend(int spend) {
		this.spend = spend;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
