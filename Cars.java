import java.util.Scanner;

public class Cars {
 public static void main(String[] args) {
    Scanner scan = new Scanner (System.in);
    int n = scan.nextInt();
    int bil = 0;
    
    for (int i = 0; i < n; i++){;
        for (int j = 0; j <= i; j++){
            System.out.print (bil%10);
            bil++;
            
        }
    System.out.println("");
    }
}
}
