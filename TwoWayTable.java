public class TwoWayTable {

	public static void main(String[] args) {
		int[][] testArray = { { 2, 5, 6, 3 }, { 9, 4, 4, 7 }, { 1, 10, 2, 3 },
				{ 8, 4, 5, 3 } };
		TwoWayTable t = new TwoWayTable(testArray);
		System.out.println(t);
	}

	int numRows;
	int numCols;
	int[][] cell = new int[numRows][numCols];
	int[] rowSum;
	int[] colSum;
	int grandTotal;

	// constructor
	TwoWayTable(int[][] data) {
		cell = data.clone();
		setMarginalTotals();
	}

	public void setMarginalTotals() {
		numRows = cell.length;
		numCols = cell[0].length;
		rowSum = new int[numRows];
		colSum = new int[numCols];
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				rowSum[i] += cell[i][j];
				grandTotal += cell[i][j];
			}
		}
		for (int i = 0; i < numCols; i++) {
			for (int j = 0; j < numRows; j++) {
				colSum[i] += cell[j][i];
			}
		}

	}

	public String toString() {
		String printout = "";
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				printout += cell[i][j] + " ";
			}
			printout += rowSum[i];
			printout += "\n";
		}
		for (int i = 0; i < numCols; i++) {
			printout += colSum[i] + " ";
		}
		;
		printout += grandTotal;
		return printout;
	}

}