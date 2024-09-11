import de.oszimt.fian.hase.model.employee.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests entsprechen (noch) nicht dem OSZ IMT Standard.
 *
 * @author Steffen Trutz
 * @version 240909
 */
public class TestA22Employee {

    private Employee e;

    @BeforeEach
    void init(){
        //testdata
        e = new Employee(0, "vorname", "nachname", "briefpost", "telefon");
    }

    /**
     * Testet alle getter und setter vom employee
     */
    @Test
    void testGetSetId() {
        assertEquals(0, e.getId(), "ID Getter funktioniert nicht");

        try {
            e.getClass().getMethod("setId", Integer.class);
            fail("ID Setter existiert");
        } catch (NoSuchMethodException ex) {
            //nothing to due, everything is fine
        }
    }

    /**
     * Testet alle getter und setter vom employee
     */
    @Test
    void testGetSetFirstname() {
        e.setFirstname("first");
        assertEquals("first", e.getFirstname(), "Firstname Getter/Setter funktioniert nicht");
    }

    /**
     * Testet alle getter und setter vom employee
     */
    @Test
    void testGetSetLastName() {
        e.setLastname("last");
        assertEquals("last", e.getLastname(), "Lastname Getter/Setter funktioniert nicht");
    }

    /**
     * Testet alle getter und setter vom employee
     */
    @Test
    void testGetSetMail() {
        e.setEmail("mail");
        assertEquals("mail", e.getEmail(), "Email Getter/Setter funktioniert nicht");
    }

    /**
     * Testet alle getter und setter vom employee
     */
    @Test
    void testGetSetTelephone() {
        e.setTelephone("telephon");
        assertEquals("telephon", e.getTelephone(), "Telephone Getter/Setter funktioniert nicht");
    }

    @Test
    void testEqualsGeneral() {
        assertNotEquals(e, null, "Employee.equal funktioniert nicht bei null");
        assertNotEquals(e, "", "Employee.equal funktioniert nicht bei anderen Typen");
    }

    @Test
    void testEqualsSameID() {
        Employee e2 = new Employee(0, null, null, null, null);

        assertEquals(e, e2, "Employee.equal funktioniert nicht bei gleichen IDs");
    }

    @Test
    void testEqualsNotSameID() {
        Employee e2 = new Employee(2, null, null, null, null);

        assertNotEquals(e, e2, "Employee.equal funktioniert nicht bei unterschiedlichen IDs");
    }

    @Test
    void testToStringName() {
        assertTrue(e.toString().contains("vorname"), "firstname wird in Employee.toString nicht angezeigt, sondern "+e.toString());
        assertTrue(e.toString().contains("nachname"), "Lastname wird in Employee.toString nicht angezeigt, sondern "+e.toString());
        }

    @Test
    void testToString() {
        assertTrue(e.toString().contains("briefpost"), "Email wird in Employee.toString nicht angezeigt, sondern "+e.toString());
        assertTrue(e.toString().contains("telefon"), "Telephone wird in Employee.toString nicht angezeigt, sondern "+e.toString());
    }
}
