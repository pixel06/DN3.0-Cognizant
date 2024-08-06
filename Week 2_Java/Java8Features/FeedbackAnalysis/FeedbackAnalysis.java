package FeedbackAnalysis;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FeedbackAnalysis {
    public static void main(String[] args) {
        List<Feedback> feedbackList = new ArrayList<>();
        feedbackList.add(new Feedback("1", "Alice", 5, "Excellent service!"));
        feedbackList.add(new Feedback("2", "Bob", 3, "Average experience."));
        feedbackList.add(new Feedback("3", "Charlie", 4, "Good, but could be better."));
        feedbackList.add(new Feedback("4", "David", 2, "Not satisfied."));
        feedbackList.add(new Feedback("5", "Eve", 5, "Absolutely wonderful!"));

        
        List<Feedback> filteredFeedback = feedbackList.stream()
                .filter(feedback -> feedback.getRating() >= 4)
                .collect(Collectors.toList());
        System.out.println("Filtered Feedback:");
        filteredFeedback.forEach(System.out::println);

        
        List<String> customerFeedback = feedbackList.stream()
                .map(feedback -> feedback.getCustomerName() + ": " + feedback.getComments())
                .collect(Collectors.toList());
        System.out.println("Customer Feedback:");
        customerFeedback.forEach(System.out::println);

       
        Map<String, Long> feedbackCount = feedbackList.stream()
                .collect(Collectors.groupingBy(
                        feedback -> feedback.getRating() >= 4 ? "Positive" : "Negative",
                        Collectors.counting()
                ));
        System.out.println("Feedback Count:");
        feedbackCount.forEach((key, value) -> System.out.println(key + ": " + value));

        
        processFeedback(feedbackList, feedback -> feedback.getRating() >= 4, feedback -> System.out.println("Processing feedback: " + feedback));
    }

    public static void processFeedback(List<Feedback> feedbackList, FeedbackFilter filter, FeedbackProcessor processor) {
        feedbackList.stream()
                .filter(filter::filter)
                .forEach(processor::process);
    }
}
