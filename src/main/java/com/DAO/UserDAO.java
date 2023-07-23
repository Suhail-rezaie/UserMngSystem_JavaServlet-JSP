package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Entity;

public class UserDAO {
	private Connection con;

	public UserDAO(Connection con) {
		super();
		this.con = con;
	}

	// this method is for Register of Admin
	public boolean Register(String username, String email, String password) {
		boolean f = false;
		try {
			String query = "INSERT INTO admin(username,email,password) values(?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, email);
			ps.setString(3, password);

			int rs = ps.executeUpdate();

			if (rs == 1) {

				f = true;

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return f;
	}

	// this method is adding the user into database
	public boolean addUser(String id, String username, String email, String password) {
		boolean f = false;
		try {
			String query = "INSERT INTO users(id,username,email,password) values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, id);
			ps.setString(2, username);
			ps.setString(3, email);
			ps.setString(4, password);

			int rs = ps.executeUpdate();

			if (rs == 1) {

				f = true;

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return f;
	}

	// this method is showing the list of the Users using ArrayList
	public List<Entity> getUser() {
		List<Entity> list = new ArrayList<Entity>();
		Entity t = null;

		try {
			String query = "Select * from users";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				t = new Entity();
				t.setId(rs.getString(1));
				t.setUsername(rs.getString(2));
				t.setEmail(rs.getString(3));
				t.setPassword(rs.getString(4));

				list.add(t);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	// this method is getting user by id for editing the user
	public Entity getUserById(String id) {
		Entity e = null;
		try {
			String query = "select * from users where id = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				e = new Entity();
				e.setId(rs.getString(1));
				e.setUsername(rs.getString(2));
				e.setEmail(rs.getString(3));
				e.setPassword(rs.getString(4));

			}

		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}
		return e;

	}

	// for Searching

	public Entity Search(String id) {
		Entity e = null;
		try {
			String query = "select * from users where id = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				e = new Entity();
				e.setId(rs.getString(1));
				e.setUsername(rs.getString(2));
				e.setEmail(rs.getString(3));
				e.setPassword(rs.getString(4));

			}

		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}
		return e;

	}

	// this method is for Updating the users
	public boolean EditUser(Entity e) {
		boolean f = false;
		try {
			String query = "update users set id=?,username=?,email=?,password=? where id =? ";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, e.getId());
			ps.setString(2, e.getUsername());
			ps.setString(3, e.getEmail());
			ps.setString(4, e.getPassword());
			ps.setString(5, e.getId());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}

		return f;

	}

	// this method is for deleting users
	public boolean DeleteUser(String id) {
		boolean f = false;
		try {
			String query = "delete from users where id = ?";
			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, id);

			int i = ps.executeUpdate();

			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return f;
	}

}
