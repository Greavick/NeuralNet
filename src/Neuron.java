import java.util.ArrayList;
import java.util.Random;

public class Neuron {
    ArrayList<Double> inputs = new ArrayList<>();
    ArrayList<Double> weights = new ArrayList<>();
    double output;
    static ActivationFunction activationFunction;


    public void setRandomWeights(){
        Random r = new Random();
        for(int i = 0; i < inputs.size(); i++){
            weights.add(r.nextDouble());
        }
    }

    public void calculateOutput(){
        output = 0;
        for(int i = 0; i < inputs.size(); i ++){
            output += inputs.get(i) * weights.get(i);
        }
        output = activationFunction.calc(output);
    }

    public ArrayList<Double> getInputs() {
        return inputs;
    }

    public ArrayList<Double> getWeights() {
        return weights;
    }

    public double getOutput() {
        return output;
    }

    public ActivationFunction getActivationFunction() {
        return activationFunction;
    }

    public void setInputs(ArrayList<Double> inputs) {
        this.inputs = inputs;
    }

    public void setInput(int index, double value) {
        this.inputs.set(index,value);
    }

    public void setWeights(ArrayList<Double> weights) {
        this.weights = weights;
    }

    public void setWeight(int index, double value) {
        this.weights.set(index,value);
    }

    public void setOutput(double output) {
        this.output = output;
    }

    public void setActivationFunction(ActivationFunction activationFunction) {
        this.activationFunction = activationFunction;
    }
}
