package assignment4;

import java.io.*;
import java.util.ArrayList;

/** class begin
 *##public class assignment4
 *  Program Assignment : 4 
 *  Description: to compute the relative size from data entered.
 */
public class assignment4 {
	
	/* method begin
     * #main
     * entry of this program
     * @param String[] args
     * @return void
     */	
	public static void main(String[] args){
		assignment4 assign = new assignment4();
		
		ArrayList<Double> classLOC = new ArrayList<Double>();
		ArrayList<Double> numOfMethods = new ArrayList<Double>();
		ArrayList<Double> pagesOfCahapter = new ArrayList<Double>();
		
		System.out.println("Enter Class LOC	:");
		classLOC = assign.input();
		System.out.println("Enter Number of Methods	:");
		numOfMethods = assign.input();
		System.out.println("Enter Pages of Chapters :");
		pagesOfCahapter = assign.input();
		
		ArrayList<Double> size1 = new ArrayList<Double>();
		ArrayList<Double> size2 = new ArrayList<Double>();
		
		classLOC = assign.loc_Method(classLOC, numOfMethods);
		classLOC = assign.calLn(classLOC);
		double avg1 = assign.computeMean(classLOC);
		double Sigma1 = assign.computeStdDev(classLOC, avg1);
		size1 = assign.calRanges(avg1, Sigma1);
		size1 = assign.calAntiLn(size1);
		
		pagesOfCahapter = assign.calLn(pagesOfCahapter);
		double avg2 = assign.computeMean(pagesOfCahapter);
		double Sigma2 = assign.computeStdDev(pagesOfCahapter, avg2);
		size2 = assign.calRanges(avg2, Sigma2);
		size2 = assign.calAntiLn(size2);
		
		System.out.println("Relative Size for LOC/Method  :");
		System.out.println("VS:" + String.format("%.4f",size1.get(0)) + "\n" 
		+ " S:" + String.format("%.4f",size1.get(1)) + "\n"  
		+ " M:" + String.format("%.4f",size1.get(2)) + "\n" 
		+ " L:" + String.format("%.4f",size1.get(3)) + "\n"
		+ "VL:" + String.format("%.4f",size1.get(4)));
		System.out.println("Relative Size for Pgs/Chapter :");
		System.out.println("VS:" + String.format("%.4f",size2.get(0)) + "\n" 
		+ " S:" + String.format("%.4f",size2.get(1)) + "\n" 
		+ " M:" + String.format("%.4f",size2.get(2)) + "\n"
		+ " L:" + String.format("%.4f",size2.get(3)) + "\n"
		+ "VL:" + String.format("%.4f",size2.get(4)));
		
		
	}//method end
	
	
	/* method begin
     * #input
     * input numbers (reuse)
     * @param 
     * @return ArrayList<Double>
     */
	public ArrayList<Double> input (){
		String str = "";
		ArrayList<Double> num = new ArrayList<Double>();
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
		return num;
	}//method end
	
	
	/* method begin
     * #computeStdDev
     * compute standard deviation
     * @param ArrayList<Double>
     * @return double
     */
	
	public double computeStdDev(ArrayList<Double> num, double mean) {
		double stdDev = 0.0;
		double temp = 0.0;
		for (int i = 0; i < num.size(); i++) {
			temp = temp + (num.get(i)-mean)*(num.get(i)-mean);
		}
		temp = temp/(num.size()-1);
		stdDev = Math.sqrt(temp);
		return stdDev;
	}//method end

	
	 /* method begin
     * #computeMean
     * compute Mean
     * @param ArrayList<Double>
     * @return double
     */
	public double computeMean(ArrayList<Double> num){
		double mean = 0.0;
		for (int i = 0; i < num.size(); i++) {
			mean += num.get(i);
		}
		mean = mean/num.size();
		return mean;
	}//method end
	
	
	/* method begin
     * #loc_Method
     * calculate LOC/method
     * @param ArrayList<Double> tem1,ArrayList<Double> tem2
     * @return ArrayList<Double>
     */
	public ArrayList<Double> loc_Method (ArrayList<Double> tem1,ArrayList<Double> tem2){
		ArrayList<Double> loc = new ArrayList<Double>();
		for (int i = 0; i < tem1.size(); i++) {
			loc.add(tem1.get(i) / tem2.get(i));
		}
		return loc;
	}//method end
	
	
	/* method begin
     * #calLn
     * calculate the natural logarithm
     * @param ArrayList<Double> tem
     * @return ArrayList<Double> ln
     */
	public ArrayList<Double> calLn(ArrayList<Double> tem){
		ArrayList<Double> ln = new ArrayList<Double>();
		for (int i = 0; i < tem.size(); i++) {
			ln.add(Math.log(tem.get(i)));
		}
		return ln;
	}//method end
	
	
	/* method begin
     * #calAntiLn
     * calculate the anti-logarithm
     * @param ArrayList<Double> tem
     * @return ArrayList<Double> antiLn
     */
	public ArrayList<Double> calAntiLn(ArrayList<Double> tem) {
		ArrayList<Double> antiLn = new ArrayList<Double>();
		for (int i = 0; i < tem.size(); i++) {
			antiLn.add(Math.exp(tem.get(i)));
		}
		return antiLn;
	}//method end
	
	
	/* method begin
     * #calRanges
     * calculate the logarithmic ranges
     * @param double avg,Sigma
     * @return ArrayList<Double> ranges
     */
	public ArrayList<Double> calRanges(double avg,double Sigma) {
		ArrayList<Double> ranges = new ArrayList<Double>();
		
		ranges.add(avg - 2 * Sigma);
		ranges.add(avg - Sigma);
		ranges.add(avg);
		ranges.add(avg + Sigma);
		ranges.add(avg + 2 * Sigma);
		
		return ranges;
	}//method end
}//class end
