import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class AppReader {

    // Read the file
    // If app is of a particular category, add its rating to a list
    // Find the average of the


    public AppReader() {



    }

    public static List<String> readFile (String fileName, String category) {

        System.out.printf("Processing %s...\n", fileName);
        System.out.println("Looking for apps under " + category + "...");
        System.out.println(" ");

        List<String> ratingsList = new LinkedList<>();

        try {
            
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);

            // List<String> ratingList = br.lines()
            // .skip(1)
            // .map(i -> i.split(","))
            // .filter((n) -> !n[2].trim().equals("NaN"))
            // .collect(Collectors.toList())
            // ;


            String line;

            while(null != (line = br.readLine())) {

                String[] splitString = line.split(",");

                if(splitString[1].equals(category)) {
                    if(splitString[2].strip().equals("NaN")) {
                        continue;
                    }

                    ratingsList.add(splitString[2].strip());

                }

            }

            br.close();

        }

         catch (IOException e) {
            e.printStackTrace();
         }

         return ratingsList;

    }

    public static float getAverage(List<String> ratingsList) {

        float total = ratingsList.stream()
        .map(n -> Float.parseFloat(n))
        .collect(Collectors.reducing(0.0f // total = 0 -> initalises the sum
        , (acc, n) -> {

            //System.out.printf("Total: %f, i: %f\n", acc, n);

            return (acc + n);

            })

        );

        float average = total/ratingsList.size();
        return average;

        //Stream groupBy can create a Map of key and values


    }

    
}
