import java.util.ArrayList;

public class NeuralNet {
    OutputLayer outputLayer;
    InputLayer inputLayer;
    ArrayList<HiddenLayer> hiddenLayers;
    int numberOfHiddenLayers;
    ActivationFunction activationFunction;

    NeuralNet(ArrayList<Double> inputs, ArrayList<Integer> numberOfNeuronsInHiddenLayers, int numberOfOutputNeurons, ActivationFunction activationFunction){
        this.numberOfHiddenLayers = numberOfNeuronsInHiddenLayers.size();
        this.activationFunction = activationFunction;
        inputLayer = new InputLayer(inputs);
        outputLayer = new OutputLayer(numberOfOutputNeurons);
        initHiddenLayers(numberOfHiddenLayers,numberOfNeuronsInHiddenLayers);
        Neuron.activationFunction = activationFunction;
        int x = 0;
        for(int i = 0; i < numberOfHiddenLayers ; i ++){
            hiddenLayers.get(i).initialiseInputs();
            hiddenLayers.get(i).calculateOutputs();
        }
        outputLayer.initialiseInputs();
        outputLayer.calculateOutputs();
    }

    public void printOutputs(){
        for(Neuron n : outputLayer.getNeurons()) {
            System.out.println(n.getOutput());
        }
    }

    private void initHiddenLayers(int numberOfHiddenLayers, ArrayList<Integer> numberOfNeuronsInHiddenLayers) {
        hiddenLayers = new ArrayList<>();
        for(int i = 0; i < numberOfHiddenLayers; i++){
            hiddenLayers.add(new HiddenLayer(numberOfNeuronsInHiddenLayers.get(i)));
        }
        setPrevNextLayers(inputLayer,hiddenLayers,outputLayer);
    }

    private void setPrevNextLayers(InputLayer inputLayer, ArrayList<HiddenLayer> hiddenLayers, OutputLayer outputLayer) {
        if(hiddenLayers.size()>0){
            inputLayer.setNextLayer(hiddenLayers.get(0));
            outputLayer.setPreviousLayer(hiddenLayers.get(hiddenLayers.size()-1));
            hiddenLayers.get(0).setPreviousLayer(inputLayer);
            hiddenLayers.get(hiddenLayers.size()-1).setNextLayer(outputLayer);

            if(hiddenLayers.size()>1){
                hiddenLayers.get(0).setNextLayer(hiddenLayers.get(1));
                hiddenLayers.get(hiddenLayers.size()-1).setPreviousLayer( hiddenLayers.get(hiddenLayers.size()-2));
                for(int i = 1; i < hiddenLayers.size()-1; i++){
                    hiddenLayers.get(i).setPreviousLayer(hiddenLayers.get(i-1));
                    hiddenLayers.get(i).setNextLayer(hiddenLayers.get(i+1));
                }
            }
        }
        else {
            outputLayer.setPreviousLayer(inputLayer);
            inputLayer.setNextLayer(outputLayer);
        }
    }

}
