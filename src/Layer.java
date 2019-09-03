import java.util.ArrayList;

public abstract class Layer {
    ArrayList<Neuron> neurons = new ArrayList<>();
    ArrayList<Double> outputs;
    Layer previousLayer;
    Layer nextLayer;
    int numberOfNeurons;

    Layer(){}

    Layer(int numberOfNeurons){
        this.numberOfNeurons = numberOfNeurons;
        for(int i = 0; (i < numberOfNeurons) && (neurons.size() < numberOfNeurons); i++){
            neurons.add(new Neuron());
        }
    }

    ArrayList<Double> getOuputs(){
        ArrayList<Double> temp = new ArrayList<>();
        for(int i = 0; i < numberOfNeurons; i++) {
            temp.add(neurons.get(i).getOutput());
        }
        this.outputs = temp;
        return temp;
    }

    void initialiseInputs(){
        for(Neuron neuron : neurons){
            neuron.setInputs(previousLayer.getOuputs());
            neuron.setRandomWeights();
        }
    }

    void calculateOutputs(){
        for(Neuron neuron : neurons){
            neuron.calculateOutput();
        }
    }

    void setNumberOfNeurons(int numberOfNeurons){
        this.numberOfNeurons = numberOfNeurons;
    }

    int getNumberOfNeurons(){
        return numberOfNeurons;
    }

    public ArrayList<Neuron> getNeurons() {
        return neurons;
    }

    public void setNeurons(ArrayList<Neuron> neurons) {
        this.neurons = neurons;
    }

    public Layer getPreviousLayer() {
        return previousLayer;
    }

    public void setPreviousLayer(Layer previousLayer) {
        this.previousLayer = previousLayer;
    }

    public Layer getNextLayer() {
        return nextLayer;
    }

    public void setNextLayer(Layer nextLayer) {
        this.nextLayer = nextLayer;
    }


}
