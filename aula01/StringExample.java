package aula01;

public class StringExample {
    public static void main(String[] args) {
        String st = "programar em java";
        System.out.println(st.split("")[0] + "é engraçado!!");
        for (int i = 1; i < 10; i++) {
            System.out.println("Não vou " + st + " na aula " + i);
        }
    }
}
