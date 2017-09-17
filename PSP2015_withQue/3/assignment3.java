package Assignment;

import java.util.ArrayList;

/**class begin
 *##public class assignment3
 * Program Assignment: 3
 * Description: to compute ¦Â.
 */
public class assignment3 {
    
	/* method begin
     * #main
     * entry of this programme
     * @param
     * @return
     */	
	
	public static void main(String[] args) {
		assignment3 as3 = new assignment3();
		assignment1 as1 = new assignment1();
		ArrayList<Double> beta0 = new ArrayList<Double>();
		ArrayList<Double> beta1 = new ArrayList<Double>();
		ArrayList<Double> R = new ArrayList<Double>();
		ArrayList<Double> R2 = new ArrayList<Double>();
		ArrayList<Double> Yk = new ArrayList<Double>();
		
		ArrayList<Double> num1;
		ArrayList<Double> num2;
		ArrayList<Double> num3;
		ArrayList<Double> num4;
		
		System.out.println("Input num1: ");
		num1 = as1.input();
		System.out.println("Input num2: ");
		num2 = as1.input();
		System.out.println("Input num3: ");
		num3 = as1.input();
		System.out.println("Input num4: ");
		num4 = as1.input();
	
		
		beta0.add(as3.computeBeta0(num1, num3));
		beta0.add(as3.computeBeta0(num1, num4));
		beta0.add(as3.computeBeta0(num2, num3));
		beta0.add(as3.computeBeta0(num2, num4));
		
		beta1.add(as3.computeBeta1(num1, num3));
		beta1.add(as3.computeBeta1(num1, num4));
		beta1.add(as3.computeBeta1(num2, num3));
		beta1.add(as3.computeBeta1(num2, num4));
		
		R.add(as3.computeR(num1, num3));
		R.add(as3.computeR(num1, num4));
		R.add(as3.computeR(num2, num3));
		R.add(as3.computeR(num2, num4));
		
		R2.add(as3.computeR(num1, num3)*as3.computeR(num1, num3));
		R2.add(as3.computeR(num1, num4)*as3.computeR(num1, num4));
		R2.add(as3.computeR(num2, num3)*as3.computeR(num2, num3));
		R2.add(as3.computeR(num2, num4)*as3.computeR(num2, num4));
		
		
		for (int j = 0; j < 4; j++) {
			Yk.add(beta0.get(j)+beta1.get(j)*386);
		}
		
		
		for (int j = 0; j < 4; j++) {
		    System.out.println("Test"+(j+1)+":"+"\n"+"beta0 = "+beta0.get(j)+"     "+"beta1 = "
		                 +beta1.get(j)+"     "+"R = "+ R.get(j) +"     "+"R2 = "+R2.get(j) +"     " +"Yk = "+Yk.get(j));
		}
		
		
		
	}//method end
	
	/* method begin
	 * #public double multiplyAdd
	 * @param ArrayList<Double> , ArrayList<Double>
	 * @return double
	 */
	
	public double multiplyAdd (ArrayList<Double> x,ArrayList<Double> y){
		double sum = 0.0;
		for (int i = 0; i < x.size(); i++) {
			sum = sum + x.get(i)*y.get(i);
		}
		return sum;
	}//method end
	
	/* method begin
	 * #public double computeBeta1
	 * @param ArrayList<Double> , ArrayList<Double>
	 * @return double
	 */
	
	public double computeBeta1(ArrayList<Double> x,ArrayList<Double> y){
		assignment3 as3 = new assignment3();
		assignment1 as1 = new assignment1();
		double sum = 0.0;
		double n = (double)x.size();
		double avgX = 0.0;
		double avgY = 0.0;
		avgX = as1.computeMean(x);
		avgY = as1.computeMean(y);
		sum = (as3.multiplyAdd(x, y)-n*avgX*avgY)/(as3.multiplyAdd(x, x)-n*avgX*avgX);
		return sum;
	}//method end
	
	/* method begin
	 * #public double computeBeta0
	 * @param ArrayList<Double> , ArrayList<Double>
	 * @return double
	 */
	
	public double computeBeta0(ArrayList<Double> x,ArrayList<Double> y){
		assignment3 as3 = new assignment3();
		assignment1 as1 = new assignment1();
		double sum = 0.0;
		sum = as1.computeMean(y) - as3.computeBeta1(x, y)*as1.computeMean(x);
		return sum;
	}//method end
	
	/* method begin
	 * #public double computeR
	 * @param ArrayList<Double> , ArrayList<Double>
	 * @return double
	 */
	
	public double computeR(ArrayList<Double> x, ArrayList<Double> y){
		assignment3 as3 = new assignment3();
		double sum = 0.0;
		double n = (double)x.size();
		ArrayList<Double> ones = new ArrayList<Double>();
		for (int i = 0; i < x.size(); i++) {
			ones.add(1.0);
		}
		sum = (n*as3.multiplyAdd(x, y)-as3.multiplyAdd(x, ones)*as3.multiplyAdd(y, ones))
				/(Math.sqrt((n*as3.multiplyAdd(x, x)-as3.multiplyAdd(x, ones)*as3.multiplyAdd(x, ones))*(n*as3.multiplyAdd(y, y)-as3.multiplyAdd(y, ones)*as3.multiplyAdd(y, ones))));
		
		return sum;
	}//method end

}//class end
