package parsing_json;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ElementCollection extends ArrayList {
    Element element = new Element();

    public Element findByAtomicNumber(int atomic_number) {
       return null;
    }

    public Element findByName(String name) {
        return null;
    }

    public ElementCollection where(String fieldName, Object value) {
        return null;
    }


    public ArrayList<String> parseTableIntoElementStringArray(String rawData) {
        String stringPattern = "},";
        ArrayList<String> response = splitStringWithRegexPattern(stringPattern, rawData);
        return response;
    }

    public Element parseStringIntoElement(String rawData)  {

        //String name = nameFinder(rawData);
       // int number = numberFinder(rawData);

       // return new Element(name, number);
        return null;
    }

    public ArrayList<String> findKeyValuePairsInRawItemData(String rawData) {
        String stringPattern = "[;|^]";
        ArrayList<String> response = splitStringWithRegexPattern(stringPattern, rawData);
        return response;
    }

    private ArrayList<String> splitStringWithRegexPattern(String stringPattern, String inputString) {
        return new ArrayList<String>(Arrays.asList(inputString.split(stringPattern)));
    }




    public String elementName(ElementCollection ec) {
       ElementCollectionInitializer eci = new ElementCollectionInitializer();
        StringBuilder found = new StringBuilder();
        String periodicTable = new ElementCollectionInitializer().loadFile();

        Pattern p = Pattern.compile("number\": \\d{1,4}");
        Matcher m = p.matcher(periodicTable);
        while (m.find())

        {
            if (!m.group().equals("")) {
                found.append(m.group());
            }
            String myAtomicNumber = found.toString();
           return myAtomicNumber;

        }

        return null;
    }
}