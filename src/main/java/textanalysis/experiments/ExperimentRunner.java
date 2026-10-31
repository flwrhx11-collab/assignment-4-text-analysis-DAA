package textanalysis.experiments;

import textanalysis.dp.LCS;
import textanalysis.dp.EditDistance;
import textanalysis.matching.KMP;
import textanalysis.matching.NaiveSearch;
import textanalysis.matching.RabinKarp;
import textanalysis.advanced.Kasai;
import java.util.Random;

public class ExperimentRunner {
    public static void main(String[] args) {
        runDPExperiments();
        runMatchingExperiments();
        runKasaiExperiments();
    }

    private static void runDPExperiments() {
        System.out.println("--- DP Experiments (LCS & Edit Distance) ---");
        int[] sizes = {100, 500, 1000};
        LCS lcs = new LCS();
        EditDistance ed = new EditDistance();

        for (int size : sizes) {
            String s1 = generateRandomString(size);
            String s2 = generateRandomString(size);

            long timeLCS = 0, timeED = 0;
            for (int i = 0; i < 5; i++) {
                long start = System.nanoTime();
                lcs.findLCS(s1, s2);
                timeLCS += (System.nanoTime() - start);

                start = System.nanoTime();
                ed.calculate(s1, s2);
                timeED += (System.nanoTime() - start);
            }
            System.out.println("Size: " + size);
            System.out.println("LCS Avg Time: " + (timeLCS / 5) + " ns");
            System.out.println("ED Avg Time:  " + (timeED / 5) + " ns");
        }
        System.out.println();
    }

    private static void runMatchingExperiments() {
        System.out.println("--- String Matching Experiments ---");
        int[] sizes = {10000, 50000, 100000};
        int patternLength = 100;
        NaiveSearch naive = new NaiveSearch();
        KMP kmp = new KMP();
        RabinKarp rk = new RabinKarp();

        for (int size : sizes) {
            String text = generateRandomString(size);
            String pattern = text.substring(size / 2, size / 2 + patternLength);

            long timeNaive = 0, timeKMP = 0, timeRK = 0;
            for (int i = 0; i < 5; i++) {
                long start = System.nanoTime();
                naive.search(text, pattern);
                timeNaive += (System.nanoTime() - start);

                start = System.nanoTime();
                kmp.search(text, pattern);
                timeKMP += (System.nanoTime() - start);

                start = System.nanoTime();
                rk.search(text, pattern);
                timeRK += (System.nanoTime() - start);
            }
            System.out.println("Size: " + size);
            System.out.println("Naive Avg Time: " + (timeNaive / 5) + " ns");
            System.out.println("KMP Avg Time:   " + (timeKMP / 5) + " ns");
            System.out.println("RK Avg Time:    " + (timeRK / 5) + " ns");
        }
        System.out.println();
    }

    private static void runKasaiExperiments() {
        System.out.println("--- Kasai Experiments ---");
        int[] sizes = {1000, 5000, 10000};
        Kasai kasai = new Kasai();

        for (int size : sizes) {
            String text = generateRandomString(size);
            int[] dummySuffixArray = new int[size];
            for (int i = 0; i < size; i++) {
                dummySuffixArray[i] = i;
            }

            long timeKasai = 0;
            for (int i = 0; i < 5; i++) {
                long start = System.nanoTime();
                kasai.buildLCP(text, dummySuffixArray);
                timeKasai += (System.nanoTime() - start);
            }
            System.out.println("Size: " + size);
            System.out.println("Kasai Avg Time: " + (timeKasai / 5) + " ns");
        }
    }

    private static String generateRandomString(int length) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder(length);
        Random random = new Random(42);
        for (int i = 0; i < length; i++) {
            sb.append(alphabet.charAt(random.nextInt(alphabet.length())));
        }
        return sb.toString();
    }
}