public class Testing {

    public void show(int...args){
        for(int x : args)
        System.out.print(x+",");
    }

    public static void main(String[] args) {
        new Testing().show(new int[]{1,2,3,4,5});
        System.out.print("\n--------------------\n");
        new Testing().show(11,22,33,44,55);
    }
}
