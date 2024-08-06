package SalesAnalysis2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SalesAnalysis {
    public static void main(String[] args) {
        List<SalesRecord> salesRecords = new ArrayList<>();
        salesRecords.add(new SalesRecord("1", "Alice", "North", 150.0, LocalDate.of(2023, 1, 10), "Electronics", 5));
        salesRecords.add(new SalesRecord("2", "Bob", "South", 250.0, LocalDate.of(2023, 2, 12), "Clothing", 10));
        salesRecords.add(new SalesRecord("3", "Charlie", "North", 100.0, LocalDate.of(2023, 3, 15), "Electronics", 3));
        salesRecords.add(new SalesRecord("4", "David", "West", 300.0, LocalDate.of(2023, 4, 18), "Furniture", 2));
        salesRecords.add(new SalesRecord("5", "Eve", "North", 200.0, LocalDate.of(2023, 5, 20), "Electronics", 7));

       
        List<SalesRecord> filteredAndSortedRecords = salesRecords.stream()
                .filter(record -> "Electronics".equals(record.getProductCategory()))
                .sorted(Comparator.comparing(SalesRecord::getDate))
                .collect(Collectors.toList());
        System.out.println("Filtered and Sorted Records:");
        filteredAndSortedRecords.forEach(System.out::println);

        
        double averageSales = salesRecords.stream()
                .filter(record -> "North".equals(record.getRegion()))
                .mapToDouble(SalesRecord::getAmount)
                .average()
                .orElse(0.0);
        System.out.println("Average Sales Amount in North Region: " + averageSales);

        
        Optional<SalesRecord> topSalesRecord = salesRecords.stream()
                .max(Comparator.comparingDouble(SalesRecord::getAmount));
        topSalesRecord.ifPresent(record -> System.out.println("Top Sales Record: " + record));

        
        long startSequential = System.currentTimeMillis();
        List<SalesRecord> sequentialFilteredAndSortedRecords = salesRecords.stream()
                .filter(record -> "Electronics".equals(record.getProductCategory()))
                .sorted(Comparator.comparing(SalesRecord::getDate))
                .collect(Collectors.toList());
        long endSequential = System.currentTimeMillis();
        System.out.println("Time taken for sequential stream: " + (endSequential - startSequential) + " ms");

        long startParallel = System.currentTimeMillis();
        List<SalesRecord> parallelFilteredAndSortedRecords = salesRecords.parallelStream()
                .filter(record -> "Electronics".equals(record.getProductCategory()))
                .sorted(Comparator.comparing(SalesRecord::getDate))
                .collect(Collectors.toList());
        long endParallel = System.currentTimeMillis();
        System.out.println("Time taken for parallel stream: " + (endParallel - startParallel) + " ms");
    }
}
