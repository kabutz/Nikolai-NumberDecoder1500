import java.util.Scanner;

import static java.lang.Character.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static String number;
    public static CharSequence decoder(String num){

        number = num;
        StringBuilder numba = new StringBuilder();

        if(number.length()==10){
            for(int i = 1; i<=10; i++) {
                if (i==1)
                    numba.append("(");
                if(i == 4)
                    numba.append(") ");
                if(i==7)
                    numba.append("-");
                char c = number.charAt(i-1);
                if(isDigit(c)){
                    numba.append(c);
                }else{
                    if(isLowerCase(c)){
                    c = toUpperCase(c);}
                    if(c == 'A'|| c== 'B' || c=='C'){
                        numba.append('2');
                    }else if(c == 'D'|| c== 'E' || c=='F'){
                        numba.append('3');
                    }else if(c == 'G'|| c== 'H' || c=='I'){
                        numba.append('4');
                    }else if(c == 'J'|| c== 'K' || c=='L'){
                        numba.append('5');
                    }else if(c == 'M'|| c== 'N' || c=='O'){
                        numba.append('6');
                    }else if(c == 'P'|| c== 'Q' || c=='R'|| c=='S'){
                        numba.append('7');
                    }else if(c == 'T'|| c== 'U' || c=='V'){
                        numba.append('8');
                    }else if(c == 'W'|| c== 'X' || c=='Y'|| c=='Z'){
                        numba.append('9');
                    }

                }
            }


        }else if(number.length()!=10&&!(number.equals("0"))){
            System.out.println("the Number needs to be 10 digits. Try again:");
            String n = sc.nextLine();

            System.out.println(decoder(n));

        }else if(number.equals("0")){
            System.exit(0);

        }
        return numba;





    }





    public static void main(String[] args) {

        System.out.println("input phone number(0+enter to exit): ");
        String n = sc.nextLine();

        System.out.println(decoder(n));






    }
}