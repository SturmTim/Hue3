/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos3.tsturm18;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author timst
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    List<Weapon> list = new LinkedList<>();

    public static void main(String[] args) {

    }

    public void sortList() {
        list.sort((Weapon o1, Weapon o2) -> Integer.compare(o1.getDamage(), o2.getDamage()));
    }

    public void readWeapons() {
        try {
            list = Files.lines(new File("weapons.csv")
                    .toPath())
                    .skip(1)
                    .map(s -> s.split(";"))
                    .map(s -> new Weapon(s[0], CombatType.valueOf(s[1]), DamageType.valueOf(s[2]), Integer.parseInt(s[3]), Integer.parseInt(s[4]), Integer.parseInt(s[5]), Integer.parseInt(s[6]))).collect(Collectors.toList());
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
