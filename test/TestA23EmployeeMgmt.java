import de.oszimt.fian.hase.model.HaseGmbHManagement;
import de.oszimt.fian.hase.model.employee.Employee;
import de.oszimt.fian.hase.model.employee.EmployeeMgmt;
import de.oszimt.fian.hase.view.console.StartConsole;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Tests entsprechen (noch) nicht dem OSZ IMT Standard.
 *
 * @author Steffen Trutz
 * @version 240909
 */
class TestA23EmployeeMgmt {

	private EmployeeMgmt employeeMgmt;

	@BeforeEach
	void init(){
		HaseGmbHManagement model = new HaseGmbHManagement(new StartConsole());
		employeeMgmt = new EmployeeMgmt(model);

		//testdata
		Employee e = new Employee(0, "firstname", "lastname", "email", "tel");
		employeeMgmt.add(e);
	}

	@Test
	void testAddSize() {
		int size = employeeMgmt.getAll().size();
		Employee e = new Employee(employeeMgmt.getNextFreeId(), "firstname", "lastname", "email", "tel");
		employeeMgmt.add(e);

		assertEquals(size+1, employeeMgmt.getAll().size(), "Employee hinzugefügt, aber Gesamtanzahl ist nicht gestiegen.");
	}

	@Test
	void testAddContent() {
		Employee e = new Employee(employeeMgmt.getNextFreeId(), "firstname", "lastname", "email", "tel");
		employeeMgmt.add(e);

		assertEquals("email", employeeMgmt.get(employeeMgmt.getAll().size()-1).getEmail(), "Employee hinzugefügt, aber nicht über seine ID findbar.");
	}

	@Test
	void testAddDouble() {
		int size = employeeMgmt.getAll().size();
		Employee e = new Employee(0, "firstname", "lastname", "email", "tel");
		employeeMgmt.add(e);

		assertEquals(size, employeeMgmt.getAll().size(),"Ein neuer Employee mit vorhander ID wurde hinzugefügt. Hinzufügen sollte verweigert werden, aber die Gesamtzahl ist mehr geworden");
	}

	@Test
	void testDelete() {
		int size = employeeMgmt.getAll().size();
		employeeMgmt.delete(0);

		assertEquals(size-1, employeeMgmt.getAll().size(),"Ein Employee wurde gelöscht, aber die Gesamtzahl ist nicht weniger geworden");
	}

	@Test
	void testDeleteNotExist() {
		int size = employeeMgmt.getAll().size();
		employeeMgmt.delete(1);

		assertEquals(size, employeeMgmt.getAll().size(),"Ein nicht vorhandener Employee wurde gelöscht, aber die Gesamtzahl ist weniger geworden");
	}

	@Test
	void testFreeNextID() {
		assertEquals(1, employeeMgmt.getNextFreeId());
	}

	@Test
	void testGet() {
		assertEquals("tel", employeeMgmt.get(0).getTelephone(), "Erster Employee, aber nicht über seine ID findbar.");
	}

	@Test
	void testGetNotExist() {
		Employee employee = employeeMgmt.get(1);
		assertNull(employee, "Employee 1 existiert nicht, sollte null erhalten.");
	}

	/**
	 * Dieser Test funktioniert nur, wenn die 2 Sterne Aufgabe erledigt wurde.
	 */
	@Test
	void testGet2() {
		Employee e = new Employee(2, "firstname", "lastname", "email", "tel3");
		employeeMgmt.add(e);

		assertEquals(2, employeeMgmt.getAll().size(), "Darf nur 2 Employees geben.");
		assertEquals("tel3", employeeMgmt.get(2).getTelephone(),"Employee muss über seine ID findbar sein.");
	}
}
