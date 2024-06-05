package com.clrs;

import java.util.Arrays;
import java.util.Comparator;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

public class FractionalKnapsack {

	public static void main(String[] args) {
		Item[] arr = new Item[3];
		arr[0] = new Item(100,50);
		arr[1] = new Item(70,40);
		arr[2] = new Item(45,20);
		
		int W = 100;
		double max = new FractionalKnapsack().fractionalKnapsack(W, arr, arr.length);
		System.out.println("Max = "  + max);
	}
	
    double fractionalKnapsack(int w, Item arr[], int n) {
       
    	Comparator<Item> valWtRatioComparator = new Comparator<Item>() {
			@Override
			public int compare(Item o1, Item o2) {
				// TODO Auto-generated method stub
				double ratio1 = (double)o1.value /(double)o1.weight;
				double ratio2 = (double)o2.value /(double)o2.weight;
				
				if(ratio1 > ratio2) {
					return -1;
				} else {
					return 1;
				}
			}
		};
		
		
		// Sort the array according to the (value/weight) comparator
		Arrays.sort(arr, valWtRatioComparator);		
		
		double wi, vali;
		double totalVal = 0;
		double rWt = w;
		int i=0;
		while(rWt>0 && i<n) {
			wi = arr[i].weight;
			vali = arr[i].value;
			if(wi > rWt) {
				double val = rWt * (vali)/wi;
				totalVal += val;
				break;
			} else {
				rWt = rWt - wi;
				totalVal += vali;
			}
			i++;
		}
		
		return totalVal;
    }
}
