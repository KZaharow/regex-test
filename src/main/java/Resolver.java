import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RequiredArgsConstructor
public class Resolver {

    private final String query;
    private static final List<Template> TEMPLATES = Arrays.asList(
            new Template("SELECT * FROM %s", Pattern.compile("(?<select>(^.+?(?=#)))")),
            new Template("WHERE %s=%s", Pattern.compile("(?<where>(?<=#).+?:{1}.+?(?=[&|]))")),
            new Template("AND %s=%s", Pattern.compile("(?<and>(?<=&).+?:{1}.+?(?=[&|;]))")),
            new Template("OR %s=%s", Pattern.compile("(?<or>(?<=\\|).+?:{1}.+?(?=[&|;]))"))
    );

    @Override
    public String toString() {
        ArrayList<String> strings = new ArrayList<>();
        for (Template t : TEMPLATES) {
            Matcher matcher = t.getPattern().matcher(query);
            while (matcher.find()) {
                strings.add(
                        String.format(t.getExpression(), matcher.group().split(":")));
            }
        }
        return String.join(" ", strings);
    }
}