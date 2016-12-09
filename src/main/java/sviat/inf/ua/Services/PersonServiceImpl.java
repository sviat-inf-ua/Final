package sviat.inf.ua.Services;

import java.util.List;

import sviat.inf.ua.Dao.PersonDao;
import sviat.inf.ua.Dao.PersonDaoImpl;
import sviat.inf.ua.Objects.Person;

public class PersonServiceImpl implements PersonService {

	private PersonDao personDao = new PersonDaoImpl();
	
	public void savePersonToDB(Person p) {
		// TODO Auto-generated method stub
		personDao.add(p);
	}

	public List<Person> findAllPersonFromDB() {
		// TODO Auto-generated method stub
		return personDao.findAll();
	}

	public Person findPersonByIdFromDB(int id) {
		// TODO Auto-generated method stub
		return personDao.findById(id);
	}

	public void updatePersonByIdInDB(Person p) {
		// TODO Auto-generated method stub
		personDao.updateById(p);
	}

	public void deletePersonFromDB(int id) {
		// TODO Auto-generated method stub
		personDao.delete(id);
	}

}
