public class AppleFancyFormatter implements AppleFormatter {
    public String accept(Apple apple) {
        String charateristic = apple.getWeight() > 150 ? "heavy" : "light";
        return "A " + charateristic + " " + apple.getColor() + " apple";
    }
}
