package Assignment;

import java.io.BufferedReader;
import java.io.InputStreamReader;



/** class begin
 *##public class assignment8
 *  Program Assignment : 8 
 *  Description: to solve sudoku
 */
public class assignment8 {
	/* method begin
     * #main
     * entry of this program
     * @param String[] args
     * @return void
     */ 
	static int[] symbol = {1,2,4,8,16,32,64,128,256,511};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		assignment8 ass8 = new assignment8();
		String str = "";
		String[] num = new String[9];
		int key = 0;
		int[][] sudoku = new int[9][9];
		int[][] possi = new int[9][9];
		
		for (int i = 0; i < possi.length; i++) {
			for (int j = 0; j < possi[0].length; j++) {
				possi[i][j] = 511;
			}
		}
		
		System.out.println("input sudoku:");
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			while (true) {
				str = br.readLine();
				if (str.equals("end")) {
					break;
				}else{
					num[key] = str;
					key++;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for (int i = 0; i < num.length; i++) {
			for (int j = 0; j < num[i].length(); j++) {
				sudoku[i][j] = num[i].charAt(j)-'0';
			}
		}
		
		
		for (int i = 0; i < sudoku.length; i++) {
			for (int j = 0; j < sudoku[0].length; j++) {
				if (sudoku[i][j]==0) {
					for (int j2 = 0; j2 < sudoku.length; j2++) {
						if (sudoku[j2][j]!=0) {
							int m = sudoku[j2][j]-1;
							possi[i][j] = (~symbol[m])&possi[i][j];
						}
					}
					for (int j2 = 0; j2 < sudoku.length; j2++) {
						if (sudoku[i][j2]!=0) {
							int m = sudoku[i][j2]-1;
							possi[i][j] = (~symbol[m])&possi[i][j];
						}
					}
					int m = i-i%3;
					for (; m <= i+2-i%3; m++) {
						int n = j-j%3;
						for (; n<=j+2-j%3 ; n++) {
							if (sudoku[m][n]!=0) {
								int p = sudoku[m][n]-1;
								possi[i][j] = (~symbol[p])&possi[i][j];
							}
						}
					}
					
				}else {
					possi[i][j] = 0;
				}
			}
		}
		
		
		
		String[][] po = new String[9][9];
		for (int i = 0; i < po.length; i++) {
			for (int j = 0; j < po[0].length; j++) {
				po[i][j] = "";
			}
		}
		
		for (int i = 0; i < possi.length; i++) {
			for (int j = 0; j < possi[0].length; j++) {
				if (possi[i][j]!=0) {
					int shif = 0;
					for (int j2 = 0; j2 < 9; j2++) {
						if (possi[i][j]%2!=0) {
							shif++;
							po[i][j]+=Integer.toString(shif);
							possi[i][j]--;
							possi[i][j] = possi[i][j]/2;
						}
						shif++;
						possi[i][j] = possi[i][j]/2;
					}
				}else {
					po[i][j] = "0";
				}
			}
		}
		
		
		
		
		
		int key1 = 0;
		int key2 = 0;
		
			
		while (!po[key1][key2].equals("0")){
			 if (key2>8) {
					key1++;
					key2=0;
				}
				key2++;
		}
		
		ass8.solve(key1, key2, po,sudoku);
		
		for (int i = 0; i < sudoku.length; i++) {
			for (int j = 0; j < sudoku[0].length; j++) {
				System.out.print(sudoku[i][j]+" ");
			}
			System.out.print("\n");
		}
		
	
	}//method end
	
	/* method begin
	 * #solve
	 * to guess every possibilities
	 * @param 
	 * @return void
	 */
	public void solve(int x, int y,String[][] po,int[][] sudoku){
		assignment8 ass8 = new assignment8();
		if (y>8) {
			x++;
			y=0;
		}
		
		for (int i = 0; i < po[x][y].length(); i++) {
			sudoku[x][y] = po[x][y].charAt(i)-'0';
			ass8.solve(x, y+1, po, sudoku);
			if (sudoku[x][y] == 0) {
				ass8.solve(x, y, po, sudoku);
			}else {
				sudoku[x][y] = 0;
			}
		}
		
	}//method end
	

}//class end
