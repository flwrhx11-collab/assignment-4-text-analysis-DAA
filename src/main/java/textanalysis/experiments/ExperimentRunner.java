package textanalysis.experiments;

import textanalysis.dp.LCS;
import java.util.Random;

public class ExperimentRunner {
    public static void main(String[] args) {
        int[] sizes = {100, 500, 1000};
        LCS lcs = new LCS();

        for (int size : sizes) {
            String s1 = generateRandomString(size);
            String s2 = generateRandomString(size);
            long totalTime = 0;

            for (int i = 0; i < 5; i++) {
                long startTime = System.nanoTime();
                lcs.findLCS(s1, s2);
                long endTime = System.nanoTime();
                totalTime += (endTime - startTime);
            }
            System.out.println("LCS Size " + size + " Avg Time: " + (totalTime / 5) + " ns");
        }
    }

    private static String generateRandomString(int length) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        Random random = new Random(42);
        for (int i = 0; i < length; i++) {
            sb.append(alphabet.charAt(random.nextInt(alphabet.length())));
        }
        return sb.toString();
    }
}