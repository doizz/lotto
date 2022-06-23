package domain;

public class Count {
    private int count;

    public Count(int count) {
        this.count = count;
    }

    public void plus(){
        count++;
    }

    public int moneyCount(int money){
        return money * count;
    }

    public int getCount(){
        return count;
    }

}
