import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class CipherDecipher{
    /**
     * This method is used to cipher the message (normal) by following steps.
     * Swap the cases of String - UpperCase letters to LowerCase letters and viceversa.
     * Reverse the String
     * Replace the spaces of string with a star character("*")
     * Replace the characters in the even positions of the string
     * Append any integer at the last in that String
     * 
     * @param normal
     * @return the ciphered message
     */
    public String ciphering(String normal){
        //Write your code here
       
        char c= 0;
        // swapping
        int len = normal.length();
        StringBuffer sb = new StringBuffer(len);
        for(int i = 0;i<len;i++){
            c= normal.charAt(i);
            if(Character.isUpperCase(c)) c= Character.toLowerCase(c);
            else if(Character.isLowerCase(c)) c = Character.toUpperCase(c);
            sb.append(c);
        }
        String result = sb.toString();
        //System.out.println(normal);
        //System.out.println(result);
        
        // reverse string
        StringBuilder strBuild = new StringBuilder(result);
        strBuild = strBuild.reverse();
        result = strBuild.toString();
        //System.out.println(result);
        
        
        result = result.replace(' ', '*');
        //System.out.println(result);
        
        // replace with ascii value
        String newStr = "";
        for(int i = 0;i<result.length();i++){
            if(i%2!=0){
            int m = result.charAt(i);
            newStr = newStr+m;
            }
            else newStr = newStr+result.charAt(i);
        }
        newStr = newStr+"3";
        //System.out.println(newStr);
        
        
        
        return newStr;
        
    }
    /**
     * This method is used to get the normal text by the reverse process of ciphering.
     * 
     * @param ciphered
     * @return the deciphered message
     */
    public String deciphering(String ciphered){
        //Write your code here
        //System.out.println(ciphered);
        ciphered =  ciphered.substring(0,ciphered.length()-1);
        StringBuilder sb2 = new StringBuilder();
        int j;
        //System.out.println(ciphered);
        
        for (int i = 0; i < ciphered.length(); i++) {
            String ss = new String();
            char abc;

            if(Character.isDigit(ciphered.charAt(i)) && Character.isDigit(ciphered.charAt(i+1)) && Character.isDigit(ciphered.charAt(i+2))) {
                ss = ss + ciphered.charAt(i)+ciphered.charAt(i+1)+ciphered.charAt(i+2);
                j = Integer.parseInt(ss);
                if(j>=100 && j<=122){
                    i+=2;
                    abc = (char)j;
                    sb2.append(abc);
                }
            } else if(Character.isDigit(ciphered.charAt(i)) && Character.isDigit(ciphered.charAt(i+1)) &&
                  !Character.isDigit(ciphered.charAt(i+2))){
                      ss = ss + ciphered.charAt(i) + ciphered.charAt(i+1);
                      j= Integer.parseInt(ss);
                      if(j>=10 && j<=99){
                          i = i+1;
                          abc = (char)j;
                          sb2.append(abc);
                      }
                  }
                  else if(Character.isDigit(ciphered.charAt(i)) && !Character.isDigit(ciphered.charAt(i+1))){
                      ss = ss +ciphered.charAt(i);
                      j = Integer.parseInt(ss);
                      if(j>=0 && j<=9){
                          abc = (char)j;
                          sb2.append(abc);
                      }
                  }
            else
                sb2.append(ciphered.charAt(i));
        }
        ciphered = sb2.toString();
        //System.out.println(ciphered);
        
        ciphered = ciphered.replace("*", " ");
        //System.out.println(ciphered);
        
        StringBuilder strBuild = new StringBuilder(ciphered);
        strBuild = strBuild.reverse();
        ciphered = strBuild.toString();
        //System.out.println(ciphered);
        
        char c= 0;
        // swapping
        int len = ciphered.length();
        StringBuffer sb = new StringBuffer(len);
        for(int i = 0;i<len;i++){
            c= ciphered.charAt(i);
            if(Character.isUpperCase(c)) c= Character.toLowerCase(c);
            else if(Character.isLowerCase(c)) c = Character.toUpperCase(c);
            sb.append(c);
        }
        ciphered = sb.toString();
        //System.out.println(ciphered);
        
        
        
        
        
        return ciphered;
    }
}
public class Solution {
    
    public static void main(String[] args){
        Scanner readInput = new Scanner(System.in);
        String normal=readInput.nextLine();
        String ciphered=readInput.nextLine();
        
        CipherDecipher cipherOrDecipher = new CipherDecipher();
        System.out.println(cipherOrDecipher.ciphering(normal));
        System.out.println(cipherOrDecipher.deciphering(ciphered));
        
        

    }
    
}
