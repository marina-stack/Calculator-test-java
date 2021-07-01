import java.io.*;
import java.nio.file.*;


class Main {
    public static void main (String [] args) throws IOException {
        String s1 = null, s2 = null, s3 = null;
        int a1 = 0, b1=0;
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("inlet.txt"));
            BufferedReader br = new BufferedReader (new InputStreamReader(System.in))) {
                System.out.println ("Введите число знак и число");
                System.out.println ("Ввод пустой сточки закрывает возможноть дальнейшего ввода");
                String s;
                while(!(s=br.readLine()).equals("")) {
                    bw.write(s + "\n");
                    bw.flush();
                }
                s1 = Files.readAllLines(Paths.get("inlet.txt")).get(1);
                s3 = Files.readAllLines(Paths.get("inlet.txt")).get(3);
                s2 = Files.readAllLines(Paths.get("inlet.txt")).get(2);
                assert s1 != null;
                a1 = Integer.parseInt(s1.trim());
                assert s3 != null;
                b1 = Integer.parseInt(s3.trim());
            }
            catch(IOException ex) {
                System.out.println(ex.getMessage());
        }



        System.out.println (a1);
    }
}






class Subtraction {
    int a = 7, b = 4;
    void displayInfo () {
        System.out.print(a-b);
    }
}

class Multiplication {
    int a = 7, b = 4;
    void displayInfo () {
        System.out.print(a*b);
    }
}

class Division {
    int a = 7, b = 4;

    void displayInfo() {
        System.out.print(a / b);
    }
}
