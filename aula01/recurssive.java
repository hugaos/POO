package aula01;

public class recurssive {
    public static void main(String[] args) {
        recursiveMethod(100);
    }

    public static void recursiveMethod(int x) {
        System.out.println(x);
        x -= 1;
        if (x > 0) {
            recursiveMethod(x);
        }
    }
}
