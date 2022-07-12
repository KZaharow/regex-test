import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RequiredArgsConstructor
public class Resolver {

    private final String query;
    private final String replace;
    private static final List<Template> TEMPLATES = Arrays.asList(
            new Template("SELECT %s", Pattern.compile("(?<value>(?<=#).+?(?=#))"), false),
            new Template("FROM %s", Pattern.compile("(?<select>^.+?(?=#))"), false),
            new Template("WHERE %s=%s", Pattern.compile("(?<=#.{1,500}#).+?:{1}[^{].+?[^}](?=[&|])"), false),
            new Template("%s", Pattern.compile("(?<=#.{1,500}#).+?:{1}\\{.+?(?=}[&|])"), true),
            new Template("AND %s=%s", Pattern.compile("(?<and>(?<=&).+?:{1}.+?(?=[&|;]))"), false),
            new Template("OR %s=%s", Pattern.compile("(?<or>(?<=\\|).+?:{1}.+?(?=[&|;]))"), false)
    );

    @Override
    public String toString() {
        ArrayList<String> strings = new ArrayList<>();
        for (Template t : TEMPLATES) {
            Matcher matcher = t.getPattern().matcher(query);
            while (matcher.find()) {
                if (t.isReplaced()) {
                    strings.add(replace);
                }
                strings.add(
                        String.format(t.getExpression(), matcher.group().split(":")));
            }
        }
        return String.join(" ", strings);
    }
}