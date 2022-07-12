import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class Runner {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Runner.class);
        Resolver resolver = ctx.getBean(Resolver.class);
        //JdbcDAO jdbc = ctx.getBean(JdbcDAO.class);
        System.out.println(resolver);
        //System.out.println(jdbc.performQuery(resolver.toString()));

    }
}
