package assignment5;

import java.io.*;
import java.util.ArrayList;

/** class begin
 *##public class assignment5
 *  Program Assignment : 5 
 *  Description: to numerically integrate a function using Simpson¡¯s rule
 */
public class assignment5 {
	
	/* method begin
     * #main
     * entry of this program
     * @param String[] args
     * @return void
     */	
	public static void main(String[] args){
		
		double a = 0.33,b = 0.33300;
		System.out.println(Double.compare(a,b));
		
		assignment5 assign = new assignment5();
		ArrayList<Double> inNum = new ArrayList<Double>();
		System.out.println("Enter 'x' and 'dof':");
		inNum = assign.input();
		
		int num_seg = 10;
		double e = 0.00001d;
		double one = assign.calP(inNum.get(0), num_seg, inNum.get(0) / num_seg, inNum.get(1));
		num_seg = num_seg * 2;
		double two = assign.calP(inNum.get(0), num_seg, inNum.get(0) / num_seg, inNum.get(1));
		while (! assign.compare(one, two, e)) {
			System.out.println(assign.compare(one, two, e));//
			one = two;
			num_seg = num_seg * 2;
			two = assign.calP(inNum.get(0), num_seg, inNum.get(0) / num_seg, inNum.get(1));
		}
		System.out.println( "p = " + String.format("%.5f", two));
	}//method end
	
	
	/* method begin
	 * #compare
	 * to compare to judge whether it's accurate enough
	 * @param double one,double two,double e
	 * @param double result
	 */
	public boolean compare (double one,double two,double e){
		boolean compare = false;
		if (Math.abs(one - two) < e) {
			compare = true;
		}
		return compare;
	}//method end
	
	
	/* method begin
	 * #calP
	 * to calculate P
	 * @param double num_seg,double w,double e,double dof
	 * @param double result
	 */
	public double calP(double x,int num_seg,double w,double dof) {
		double result = 0.0d;
		double num1 = 0.0d;
		double num2 = 0.0d;
		
		
		for (int i = 1; i <= num_seg - 1; i+=2) {
			num1 += calFx(i * x / num_seg, dof);
		}
		for (int i = 2; i <= num_seg - 2; i+=2) {
			num2 += calFx(i * x / num_seg, dof);
		}
		
		result = (w / 3) * (calFx(0, dof) + 4 * num1 + 2 * num2 + calFx(x, dof));
		return result;
	}//method end
	
	
	/* method begin
	 * #calFx
	 * to calculate Function F
	 * @param double x,double dof
	 * @param double result
	 */
	public double calFx(double x,double dof) {
		double result = 0.0d;
		double num = (dof + 1) / 2.0;
		result = gamma(num) * Math.pow((1 + (x * x) / dof),-num) / (Math.sqrt(dof * Math.PI) * gamma(dof / 2));
		return result;
	}//method end
	

	/* method begin
	 * #gamma
	 * gamma function
	 * @param double x
	 * @return double gamma
	 */
	public double gamma(double x) {
		
		if (x == 1.0) {
			return 1.0;
		}else if (x == 0.5){
			return Math.sqrt(Math.PI);
		}else {
			return (x - 1) * gamma(x-1);
		}
	}//method end
	
	
	/* method begin
	 * #input
	 * input numbers (reuse)
	 * @param 
	 * @return ArrayList<Double>
	 */
	public ArrayList<Double> input (){
		String str = null;
		ArrayList<Double> num = new ArrayList<Double>();
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			while (true) {
				str = br.readLine();
				if (str.equals("end")) {
					break;
				}else{
					num.add(Double.parseDouble(str));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return num;
	}//method end
	
}//class end