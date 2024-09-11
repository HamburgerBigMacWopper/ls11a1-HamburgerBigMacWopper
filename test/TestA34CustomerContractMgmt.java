import de.oszimt.fian.hase.model.Address;
import de.oszimt.fian.hase.model.contract.Contract;
import de.oszimt.fian.hase.model.contract.ContractMgmt;
import de.oszimt.fian.hase.model.customer.Customer;
import de.oszimt.fian.hase.model.customer.CustomerMgmt;
import de.oszimt.fian.hase.model.employee.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests entsprechen (noch) nicht dem OSZ IMT Standard.
 *
 * @author Steffen Trutz
 * @version 231020
 */
public class TestA34CustomerContractMgmt {

    private Address address;

    @BeforeEach
    void init(){
        address = new Address("street", "house", "postal", "city");
    }

    @Test
    void testCustomer() {
        Customer customer = new Customer(0, "first", "last", LocalDate.now(), "email", address);

        assertEquals("first",customer.getFirstname(), "Vorname im Customer stimmt nicht.");
        assertEquals("email",customer.getEmail(), "E-Mail im Customer stimmt nicht.");
    }

    @Test
    void testCustomerAssociationAddress() {
        Customer customer = new Customer(0, "first", "last", LocalDate.now(), "email", address);

        assertEquals("street",customer.getAddress().getStreet(), "Straße in Adresse des Customer stimmt nicht.");
        assertEquals("city",customer.getAddress().getCity(), "City in Adresse des Customer stimmt nicht.");
    }

    @Test
    void testContract() {
        Contract contract = new Contract(0, LocalDate.now(), address, null, null, "contractType", "desc", new ArrayList<>());

        assertEquals("contractType",contract.getContractType(), "contractType im Contract stimmt nicht.");
        assertEquals(0,contract.getActivityRecordList().size(), "getActivityRecordList im Contract stimmt nicht.");
    }

    @Test
    void testContractAssociationCustomerEmployee() {
        Employee employee = new Employee(0, "firstname", "lastname", "email", "telephone");
        Customer customer = new Customer(0, "first", "last", LocalDate.now(), "email", address);

        Contract contract = new Contract(0, LocalDate.now(), address, customer, employee, "contractType", "desc", new ArrayList<>());

        assertEquals("firstname",contract.getProjectOwner().getFirstname(), "firstname im Employee im Contract stimmt nicht.");
        assertEquals("last",contract.getCustomer().getLastname(), "lastname im Customer im Contract stimmt nicht.");
    }

    @Test
    void testCustomerMgmt() {
        Customer customer = new Customer(0, "first", "last", LocalDate.now(), "email", address);

        CustomerMgmt customerMgmt = new CustomerMgmt(null);
        int size = customerMgmt.getAll().size();
        customerMgmt.add(customer);

        assertEquals(size+1, customerMgmt.getAll().size(), "customer zu customerMgmt hinzugefügt, aber Gesamtanzahl ist nicht gestiegen.");
    }

    @Test
    void testContractMgmt() {
        Contract contract = new Contract(0, LocalDate.now(), address, null, null, "contractType", "desc", new ArrayList<>());

        ContractMgmt contractMgmt = new ContractMgmt(null);
        int size = contractMgmt.getAll().size();
        contractMgmt.add(contract);

        assertEquals(size+1, contractMgmt.getAll().size(), "customer zu customerMgmt hinzugefügt, aber Gesamtanzahl ist nicht gestiegen.");
    }
}
