package textanalysis.matching;

import java.util.ArrayList;
import java.util.List;

public class RabinKarp {
    private final int d = 256;
    private final int q = 101;

    public List<Integer> search(String text, String pattern) {
        List<Integer> result = new ArrayList<>();
        if (pattern == null || pattern.isEmpty() || text == null || text.length() < pattern.length()) {
            return result;
        }
        int m = pattern.length();
        int n = text.length();
        int p = 0;
        int t = 0;
        int h = 1;

        for (int i = 0; i < m - 1; i++) {
            h = (h * d) % q;
        }
        for (int i = 0; i < m; i++) {
            p = (d * p + pattern.charAt(i)) % q;
            t = (d * t + text.charAt(i)) % q;
        }
        for (int i = 0; i <= n - m; i++) {
            if (p == t) {
                boolean match = true;
                for (int j = 0; j < m; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    result.add(i);
                }
            }
            if (i < n - m) {
                t = (d * (t - text.charAt(i) * h) + text.charAt(i + m)) % q;
                if (t < 0) {
                    t = (t + q);
                }
            }
        }
        return result;
    }
}