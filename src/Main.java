import java.util.*;

public class Main {
    public static void main(String[] args) {


        //hw0();

        String lineN = "Иван Иванов, Светлана Петрова, Кристина Белова, \n"+
                "Анна Мусина, Анна Крутова, Иван Юрин, Петр Лыков, \n"+
                "Павел Чернов, Петр Чернышов, Мария Федорова, Марина Светлова, Мария Савина, \n"+
                "Мария Рыкова, Марина Лугова, Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов.\n";

        hw1(lineN);



    }

    static void hw0(){
        //Реализуйте структуру телефонной книги с помощью HashMap,
        //учитывая, что 1 человек может иметь несколько телефонов.

        PhoneBook phoneBook=new PhoneBook();
        Scanner scanner=new Scanner(System.in);

        while (true){
            System.out.println("Нажмите 1 для добавления записи и 2 для просмотра справочника ");
            int choice=scanner.nextInt();
            if(choice==1){
                System.out.println("Введите имя ");
                String name=scanner.next();
                System.out.println("Введите номер ");
                String num = scanner.next();
                phoneBook.addNum(name, num);
            }else if (choice==2){
                phoneBook.printAll();
            }
        }
    }

    static void hw1(String lineN){
                /*Пусть дан список сотрудников:
                Иван Иванов, Светлана Петрова, Кристина Белова,
                Анна Мусина, Анна Крутова, Иван Юрин, Петр Лыков,
                Павел Чернов, Петр Чернышов, Мария Федорова, Марина Светлова, Мария Савина,
                Мария Рыкова, Марина Лугова, Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов.
                Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
                Отсортировать по убыванию популярности. Для сортировки использовать TreeMap.*/

        lineN=lineN.replace(",", "");
        lineN=lineN.replace(".", "");

        lineN=lineN.replace("\n", "");


        String[] namesSurnames=lineN.split(" ");

        int length=0;
        int j=0;

        for (int i = 0; i < namesSurnames.length; i++) {
            if(i%2==0){
                length++;
            }

        }
        List<String> listNames=new ArrayList<>();

        for (int i = 0; i < namesSurnames.length; i++){
            if(i%2==0){
                listNames.add(namesSurnames[i]);
            }

        }

        System.out.println("list "+listNames);

       Map<Integer,String>mapName = createMap(listNames);

        TreeMap<Integer, String> tree_map = new TreeMap<>(Comparator.reverseOrder());

        tree_map.putAll(mapName);
        int it=0;
        for(Map.Entry e : tree_map.entrySet()){
            System.out.println(e.getKey()+" "+ e.getValue());
            it++;
        }






//        Map<List<Integer>,String>mapName = new TreeMap<>();
//        for (int i = 0; i < mapName.size(); i++) {
//            int count = 0;
//
//            for (int h = 0; h < mapName.size(); h++) {
//                if (mapName.get(i).equals(mapName.get(h))) {
//                    count++;
//                }
//            }
//
//            if (mapName.containsValue(mapName.get(i)) == false) {
//
//                List<Integer> list = new ArrayList<>();
//                list.add(count);
//
//                mapName.put(list, mapName.get(i));
//
//            }
//        }



        System.out.println(mapName);
    }

    public static Map<Integer,String> createMap(List<String> name){
        Map<Integer, String> mapName = new HashMap<>();
        for (int i = 0; i < name.size(); i++) {
            int count=0;
            for (int j = 0; j < name.size(); j++) {
                if(name.get(i).equals(name.get(j))){
                    count++;
                }
            }
            if(mapName.containsValue(name.get(i))==false){
                mapName.put(count,name.get(i));

            }
        }
        return mapName;
    }
//public static Map<List<Integer>,String> createMap(List<String> name){
//    Map<List<Integer>, String> mapName = new HashMap<>();
//    for (int i = 0; i < name.size(); i++) {
//        int count=0;
//        for (int j = 0; j < name.size(); j++) {
//            if(name.get(i).equals(name.get(j))){
//                count++;
//            }
//        }
//
//
//        if(mapName.containsValue(name.get(i))==false){
//
//            List<Integer> list = new ArrayList<>();
//            list.add(count);
//
//            mapName.put(list,name.get(i));
//
//        }
//    }
//    return mapName;
//}
//    public static Map<String,Integer> createMap(List<String> name){
//        Map<String, Integer> mapName = new HashMap<>();
//        for (int i = 0; i < name.size(); i++) {
//            int count=0;
//            for (int j = 0; j < name.size(); j++) {
//                if(name.get(i).equals(name.get(j))){
//                    count++;
//                }
//            }
//            if(mapName.containsValue(name.get(i))==false){
//                mapName.put(name.get(i), count);
//
//            }
//        }
//        return mapName;
//    }

}