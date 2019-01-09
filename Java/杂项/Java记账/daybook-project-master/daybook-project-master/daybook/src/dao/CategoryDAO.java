package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Category;
import util.DBUtil;
/**
 * 消费分类的数据库操作--增删改查等
 * @author lzp
 *
 */
public class CategoryDAO {
	// 统计总数
	public int getTotal() {
		int total = 0;
		try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

			String sql = "select count(*) from category";

			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				total = rs.getInt(1);
			}

			System.out.println("total:" + total);

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return total;
	}

	// 增加
	public void add(Category category) {

		String sql = "insert into category values(null,?)";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

			ps.setString(1, category.getName());

			ps.execute();

			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				int id = rs.getInt(1);
				category.setId(id);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	// 更新
	public void update(Category category) {

		String sql = "update category set name= ? where id = ?";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

			ps.setString(1, category.getName());
			ps.setInt(2, category.getId());

			ps.execute();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	// 删除
	public void delete(int id) {

		try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

			String sql = "delete from category where id = " + id;

			s.execute(sql);

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	// 查
	public Category get(int id) {
		Category category = null;

		try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

			String sql = "select * from category where id = " + id;

			ResultSet rs = s.executeQuery(sql);

			if (rs.next()) {
				category = new Category();
				String name = rs.getString(2);
				category.setName(name);
				category.setId(id);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return category;
	}

	// 查询所有
	public List<Category> list() {
		return list(0, Short.MAX_VALUE);
	}

	// 分页查询
	public List<Category> list(int start, int count) {
		List<Category> categorys = new ArrayList<Category>();

		String sql = "select * from category order by id desc limit ?,? ";

		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

			ps.setInt(1, start);
			ps.setInt(2, count);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Category category = new Category();
				int id = rs.getInt(1);
				String name = rs.getString(2);
				category.setId(id);
				category.setName(name);
				categorys.add(category);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return categorys;
	}

}
