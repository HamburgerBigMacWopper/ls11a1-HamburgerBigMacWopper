import de.oszimt.fian.hase.model.Address;
import de.oszimt.fian.hase.model.base.Person;
import de.oszimt.fian.hase.model.customer.Company;
import de.oszimt.fian.hase.model.customer.Consumer;
import de.oszimt.fian.hase.model.customer.Customer;
import de.oszimt.fian.hase.model.employee.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests entsprechen (noch) nicht dem OSZ IMT Standard.
 *
 * @author Steffen Trutz
 * @version 240926
 */
public class TestA47CompanyConsumer {

    private Address ad;
    @BeforeEach
    void init(){
        ad = new Address("steet", "house", "pot", "city");
    }

    @Test
    void testCustomerIsAbstract() {
        Class<Customer> clazz = Customer.class;

        assertTrue(Modifier.isAbstract(clazz.getModifiers()), "Class Customer is not abstract");
    }

    @Test
    void testToStringCompany() {
        Company c = new Company(0, "name", "fit", "lat", "email", ad);
        c.setCreditLimit(100);
        c.setPaymentType('R');
        c.setStatus('S');

        assertTrue(c.toString().contains("name"),"Company toString enthält nicht Firmenname");
        assertTrue(c.toString().contains("fit"),"Company toString enthält nicht Firstname");
        assertTrue(c.toString().contains("lat"),"Company toString enthält nicht Lastname");
        assertTrue(c.toString().contains("email"),"Company toString enthält nicht EMail");
        assertTrue(c.toString().contains("100"),"Company toString enthält nicht CreditLimit");
        assertTrue(c.toString().contains("R"),"Company toString enthält nicht PaymentType");
        assertTrue(c.toString().contains("S"),"Company toString enthält nicht Status");
    }

    @Test
    void testEqualsExist() throws NoSuchMethodException {
        Person.class.getMethod("equals",Object.class);
        Employee.class.getMethod("equals",Object.class);
        Consumer.class.getMethod("equals",Object.class);
        Company.class.getMethod("equals",Object.class);

    }

    @Test
    void testEqualsConsumer() {
        Consumer c1 = new Consumer(0, "fit","lat", LocalDate.now(), "email", ad);
        Consumer c2 = new Consumer(0, "fit","lat", LocalDate.now(), "email", ad);
        Company c3 = new Company(0, "name", "fit", "lat", "email", ad);

        assertEquals(c1, c1, "Selbes Objekt ist nicht gleich");
        assertEquals(c1, c2, "Selbe ID ist nicht gleich");
        assertFalse(c1.equals(null), "Objekt und null ist gleich");
        assertFalse(c1.equals(c3), "Unterschiedliche Klassen sind gleich");
    }

    @Test
    void testExtendsCustomer(){
        assertTrue(Customer.class.isAssignableFrom(Consumer.class), "Class Consumer erbt nicht von Customer");
        assertTrue(Customer.class.isAssignableFrom(Company.class), "Class Company erbt nicht von Customer");
    }

    @Test
    void testProtectedAttributesCustomer(){
        List<Field> customerFields = Arrays.stream(Customer.class.getDeclaredFields())
                .filter(f -> Modifier.isProtected(f.getModifiers())).toList();

        assertEquals(3, customerFields.size(), "Es gibt nicht 3 protected Attribute in Customer");
    }

    @Test
    void testAttributesCustomer(){
        List<Field> customerFields = Arrays.stream(Customer.class.getDeclaredFields())
                .filter(f -> Modifier.isProtected(f.getModifiers())).toList();
        List<Field> customerFields2 = Arrays.stream(Customer.class.getDeclaredFields())
                .filter(f -> Modifier.isPrivate(f.getModifiers())).toList();

        assertEquals(3, customerFields.size()+customerFields2.size(), "Es gibt nicht 2 Attribute in Customer");
    }

    @Test
    void testCompanyDefaultValue(){
        Company c = new Company(0, "name", "firstname", "lastname", "email", null);

        assertEquals(0, c.getCreditLimit(), "Standardwert vom Kreditlimit soll 0 sein.");
        assertEquals('V', c.getPaymentType(), "Standardwert vom Paymenttype soll V sein.");
    }

    @Test
    void testCompanyDefaultValue2(){
        Company c = new Company(0, "name", "firstname", "lastname", "email", null);

        assertEquals('G', c.getStatus(), "Standardwert vom Status soll G sein.");
    }

    @Test
    void testCompanyAddonValue(){
        Company c = new Company(0, "name", "firstname", "lastname", "email", null);
        c.setCreditLimit(100);
        c.setPaymentType('R');
        c.setStatus('S');

        assertEquals(100, c.getCreditLimit(), "Standardwert vom Kreditlimit soll 100 sein.");
        assertEquals('R', c.getPaymentType(), "Standardwert vom Paymenttype soll R sein.");
        assertEquals('S', c.getStatus(), "Standardwert vom Status soll S sein.");
    }
}
