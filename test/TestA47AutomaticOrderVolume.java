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
public class TestA47AutomaticOrderVolume {

    private Address ad;
    @BeforeEach
    void init(){
        ad = new Address("steet", "house", "pot", "city");
    }

    @Test
    void testCustomerIsAutomaticOrderVolumeAbstract() throws NoSuchMethodException {
        Method m = Customer.class.getMethod("isAutomaticOrderVolume", int.class);
        assertTrue(Modifier.isAbstract(m.getModifiers()),"isAutomaticOrderVolume in Customer ist nicht abstract");
    }

    @Test
    void testCompanyIsAutomaticOrderVolumeRechnung() {
        Company c = new Company(0, "name", "fit", "lat", "email", ad);
        c.setPaymentType('R');
        c.setCreditLimit(1000);

        assertTrue(c.isAutomaticOrderVolume(3500),"Limit sollte 3500 sein und 3500 ist kleiner.");
        assertFalse(c.isAutomaticOrderVolume(3501), "Limit sollte 3500 sein und 3501 ist größer.");
    }

    @Test
    void testCompanyIsAutomaticOrderVolumeLastschrift() {
        Company c = new Company(0, "name", "fit", "lat", "email", ad);
        c.setPaymentType('L');
        c.setStatus('S');

        assertTrue(c.isAutomaticOrderVolume(6000),"Limit sollte 6000 sein und 6000 ist kleiner.");
        assertFalse(c.isAutomaticOrderVolume(6001), "Limit sollte 6000 sein und 6001 ist größer.");
    }

    @Test
    void testConsumerIsAutomaticOrderVolumeRechnung() {
        Consumer c = new Consumer(0, "fit","lat", LocalDate.now(), "email", ad);
        c.setPaymentType('R');

        assertTrue(c.isAutomaticOrderVolume(500),"Limit sollte 500 sein und 500 ist kleiner.");
        assertFalse(c.isAutomaticOrderVolume(501), "Limit sollte 500 sein und 501 ist größer.");
    }

    @Test
    void testConsumerIsAutomaticOrderVolumeLastschrift() {
        Consumer c = new Consumer(0, "fit","lat", LocalDate.now(), "email", ad);
        c.setPaymentType('L');
        c.setStatus('S');

        assertTrue(c.isAutomaticOrderVolume(3000),"Limit sollte 3000 sein und 6000 ist kleiner.");
        assertFalse(c.isAutomaticOrderVolume(3001), "Limit sollte 3000 sein und 6001 ist größer.");
    }
}
