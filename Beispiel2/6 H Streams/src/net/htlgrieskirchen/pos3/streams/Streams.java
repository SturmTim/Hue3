package net.htlgrieskirchen.pos3.streams;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Streams {

    private final int[] numbers;
    private final String[] strings;
    private final List<Weapon> weapons;

    public Streams() {
        numbers = new GetRandoms().getRandomNumberArray(1000, 0, 100);
        strings = new GetRandoms().getRandomStringArray(10, 10);
        weapons = readWeapons("weapons.csv");
    }

    public double average(int[] numbers) {
        return Arrays.stream(numbers).average().getAsDouble();
    }

    public List<String> upperCase(String[] strings) {
        return Arrays.stream(strings).map(string -> string.toUpperCase()).collect(Collectors.toList());
    }

    public Weapon findWeaponWithLowestDamage(List<Weapon> weapons) {
        return weapons.stream()
                .min((w1, w2) -> w1.getDamage() - w2.getDamage())
                .orElse(null);
    }

    public Weapon findWeaponWithHighestStrength(List<Weapon> weapons) {
        return weapons.stream()
                .max((w1, w2) -> w1.getMinStrength() - w2.getMinStrength())
                .orElse(null);
    }

    public List<Weapon> collectMissileWeapons(List<Weapon> weapons) {
        return weapons.stream()
                .filter(weapon -> weapon.getDamageType() == DamageType.MISSILE)
                .collect(Collectors.toList());
    }

    public Weapon findWeaponWithLongestName(List<Weapon> weapons) {
        return weapons.stream()
                .max((w1, w2) -> w1.getName().length() - w2.getName().length())
                .orElse(null);
    }

    public List<String> toNameList(List<Weapon> weapons) {
        return weapons.stream()
                .map(weapon -> weapon.getName())
                .collect(Collectors.toList());
    }

    public int[] toSpeedArray(List<Weapon> weapons) {
        return weapons.stream()
                .mapToInt(weapon -> weapon.getSpeed())
                .toArray();
    }

    public int sumUpValues(List<Weapon> weapons) {
        return weapons.stream()
                .mapToInt(weapon -> weapon.getValue())
                .sum();
    }

    public long sumUpHashCodes(List<Weapon> weapons) {
        return weapons.stream()
                .mapToInt(weapon -> weapon.hashCode())
                .sum();
    }

    public List<Weapon> removeDuplicates(List<Weapon> weapons) {
        return weapons.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    public void increaseValuesByTenPercent(List<Weapon> weapons) {
        weapons.stream()
                .forEach(weapon -> weapon.setValue((int) (weapon.getValue() * 1.1)));
    }

    public List<Weapon> readWeapons(String file) {
        List<Weapon> weaponList = new LinkedList<>();
        try {
            weaponList = Files.lines(new File("weapons.csv")
                    .toPath())
                    .skip(1)
                    .map(s -> s.split(";"))
                    .map(s -> new Weapon(s[0], CombatType.valueOf(s[1]), DamageType.valueOf(s[2]), Integer.parseInt(s[3]), Integer.parseInt(s[4]), Integer.parseInt(s[5]), Integer.parseInt(s[6])))
                    .collect(Collectors.toList());
        } catch (IOException ex) {
            Logger.getLogger(Streams.class.getName()).log(Level.SEVERE, null, ex);
        }
        return weaponList;
    }
}
