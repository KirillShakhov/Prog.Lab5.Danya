package lab.classes;
//Переписан 100%
public class Location implements Comparable<Location> {
    private Integer x; //Поле не может быть null
    private float y;
    private String name; //Длина строки не должна быть больше 221, Поле не может быть null

    Location(Integer x, float y, String name){
        this.x = x;
        this.y = y;
        this.name = name;
    }

    @Override
    public String toString() {
        return "x: (" + x + "), y: (" + y + "), name:(" + name + ")";
    }

    @Override
    public int compareTo(Location otherLocation) {
        if(this.x == otherLocation.x && this.y == otherLocation.x){
            return 0;
        }
        else if(this.x+this.y < otherLocation.x+otherLocation.y){
            return -1;
        }
        else{
            return 1;
        }
    }
}
