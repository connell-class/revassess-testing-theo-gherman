package com.rev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rev.config.ConnectionConfig;
import com.rev.model.User;



public class UserRepository implements CrudRepository<User, Integer> {

	public User save(User t) {
		try (Connection conn = ConnectionConfig.connect()) {
			String sql = "insert into app_user (username, password, first_name, last_name, role_id) values (?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, t.getUsername());
			ps.setString(2, t.getPassword());
			ps.setString(3, t.getFirstName());
			ps.setString(4, t.getLastName());
			ps.setInt(5, t.getRole_id());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<User> findAll() {
		try (Connection conn = ConnectionConfig.connect()) {
			String sql = "select * from app_user order by user_id";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			List<User> list = new ArrayList<>();
			while (rs.next()) {
				list.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						null, rs.getInt(6)));
			}
			rs.close();
			return list;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public User findById(Integer id) {
		try (Connection conn = ConnectionConfig.connect()) {
			String sql = "select * from app_user where user_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			User result = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
					null, rs.getInt(6));
			rs.close();
			ps.close();
			return result;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public User update(User t) {
		try (Connection conn = ConnectionConfig.connect()) {
			String sql = "update app_user set username = ?, password = ?, first_name = ?, last_name = ?, role_id = ? where id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, t.getUsername());
			ps.setString(2, t.getPassword());
			ps.setString(3, t.getFirstName());
			ps.setString(4, t.getLastName());
			ps.setInt(5, t.getRole_id());
			ps.setInt(6, t.getId());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public User deleteById(Integer id) {
		try (Connection conn = ConnectionConfig.connect()) {
			String sql = "delete from app_user where id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}