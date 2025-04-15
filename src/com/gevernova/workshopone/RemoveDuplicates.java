package com.gevernova.workshopone;

import java.util.*;
public class RemoveDuplicates{
    public static int[] sort(int arr[]){
        int n=arr.length;
        boolean swapp;
        for(int i=0;i<n-1;i++){
            swapp=false;
            for(int j=0;j<n-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    swapp=true;
                }
            }
            if(!swapp) break;
        }
        return arr;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the no of elements: ");
        int n=sc.nextInt();
        int[] arr1=new int[n];
        for(int i=0;i<n;i++){
            arr1[i]=sc.nextInt();
        }
        int [] Sortedarr=sort(arr1);
        int count=0;
        int []newarr=new int[n];
        for(int i=0;i<Sortedarr.length;i++){
            if(i!=n-1 && Sortedarr[i]==Sortedarr[i+1]){
                while(i!=n-1 && Sortedarr[i]==Sortedarr[i+1]){
                    i++;
                }
                if(i==n-1){
                    newarr[count]=Sortedarr[i];
                    count++;
                    break;
                }
                else{
                    newarr[count]=Sortedarr[i];
                    count++;
                }
            }
            else{
                newarr[count]=Sortedarr[i];
                count++;
            }

        }

        for(int i=0;i<count;i++){
            System.out.print(newarr[i]+" ");
        }


    }
}

