public class ActivationFunction {
    private double coeff = 1.0;

    public ActivationFunction(double coeff) {
        this.coeff = coeff;
    }

    public ActivationFunction() {

    }

    public double calc(double in) {
        return 1.0 / (1.0 + Math.exp( -coeff * in ));
    }
}
