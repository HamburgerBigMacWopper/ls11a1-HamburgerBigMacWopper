import de.oszimt.fian.hase.model.base.Person;
import de.oszimt.fian.hase.model.customer.Customer;
import de.oszimt.fian.hase.model.employee.Employee;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests entsprechen (noch) nicht dem OSZ IMT Standard.
 *
 * @author Steffen Trutz
 * @version 240926
 */
public class TestA44Inheritance {


    @Test
    void testToStringExist() throws NoSuchMethodException {
        Person.class.getMethod("toString");
        Employee.class.getMethod("toString");
        Customer.class.getMethod("toString");
    }

    @Test
    void testToStringEmployee() {
        Employee e = new Employee(0, "first","last", "email", "tele");

        assertTrue(e.toString().contains("first"),"Consumer toString enthält nicht firstname");
        assertTrue(e.toString().contains("last"),"Consumer toString enthält nicht lastname");
        assertTrue(e.toString().contains("email"),"Consumer toString enthält nicht email");
        assertTrue(e.toString().contains("tele"),"Consumer toString enthält nicht telephone");
    }

    @Test
    void testPersonIsAbstract() {
        Class<Person> clazz = Person.class;

        assertTrue(Modifier.isAbstract(clazz.getModifiers()), "Class Person is not abstract");
    }

    @Test
    void testCustomerExtendsPerson(){
        assertTrue(Person.class.isAssignableFrom(Customer.class), "Class Customer erbt nicht von Person");
    }

    @Test
    void testEmployeeExtendsPerson(){
        assertTrue(Person.class.isAssignableFrom(Employee.class), "Class Employee erbt nicht von Person");
    }

    @Test
    void testAttributesEmployee(){
        List<Field> employeeFields = Arrays.stream(Employee.class.getDeclaredFields())
                .filter(f -> Modifier.isPrivate(f.getModifiers())).toList();

        assertEquals(1, employeeFields.size(), "Es gibt nicht 1 Attribut in Employee");
    }

    @Test
    void testProtectedAttributesPerson(){
        List<Field> customerFields = Arrays.stream(Person.class.getDeclaredFields())
                .filter(f -> Modifier.isProtected(f.getModifiers())).toList();

        assertEquals(4, customerFields.size(), "Es gibt nicht 4 protected Attribute in Person");
    }
}
