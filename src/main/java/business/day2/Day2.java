package business.day2;

import business.Elf;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Day2 {
    public static void main(String[] args) {
        try {
            File file = new File(
                    "C:\\Users\\Sebastien\\Documents\\Cours\\Semestre5\\PratDev\\0-Projet\\adventOfCodeDay1.txt");

            BufferedReader br
                    = new BufferedReader(new FileReader(file));

            String st;
            int counter = 1;

            List<Integer> cals = new ArrayList<>();
            List<Elf> elves = new ArrayList<>();
            Elf elf ;

            while ((st = br.readLine()) != null){
                if (!st.equals("")){
                    cals.add(Integer.parseInt(st));
                }else {
                    elf = new Elf(counter, cals);
                    elves.add(elf);
                    cals = new ArrayList<>();
                }
            }

            List<Integer> sum = elves.stream()
                    .map(e -> e.getCalories()
                            .stream().mapToInt(Integer::intValue).sum())
                    .sorted(Comparator.reverseOrder())
                    .collect(Collectors.toList());

            System.out.println("--- 3 plus grands calory keepers : " + sum.get(0) + ", " + sum.get(1) + ", " + sum.get(2));

            int sumOfsum = sum.stream()
                    .limit(3)
                    .mapToInt(Integer::valueOf)
                    .sum();

            System.out.println("--- Somme totale des 3 calory keepers : " + sumOfsum);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
