import java.util.ArrayList;

public class InputLayer extends Layer {

    InputLayer(ArrayList<Double> inputs){
        setOutputs(inputs);
        previousLayer = null;
    }

    public void setOutputs(ArrayList<Double> outputs){
        this.numberOfNeurons = outputs.size();

        for(int i = 0; (i < numberOfNeurons); i++){
            if((neurons.size() < numberOfNeurons))
                neurons.add(new Neuron());
            neurons.get(i).setOutput(outputs.get(i));
        }
    }

    public void setOutput(int index, double value){
        neurons.get(index).setOutput(value);
    }
}