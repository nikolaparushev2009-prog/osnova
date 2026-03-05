package combat.sports;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class BoxerTest {
    @Test
    void testAttack() {
        Boxer boxer = new Boxer("Mike", 90, 100);
        Fighter opponent = new Boxer("Rocky", 80, 100);
        int initialStamina = opponent.stamina;
        int initialFatigue = boxer.fatigue;
        boxer.attack(opponent);
        int expectedDamage = boxer.strength + boxer.skillBonus();
        assertEquals(initialStamina - expectedDamage, opponent.stamina);
        assertEquals(initialFatigue + 10, boxer.fatigue);
    }
    @Test
    void testCounterAttack() {
        Boxer boxer = new Boxer("Mike", 90, 100);
        Fighter opponent = new Boxer("Rocky", 80, 100);
        int initialStamina = opponent.stamina;
        boxer.counterAttack(opponent);
        int expectedDamage = (boxer.strength + boxer.skillBonus()) / 2; // 47
        assertEquals(initialStamina - expectedDamage, opponent.stamina);
    }
    @Test
    void testCriticalHit() {
        Boxer boxer = new Boxer("Mike", 90, 100);
        Fighter opponent = new Boxer("Rocky", 80, 100);
        boxer.criticalHit(opponent);
        assertTrue(opponent.stamina == 0 || opponent.stamina == 100);
    }

    @Test
    void testBleedingDamage() {
        Boxer boxer = new Boxer("Mike", 90, 40);
        int initialStamina = boxer.stamina;
        boxer.BleedingDamage();
        int expectedLoss = (int) (initialStamina * 0.08);
        assertEquals(initialStamina - expectedLoss, boxer.stamina);
    }
    @Test
    void testRest() {
        Boxer boxer = new Boxer("Mike", 90, 100);
        boxer.fatigue = 30;
        boxer.rest();
        assertEquals(15, boxer.fatigue);
    }
    @Test
    void testRecover() {
        Boxer boxer = new Boxer("Mike", 90, 50);
        boxer.recover();
        assertEquals(70, boxer.stamina);
    }
}