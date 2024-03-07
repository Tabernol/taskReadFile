import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StatisticService {
    public Integer findMaxNumber(List<Integer> numbers) {
        int maxValue = Integer.MIN_VALUE; // init

        for (Integer number : numbers) {
            if (number > maxValue) { // find max
                maxValue = number;
            }
        }
        return maxValue;
    }


    public Integer findMinNumber(List<Integer> numbers) {
        int minValue = Integer.MAX_VALUE; // init

        for (Integer number : numbers) {
            if (number < minValue) { // find min
                minValue = number;
            }
        }
        return minValue;
    }

    public Integer findMedianValue(List<Integer> numbers) {
        List<Integer> sortedNumbers = numbers.stream().sorted().toList(); // default sorting

        int size = sortedNumbers.size();

        if (size % 2 == 0) { // if list has paired items
            return findMedianInPairedList(sortedNumbers);
        }

        return sortedNumbers.get(size / 2);
    }


    public Double findAverageValue(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    public List<Integer> findLargestIncreasingSequence(List<Integer> numbers) {
        List<Integer> currentSequence = new ArrayList<>();
        List<Integer> largestSequence = new ArrayList<>();

        for (int number : numbers) {
            if (currentSequence.isEmpty() || number > currentSequence.get(currentSequence.size() - 1)) {
                currentSequence.add(number); // add to sequence
            } else {
                if (currentSequence.size() > largestSequence.size()) {
                    largestSequence = new ArrayList<>(currentSequence); // saving if current list large tha existing
                }
                currentSequence.clear(); // start new cycle saving sequence
                currentSequence.add(number);
            }
        }

        // execute at the end
        // if current sequence lager than last largest sequence
        if (currentSequence.size() > largestSequence.size()) {
            largestSequence = new ArrayList<>(currentSequence);
        }

        return largestSequence;
    }

    public List<Integer> findLargestDecreasingSequence(List<Integer> numbers) {
        List<Integer> currentSequence = new ArrayList<>();
        List<Integer> largestSequence = new ArrayList<>();

        for (int number : numbers) {
            if (currentSequence.isEmpty() || number < currentSequence.get(currentSequence.size() - 1)) {
                currentSequence.add(number); // add to sequence
            } else {
                if (currentSequence.size() > largestSequence.size()) {
                    largestSequence = new ArrayList<>(currentSequence); // saving if current list large tha existing
                }
                currentSequence.clear(); // start new cycle saving sequence
                currentSequence.add(number);
            }
        }

        // execute at the end
        // if current sequence lager than last largest sequence
        if (currentSequence.size() > largestSequence.size()) {
            largestSequence = new ArrayList<>(currentSequence);
        }

        return largestSequence;
    }


    private Integer findMedianInPairedList(List<Integer> sortedNumbers) {
        int firstIndexForMedian = sortedNumbers.size() / 2;
        int secondIndexForMedian = firstIndexForMedian - 1;
        int firstValueMedian = sortedNumbers.get(firstIndexForMedian);
        int secondValueMedian = sortedNumbers.get(secondIndexForMedian);
        int medianValue = (firstValueMedian + secondValueMedian) / 2; // average median between two values
        return medianValue;
    }


    public void showAllRequirementData(List<Integer> numbers){
        System.out.println("Max value = " + findMaxNumber(numbers));
        System.out.println("Min value = " + findMinNumber(numbers));
        System.out.println("Median value = " + findMedianValue(numbers));
        System.out.println("Average value = " + findAverageValue(numbers));
        System.out.println("The largest increase sequence " + findLargestIncreasingSequence(numbers));
        System.out.println("The largest decrease sequence " + findLargestDecreasingSequence(numbers));
    }
}
