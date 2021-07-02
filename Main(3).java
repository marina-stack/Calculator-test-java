import java.io.*;
import java.nio.file.*;


class Main {
    public static void main(String[] args) throws IOException {
        String [] arab = new String [] {"10","1","2","3","4","5","6","7","8","9", "20", "30", "40", "50", "60", "70", "80", "90", "100"};
        String [] rome = new String [] {"X","I","II","III","IV","V","VI","VII","VIII","IX", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC", "C"};
        String s1, sign, s3;
        int a1 = 0, b1 = 0, flag = 0, k = 0;

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("inlet.txt"));
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Введите число, знак и число");
            System.out.println("Ввод пустой сточки закрывает возможноть дальнейшего ввода");
            String s;
            while (!(s = br.readLine()).equals("")) {
                bw.write(s + "\n");
                bw.flush();
            }
            s1 = Files.readAllLines(Paths.get("inlet.txt")).get(0);
            s3 = Files.readAllLines(Paths.get("inlet.txt")).get(2);
            sign = Files.readAllLines(Paths.get("inlet.txt")).get(1);

            int i;
            for (i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (((s1.equals(rome[i]) & (s3.equals(rome[j])) || (s3.equals(rome[i]) & (s1.equals(rome[j])))))) {
                        flag = flag + 2;
                        if (rome[i].equals(s1)) {
                            s1 = arab[i];
                        } else if (rome[i].equals(s3)) {
                            s3 = arab[i];
                        }
                    } else if (((s1.equals(arab[i]) & (s3.equals(arab[j])) || (s3.equals(arab[i]) & (s1.equals(arab[j])))))) {
                        flag = flag + 3;
                    } else {
                        flag = flag + 1;
                    }
                }
            }

            switch (flag) {
                case 1:
                    System.out.println ("Введена неверная пара чисел");
                    break;
                case 2:

            }

        }

        int i;
        for (i = 0; i < 10; i++) {
                if (rome[i].equals(s1)) {
                    s1 = arab[i];
                } else if (rome[i].equals(sign)) {
                    sign = arab[i];
                } else if (rome[i].equals(s3)) {
                    s3 = arab[i];
                }
            }
            a1 = Integer.parseInt(s1.trim());
            b1 = Integer.parseInt(s3.trim());

            if (((a1 > 0) & (a1 <= 10)) & ((b1 > 0) & (b1 <= 10))) {
                switch (sign) {
                    case "+" -> {
                        Addition v1 = new Addition();
                        v1.a = a1;
                        v1.b = b1;
                        v1.displayInfo();
                    }
                    case "-" -> {
                        Subtraction v2 = new Subtraction();
                        v2.a = a1;
                        v2.b = b1;
                        k = v2.displayInfo();
                    }
                    case "*" -> {
                        Multiplication v3 = new Multiplication();
                        v3.a = a1;
                        v3.b = b1;
                        v3.displayInfo();
                    }
                    case "/" -> {
                        Division v4 = new Division();
                        v4.a = a1;
                        v4.b = b1;
                        v4.displayInfo();
                    }
                    default -> System.out.println("Введен неверный знак");
                }

            } else {
                System.out.println("Введено неверное число");
            }


        }
        }


class Addition {
    int a, b;
    void displayInfo () {
        System.out.print(a+b);
    }
}
class Subtraction {
    int a, b;
    int displayInfo () {
        System.out.print(a-b);
        return 0;
    }
}

class Multiplication {
    int a, b;
    void displayInfo () {
        System.out.print(a*b);
    }
}

class Division {
    int a, b;

    void displayInfo() {
        System.out.print(a / b);
    }
}
