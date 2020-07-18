package lab;

import lab.classes.MusicBand;

import javax.xml.bind.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Класс - база данных, позволяет проводить операции с базой данных. Без него коллекция не будет работать.
 * @autor Шахов Кирилл Андреевич P3132
 * @version 1.1
 */
public class BD {
    /** Поле, которое хранит путь до файла с базой данных */
    private final String file_path;
    /** Колекция, которая используется для представления данных в работающей программе. */
    private ArrayList<MusicBand> data = new ArrayList<>();
    /** Лист, который хранит историю введённых команд. */
    private ArrayList<String> history = new ArrayList<>();

    /**
     * Создание базы данных, загрузка данных из прошлой сессии или же создание новой в случае отсутствие прошлых сессий.
     *
     * @param file_path название файла в котором сохранена или будет сохранена база данных.
     */
    public BD(String file_path) {
        this.file_path = file_path;
        if(load()){ Console.sendln("Загрузка успешна"); }
        else{
            Console.sendln("Прошлые данные не загружены.");
            Console.sendln("Создание файла с данными.");
            if(save()){
                Console.sendln("Файл создан");
            }
            else{
                Console.sendln("Нет доступа к файлу");
                System.exit(0);
            }
        }
    }
    /** Метод, позволяет получить id для нового объекта.
     *
     * @return возвращает int ID
     * */
    private int giveID(){
        boolean is = false;
        for(int result = 1; result <= data.size(); result++){
            for(MusicBand m : data){
                if(m.getId() == result){
                    is = true;
                }
            }
            if(is){
                is = false;
            }
            else{
                return result;
            }
        }
        return data.size()+1;
    }
    /** Метод, позволяющий подметить какой-либо объект по ID.
     * @param id ID объекта, который мы хотим поменять.
     * @param name Имя объекта. Поле не может быть null, Строка не может быть пустой
     * @param x Координата X. Значение поля должно быть больше -687.
     * @param y Координата Y. Поле не может быть null
     * @param numberOfParticipants Количество людей в музыкальной группе. Значение поля должно быть больше 0
     * @param description Описание музыкальной группы. Поле не может быть null
     * @param establishmentDate Дата создания музыкальной группы. Формат: yyyy-MM-dd. Поле может быть null.
     * @param genre Жанр(PSYCHEDELIC_ROCK, RAP, POP, POST_ROCK, POST_PUNK). Поле не может быть null
     * @param albumName Название лучшего альбома.
     * @param tracks Количество треков в лучшем альбоме.
     * @param length Длина лучшего альбома.
     * @param sales Продажи лучшего альбома.
     *
     * @return возвращает успешность выполнения метода. true - успех, false - исключение
     * */
    public boolean update(String id, String name, String x, String y, String numberOfParticipants, String description, String establishmentDate, String genre, String albumName, String tracks, String length, String sales){
        try{
            //TODO переделать
            //data.set(Integer.parseInt(id)-1, MusicBand.parseMusicBand(Integer.parseInt(id), name, x, y, numberOfParticipants, description, establishmentDate, genre, albumName, tracks, length, sales));
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    /** Метод позволяет сохранить коллекцию в файл, название файла указывалось присоздании объекта.
     *
     * @return возвращает успешность выполнения метода. true - успех, false - исключение
     * */
    public boolean save(){
        /*
        try(PrintWriter  writer = new PrintWriter (file_path))
        {

            JAXBContext context = JAXBContext.newInstance(ClassWrapper.class);
            ClassWrapper cw = new ClassWrapper();
            cw.setTheCollection(data);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(cw, writer);
            writer.flush();
            writer.close();
            return true;
        }
        catch(IOException | JAXBException ex){
            Console.sendln(ex.getMessage());
            return false;
        }

         */
        try {
            JAXBContext context = JAXBContext.newInstance(ClassWrapper.class);
            ClassWrapper cw = new ClassWrapper();
            cw.setTheCollection(data);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            File fileWrite = new File(file_path);
            FileWriter fw = new FileWriter(fileWrite);
            BufferedWriter bw = new BufferedWriter(fw);
            marshaller.marshal(cw, bw);
            return true;
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
            return false;
        }
    }
    /** Метод, позволяет загрузить коллекцию из файла.
     *
     * @return возвращает успешность выполнения метода. true - успех, false - исключение
     * */
    private boolean load(){
        try {
            //TODO тупо не работает
            /*
            StringReader reader = new StringReader(Console.readFile(file_path));
            ClassWrapper returnedHS = JAXB.unmarshal(reader, ClassWrapper.class);
            JAXBContext jaxbContext = JAXBContext.newInstance(ClassWrapper.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();
            //StringReader reader = new StringReader(Console.readFile(file_path));
            //ClassWrapper returnedHS = (ClassWrapper) un.unmarshal(reader, ClassWrapper.class);

            /*
            Type userListType = new TypeToken<ArrayList<MusicBand>>(){}.getType();
            data = new Gson().fromJson(Console.readFile(file_path), userListType);
             */








            /*
            JAXBContext jaxbContext = JAXBContext.newInstance(ClassWrapper.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            StringReader reader = new StringReader(Console.readFile(file_path));
            ClassWrapper returnedHS = (ClassWrapper) unmarshaller.unmarshal(reader);

             */
            File fileRead = new File(file_path);
            FileReader fr = new FileReader(fileRead);
            BufferedReader br = new BufferedReader(fr);
            ClassWrapper returnedHS = JAXB.unmarshal(br, ClassWrapper.class);
            data = returnedHS.getTheCollection();
            return true;
        }
        catch (FileNotFoundException e){
            return false;
        }
    }
    /** Метод, позволяет добавить объект в коллекцию.
     *
     * @param name Имя объекта. Поле не может быть null, Строка не может быть пустой
     * @param x Координата X. Значение поля должно быть больше -687.
     * @param y Координата Y. Поле не может быть null
     * @param numberOfParticipants Количество людей в музыкальной группе. Значение поля должно быть больше 0
     * @param description Описание музыкальной группы. Поле не может быть null
     * @param establishmentDate Дата создания музыкальной группы. Формат: yyyy-MM-dd. Поле может быть null.
     * @param genre Жанр(PSYCHEDELIC_ROCK, RAP, POP, POST_ROCK, POST_PUNK). Поле не может быть null
     * @param albumName Название лучшего альбома.
     * @param tracks Количество треков в лучшем альбоме.
     * @param length Длина лучшего альбома.
     * @param sales Продажи лучшего альбома.
     *
     * @return возвращает успешность выполнения метода. true - успех, false - исключение
     * */
    public boolean add(String name, String x, String y, String numberOfParticipants, String description, String establishmentDate, String genre, String albumName, String tracks, String length, String sales){
        try {
            //TODO переделать
            //data.add(MusicBand.parseMusicBand(giveID(), name, x, y, numberOfParticipants, description, establishmentDate, genre, albumName, tracks, length, sales));
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    /** Метод, возвращает Историю вводимых команд
     *
     * @return ArrayList<String> - История
     * */
    public ArrayList<String> getHistory() { return history; }
    /** Метод, позволяет удалять объекты из коллекции по ID.
     * ВАЖНО: ID в коллекции начинаються с 1, а не с 0.
     * @param id ID файла, который хотим удалить.
     *
     * @return возвращает успешность выполнения метода. true - успех, false - исключение.
     * */
    public boolean remove(int id) {
        try {
            data.removeIf(m -> m.getId() == id);
            return true;
        }
        catch (Exception ignored){}
        return false;
    }
    /** Метод, позволяет очищать коллекцию.
     *
     * @return возвращает успешность выполнения метода. true - успех, false - исключение.
     * */
    public boolean clean(){
        try {
            data = new ArrayList<MusicBand>();
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    /** Метод, позволяет получить дату создания файла.
     *
     * @return возвращает String - дата создания.
     * */
    public String getCreateTime(){
        try {
            //return data.get(0).getCreateTime().toString();
            BasicFileAttributes attr = Files.readAttributes(Paths.get(file_path), BasicFileAttributes.class);
            return attr.creationTime().toString();
        }
        catch (Exception e){
            return "В коллекции нет элементов.";
        }
    }
    /** Метод, позволяет получить объект по его ID.
     * ВАЖНО: ID в коллекции начинаються с 1, а не с 0.
     *
     * @param id ID объекта.
     *
     * @return Объект MusicBand.
     * */
    public MusicBand get(int id){
        return data.get(id-1);
    }
    /** Метод, позволяет получить количество элементов в коллекции.
     *
     * @return int - колличество элементов.
     * */
    public int size(){return data.size();}
    /** Метод, позволяет записать команду в историю.
     *
     * @param command Команда, которую надо записать.
     * */
    public void log(String command) { history.add(command); }
    /** Метод, позволяет отсортировать массив по текущему методу сортировки.*/
    public void sort(boolean reverse){
        if(!reverse){
            Collections.sort(data, (player2, player1) -> {
                if (player1.getId() < player2.getId()) {
                    return 1;
                } else if (player1.getId() > player2.getId()) {
                    return -1;
                } else {
                    return 0;
                }
            });
        }
        else{
            Collections.sort(data, (player2, player1) -> {
                if (player1.getId() > player2.getId()) {
                    return 1;
                } else if (player1.getId() < player2.getId()) {
                    return -1;
                } else {
                    return 0;
                }
            });
        }
    }
}
