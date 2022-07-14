package domain;

public class Count {
    private int count;

    public Count(int count) {
        this.count = count;
    }

    public void plus(){
        count++;
    }

    public int getCount(){
        return count;
    }

}
