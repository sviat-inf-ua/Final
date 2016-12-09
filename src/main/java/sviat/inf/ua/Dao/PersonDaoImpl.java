package sviat.inf.ua.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sviat.inf.ua.Objects.Person;
import sviat.inf.ua.Utilities.JDBCUtils;

public class PersonDaoImpl implements PersonDao {

	private static final String ADD_PERSON = "insert into persons (`firstName`,`lastName`,`role`,`email`,`is_deleted`) values (?,?,?,?,?)";
	private static final String FIND_PERSON_BY_ID = "select * from persons where persone_id=?";
	private static final String FIND_ALL_PERSON = "select * from persons";
	private static final String UPDATE_PERSON_BY_ID = "update persons set firstName=?, lastName=?, role=?, email=? where persone_id=?";
	private static final String DELETE_PERSON_BY_ID = "update persons set is_deleted=? where persone_id=?";
	private Connection conn;

	public PersonDaoImpl() {
		// Constructor
		conn = JDBCUtils.getConnection();

	}

	public void add(Person p) {
		// TODO Auto-generated method stub

		System.out.println("Open in add method!");
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(ADD_PERSON, PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, p.getFirstName());
			stmt.setString(2, p.getLastName());
			stmt.setString(3, p.getRole());
			stmt.setString(4,p.getEmail());
			stmt.setBoolean(5, p.getIsDeleted());
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				System.out.println("closed in add method!");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public List<Person> findAll() {
		// TODO Auto-generated method stub

		System.out.println("Open in findAll method!");
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Person> listOfPerson = new ArrayList<Person>();

		try {
			stmt = conn.prepareStatement(FIND_ALL_PERSON);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Person p = new Person();
				// p.setId(rs.getInt("id"));
				p.setFirstName(rs.getString("firstName"));
				p.setLastName(rs.getString("lastName"));
				p.setRole(rs.getString("role"));
				p.setEmail(rs.getString("email"));
				// p.setName(rs.getString("name"));
				p.setIsDeleted(rs.getInt("is_deleted") == 0 ? false : true);
				listOfPerson.add(p);
			}
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				System.out.println("closed in findAll method!");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		System.out.println(listOfPerson.toString());
		return listOfPerson;
	}

	public Person findById(int id) {
		// TODO Auto-generated method stub
		System.out.println("open in findById method!");
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Person p = null;

		try {
			stmt = conn.prepareStatement(FIND_PERSON_BY_ID);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			p = new Person();

			while (rs.next()) {
				p.setId(rs.getInt("persone_id"));
				p.setFirstName(rs.getString("firstName"));
				p.setLastName(rs.getString("lastName"));
				p.setRole(rs.getString("role"));
				p.setEmail(rs.getString("email"));
				p.setIsDeleted(rs.getInt("is_deleted") == 0 ? false : true);

			}
			rs.close();

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				System.out.println("closed in findById method!");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println(p.toString());
		return p;
	}

	public void updateById(Person p) {
		// TODO Auto-generated method stub

		System.out.println("open in updateById method!");
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(UPDATE_PERSON_BY_ID);
			stmt.setString(1, p.getFirstName());
			stmt.setString(2, p.getLastName());
			stmt.setString(3, p.getRole());
			stmt.setString(4, p.getEmail());
			stmt.setInt(5, p.getId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				System.out.println("closed in updateById method!");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void delete(int id) {
		// TODO Auto-generated method stub

		System.out.println("open in delete method!");
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(DELETE_PERSON_BY_ID);
			stmt.setInt(1, 1);
			stmt.setInt(2, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				System.out.println("closed in delete method!");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

//	public static void main(String[] args) {
//		PersonDaoImpl obj = new PersonDaoImpl();
//		Person person = new Person();
//		 person.setFirstName("Piter");
//		 person.setLastName("Parker");
//		 person.setRole("user");
//		 person.setIsDeleted(false);
//
//		 obj.add(person);
//		// obj.findById(1);
//		// obj.findAll();
//		// obj.updateById(person);
//	//obj.delete(1);
//
//	}

	

}
