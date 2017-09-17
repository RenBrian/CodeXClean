package Assignment;

import java.io.*;
import java.util.ArrayList;



/**class begin
 *##public class assignment2
 * Program Assignment: 2
 * Description: to compute the LOC,number and size of classes and methods of a program.
 */
public class assignment2 {
	/* method begin
	 * #main
	 * @param 
	 * @return
	 */
	public static void main(String[] args){
		assignment2 as = new assignment2();
		int lineOfCode = 0;
		ArrayList<String> classname = new ArrayList<String>();
		ArrayList<Integer> classes = new ArrayList<Integer>();
		ArrayList<String> methodname = new ArrayList<String>();
		ArrayList<Integer> methods = new ArrayList<Integer>();
		try{
			File file = new File("assignment3.java");
			FileReader fileReader = new FileReader(file);
			BufferedReader br = new BufferedReader(fileReader);
			String line = null;
			//逐行扫描
			while ((line = br.readLine())!= null){
				//判断是否为类
				if (as.isClassBegin(line)){
					int lineOfClass = 0;
					//在类中扫描
					do {
						line = br.readLine();
						if (as.isClassName(line)) {
							classname.add(line.trim());
						}		
						if (as.isMethodBegin(line)) {
							int lineOfMethod = 0;
							//在方法中扫描
							do {
								line = br.readLine();
								
								if (as.isMethodName(line)){
									methodname.add(line.trim());
								}
								if (as.isLgline(line)) {
									lineOfCode++;
									lineOfMethod++;
									lineOfClass++;
								}
							} while (!as.isMethodOver(line));
							methods.add(lineOfMethod);
						}
						if(as.isLgline(line)){
						lineOfClass ++;
						lineOfCode ++;
						}
					} while (!as.isClassOver(line));
					classes.add(lineOfClass);
				}
				if (as.isLgline(line))
					lineOfCode ++;
			}
			br.close();
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	System.out.println("The program size is:       "+ lineOfCode);
	System.out.println("The number of classes is:  "+ classes.size());
	for (int i = 0; i < classes.size(); i++) {
		System.out.println(classname.get(i).substring(2) + " : " + classes.get(i)+" ");
	}
	System.out.println("\n");
	System.out.println("The number of methods is:  "+ methods.size());
    for (int i = 0; i < methods.size(); i++) {
		System.out.println(methodname.get(i).substring(2) + " : " + methods.get(i)+" ");
	}	
	}//method end
	
	/* method begin
	 * #public boolean isLgline
	 * @param String
	 * @return boolean
	 */
	public boolean isLgline(String eachLine){
		boolean isLgline = false;
		
		if (eachLine.endsWith(";")){
			isLgline = true;
		}
		else if(eachLine.contains("{") ){
			
			isLgline = true;
		}
		else {
			isLgline = false;
		}
		return isLgline;
	}//method end
	
	/* method begin
	 * #public boolean isClassBegin
	 * @param String
	 * @return boolean
	 */
	public boolean isClassBegin(String eachLine){
		boolean isClassBegin = false;
		
		if (eachLine.endsWith("class begin")){
			isClassBegin = true;
		}
		return isClassBegin;
	}//method end
	
	/* method begin
	 * #public boolean isClassOver
	 * @param String
	 * @return boolean
	 */
	public boolean isClassOver(String eachLine){
		boolean isClassOver = false;
		if (eachLine.endsWith("class end")) {
			isClassOver = true;
		}
		return isClassOver;
	}//method end
	
	/* method begin
	 * #public boolean isMethodBegin
	 * @param String
	 * @return boolean
	 */
	public boolean isMethodBegin(String eachLine) {
		boolean isMethodBegin = false;
		if (eachLine.endsWith("method begin")){
			isMethodBegin = true;
		}
		return isMethodBegin;
	}//method end
	
	/* method begin
	 * #public boolean isMethodOver
	 * @param String
	 * @return boolean
	 */
	public boolean isMethodOver(String eachLine) {
		boolean isMethodOver = false;
		if (eachLine.endsWith("method end")){
			isMethodOver = true;
		}
		return isMethodOver;
	}//method end
	
	/* method begin
	 * #public boolean isClassName
	 * @param String
	 * @return boolean
	 */
	public boolean isClassName(String eachLine) {
		boolean isClassName = false;
		if (eachLine.trim().startsWith("*##")){
			isClassName = true;
		}
		return isClassName;
	}//method end
	
	/* method begin
	 * #public boolean isMethodName
	 * @param String
	 * @return boolean
	 */
	public boolean isMethodName(String eachLine) {
		boolean isMethodName = false;
		if (eachLine.trim().startsWith("* #")){
			isMethodName = true;
		}
		return isMethodName;
	}//method end

}//class end
