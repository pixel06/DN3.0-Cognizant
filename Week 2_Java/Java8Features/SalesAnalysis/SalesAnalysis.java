package SalesAnalysis;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SalesAnalysis {
    public static void main(String[] args) {
        List<SalesRecord> salesRecords = new ArrayList<>();
        salesRecords.add(new SalesRecord("1", "Alice", "North", 150.0, LocalDate.of(2023, 1, 10)));
        salesRecords.add(new SalesRecord("2", "Bob", "South", 250.0, LocalDate.of(2023, 2, 12)));
        salesRecords.add(new SalesRecord("3", "Charlie", "North", 100.0, LocalDate.of(2023, 3, 15)));
        salesRecords.add(new SalesRecord("4", "David", "West", 300.0, LocalDate.of(2023, 4, 18)));
        salesRecords.add(new SalesRecord("5", "Eve", "North", 200.0, LocalDate.of(2023, 5, 20)));

        
        List<SalesRecord> filteredRecords = salesRecords.stream()
                .filter(record -> "North".equals(record.getRegion()))
                .collect(Collectors.toList());
        System.out.println("Filtered Records:");
        filteredRecords.forEach(System.out::println);

        
        List<Double> salesAmounts = filteredRecords.stream()
                .map(SalesRecord::getAmount)
                .collect(Collectors.toList());
        System.out.println("Sales Amounts:");
        salesAmounts.forEach(System.out::println);

        
        double totalSales = filteredRecords.stream()
                .mapToDouble(SalesRecord::getAmount)
                .sum();
        System.out.println("Total Sales Amount: " + totalSales);

        
        Map<String, List<SalesRecord>> salesByPerson = salesRecords.stream()
                .collect(Collectors.groupingBy(SalesRecord::getSalesPerson));
        System.out.println("Sales Grouped by SalesPerson:");
        salesByPerson.forEach((salesPerson, records) -> {
            System.out.println(salesPerson + ":");
            records.forEach(System.out::println);
        });

        
        Map<String, Double> salesReport = salesRecords.stream()
                .collect(Collectors.groupingBy(SalesRecord::getSalesPerson, Collectors.summingDouble(SalesRecord::getAmount)));
        System.out.println("Sales Report:");
        salesReport.forEach((salesPerson, totalAmount) -> {
            System.out.println(salesPerson + ": " + totalAmount);
        });
    }
}
