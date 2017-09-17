package assignment1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class assignment1 {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Double> num = new ArrayList<Double>();
		String str = "";
		double mean = 0.0;
		double stdDev = 0.0;
		double temp = 0.0;
		int key = 0;
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			while (true) {
				str = br.readLine();
				if (str.equals("end")) {
					break;
				}else{
				num.add(key,Double.parseDouble(str));
				key++;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for (int i = 0; i < num.size(); i++) {
			mean += num.get(i);
		}
		mean = mean/num.size();
		
		for (int i = 0; i < num.size(); i++) {
			temp = temp + (num.get(i)-mean)*(num.get(i)-mean);
		}
		temp = temp/(num.size()-1);
		stdDev = Math.sqrt(temp);
		
        System.out.println(String.format("%.2f", mean));
        System.out.println(String.format("%.2f", stdDev));
	}

}
