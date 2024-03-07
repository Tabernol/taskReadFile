import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class DataHolder {
    private final String pathToFile;
    private List<Integer> numbers;

    public DataHolder(String pathToFile) {
        this.pathToFile = pathToFile;
        this.numbers = readNumbersFromFile();
    }

    private List<Integer> readNumbersFromFile() {
        numbers = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(pathToFile))) {
            String line;

            System.out.println("start reading file ... ");
            while ((line = br.readLine()) != null) {
                int currentNumber = Integer.parseInt(line.trim());
                numbers.add(currentNumber);
            }
            System.out.println("finish reading file");
            return numbers;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error reading file", e);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

}
