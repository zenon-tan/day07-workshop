import java.util.List;

public class Main {

    public static void main(String[] args) {

        String category = args[1];
        String fileName = args[0];

        List<String> ratingsList = AppReader.readFile(fileName, category);

        float averageRating = AppReader.getAverage(ratingsList);

        System.out.printf("Average rating for apps under category %s is %.2f/5.00\n", category, averageRating);
        
    }
    
}
