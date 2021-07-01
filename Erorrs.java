import java.io.*;
import java.nio.file.*;


class Main {
    public static void main (String [] args) {
        String [] arab = new String [] {"10","1","2","3","4","5","6","7","8","9"};
        String [] rome = new String [] {"X","I","II","III","IV","V","VI","VII","VIII","IX"};
        String s1, s2 , s3 ;
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

            for (int i=0; i<10; i++) {
                if (rome[i].equals(s1)) {
                    s1 = arab[i];
                }
                else if (rome[i].equals(s2)) {
                    s2 = arab[i];
                }
                else if (rome[i].equals(s3)) {
                    s3 = arab[i];
                }
            }
            System.out.println (s3);

        }
        catch(IOException ex) {
            System.out.println("123");
        }



        // System.out.println (a1);
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
