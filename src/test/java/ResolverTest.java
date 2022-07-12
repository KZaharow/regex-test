import org.junit.jupiter.api.Test;

public class ResolverTest {

    @Test
    void resolverTest(){
        //String test = "cities#city#id:100Гомель&street:Советская|house:20&floor:2&room:2-1|room:2-2;";
        String test = "complince_fin_operation#column#id:{complince_fin_operation_id}&k1:v2|k2:v2";
        Resolver resolver = new Resolver(test);
        System.out.println(resolver);
    }
}
