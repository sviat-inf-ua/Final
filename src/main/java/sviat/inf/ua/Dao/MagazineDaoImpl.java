package sviat.inf.ua.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sviat.inf.ua.Objects.Magasine;
import sviat.inf.ua.Utilities.JDBCUtils;

public class MagazineDaoImpl implements MagazinesDao {

	private static final String ADD_MAGAZINE = "insert into magazines (`title`,`description`,`price`,`periodicity`,`is_deleted`) values (?,?,?,?,?)";
	private static final String FIND_MAGAZINE_BY_ID = "select * from magazines where magazine_id=?";
	private static final String FIND_ALL_MAGAZINES = "select * from magazines";
	private static final String UPDATE_MAGAZINE_BY_ID = "update magazines set title=?, description=?, price=?, periodicity=?, is_deleted=? where magazine_id=?";
	private static final String DELETE_MAGAZINE_BY_ID = "update magazines set is_deleted=? where persone_id=?";
	private Connection conn;
	
	public MagazineDaoImpl() {
		// TODO Auto-generated constructor stub
		conn = JDBCUtils.getConnection();
	}
	public void add(Magasine m) {
		// TODO Auto-generated method stub
		
		System.out.println("Open in add method!");
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(ADD_MAGAZINE, PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, m.getTitle());
			stmt.setString(2, m.getDescription());
			stmt.setDouble(3, m.getPrice());
			stmt.setInt(4, m.getPeriodicity());
			stmt.setBoolean(5, m.getIs_deleted());
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO: handle exception
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

	public List<Magasine> findAll() {
		// TODO Auto-generated method stub
		
		System.out.println("Open in findAll method!");
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Magasine> listOfMagazines = new ArrayList<Magasine>();
		
		try {
			
			stmt = conn.prepareStatement(FIND_ALL_MAGAZINES);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Magasine m = new Magasine();
				// p.setId(rs.getInt("id"));
				m.setTitle(rs.getString("title"));
				m.setDescription(rs.getString("description"));
				m.setPrice(rs.getDouble("price"));
				m.setPeriodicity(rs.getInt("periodicity"));
				m.setIs_deleted(rs.getInt("is_deleted") == 0 ? false : true);
				listOfMagazines.add(m);
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
		System.out.println(listOfMagazines.toString());
		return listOfMagazines;
	}

	public Magasine findById(int id) {
		// TODO Auto-generated method stub
		System.out.println("open in findById method!");
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Magasine m = null;
		
		try {
			stmt = conn.prepareStatement(FIND_MAGAZINE_BY_ID);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			m = new Magasine();

			while (rs.next()) {
				m.setId(rs.getInt("magazine_id"));
				m.setTitle(rs.getString("title"));
				m.setDescription(rs.getString("description"));
				m.setPrice(rs.getDouble("price"));
				m.setPeriodicity(rs.getInt("periodicity"));
				m.setIs_deleted(rs.getInt("is_deleted") == 0 ? false : true);

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
		
		return m;
	}

	public void updateById(Magasine m) {
		// TODO Auto-generated method stub
		
		System.out.println("open in updateById method!");
		PreparedStatement stmt = null;
		
		try {
			stmt = conn.prepareStatement(UPDATE_MAGAZINE_BY_ID);
			stmt.setString(1, m.getTitle());
			stmt.setString(2, m.getDescription());
			stmt.setDouble(3, m.getPrice());
			stmt.setInt(4, m.getPeriodicity());
			stmt.setBoolean(5, m.getIs_deleted());
			stmt.setInt(6, m.getId());
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
			stmt = conn.prepareStatement(DELETE_MAGAZINE_BY_ID);
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
//		Magasine magazine = new Magasine();
//		
//		magazine.setTitle("Harry Potter");
//		magazine.setDescription("Famtacy about magic");
//		magazine.setPrice(200.0);
//		magazine.setPeriodicity(2);
//		magazine.setIs_deleted(false);
//		
//		MagazineDaoImpl obj = new MagazineDaoImpl();
//		
//		//obj.add(magazine);
//		obj.findAll();
//		
//		
//		
//	}

}
