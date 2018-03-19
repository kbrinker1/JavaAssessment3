package parsing_json;

        import org.junit.Test;

        import java.io.IOException;

        import static org.junit.Assert.*;

public class ElementCollectionInitializerTest {

    @Test
    public void testLoadFile(){
        ElementCollectionInitializer e = new ElementCollectionInitializer();
        ElementCollection ele = new ElementCollection();
        String answer =  e.loadFile();
        System.out.println(answer);
    }
    @Test
    public void testgenerate(){

        ElementCollectionInitializer e = new ElementCollectionInitializer();
        ElementCollection answer = e.generate();
        System.out.println(answer);
    }


    @Test
    public void generate() throws IOException {
        assertEquals(119, ElementCollectionInitializer.generate().size());
    }
}