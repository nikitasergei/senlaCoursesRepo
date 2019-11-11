package by.senla.nikitaSergei.task6;

public class ItemSet {
    private char[] set;
    private int sumWeight = 0;
    private double sumCost = 0;


    public ItemSet() {
    }

    public char[] getSet() {
        return set;
    }

    public void setSet(char[] set) {
        this.set = set;
    }

    public int getSumWeight() {
        return sumWeight;
    }

    public void setSumWeight(int sumWeight) {
        this.sumWeight = sumWeight;
    }

    public double getSumCost() {
        return sumCost;
    }

    public void setSumCost(double sumCost) {
        this.sumCost = sumCost;
    }


    @Override
    public String toString() {
        return "ItemSet contains: sumWeight = " + sumWeight +
                ", sumCost=" + sumCost;
    }


}
