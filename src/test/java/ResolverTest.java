import org.junit.jupiter.api.Test;

public class ResolverTest {

    @Test
    void resolverTest(){
        String test = "cities#city:Гомель&street:Советская|house:20&floor:2&room:2-1|room:2-2;";
        Resolver resolver = new Resolver(test);
        System.out.println(resolver);
    }
}
