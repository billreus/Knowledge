package gui.model;
 
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import entity.Category;
import service.CategoryService;
/**
 * 分类信息原型，需要使用数据库数据
 * @author lzp
 *
 */
public class CategoryTableModel implements TableModel{
 
    String[] columnNames = new String[]{"分类名称","消费次数"};
    
    // 使用从Service中返回的List作为TableModel的数据
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
 
    // 先通过cs.get(rowIndex)获取行对应的Category对象
    // 然后根据columnIndex返回对应的属性
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
    	Category h = cs.get(rowIndex); // 根据分类，获取记录中
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