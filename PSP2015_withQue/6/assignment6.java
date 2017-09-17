package Assignment;

import java.util.ArrayList;

/** class begin
 *##public class assignment6
 *  Program Assignment : 6
 *  Description: to find corresponding x of a certain p and dof
 */
public class assignment6 {
    
	/* method begin
     * #main
     * entry of this program
     * @param String[] args
     * @return void
     */	
	public static void main(String[] args){
		double error = 0.00000001d;
		assignment1 assign1 = new assignment1();
    	assignment6 assign6 = new assignment6();
    	ArrayList<Double> x = new ArrayList<Double>();
        System.out.println("Input a x:");
    	x = assign1.input();
    	double dev = 0.5;
    	
    	assignment5 assign = new assignment5();
		ArrayList<Double> inNum = new ArrayList<Double>();
		System.out.println("Enter 'dof' and 'p':");
		inNum = assign.input();
		String dirtyBit1 = "0";
		String dirtyBit2 = "0";
		
		double p0 = assign6.getP(x, inNum);
		if (!assign.compare(p0, inNum.get(1), error)) {
			dirtyBit1 = assign6.checkMoreOrLess(p0, inNum.get(1));
			if (dirtyBit1.equals("0")) {
				x.set(0, x.get(0)+dev);
			}else {
				x.set(0, x.get(0)-dev);
			}
		}
		while (!assign.compare(assign6.getP(x, inNum), inNum.get(1), error)) {
			p0 = assign6.getP(x, inNum);
			dirtyBit2 = assign6.checkMoreOrLess(p0, inNum.get(1));
			if (assign6.checkBF(dirtyBit1, dirtyBit2)) {
				dev = dev*0.5;
			}
			if (dirtyBit2.equals("0")) {
				x.set(0, x.get(0)+dev);
			}else {
				x.set(0, x.get(0)-dev);
			}
			dirtyBit1 = dirtyBit2;
		}
		System.out.println("x = "+ x.get(0));
    }//method end
	
	/* method begin
     * #getP
     * get p
     * @param ArrayList<Double>,ArrayList<Double>
     * @return double
     */	
	public double getP (ArrayList<Double> x, ArrayList<Double> inNum){
		assignment5 assign = new assignment5();
		int num_seg = 100000;
		int a = 0;
		double error = 0.00000001d;
		double one = assign.calP(x.get(0), num_seg, x.get(0) / num_seg, inNum.get(0));
		num_seg = num_seg * 2;
		double two = assign.calP(x.get(0), num_seg, x.get(0) / num_seg, inNum.get(0));
		while (! assign.compare(one, two, error)) {
			System.out.println(a);
			one = two;
			num_seg = num_seg * 2;
			two = assign.calP(x.get(0), num_seg, x.get(0) / num_seg, inNum.get(0));
			a++;
		}
		return two;
	}//method end
	
	/* method begin
     * #checkMoreOrLess
     * check more or less
     * @param double, double
     * @return String
     */	
	public String checkMoreOrLess(double p0, double p) {
		String key = "0";
		if (p0>p) {
			key = "1";
		}
		return key;
	}//method end
	
	/* method begin
     * #CheckBF
     * decide if we should halve dev
     * @param String, String
     * @return boolean
     */	
	public boolean checkBF(String dirtyBit1,String dirtyBit2){
		if (dirtyBit1 == dirtyBit2) {
			return false;
		}
		return true;
	}//method end
}//class end
