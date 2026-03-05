package combat.sports;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class BoxerTest {
    @Test
    void testAttack() {
        Fighter boxer = new Boxer("Mike", 90, 100);
        Fighter opponent = new Boxer("Rocky", 80, 100);
        int initialStamina = opponent.stamina;
        boxer.attack(opponent);
        assertTrue(opponent.stamina < initialStamina);
    }

    @Test
    void testCounterAttack() {
        Boxer boxer = new Boxer("Mike", 90, 100);
        Fighter opponent = new Boxer("Rocky", 80, 100);
        int initialStamina = opponent.stamina;
        boxer.counterAttack(opponent);
        assertTrue(opponent.stamina < initialStamina);
    }
    @Test
    void testCriticalHit() {
        Boxer boxer = new Boxer("Mike", 90, 100);
        Fighter opponent = new Boxer("Rocky", 80, 100);
        boxer.criticalHit(opponent);
        // или stamina става 0, или остава същата
        assertTrue(opponent.stamina == 0 || opponent.stamina == 100);
    }
        @Test
        void testBleedingDamage() {
            Boxer boxer = new Boxer("Mike", 90, 40); // bleeding = true
            int initialStamina = boxer.stamina;
            boxer.BleedingDamage();
            assertTrue(boxer.stamina < initialStamina);
        }
    @Test
    void testRest() {
        Boxer boxer = new Boxer("Mike", 90, 100);
        boxer.fatigue = 30;
        boxer.rest();
        assertTrue(boxer.fatigue < 30);
    }
    @Test
    void testRecover() {
        Boxer boxer = new Boxer("Mike", 90, 50);
        boxer.recover();
        assertTrue(boxer.stamina > 50);
    }
}

