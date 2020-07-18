package lab.classes;

public class Coordinates {
    private Integer x; //Поле не может быть null
    private Float y; //Поле не может быть null

    public Coordinates(Integer x, Float y) {
        this.x = x;
        this.y = y;
    }

    public Integer getX() {
        return x;
    }

    public Float getY() {
        return y;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public void setY(Float y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
