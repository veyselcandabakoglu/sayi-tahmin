import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Random rnd = new Random();
        int number = rnd.nextInt(100);

        Scanner input = new Scanner(System.in);
        int right = 0;
        int selected;
        int[] wrong = new int[5];
        boolean isWin = false;
        boolean isWrong = false;
        
        System.out.println(number);

        while(right < 5) {
            System.out.print("Lütfen Tahmininizi Giriniz: ");
            selected = input.nextInt();

            if(selected < 0 || selected > 99) {
                System.out.println("Lütfen 0-100 arasınnda değer giriniz!");
                if(!isWrong) {
                    isWrong = true;
                    System.out.println("Bir Daha Hatalı Girişinizde Hakkınızdan Düşülecektir.");
                } else {
                    System.out.println("Çok fazla hatalı giriş yaptınız! Kalan Hakkınız: "+ (5-(++right)));
                }
                continue;
            }

            if(selected == number) {
                isWin = true;
                System.out.println("Tebrikler, doğru tahmin! Tahmin ettiğiniz sayı: "+ number);
                break;
            } else {
                System.out.println("Hatalı bir sayı girdiniz!");
                if(selected > number) {
                    System.out.println(selected + " sayısı gizli sayıdan büyüktür!");
                } else {
                    System.out.println(selected + " sayısı gizli sayıdan küçüktür!");
                }
                 wrong[right] = selected;
                 right++;
                System.out.println("Kalan hakkınız: "+ (5-right));

            }
        }
            input.close();
            if(!isWin ) {
                System.out.println("Kaybettiniz!");
                if(!isWrong) {
                    System.out.println("Tahminleriniz: " + Arrays.toString(wrong));
                }
                System.out.println("Gizli Sayı: "+ number);
            }
    }
}