import de.oszimt.fian.hase.model.HaseGmbHManagement;
import de.oszimt.fian.hase.model.employee.Employee;
import de.oszimt.fian.hase.model.employee.EmployeeMgmt;
import de.oszimt.fian.hase.view.console.StartConsole;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests entsprechen (noch) nicht dem OSZ IMT Standard.
 *
 * @author Steffen Trutz
 * @version 240905
 */
class TestA24EmployeeMgmt {

	private EmployeeMgmt employeeMgmt;

	@BeforeEach
	void init(){
		HaseGmbHManagement model = new HaseGmbHManagement(new StartConsole());
		employeeMgmt = new EmployeeMgmt(model);

		//testdata
		Employee e = new Employee(0, "firstname", "lastname", "email", "tel");
		employeeMgmt.add(e);
	}

	/**
	 * Dieser Test funktioniert nur, wenn die 3 Sterne Aufgabe erledigt wurde.
	 */
	@Test
	void testFreeNextIDSterne3Empty() {
		Employee e = new Employee(1, "firstname", "lastname", "email", "tel");
		employeeMgmt.add(e);
		e = new Employee(2, "firstname2", "lastname2", "email2", "tel2");
		employeeMgmt.add(e);

		employeeMgmt.delete(1);
		// Mitarbeiter 0,1,2 wurden angelegt. 1 gelöscht. 0,2 existieren. Die nächste freie ID ist somit die 1.
		assertEquals(1, employeeMgmt.getNextFreeId(), "Mitarbeiter 0,1,2 wurden angelegt. 1 gelöscht. 0,2 existieren. Die nächste freie ID ist somit die 1.");
	}
}
