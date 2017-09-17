
package Assignment;
 
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

  
/** class begin
 *##public class assignment1
 *  Program Assignment : 1 
 *  Description: to compute the mean and standard deviation of several numbers from input
 */

public class assignment1 {

    /* method begin
     * #main
     * entry of this programme
     * @param
     * @return
     */	
	
	public static void main(String[] args) {
		ArrayList<Double> num = new ArrayList<Double>();
		double mean = 0.0;
		double stdDev = 0.0;
		assignment1 as = new assignment1();
		num = as.input();
		mean = as.computeMean(num);
		stdDev = as.computeStdDev(num, mean);
		
        System.out.println(String.format("%.2f", mean));
        System.out.println(String.format("%.2f", stdDev));
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
     * #input
     * input numbers
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
}//class end
