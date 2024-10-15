package seedu.address.model.policy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import seedu.address.model.person.Person;
import seedu.address.testutil.PersonBuilder;

public class HealthPolicyTest {
    private final HealthPolicy health = new HealthPolicy();

    @Test
    public void constructor_nullInputs_throwsNullPointerException() {
        LocalDate expiryDate = LocalDate.now();
        Person insuree = new PersonBuilder().build();
        assertThrows(NullPointerException.class, () -> new LifePolicy(0, 0, null, insuree));
        assertThrows(NullPointerException.class, () -> new LifePolicy(0, 0, expiryDate, null));
    }

    @Test
    public void getType_returnsCorrectType() {
        assertEquals(PolicyType.HEALTH, health.getType());
    }

    @Test
    public void toStringMethod() {
        String expectedPrefix = "Policy type: " + health.getType() + " | ";
        assertTrue(health.toString().startsWith(expectedPrefix));
    }

    @Test
    public void equalsMethod() {
        // same object -> returns true
        assertTrue(health.equals(health));

        // null -> returns false
        assertFalse(health.equals(null));

        // same values -> return true
        HealthPolicy policyWithSameValues = new HealthPolicy();
        assertTrue(health.equals(policyWithSameValues));

        // different type -> returns false
        Policy life = new LifePolicy();
        life.setPremiumAmount(health.getPremiumAmount());
        life.setCoverageAmount(health.getCoverageAmount());
        assertFalse(health.equals(life));
    }
}
