package gui.model;
 
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import entity.Category;
import service.CategoryService;
/**
 * ������Ϣԭ�ͣ���Ҫʹ�����ݿ�����
 * @author lzp
 *
 */
public class CategoryTableModel implements TableModel{
 
    String[] columnNames = new String[]{"��������","���Ѵ���"};
    
    // ʹ�ô�Service�з��ص�List��ΪTableModel������
    public List<Category> cs = new CategoryService().list();
     
    @Override
    public int getRowCount() {
        return cs.size();
    }
 
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }
 
    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }
 
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }
 
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
 
    // ��ͨ��cs.get(rowIndex)��ȡ�ж�Ӧ��Category����
    // Ȼ�����columnIndex���ض�Ӧ������
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
    	Category h = cs.get(rowIndex); // ���ݷ��࣬��ȡ��¼��
        if(0==columnIndex)
            return h.getName();
        if(1==columnIndex)
            return h.getRecordNumber();
        return null;
    }
 
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
         
    }
 
    @Override
    public void addTableModelListener(TableModelListener l) {
         
    }
 
    @Override
    public void removeTableModelListener(TableModelListener l) {
         
    }
 
}