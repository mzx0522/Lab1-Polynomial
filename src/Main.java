import java.util.Scanner;

public class Main {
    public static void Derivation(StringBuffer beforeD, String x)//
    {
        StringBuffer afterD = new StringBuffer();
        int count = 0;
        int i;
        char item;
        //
        for (i = 0; i < beforeD.length(); i++) {
            item = beforeD.charAt(i);
            if (item == x.charAt(0)) {
                count++;
            } else if (item != '*') {
                afterD.append(item);
            }
        }
        if (count == 0)//
        {
            afterD.delete(0, afterD.length());
        } else if (count == 1) {
            afterD.append("1");
        } else if (count != 1)//
        {
            afterD.append(Integer.toString(count));
            for (i = 0; i < count - 1; i++) {
                afterD.append(x);
            }
        }
        //
        for (i = 0; i < afterD.length() - 1; i++) {
            //
            if (Character.isDigit(afterD.charAt(i)) & !Character.isDigit(afterD.charAt(i + 1))) {
                afterD.insert(i + 1, '*');
            }
            //
            if (Character.isAlphabetic(afterD.charAt(i)) & i != afterD.length() - 1) {
                afterD.insert(i + 1, '*');
            }
        }
        for (i = 1; i < afterD.length(); i++) {
            //
            if (afterD.charAt(i) == '*' & i == afterD.length() - 1) {
                afterD.deleteCharAt(i);
            }
        }
        System.out.print(afterD);
    }

    //    public static void Simplify(StringBuffer str,String op)
    public static void Analyst(StringBuffer str, String x) {
        int i;
        char item;
        StringBuffer temp = new StringBuffer();
        for (i = 0; i < str.length(); i++) {
            item = str.charAt(i);
            if (item != '+' & item != '-' & i != str.length() - 1) {
                temp.append(item);
            } else {
                Derivation(temp, x);
                temp.setLength(0);
                temp.append(item);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner input = new Scanner(System.in);
        StringBuffer str1 = new StringBuffer(), str2 = new StringBuffer();
        String fact, op, fu;
        int i = 0, a = 0;
        System.out.println("璇疯緭鍏ュ椤瑰紡:");
        System.out.println("鍙橀噺涓嶅彲瓒呰繃涓変釜涓斿繀椤讳负:x,y,z");
        str1.append(input.next());
        str2.append(str1);
        op = str2.toString();
        while (!op.contains("a")) {
            if (op.contains("simplify")) {
                for (i = 1; i < 4; i++) {
                    fu = input.next();
                    if (fu != null) {
                        for (a = 0; a < str1.length(); a++) {
                            if (str1.charAt(a) == fu.charAt(0)) {
                                str1.replace(a, a + 1, fu.substring(2, fu.length()));
                            }
                        }
                        System.out.println(str1);
                        //Simplify(str1,fu);
                    } else {
                        System.out.println(str1);
                    }
                }
            } else if (op.contains("d/d")) {
                fact = input.next();
                if (str1.indexOf(fact) != -1) {
                    System.out.println("姹傚缁撴灉涓�:");
                    Analyst(str1, fact);
                } else {
                    System.out.println("ERROR,No variable");
                }
            } else {
                str1.delete(0, str1.length());
                str1.append(str2);
                System.out.println("鎮ㄨ緭鍏ョ殑澶氶」寮忔槸:");
                System.out.println(str1);
            }
            str2.delete(0, str2.length());
            str2.append(input.next());
            op = str2.toString();
        }
        input.close();
        System.exit(0);
    }
}