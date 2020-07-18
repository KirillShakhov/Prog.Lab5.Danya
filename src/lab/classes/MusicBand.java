package lab.classes;
// Переписан 90%, функционален на 99% из-за birthday

import lab.Console;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Объект, который будет сохраняться в базе данных.
 * @autor Шахов Кирилл Андреевич P3132
 * @version 1.1
 */

public class MusicBand implements Comparable<MusicBand> {
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private long numberOfParticipants; //Значение поля должно быть больше 0
    private String description; //Поле может быть null
    private MusicGenre genre; //Поле может быть null
    private Person frontMan; //Поле не может быть null


    public MusicBand(Long id, String name, Coordinates coordinates, LocalDate creationDate, long numberOfParticipants, String description, MusicGenre genre, Person frontMan) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.numberOfParticipants = numberOfParticipants;
        this.description = description;
        this.genre = genre;
        this.frontMan = frontMan;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public long getNumberOfParticipants() {
        return numberOfParticipants;
    }

    public void setNumberOfParticipants(long numberOfParticipants) {
        this.numberOfParticipants = numberOfParticipants;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MusicGenre getGenre() {
        return genre;
    }

    public void setGenre(MusicGenre genre) {
        this.genre = genre;
    }

    public Person getFrontMan() {
        return frontMan;
    }

    public void setFrontMan(Person frontMan) {
        this.frontMan = frontMan;
    }
    public static MusicBand parseMusicBand(Long id){
        return parseMusicBand(id, null, null, null , null, null, null, null, null, null, null, null, null, null);
    }
    //TODO переписать под новые поля
    public static MusicBand parseMusicBand(Long id, String name, String x, String y, String numberOfParticipants, String description, String genre, String person_name, String person_birthday, String person_weight, String person_passportID, String person_location_name, String person_location_x, String person_location_y) {
        if (name == null || name.isEmpty()) {
            while (true) {
                Console.sendln("Имя не может быть пустым. Укажите имя:");
                Console.send("?");
                String l = Console.receive();
                if (l != null && !l.equals("")) {
                    name = l;
                    break;
                }
            }
        }
        Integer x_coordinate;
        try {
            x_coordinate = Integer.parseInt(x);
        }
        catch (Exception e){
            while (true) {
                Console.sendln("X является числом. Укажите X:");
                Console.send("?");
                try {
                    x_coordinate = Integer.parseInt(Console.receive());
                    //if (xf <= 391 && !Double.isNaN(xf)) { break; }
                    break;
                }
                catch (NullPointerException | NumberFormatException ignored){ }
            }
        }
        Float y_coordinate;
        try{
            y_coordinate = Float.parseFloat(y);
            if(Float.isNaN(y_coordinate)){throw new Exception();}
        }
        catch (Exception e){
            while (true) {
                Console.sendln("Y является числом. Укажите Y:");
                Console.send("?");
                try {
                    y_coordinate = Float.parseFloat(Console.receive());
                    if (!Float.isNaN(y_coordinate)) {
                        break;
                    }
                }
                catch (NullPointerException | NumberFormatException ignored){ }
            }
        }
        int numberOfParticipants_long;
        try {
            numberOfParticipants_long = Integer.parseInt(numberOfParticipants);
            if (numberOfParticipants_long <= 0 || numberOfParticipants == null || numberOfParticipants.isEmpty()) {
                throw new NumberFormatException();
            }
        }
        catch (NumberFormatException e){
            while (true) {
                Console.sendln("Количество участников должно быть числом и должно быть больше нуля. Укажите количество участников:");
                Console.send("?");
                try {
                    numberOfParticipants_long = Integer.parseInt(Console.receive());
                    if (numberOfParticipants_long > 0) {
                        break;
                    }
                }
                catch (NullPointerException | NumberFormatException ignored){ }
            }
        }
        if((description == null) && Console.getAnswer("Хотите добавить описание?")) {
            while (true) {
                Console.sendln("Введите описание:");
                Console.send("?");
                description = Console.receive();
                if (description != null) {
                    break;
                }
            }
        }
        //TODO поменять жанры на свои
        MusicGenre mgenre = null;
        if((genre == null) && Console.getAnswer("Хотите добавить жанр?")) {
            while (true) {
                if (genre == null || genre.isEmpty()) {
                    Console.sendln("Укажите жанр(PSYCHEDELIC_ROCK, RAP, POP, POST_ROCK, POST_PUNK):");
                    Console.send("?");
                    genre = Console.receive();
                /*} else if (genre.equals("RAP") || genre.equals("rap") || genre.equals("Rap")) {
                    mgenre = MusicGenre.RAP;
                    break;
                } else if (genre.equals("POP") || genre.equals("pop") || genre.equals("Pop")) {
                    mgenre = MusicGenre.POP;
                    break;
                } else if (genre.equals("POST ROCK") || genre.equals("POST_ROCK") || genre.equals("post rock") || genre.equals("post_rock") || genre.equals("Post rock") || genre.equals("Post_rock")) {
                    mgenre = MusicGenre.POST_ROCK;
                    break;
                } else if (genre.equals("POST PUNK") || genre.equals("POST_PUNK") || genre.equals("post punk") || genre.equals("post_punk") || genre.equals("Post punk") || genre.equals("Post_punk")) {
                    mgenre = MusicGenre.POST_PUNK;
                    break;
                } else if (genre.equals("PSYCHEDELIC ROCK") || genre.equals("PSYCHEDELIC_ROCK") || genre.equals("psychedelic rock") || genre.equals("psychedelic_rock") || genre.equals("Psychedelic rock") || genre.equals("Psychedelic_rock")) {
                    mgenre = MusicGenre.PSYCHEDELIC_ROCK;
                    break;
                 */
                }else {

                    Console.sendln("Укажите жанр(PSYCHEDELIC_ROCK, RAP, POP, POST_ROCK, POST_PUNK):");
                    Console.send("?");
                    genre = Console.receive();
                }
            }
        }
        if (person_name == null || person_name.isEmpty()) {
            while (true) {
                Console.sendln("Имя не может быть пустым. Укажите имя:");
                Console.send("?");
                String l = Console.receive();
                if (l != null && !l.equals("")) {
                    person_name = l;
                    break;
                }
            }
        }
        //TODO хуй
        //Сделать проверку person_birthday
        // person_birthday
        //TODO сделать проверку и преобразование в LocalDate(Есть в старых исходникам моей лабы)(нет)
        LocalDateTime person_birthday_LocalDateTime = LocalDateTime.now();
        //есть что-то похожее
        /*
        LocalDate time;
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            time = format.parse(person_birthday);
        } catch (ParseException e) {
            while(true) {
                System.out.println("Введите день рождение(yyyy-MM-dd):");
                try{
                    //TODO короче надо передлать для LocalDate
                    String r = Console.receive();
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    time = format.parse(r);
                } catch (Exception ignored) { }
            }
        }

         */

        Long weight_Long;
        try{
            weight_Long = Long.parseLong(person_weight);
            if(weight_Long <= 0){new Exception();}
        }
        catch (Exception e){
            while (true) {
                Console.sendln("weight является числом и должно быть больше 0. Укажите weight:");
                Console.send("?");
                try {
                    weight_Long = Long.parseLong(Console.receive());
                    if (weight_Long > 0) {
                        break;
                    }
                }
                catch (NullPointerException | NumberFormatException ignored){ }
            }
        }
        if (person_passportID == null) {
            while (true) {
                Console.sendln("person_passportID строка. Укажите person_passportID:");
                Console.send("?");
                String l = Console.receive();
                if (l != null) {
                    person_passportID = l;
                    break;
                }
            }
        }
        if (person_location_name == null || person_location_name.length() > 221) {
            while (true) {
                Console.sendln("person_location_name строка не длинее 221 символа. Укажите person_location_name:");
                Console.send("?");
                String l = Console.receive();
                if (l != null && l.length() <= 221) {
                    person_location_name = l;
                    break;
                }
            }
        }
        Integer person_location_x_Integer;
        try {
            person_location_x_Integer = Integer.parseInt(person_location_x);
            if (person_location_x_Integer <= 0 || person_location_x == null || person_location_x.isEmpty()) {
                throw new NumberFormatException();
            }
        }
        catch (NumberFormatException e){
            while (true) {
                Console.sendln("Количество участников должно быть числом и должно быть больше нуля. Укажите количество участников:");
                Console.send("?");
                try {
                    person_location_x_Integer = Integer.parseInt(Console.receive());
                    break;
                }
                catch (NullPointerException | NumberFormatException ignored){ }
            }
        }
        long person_location_y_float;
        try{
            person_location_y_float = Long.parseLong(person_location_y);
            if(person_location_y.isEmpty()){new Exception();}
        }
        catch (Exception e){
            while (true) {
                Console.sendln("weight является числом и должно быть больше 0. Укажите weight:");
                Console.send("?");
                try {
                    person_location_y_float = Long.parseLong(Console.receive());
                    break;
                }
                catch (NullPointerException | NumberFormatException ignored){ }
            }
        }
        return new MusicBand(id, name, new Coordinates(x_coordinate, y_coordinate), LocalDate.now(), numberOfParticipants_long, description, mgenre, new Person(person_name, person_birthday_LocalDateTime, weight_Long, person_passportID, new Location(person_location_x_Integer, person_location_y_float, person_location_name)));
    }
    /** Переопределенный метод toString
     *
     * @return возвращает объект в виде текста
     */
    //TODO переписать под новые поля
    @Override
    public String toString() {
        return  "________________________________________________________________" + "\n" +
                "|ID: " + id + "\n" +
                "|Имя: (" + name + ")\n" +
                "|Координаты: " + coordinates + "\n" +
                "|Дата добавления в базу: " + creationDate + " \n" +
                "|Число участников: " + numberOfParticipants + "\n" +
                "|Описание: (" + description + ")\n" +
                "|Дата создания: "  + "\n" +
                "|Жанр: " + genre + "\n" +
                "|Лучший альбом: "  + "\n" +
                "________________________________________________________________";
    }
    @Override
    public int compareTo(MusicBand anotherMusicBand)
    {
        if (this.id.equals(anotherMusicBand.id)) {
            return 0;
        } else if (this.id < anotherMusicBand.id) {
            return -1;
        } else {
            return 1;
        }
    }
}