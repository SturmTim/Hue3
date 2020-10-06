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
        Printable printNormal;
        printNormal = (List<Weapon> weapons) -> {
            list.forEach((weapon) -> {
                System.out.println(weapon.toString());
            });
        };
        printNormal.print(list);
        printTabelle();

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

    public static void printTabelle() {
        Printable tabelle;
        tabelle = (List<Weapon> weapons) -> {
            int space = 30;
            int spaceSub = 0;
            for (int i = 0; i < 7; i++) {
                System.out.print("+");
                for (int j = 0; j < space; j++) {
                    System.out.print("-");
                }
            }
            System.out.println("+");
            for (int i = 0; i < 7; i++) {
                System.out.print("|");
                switch (i) {
                    case 0:
                        spaceSub = space - "Name".length();
                        System.out.print("Name");
                        break;
                    case 1:
                        spaceSub = space - "CombatType".length();
                        System.out.print("CombatType");
                        break;
                    case 2:
                        spaceSub = space - "DamageType".length();
                        System.out.print("DamageType");
                        break;
                    case 3:
                        spaceSub = space - "damage".length();
                        System.out.print("damage");
                        break;
                    case 4:
                        spaceSub = space - "speed".length();
                        System.out.print("speed");
                        break;
                    case 5:
                        spaceSub = space - "strength".length();
                        System.out.print("strength");
                        break;
                    case 6:
                        spaceSub = space - "value".length();
                        System.out.print("value");
                        break;
                }
                for (int j = 0; j < spaceSub; j++) {
                    System.out.print(" ");
                }

            }
            System.out.println("|");
            list.forEach((weapon) -> {
                int spaceSubstract = 0;
                for (int i = 0; i < 7; i++) {
                    System.out.print("+");
                    for (int j = 0; j < 30; j++) {
                        System.out.print("-");
                    }
                }
                System.out.println("+");
                for (int i = 0; i < 7; i++) {
                    System.out.print("|");
                    switch (i) {
                        case 0:
                            spaceSubstract = 30 - weapon.getName().length();
                            System.out.print(weapon.getName());
                            break;
                        case 1:
                            spaceSubstract = 30 - weapon.getCombatType().toString().length();
                            System.out.print(weapon.combatType.toString());
                            break;
                        case 2:
                            spaceSubstract = 30 - weapon.getDamageType().toString().length();
                            System.out.print(weapon.getDamageType().toString());
                            break;
                        case 3:
                            spaceSubstract = 30 - Integer.toString(weapon.getDamage()).length();
                            System.out.print(weapon.getDamage());
                            break;
                        case 4:
                            spaceSubstract = 30 - Integer.toString(weapon.getSpeed()).length();
                            System.out.print(weapon.getSpeed());
                            break;
                        case 5:
                            spaceSubstract = 30 - Integer.toString(weapon.getStrength()).length();
                            System.out.print(weapon.getStrength());
                            break;
                        case 6:
                            spaceSubstract = 30 - Integer.toString(weapon.getValue()).length();
                            System.out.print(weapon.getValue());
                            break;
                    }
                    for (int j = 0; j < spaceSubstract; j++) {
                        System.out.print(" ");
                    }
                }
                System.out.println("|");

            });
            for (int i = 0; i < 7; i++) {
                System.out.print("+");
                for (int j = 0; j < space; j++) {
                    System.out.print("-");
                }
            }
            System.out.println("+");

        };
        tabelle.print(list);
    }

}
