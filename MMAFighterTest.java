package combat.sports;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class MMAFighterTest {
    @Test
    void testAttack() {
        MMAFighter fighter = new MMAFighter("Connor", 85, 100);
        Fighter opponent = new MMAFighter("Khabib", 90, 100);
        int initialStamina = opponent.stamina;
        int initialFatigue = fighter.fatigue;
        fighter.attack(opponent);
        int expectedDamage = fighter.strength + fighter.skillBonus() + 3;
        assertEquals(initialStamina - expectedDamage, opponent.stamina);
        assertEquals(initialFatigue + 12, fighter.fatigue);
    }
    @Test
    void testCounterAttack() {
        MMAFighter fighter = new MMAFighter("Connor", 85, 100);
        Fighter opponent = new MMAFighter("Khabib", 90, 100);
        int initialStamina = opponent.stamina;
        fighter.counterAttack(opponent);
        int expectedDamage = (fighter.strength + fighter.skillBonus()) / 2 + 5;
        assertEquals(initialStamina - expectedDamage, opponent.stamina);
    }
    @Test
    void testCriticalHit() {
        MMAFighter fighter = new MMAFighter("Connor", 85, 100);
        Fighter opponent = new MMAFighter("Khabib", 90, 100);
        fighter.criticalHit(opponent);
        assertTrue(opponent.stamina == 0 || opponent.stamina == 100);
    }
    @Test
    void testRest() {
        MMAFighter fighter = new MMAFighter("Connor", 85, 100);
        fighter.fatigue = 30;
        fighter.rest();
        assertEquals(18, fighter.fatigue); // 30 - 12
    }
    @Test
    void testRecover() {
        MMAFighter fighter = new MMAFighter("Connor", 85, 50);
        fighter.recover();
        assertEquals(68, fighter.stamina); // 50 + 18
    }
    @Test
    void testBleedings() {
        MMAFighter fighter = new MMAFighter("Connor", 85, 100);
        int initialStamina = fighter.stamina;
        fighter.Bleedings();
        int expectedLoss = (int) (initialStamina * 0.10);
        assertEquals(initialStamina - expectedLoss, fighter.stamina);
    }
}