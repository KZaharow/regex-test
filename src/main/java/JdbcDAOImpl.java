import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcDAOImpl implements JdbcDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public String performQuery(String query) {
        String s = jdbcTemplate.queryForObject(query, String.class);
        return s;
    }
}
