package sviat.inf.ua.Dao;

import java.util.List;

import sviat.inf.ua.Objects.Person;

public interface PersonDao {
	
	void add(Person p);
	List<Person> findAll();
	Person findById(int id);
	void updateById(Person p);
	void delete(int id);
	

}
