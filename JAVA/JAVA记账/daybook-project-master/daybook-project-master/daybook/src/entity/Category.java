package entity;
/*
 * ���ѷ���ʵ����--ORM ��Category����
 */
public class Category {
	private int id;
	private String name;
	
	// ��ӳ������
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
	
	// �����ѷ�����JComboBox����ʾ��ʱ����ã�������ʾ��������
	public String toString(){
		return name;
	}
}
