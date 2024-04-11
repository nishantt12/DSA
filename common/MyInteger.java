package common;

public class MyInteger implements Comparable<MyInteger>{
    private final int value;

    public MyInteger(int value){
        this.value = value;
    }

    @Override
    public int compareTo(MyInteger that) {
        if(this.value < that.value) return -1;
        if(this.value> that.value) return +1;
        else return 0;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
