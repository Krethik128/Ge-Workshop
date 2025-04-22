//Find the character that appears most frequently in a given string.
package com.gevernova.workshopThree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MostFrequentChar {
    static void  mostFrequentCharUsingHashmap(String s){
        ArrayList<Character> list=new ArrayList<Character>();
        int maxCount=0;
        String temp=s.toLowerCase();
        HashMap<Character,Integer>map =new HashMap<>();
        for(int i=0;i<temp.length();i++){
            char ch=temp.charAt(i);
            if(ch!=' ') {
                map.put(ch,map.getOrDefault(ch,0)+1);
                if(map.get(ch)>maxCount){
                    maxCount=map.get(ch);
                    while(!list.isEmpty()){
                        list.remove(0);
                    }
                    list.add(ch);
                }
                else if(map.get(ch)==maxCount){
                    list.add(ch);
                }

            }
        }

//        for(Map.Entry<Character,Integer> entry: map.entrySet() ){
//            char key= entry.getKey();
//            int val=entry.getValue();
//            if(val==maxCount){
//                list.add(key);
//            }
//        }
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i)+" Appears "+maxCount+" Times");
        }
    }
    static void mostFrequentCharUsingFreqArray(String s){
        int []freq=new int[26];
        s=s.toLowerCase();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch!=' ') {
                freq[ch - 'a']++;
            }
        }
        char mostFrequentChar=s.charAt(0);
        int maxCount=0;
        for(int i=0;i<freq.length;i++){
            if(freq[i]>maxCount){
                maxCount=freq[i];
                mostFrequentChar=(char)('a'+i);
            }
        }
        System.out.println("The character that appears most frequently in a given string is "+mostFrequentChar);
        System.out.println(maxCount+" Times");

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the String :");
        String s=sc.nextLine();
        mostFrequentCharUsingHashmap(s);
//        mostFrequentCharUsingFreqArray(s);
    }
}
