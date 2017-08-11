package dao;

import entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDAO extends JpaRepository<Employee, Long>{

@Query(value = "SELECT * FROM employee where first_name=?1 and last_name=?2", nativeQuery = true)
    Employee findByFirstNameAndLastName(String firstname, String lastname);
    Employee findByLastName(String lastName);


}
