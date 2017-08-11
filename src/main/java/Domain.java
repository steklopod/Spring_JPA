import dao.AddressDAO;
import dao.EmployeeDAO;
import dao.ProjectDAO;
import entity.Address;
import entity.Employee;
import entity.Project;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Domain {

    public static void main(String[] args) throws SQLException {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("application-context.xml");

        AddressDAO addressDAO = context.getBean(AddressDAO.class);
        EmployeeDAO employeeDAO = context.getBean(EmployeeDAO.class);
        ProjectDAO projectDAO = context.getBean(ProjectDAO.class);

        Address address = new Address();
        address.setId(13L);
        address.setCountry("Belarus");
        address.setCity("Minsk");
        address.setStreet("Umanskaya 59");
        address.setPostCode("220089");

        Project project = new Project();
        project.setId(26L);
        project.setTitle("Hibernate CRUD");

        Employee employee = new Employee();
        employee.setId(22L);
        employee.setFirstName("Dzmitry ");
        employee.setLastName("Kaltovich");

        Calendar calendar = Calendar.getInstance();
        calendar.set(2017, Calendar.AUGUST, 1);

        employee.setBirthday(new Date(calendar.getTime().getTime()));
        employee.setAddress(address);

        Set<Employee> employees = new HashSet<Employee>();
        employees.add(employee);
        project.setEmployees(employees);
        Set<Project> projects = new HashSet<Project>();
        projects.add(project);
        employee.setProjects(projects);

        addressDAO.save(address);
        employeeDAO.save(employee);
        projectDAO.save(project);

        System.out.println("*****************************");
        List<Employee> employeeList = employeeDAO.findAll();
        for (Employee emp : employeeList) {
            System.out.println(emp);
        }
        System.out.println("*****************************");

        Employee employee2 = employeeDAO.findOne(22L);
        System.out.println("*****************************");

        System.out.println(employeeDAO.findByFirstNameAndLastName("Dmitry", "Kaltovich"));
        System.out.println("*****************************");


    }

}