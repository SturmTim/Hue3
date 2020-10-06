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
     */
    public static List<Weapon> list = new LinkedList<>();

    public static void main(String[] args) {
        readWeapons();
        sortListFull();
        Printable printler;
        printler = (List<Weapon> weapons) -> {
            list.forEach((weapon) -> {
                System.out.println(weapon.toString());
            });
        };
        printler.print(list);
    }

    public static void sortListOnlyDamage() {
        list.sort((Weapon o1, Weapon o2) -> Integer.compare(o1.getDamage(), o2.getDamage()));
    }

    public static void sortListFull() {
        list.sort((Weapon o1, Weapon o2) -> {
            if (o1.getCombatType().toString().compareTo(o2.getCombatType().toString()) == 0) {
                if (o1.getDamageType().toString().compareTo(o2.getDamageType().toString()) == 0) {
                    return o1.getName().compareTo(o2.getName());
                } else {
                    return o1.getDamageType().toString().compareTo(o2.getDamageType().toString());
                }
            } else {
                return o1.getCombatType().toString().compareTo(o2.getCombatType().toString());
            }
        });
    }

    public static void readWeapons() {
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
