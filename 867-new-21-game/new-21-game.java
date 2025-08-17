class Solution {
    public double new21Game(int n, int k, int maxPts) {
        double[] P = new double[n + 1];  
        // P[i] = probability of getting score = i

        P[0] = 1.0; // Initially score = 0 with probability 1

        double currProbabSum = (k > 0) ? 1.0 : 0.0;

        for (int i = 1; i <= n; i++) {
            // Probability of reaching i
            P[i] = currProbabSum / maxPts;

            // Update running sum for next states
            if (i < k) {
                currProbabSum += P[i];
            }

            if (i - maxPts >= 0 && (i - maxPts) < k) {
                currProbabSum -= P[i - maxPts];
            }
        }

        // Sum of probabilities of all scores >= k and <= n
        double result = 0.0;
        for (int i = k; i <= n; i++) {
            result += P[i];
        }

        return result;
    }
}
