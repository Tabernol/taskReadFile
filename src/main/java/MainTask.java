import java.util.List;

public class MainTask {

    public static final String PATH_TO_FILE = "src/main/resources/10m.txt";

    public static void main(String[] args) {
        DataHolder dataHolder = new DataHolder(PATH_TO_FILE);
        List<Integer> numbers = dataHolder.getNumbers();
        StatisticService statisticService = new StatisticService();
        statisticService.showAllRequirementData(numbers);


    }
}
