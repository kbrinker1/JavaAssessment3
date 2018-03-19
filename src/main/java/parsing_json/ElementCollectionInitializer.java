package parsing_json;

import clover.com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import sun.misc.IOUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class ElementCollectionInitializer {


    public String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("periodic_table.json").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }

       return result.toString();
    }

    public static ElementCollection generate() {
        ElementCollection elementCollection = new ElementCollection();
        Gson gson = new Gson();
        String json = new ElementCollectionInitializer().loadFile();
        Element[] elements = gson.fromJson(json, Element[].class);
        Collections.addAll(elementCollection, elements);
        return elementCollection;

    }
}


//    Type collectionType = new TypeToken<Collection<ElementCollection>>(){}.getType();
//    Collection<ElementCollection> elements = gson.fromJson(json, collectionType);
//        return  elements;