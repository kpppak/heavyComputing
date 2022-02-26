public class FibonacciNumber {

    public int figure;
    int result;

    public FibonacciNumber(){
    }

    public FibonacciNumber(int figure){
        this.figure = figure;
    }

    public int getFigure() {
        return figure;
    }

    public void setFigure(int figure) {
        this.figure = figure;
    }

    public int computeFibanacciNumber(int figure){
        int n0 = 0;
        int n1 = 1;
        for (int j = 1; j <= (figure + 1); j++){
            result = n0 + n1;
            n0 = n1;
            n1 = result;
        }
        return result;
    }
}
