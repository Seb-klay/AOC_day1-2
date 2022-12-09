package business;

import java.util.List;

public class Elf {
    private final int num;
    private final List<Integer> calories;

    public Elf(int num, List<Integer> calories){
        this.num = num;
        this.calories = calories;
    }

    public List<Integer> getCalories(){
        return this.calories;
    }

    @Override
    public String toString() {
        return "Elf{" +
                "num=" + num +
                ", calories=" + calories +
                '}' + "\n";
    }
}
