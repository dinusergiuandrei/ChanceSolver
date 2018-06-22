package model;

import java.util.Collections;
import java.util.List;

public class Entry {
    private Integer id;

    private String date;

    private List<Integer> numbers;

    public Entry(String date, List<Integer> numbers) {
        this.date = date;
        this.numbers = numbers;
        Collections.sort(this.numbers);
    }

    public String getDate() {
        return date;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(date).append(" :\t");
        for(int i=0; i<this.numbers.size(); ++i){
            if(this.numbers.get(i)<10)
                stringBuilder.append(" ");
            stringBuilder.append(this.numbers.get(i)).append("\t");
        }
        return stringBuilder.toString();
    }
}
