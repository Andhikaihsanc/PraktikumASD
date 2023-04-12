import java.util.LinkedList;

public class Kereta {
    public static void main(String[] args) {
        LinkedList <String> gerbong = new LinkedList();
        
        gerbong.add("Pria");
        gerbong.add("Wanita");
        gerbong.add("Anak");
        gerbong.add(2, "Cessa");
        gerbong.addFirst("Kiki");
        // gerbong.clear();
        
        System.out.println("Isi gerbong : \n " + gerbong);
    }
}
