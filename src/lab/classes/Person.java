package lab.classes;
//Переписано 90% переписать toString

import java.time.LocalDateTime;

public class Person implements Comparable<Person> {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private java.time.LocalDateTime birthday; //Поле может быть null
    private Long weight; //Поле не может быть null, Значение поля должно быть больше 0
    private String passportID; //Поле не может быть null
    private Location location; //Поле не может быть null

    public Person(String name, LocalDateTime birthday, Long weight, String passportID, Location location) {
        this.name = name;
        this.birthday = birthday;
        this.weight = weight;
        this.passportID = passportID;
        this.location = location;
    }


    //TODO переписать под новые поля
    @Override
    public String toString() {
        return "(" + name + "), Количество треков("  + "), Длина("  + "), Продажи("  + "$)";
    }

    @Override
    public int compareTo(Person otherPerson) {
        if(this.weight.equals(otherPerson.weight)){
            return 0;
        }
        else if(this.weight < otherPerson.weight){
            return -1;
        }
        else{
            return 1;
        }
    }
}
