package FeedbackAnalysis;

@FunctionalInterface
public interface FeedbackFilter {
    boolean filter(Feedback feedback);
}
