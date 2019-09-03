import java.util.ArrayList;

public class Main {
    public static void main(String... args){

        // Initialize inputs
        ArrayList<Double> inputs = new ArrayList<>();
        inputs.add(1.0);
        inputs.add(2.0);
        inputs.add(3.0);
        inputs.add(4.0);
        inputs.add(5.0);
        inputs.add(6.0);



        ArrayList<Integer> numberOfNeuronsInHiddenLayers = new ArrayList<>();
        numberOfNeuronsInHiddenLayers.add(2);
        numberOfNeuronsInHiddenLayers.add(3);
        numberOfNeuronsInHiddenLayers.add(4);

        NeuralNet nn = new NeuralNet(inputs, numberOfNeuronsInHiddenLayers,2, new ActivationFunction());
        nn.printOutputs();
    }
}
