package com.maxSum;

public class Mine {

	public static int maxPathSum(int tri[][], int m) {

		int[] arr = new int[m - 1];
		int flag = -1;
		int[][] org = new int[m][m];
		
		// to populate the flag value to decide whether odd numbers should be considered or even

		if (tri[0][0] % 2 == 0 && m % 2 == 0) {
			flag = 1;
		} else if (tri[0][0] % 2 == 1 && m % 2 == 1)
			flag = 0;
		else if (tri[0][0] % 2 == 1 && m % 2 == 0)
			flag = 1;
		else if (tri[0][0] % 2 == 0 && m % 2 == 1)
			flag = 0;

		// populating sum of elements for last row in a separate array org.
		for (int i = 0; i <= m - 1; i++) {
			if (flag == 1) {
				if (tri[m - 1][i] % 2 != 0) {
					org[m - 1][i] = 0;
				} else
					org[m - 1][i] = tri[m - 1][i];
			} else if (flag == 0) {
				if (tri[m - 1][i] % 2 == 0) {
					org[m - 1][i] = 0;
				} else
					org[m - 1][i] = tri[m - 1][i];

			}
		}

		if (flag == 0)
			flag = 1;
		else
			flag = 0;

		// looping from 2nd last row  to top to get the sum.
		for (int i = m - 2; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {

				if (flag == 1) {
					if (tri[i][j] % 2 == 0) {

						org[i][j] = tri[i][j] + Math.max(org[i + 1][j], org[i + 1][j + 1]);
						arr[j] = Math.max(tri[i + 1][j], tri[i + 1][j + 1]);
					} else
						org[i][j] = 0;
				} else {
					if (tri[i][j] % 2 != 0) {
						org[i][j] = tri[i][j] + Math.max(org[i + 1][j], org[i + 1][j + 1]);
					} else
						org[i][j] = 0;

				}
			}

			//toggling the flag after each row pass.
			if (flag == 0)
				flag = 1;
			else
				flag = 0;
		}

		return org[0][0];

	}

	public static void main(String[] args) {
		int tri[][] = { { 1, 0, 0, 0 }, { 8, 9, 0, 0 }, { 1, 5, 9, 0 }, { 4, 5, 2, 3 } };

		int tri2[][] = { { 215 }, { 192, 124 }, { 117, 269, 442 }, { 218, 836, 347, 235 }, { 320, 805, 522, 417, 345 },
				{ 229, 601, 728, 835, 133, 124 }, { 248, 202, 277, 433, 207, 263, 257 },
				{ 359, 464, 504, 528, 516, 716, 871, 182 }, { 461, 441, 426, 656, 863, 560, 380, 171, 923 },
				{ 381, 348, 573, 533, 448, 632, 387, 176, 975, 449 },
				{ 223, 711, 445, 645, 245, 543, 931, 532, 937, 541, 444 },
				{ 330, 131, 333, 928, 376, 733, 017, 778, 839, 168, 197, 197 },
				{ 131, 171, 522, 137, 217, 224, 291, 413, 528, 520, 227, 229, 928 },
				{ 223, 626, 034, 683, 839, 052, 627, 310, 713, 999, 629, 817, 410, 121 },
				{ 924, 622, 911, 233, 325, 139, 721, 218, 253, 223, 107, 233, 230, 124, 233 } };
		System.out.println("Maxsum :" + maxPathSum(tri2, 15));
	}

}
