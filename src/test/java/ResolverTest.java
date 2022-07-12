import org.junit.jupiter.api.Test;

public class ResolverTest {

    @Test
    void resolverTest(){
        String test = "complince_fin_operation#column#id:complince_fin_operation_id&k1:v1|k2:v2;";
        Resolver resolver = new Resolver(test, "hello");
        System.out.println(resolver);
    }
}
