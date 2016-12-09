package sviat.inf.ua.Services;

import java.util.List;

import sviat.inf.ua.Objects.Person;

public interface PersonService {

	void savePersonToDB(Person p);

	List<Person> findAllPersonFromDB();

	Person findPersonByIdFromDB(int id);

	void updatePersonByIdInDB(Person p);

	void deletePersonFromDB(int id);

}
