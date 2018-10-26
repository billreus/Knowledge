package entity;
/*
 * 消费分类实体类--ORM 中Category对象
 */
public class Category {
	private int id;
	private String name;
	
	// 非映射属性
	private int recordNumber;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRecordNumber() {
		return recordNumber;
	}

	public void setRecordNumber(int recordNumber) {
		this.recordNumber = recordNumber;
	}
	
	// 在消费分类中JComboBox中显示的时候调用，用于显示分类名称
	public String toString(){
		return name;
	}
}
