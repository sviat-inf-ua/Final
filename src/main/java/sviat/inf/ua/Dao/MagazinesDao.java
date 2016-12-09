package sviat.inf.ua.Dao;
import java.util.List;

import sviat.inf.ua.Objects.Magasine;

public interface MagazinesDao {
	
	void add(Magasine m);
	List<Magasine> findAll();
	Magasine findById(int id);
	void updateById(Magasine m);
	void delete(int id);
	

}
