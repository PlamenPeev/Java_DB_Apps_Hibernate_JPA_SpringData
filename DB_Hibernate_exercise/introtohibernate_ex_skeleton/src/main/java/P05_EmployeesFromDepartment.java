import entities.Department;
import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.List;

public class P05_EmployeesFromDepartment {
    private static final String GET_EMPLOYEES_FROM_RESEARCH_AND_DEVELOPMENT_DEPARTMENT =
        "SELECT e FROM Employee AS e" +
                " WHERE e.department.name = 'Research and Development'" +
                " ORDER BY e.salary, e.id";
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entityManager = factory.createEntityManager();

        // ** another way **
//        final String PRINT_FORMAT = "%s %s from %s - $%.2f%n";
//        entityManager.createQuery("SELECT e FROM Employee AS e" +
//        " WHERE e.department.name = :dp" +
//        " ORDER BY e.salary, e.id", Employee.class)
//        .setParameter("dp", "Research and Development")
//        .getResultList()
//        .forEach(e-> System.out.printf(PRINT_FORMAT,
//                e.getFirstName(),
//                e.getLastName(),
//                e.getDepartment().getName(),
//                e.getSalary()));

        TypedQuery<Employee> query =
                entityManager.createQuery(GET_EMPLOYEES_FROM_RESEARCH_AND_DEVELOPMENT_DEPARTMENT, Employee.class);
        List<Employee> resultList = query.getResultList();

            for (Employee employee : resultList) {
                // I made a print method in Employee.class -> public String print(){
                //        return String.format("%s %s from Research and Development - $%.2f",
                //        getFirstName(), getLastName(), getSalary());}
                System.out.println(employee.print());
            }

        entityManager.close();
    }
}

