package com.company;

import java.util.Scanner;

public class Main {



    public static void main(String[] args) throws Exception {
        // write your code here
        System.out.println("hello world!");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите арифметичское выражение: ");
        String s = scanner.nextLine().replace(" ", "");
        //System.out.println(s);
        String a = "";
        String b= "";
        boolean rim = false;
        boolean arab = false;
        int isCyrilic = 0;

        char symbol = 0;
        for (char rr : s.toCharArray()) {
            if (Character.UnicodeBlock.of(rr) == Character.UnicodeBlock.CYRILLIC) {
                isCyrilic += 1;
            }
            int numParse  = Character.getNumericValue(rr);
            if (numParse == -1 && Character.UnicodeBlock.of(rr) != Character.UnicodeBlock.CYRILLIC) {
                symbol = rr;
            }
            else {
                //System.out.println(numParse);
                if(numParse == 18 || numParse == 31 || numParse == 33 || numParse == 21 || numParse == 12 || numParse == 13 || numParse == 22){
                    rim = true;
                }
                else if (numParse >=0 && numParse <=9){
                    arab = true;
                }else if(numParse > 9 || isCyrilic > 0){
                    throw new Exception("Введены буквы");
                }

                if(arab && rim)
                    throw new Exception("Введены римские и арабские числа");

                if (symbol == 0) {
                    a += Character.toString(rr);
                } else {
                    b += Character.toString(rr);
                }
            }
        }
        int aa;
        int bb;
    if(rim) {
        aa = RimNum.Rim(a);

        bb = RimNum.Rim(b);


        if((aa>10)||bb>10)
        {
            throw new Exception("Введите числа от I до X");
        }
        else {
            int result =  Operation.Sum(aa,bb,symbol);
            String rimNum = Arab2Rim.toRoman(result);
            System.out.println("Ответ:");
            System.out.println(rimNum);
        }

    }

    else if(arab){
        aa = Integer.parseInt(a);
        bb = Integer.parseInt(b);
       if(aa>10||bb>10)
       {
            throw new Exception("Введите числа от 1 до 10");
       }
        else {
            int result = Operation.Sum(aa,bb,symbol);
            System.out.println("Ответ:");
            System.out.println(result);
            }
        }
    }
    }


