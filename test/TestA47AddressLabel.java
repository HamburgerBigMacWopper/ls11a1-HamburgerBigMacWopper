import de.oszimt.fian.hase.model.Address;
import de.oszimt.fian.hase.model.customer.Company;
import de.oszimt.fian.hase.model.customer.Consumer;
import de.oszimt.fian.hase.model.customer.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests entsprechen (noch) nicht dem OSZ IMT Standard.
 *
 * @author Steffen Trutz
 * @version 240930
 */
public class TestA47AddressLabel {

    private Address ad;
    @BeforeEach
    void init(){
        ad = new Address("street", "house", "pot", "city");
    }

    @Test
    void testCustomerIsAutomaticOrderVolumeAbstract() throws NoSuchMethodException {
        Method m = Customer.class.getMethod("getAddressLabel");
        assertTrue(Modifier.isAbstract(m.getModifiers()),"getAddressLabel in Customer ist nicht abstract");
    }

    @Test
    void testCompanyGetAddressLabelFormat() {
        Company c = new Company(0, "name2name", "fit", "lat", "email", ad);

        assertTrue(c.getAddressLabel().startsWith("name2name"),"Company.getAddressLabel() beginnt nicht mit Firmenname: "+c.getAddressLabel());
        assertTrue(c.getAddressLabel().contains("z.Hd. fit"),"Company.getAddressLabel() enthält bei Firmen kein Ansprechpartner: "+c.getAddressLabel());
    }

    @Test
    void testCompanyGetAddressLabelAddress() {
        Company c = new Company(0, "name", "fit", "lat", "email", ad);

        assertTrue(c.getAddressLabel().contains("street"),"Company.getAddressLabel() enthält nicht die Straße: "+c.getAddressLabel());
        assertTrue(c.getAddressLabel().contains("house"),"Company.getAddressLabel() enthält nicht die Hausnummer: "+c.getAddressLabel());
        assertTrue(c.getAddressLabel().contains("pot"),"Company.getAddressLabel() enthält nicht die PLZ: "+c.getAddressLabel());
        assertTrue(c.getAddressLabel().contains("city"),"Company.getAddressLabel() enthält nicht die Stadt: "+c.getAddressLabel());
    }

    @Test
    void testConsumerIsAutomaticOrderVolumeRechnung() {
        Consumer c = new Consumer(0, "fit","lat", LocalDate.now(), "email", ad);

        assertTrue(c.getAddressLabel().startsWith("fit lat"),"Consumer.getAddressLabel() beginnt nicht mit Namen: "+c.getAddressLabel());
    }

    @Test
    void testConsumerGetAddressLabelAddress() {
        Consumer c = new Consumer(0, "fit","lat", LocalDate.now(), "email", ad);

        assertTrue(c.getAddressLabel().contains("street"),"Consumer.getAddressLabel() enthält nicht die Straße: "+c.getAddressLabel());
        assertTrue(c.getAddressLabel().contains("house"),"Consumer.getAddressLabel() enthält nicht die Hausnummer: "+c.getAddressLabel());
        assertTrue(c.getAddressLabel().contains("pot"),"Consumer.getAddressLabel() enthält nicht die PLZ: "+c.getAddressLabel());
        assertTrue(c.getAddressLabel().contains("city"),"Consumer.getAddressLabel() enthält nicht die Stadt: "+c.getAddressLabel());
    }
}
