package task.persistance;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;

import task.model.Child;
import task.model.Parent;

public class DataStore {
    
    public static List<Parent> getParentListFromFile(){
        String path = "src/main/resources/parent.json";
        ObjectMapper mapper = new ObjectMapper(); 
        List<Parent> list = new ArrayList<>();
        for(Object o : getListFromFile(path))
         list.add(mapper.convertValue(o, Parent.class));  
        return list;
    }

    public static List<Child> getChildListFromFile(){
        String path = "src/main/resources/child.json";
        ObjectMapper mapper = new ObjectMapper(); 
        List<Child> list = new ArrayList<>();
        for(Object o : getListFromFile(path))
         list.add(mapper.convertValue(o, Child.class));  
        return list;
    }

    private static List<Object> getListFromFile(String path){
        Object obj = null;
        try {
            obj = new JSONParser(new FileReader(path)).parse();
        } catch (FileNotFoundException | ParseException e1) {
            e1.printStackTrace();
        }
        Map<String,Object> m =(Map)obj;
        return (ArrayList) m.get("data");
    }

    public static Parent getParentById(Long id){
        List<Parent> parents = getParentListFromFile();
        for(Parent parent : parents){
            if(parent.getId() == id)
                return parent;
        }
        return null;
        //throw new ParentNotFoundException(id);
    }
}
