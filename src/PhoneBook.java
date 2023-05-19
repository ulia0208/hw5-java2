import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    private HashMap<String, List>contacts;

    public PhoneBook(){
        contacts=new HashMap<String,List>();
    }


    public void addNum(String name, String number){
        List numbers;
        if(contacts.containsKey(name)) {
            numbers = contacts.get(name);
        }else{
            numbers=new ArrayList();
            contacts.put(name,numbers);
        }
        numbers.add(number);
    }

    public void printAll(){
        for(String name: contacts.keySet()){
            System.out.println(name+":");
            List numbers = contacts.get(name);
            for(Object num: numbers) {
                System.out.println(num + " ");
            }
            System.out.println();
        }
    }

}
