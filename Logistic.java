import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Logistic {

    /* the learning rate */
    private double rate;

    /* the weight to learn */
    private double[] weights;

    /* the number of iterations */
    private int ITERATIONS = 3000;

    public Logistic(int n) {
        this.rate = 0.0001;
        weights = new double[n];
    }

    private double sigmoid(double z) {
        return 1 / (1 + Math.exp(-z));
    }

    public void train(List<Instance> instances) {
        for (int n=0; n<ITERATIONS; n++) {
            double lik = 0.0;
            for (int i=0; i<instances.size(); i++) {
                int[] x = instances.get(i).getX();
                double predicted = classify(x);
                int label = instances.get(i).getLabel();
                for (int j=0; j<weights.length; j++) {
                    weights[j] = weights[j] + rate * (label - predicted) * x[j];
                }

                lik += label * Math.log(classify(x)) + (1-label) * Math.log(1- classify(x));
            }
            //System.out.println("iteration: " + n + " " + Arrays.toString(weights) + " mle: " + lik);
        }
    }

    public double classify(int[] x) {
        double logit = .0;
        for (int i=0; i<weights.length;i++)  {
            logit += weights[i] * x[i];
        }
        return sigmoid(logit);
    }

}
