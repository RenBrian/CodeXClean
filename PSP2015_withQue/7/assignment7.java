package Assignment;

import java.util.ArrayList;

/** class begin
 *##public class assignment7
 *  Program Assignment : 7
 *  Description: to find corresponding x of a certain p and dof
 */
public class assignment7 {
	
	static int n = 6;
	static double Wk = 185;
	static double Xk = 150;
	static double Yk = 45;
	/* method begin
     * #main
     * entry of this program
     * @param String[] args
     * @return void
     */	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		assignment1 as1 = new assignment1();
		assignment3 as3 = new assignment3();
		assignment7 as7 = new assignment7();
		ArrayList<Double> num1;
		ArrayList<Double> num2;
		ArrayList<Double> num3;
		ArrayList<Double> num4;
		double[][] gauss = new double[4][5];
		double[] coef = new double[4];
		double z = 0.0;
		double range = 0.0;
		double UPI = 0.0;
		double LPI = 0.0;
		
		ArrayList<Double> ones = new ArrayList<Double>();
		for (int i = 0; i < 6; i++) {
			ones.add(1.0);
		}
		
		System.out.println("Input num1: ");
		num1 = as1.input();
		System.out.println("Input num2: ");
		num2 = as1.input();
		System.out.println("Input num3: ");
		num3 = as1.input();
		System.out.println("Input num4: ");
		num4 = as1.input();
		
		gauss[0][0] = n;
		gauss[0][1] = as3.multiplyAdd(ones, num1);
		gauss[1][0] = as3.multiplyAdd(ones, num1);
		gauss[0][2] = as3.multiplyAdd(ones, num2);
		gauss[2][0] = as3.multiplyAdd(ones, num2);
		gauss[1][1] = as3.multiplyAdd(num1, num1);
		gauss[0][3] = as3.multiplyAdd(ones, num3);
		gauss[3][0] = as3.multiplyAdd(ones, num3);
		gauss[2][1] = as3.multiplyAdd(num2, num1);
		gauss[1][2] = as3.multiplyAdd(num2, num1);
		gauss[0][4] = as3.multiplyAdd(ones, num4);
		gauss[3][1] = as3.multiplyAdd(num1, num3);
		gauss[1][3] = as3.multiplyAdd(num1, num3);
		gauss[2][2] = as3.multiplyAdd(num2, num2);
		gauss[2][3] = as3.multiplyAdd(num2, num3);
		gauss[3][2] = as3.multiplyAdd(num2, num3);
		gauss[3][3] = as3.multiplyAdd(num3, num3);
		gauss[1][4] = as3.multiplyAdd(num1, num4);
		gauss[2][4] = as3.multiplyAdd(num2, num4);
		gauss[3][4] = as3.multiplyAdd(num3, num4);
		
		double avgW = as1.computeMean(num1);
		double avgX = as1.computeMean(num2);
		double avgY = as1.computeMean(num3);
		double avgZ = as1.computeMean(num4);
		coef = as7.calGauss(gauss);
		double stdDev = as7.calStdDev7(num1, num2, num3, num4, coef);
		
		z = coef[0] + coef[1]*Wk + coef[2]*Xk + coef[3]*Yk;
		
		double sum1 = 0.0;
		double sum2 = 0.0;
		double sum3 = 0.0;
		for (int i = 0; i < num1.size(); i++) {
			sum1+=(num1.get(i)-avgW)*(num1.get(i)-avgW);
		}
		for (int i = 0; i < num2.size(); i++) {
			sum2+=(num2.get(i)-avgX)*(num2.get(i)-avgX);
		}
		for (int i = 0; i < num3.size(); i++) {
			sum3+=(num3.get(i)-avgY)*(num3.get(i)-avgY);
		}
		
		range = 1.386*stdDev*Math.sqrt(1+1.0/n+(Wk-avgW)*(Wk-avgW)/sum1+(Xk-avgX)*(Xk-avgX)/sum2+(Yk-avgY)*(Yk-avgY)/sum3);
		
		UPI = z+range;
		LPI = z-range;
		System.out.println("z = "+z+"\n"+"UPI = "+UPI+"\n"+"LPI = "+ LPI);
		
		
	}//method end
	
	/* method begin
	 * #calGauss
	 * calGauss
	 * @param double[][]
	 * @return double[]
	 */	
	public double[] calGauss(double[][] gauss){
		double[] coef = new double[4];
		for (int j = 0; j < gauss.length; j++) {
			double key = gauss[j][j];
			for (int i = 0; i < gauss[0].length; i++) {
				gauss[j][i] = gauss[j][i]/key;
			}
			
			int k = j+1;
			for (; k < gauss.length; k++) {
				double m = gauss[k][j]/gauss[j][j];
				for (int t = 0; t < gauss[0].length; t++) {
					gauss[k][t] = gauss[k][t]- m*gauss[j][t];
				}
			}
			
		}
		coef[coef.length-1] = gauss[3][4];
		coef[coef.length-2] = gauss[2][4] - gauss[2][3]*coef[coef.length-1];
		coef[coef.length-3] = gauss[1][4] - gauss[1][3]*coef[coef.length-1] - gauss[1][2]*coef[coef.length-2];
		coef[coef.length-4] = gauss[0][4] - gauss[0][3]*coef[coef.length-1] - gauss[0][2]*coef[coef.length-2] - gauss[0][1]*coef[coef.length-3];
		return coef;
	}//method end
	
    
    /* method begin
	 * #calStdDev7
	 * calStdDev7
	 * @param ArrayList<Double>
	 * @return double
	 */	
    public double calStdDev7(ArrayList<Double> num1,ArrayList<Double> num2,ArrayList<Double> num3,ArrayList<Double> num4,double[] coef){
    	double stdDev = 0.0;
    	for (int i = 0; i < num1.size(); i++) {
			stdDev= stdDev+1.0/(n-4)*(num4.get(i)- coef[0] -num1.get(i)*coef[1] -num2.get(i)*coef[2] - num3.get(i)*coef[3])*
					(num4.get(i)- coef[0] -num1.get(i)*coef[1] -num2.get(i)*coef[2] - num3.get(i)*coef[3]);
		}
    	stdDev = Math.sqrt(stdDev);
    	return stdDev;
    }//method end
}//class end
