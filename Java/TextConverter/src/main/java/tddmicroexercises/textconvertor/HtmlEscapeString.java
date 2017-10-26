package tddmicroexercises.textconvertor;

public class HtmlEscapeString implements IEscapeString {

    private ReplacementRule[] replacementRules = {
            new ReplacementRule("&", "&amp;"),
            new ReplacementRule("<", "&lt;"),
            new ReplacementRule(">", "&gt;"),
            new ReplacementRule("\"", "&quot;"),
            new ReplacementRule("'", "&quot;")
    };

    public String escape(String input) {
        String output = input;
        for (ReplacementRule rule : replacementRules) {
            output = output.replace(rule.target, rule.replacement);
        }
        return output;
    }

    public class ReplacementRule {
        public String target;
        public String replacement;

        public ReplacementRule(String target, String replacement) {
            this.target = target;
            this.replacement = replacement;
        }
    }
}
