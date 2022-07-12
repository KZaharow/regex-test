import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.regex.Pattern;

@Data
@AllArgsConstructor
public class Template {
    private String expression;
    private Pattern pattern;
    private boolean isObligate;

    @Override
    public String toString() {
        return expression;
    }
}