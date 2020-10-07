/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos3.tsturm18;

import java.util.List;
import static org.junit.Assert.fail;
import org.junit.Test;

/**
 *
 * @author timst
 */
public class MainTest {

    @Test
    public void testSortListOnlyDamage() {
        List<Weapon> weapons = Main.getList();
        weapons = Main.sortListOnlyDamage(weapons);

        for (int i = 0; i < weapons.size() - 1; i++) {
            if (weapons.get(i).getDamage() < weapons.get(i + 1).getDamage()) {
                fail("Fehlschlag");
            }
        }
    }

    @Test
    public void testSortListFull() {
        List<Weapon> weapons = Main.getList();
        weapons = Main.sortListFull(weapons);
        int compare;
        for (int i = 0; i < weapons.size() - 1; i++) {
            Weapon weapon1 = weapons.get(i);
            Weapon weapon2 = weapons.get(i + 1);
            compare = weapon1.getCombatType().toString().compareTo(weapon2.getCombatType().toString());
            if (compare > 0) {
                fail("CombatType Fail");
            }
            compare = weapon1.getDamageType().toString().compareTo(weapon2.getDamageType().toString());
            if (compare > 0) {
                fail("DamageType Fail");
            }
            compare = weapon1.getName().compareTo(weapon2.getName());
            if (compare > 0) {
                fail("Name Fail");
            }

        }
    }

}
