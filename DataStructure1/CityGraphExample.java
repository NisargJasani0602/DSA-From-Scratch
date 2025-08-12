package DataStructure1;

import java.util.Scanner;

public class CityGraphExample {

	public static void main(String[] args) 
	{		
		Graph g = new Graph(27);
		g.IntializeCityData();
		int option = 0;
		do
		{
			System.out.println("Select from the following Option : ");
			System.out.println("0.\tExit");
			System.out.println("1.\tDisplay Adjacent Matrix");
			System.out.println("2.\tBFS Traversal");
			System.out.println("3.\tDFS Traversal");
			System.out.println("4.\tMinimum Spanning Tree Using Prims ALgorithm");
			System.out.println("5.\tMinimum Spanning Tree Using Krushkal ALgorithm");
			System.out.println("Your Option : ");
			Scanner sc = new Scanner(System.in);
			option = sc.nextInt();
			switch(option)
			{
				case 0 : 
					System.out.println("Exiting the Program. Thanks for your the application.");
					break;
				case 1 :
					g.DisplayAdjMatrix();
					break;
				case 2 :
					System.out.println("Enter the code for Starting Matrix : ");
					for(int i = 0; i<g.size; i++)
					{
						System.out.println(i + ".\t" + g.City[i]);
					}
					System.out.println("City ID : ");
					int CityID = sc.nextInt();
					g.BFSTraverse(CityID);
					break;
				case 3 :
					System.out.println("Enter the code for Starting Matrix : ");
					for(int i = 0; i<g.size; i++)
					{
						System.out.println(i + ".\t" + g.City[i]);
					}
					System.out.println("City ID : ");
					int CityId = sc.nextInt();
					g.DFSTraverse(CityId);
					break;
					
				default :
					System.out.println("Invalid Option. Please select the option again");
			}
		}while(option != 0);
		g.DisplayAdjMatrix();
		//g.BFSTraverse(5);
	}

}

class Graph
{
	String[] City;
	double adjMatrix[][];
	int size;
	Graph(int size)
	{
		City = new String[size];
		this.size = size;
		adjMatrix = new double[size][size];
	}
	
	void DisplayAdjMatrix() 
	{
		System.out.println("\nThe Given Adjacent Matrix is : \n");
		for (int i = 0; i < size; i++) 
		{
			System.out.printf("%-30s", City[i]);
			for (int j = 0; j < size; j++) 
			{
				System.out.print(adjMatrix[i][j] + "\t");
			}
			System.out.println();
		}
	}
	
	void DFSTraverse(int startNode) {
		StackDFS s = new StackDFS(size);
		int[] visited = new int[size];
		for (int i = 0; i < size; i++) 
		{
			visited[i] = 0;
		}

		s.Push(startNode);
		visited[startNode] = 1;
		System.out.println("DFS Traversal for the given graph is : \n");
		while (!s.isStackEmpty()) {
			int node = s.Pop();
			System.out.println(City[node]);

			for (int i = 0; i < size; i++) {
				if (adjMatrix[node][i] != 0 && visited[i] != 1) {
					s.Push(i);
					visited[i] = 1;
				}
			}
		}
	}
	
	void BFSTraverse(int startNode)
	{
		QueueBFS q = new QueueBFS(size) ;
		int[] visited = new int[size];
		for(int i = 0; i<size; i++)
		{
			visited[i] = 0;
		}
		
		q.enqueue(startNode);
		visited[startNode] = 1;
		
		System.out.println("BFS Traversal for the given graph is : \n");
		
		while(!q.isQueueEmpty())
		{
			int node = q.dequeue();
			System.out.println(City[node]);
			
			for(int i=0; i<size; i++)
			{
				if(adjMatrix[node][i] != 0 && visited[i] != 1)
				{
					q.enqueue(i);
					visited[i] =1;
				}
			}
			
		}
	}
	
	void IntializeCityData()
	{
		City[0]="Hyderabad";
		City[1]="Itanagar";
		City[2]="Dispur";
		City[3]="Patna";
		City[4]="Raipur";
		City[5]="Panaji";
		City[6]="Gandhinagar";
		City[7]="Chandigarh";
		City[8]="Shimla";
		City[9]="Srinagar";
		City[10]="Ranchi";
		City[11]="Bengaluru";
		City[12]="Trivandrum";
		City[13]="Bhopal";
		City[14]="Mumbai";
		City[15]="Imphal";
		City[16]="Shillong";
		City[17]="Aizawl";
		City[18]="Kohima";
		City[19]="Bhubaneswar";
		City[20]="Jaipur";
		City[21]="Gangtok";
		City[22]="Chennai";
		City[23]="Agartala";
		City[24]="Lucknow";
		City[25]="Dehradun";
		City[26]="Kolkata";
			
	
		adjMatrix[0][0]=0;
		adjMatrix[1][0]=1895.89;
		adjMatrix[2][0]=1684.55;
		adjMatrix[3][0]=1146.46;
		adjMatrix[4][0]=544.88;
		adjMatrix[5][0]=538.28;
		adjMatrix[6][0]=890.9;
		adjMatrix[7][0]=1496.73;
		adjMatrix[8][0]=1532.83;
		adjMatrix[9][0]=1430.37;
		adjMatrix[10][0]=977.5;
		adjMatrix[11][0]=497.05;
		adjMatrix[12][0]=996.17;
		adjMatrix[13][0]=663.98;
		adjMatrix[14][0]=623.48;
		adjMatrix[15][0]=1803.11;
		adjMatrix[16][0]=1659.29;
		adjMatrix[17][0]=1641.79;
		adjMatrix[18][0]=1859.87;
		adjMatrix[19][0]=829.63;
		adjMatrix[20][0]=1098.1;
		adjMatrix[21][0]=1520.31;
		adjMatrix[22][0]=511.68;
		adjMatrix[23][0]=1513.72;
		adjMatrix[24][0]=1084.89;
		adjMatrix[25][0]=1441.18;
		adjMatrix[26][0]=1184.47;

		adjMatrix[0][1]=1895.89;
		adjMatrix[1][1]=0;
		adjMatrix[2][1]=211.46;
		adjMatrix[3][1]=862.51;
		adjMatrix[4][1]=1378.16;
		adjMatrix[5][1]=2419.09;
		adjMatrix[6][1]=2512.34;
		adjMatrix[7][1]=1687.12;
		adjMatrix[8][1]=1655.68;
		adjMatrix[9][1]=1488.79;
		adjMatrix[10][1]=932.13;
		adjMatrix[11][1]=2292.67;
		adjMatrix[12][1]=2711.24;
		adjMatrix[13][1]=1682.72;
		adjMatrix[14][1]=2308.97;
		adjMatrix[15][1]=257.42;
		adjMatrix[16][1]=242.83;
		adjMatrix[17][1]=386.33;
		adjMatrix[18][1]=166.08;
		adjMatrix[19][1]=1104.75;
		adjMatrix[20][1]=1765.37;
		adjMatrix[21][1]=496.5;
		adjMatrix[22][1]=2093.87;
		adjMatrix[23][1]=432.84;
		adjMatrix[24][1]=1256.28;
		adjMatrix[25][1]=1560.99;
		adjMatrix[26][1]=731.79;

		adjMatrix[0][2]=1684.55;
		adjMatrix[1][2]=211.46;
		adjMatrix[2][2]=0;
		adjMatrix[3][2]=668.95;
		adjMatrix[4][2]=1167.4;
		adjMatrix[5][2]=2207.73;
		adjMatrix[6][2]=1959.36;
		adjMatrix[7][2]=1552.64;
		adjMatrix[8][2]=1526.26;
		adjMatrix[9][2]=1352.92;
		adjMatrix[10][2]=721.84;
		adjMatrix[11][2]=2084.85;
		adjMatrix[12][2]=2509.28;
		adjMatrix[13][2]=1485.01;
		adjMatrix[14][2]=2101.97;
		adjMatrix[15][2]=261.87;
		adjMatrix[16][2]=63.38;
		adjMatrix[17][2]=284.42;
		adjMatrix[18][2]=237.35;
		adjMatrix[19][2]=898.76;
		adjMatrix[20][2]=1592.84;
		adjMatrix[21][2]=342.24;
		adjMatrix[22][2]=1891.03;
		adjMatrix[23][2]=261.56;
		adjMatrix[24][2]=1081.58;
		adjMatrix[25][2]=1424.49;
		adjMatrix[26][2]=527.33;

		adjMatrix[0][3]=1146.46;
		adjMatrix[1][3]=862.51;
		adjMatrix[2][3]=668.95;
		adjMatrix[3][3]=0;
		adjMatrix[4][3]=601.86;
		adjMatrix[5][3]=1627.42;
		adjMatrix[6][3]=1290.92;
		adjMatrix[7][3]=996.73;
		adjMatrix[8][3]=987.11;
		adjMatrix[9][3]=807.55;
		adjMatrix[10][3]=250;
		adjMatrix[11][3]=1612.1;
		adjMatrix[12][3]=2088.08;
		adjMatrix[13][3]=822.26;
		adjMatrix[14][3]=1464.87;
		adjMatrix[15][3]=890.52;
		adjMatrix[16][3]=677.08;
		adjMatrix[17][3]=794.78;
		adjMatrix[18][3]=899.62;
		adjMatrix[19][3]=596.1;
		adjMatrix[20][3]=942.06;
		adjMatrix[21][3]=395.86;
		adjMatrix[22][3]=1486.6;
		adjMatrix[23][3]=651.93;
		adjMatrix[24][3]=439.1;
		adjMatrix[25][3]=871.21;
		adjMatrix[26][3]=472;


		adjMatrix[0][4]=544.88;
		adjMatrix[1][4]=1378.16;
		adjMatrix[2][4]=1167.4;
		adjMatrix[3][4]=601.86;
		adjMatrix[4][4]=0;
		adjMatrix[5][4]=1044.23;
		adjMatrix[6][4]=951.33;
		adjMatrix[7][4]=1161.18;
		adjMatrix[8][4]=1181.68;
		adjMatrix[9][4]=1038.48;
		adjMatrix[10][4]=446.46;
		adjMatrix[11][4]=1015.75;
		adjMatrix[12][4]=1501.42;
		adjMatrix[13][4]=487.42;
		adjMatrix[14][4]=955.03;
		adjMatrix[15][4]=1318.42;
		adjMatrix[16][4]=1150.04;
		adjMatrix[17][4]=1170.54;
		adjMatrix[18][4]=1362.43;
		adjMatrix[19][4]=438.56;
		adjMatrix[20][4]=866.13;
		adjMatrix[21][4]=977.85;
		adjMatrix[22][4]=921.61;
		adjMatrix[23][4]=1030.77;
		adjMatrix[24][4]=626.73;
		adjMatrix[25][4]=1071.19;
		adjMatrix[26][4]=709.39;

		adjMatrix[0][5]=538.28;
		adjMatrix[1][5]=2419.09;
		adjMatrix[2][5]=2207.73;
		adjMatrix[3][5]=1627.42;
		adjMatrix[4][5]=1044.23;
		adjMatrix[5][5]=0;
		adjMatrix[6][5]=869.32;
		adjMatrix[7][5]=1722.12;
		adjMatrix[8][5]=1769.58;
		adjMatrix[9][5]=1714.98;
		adjMatrix[10][5]=1489.97;
		adjMatrix[11][5]=491.19;
		adjMatrix[12][5]=843.73;
		adjMatrix[13][5]=942.89;
		adjMatrix[14][5]=401.83;
		adjMatrix[15][5]=2337.55;
		adjMatrix[16][5]=2186.17;
		adjMatrix[17][5]=2178.02;
		adjMatrix[18][5]=2391.35;
		adjMatrix[19][5]=1367.71;
		adjMatrix[20][5]=1287.94;
		adjMatrix[21][5]=2016.33;
		adjMatrix[22][5]=737.79;
		adjMatrix[23][5]=2047.75;
		adjMatrix[24][5]=1462.7;
		adjMatrix[25][5]=1704.22;
		adjMatrix[26][5]=1718.46;

		adjMatrix[0][6]=890.9;
		adjMatrix[1][6]=2512.34;
		adjMatrix[2][6]=1959.36;
		adjMatrix[3][6]=1290.92;
		adjMatrix[4][6]=951.33;
		adjMatrix[5][6]=869.32;
		adjMatrix[6][6]=0;
		adjMatrix[7][6]=929.79;
		adjMatrix[8][6]=984;
		adjMatrix[9][6]=987.62;
		adjMatrix[10][6]=1294.44;
		adjMatrix[11][6]=1252.37;
		adjMatrix[12][6]=1696.33;
		adjMatrix[13][6]=488.73;
		adjMatrix[14][6]=473.4;
		adjMatrix[15][6]=2167.48;
		adjMatrix[16][6]=1963.53;
		adjMatrix[17][6]=2046.16;
		adjMatrix[18][6]=2186.69;
		adjMatrix[19][6]=1389.78;
		adjMatrix[20][6]=519.06;
		adjMatrix[21][6]=1667.57;
		adjMatrix[22][6]=1381.65;
		adjMatrix[23][6]=1899.67;
		adjMatrix[24][6]=927.98;
		adjMatrix[25][6]=952.47;
		adjMatrix[26][6]=1611.42;

		adjMatrix[0][7]=1496.73;
		adjMatrix[1][7]=1687.12;
		adjMatrix[2][7]=1552.64;
		adjMatrix[3][7]=996.73;
		adjMatrix[4][7]=1161.18;
		adjMatrix[5][7]=1722.12;
		adjMatrix[6][7]=929.79;
		adjMatrix[7][7]=0;
		adjMatrix[8][7]=56.57;
		adjMatrix[9][7]=199.72;
		adjMatrix[10][7]=1176.71;
		adjMatrix[11][7]=1976.13;
		adjMatrix[12][7]=2468.92;
		adjMatrix[13][7]=834.35;
		adjMatrix[14][7]=1367.39;
		adjMatrix[15][7]=1810;
		adjMatrix[16][7]=1586.14;
		adjMatrix[17][7]=1755.63;
		adjMatrix[18][7]=1786.56;
		adjMatrix[19][7]=1467.83;
		adjMatrix[20][7]=434.63;
		adjMatrix[21][7]=1210.44;
		adjMatrix[22][7]=1994.97;
		adjMatrix[23][7]=1623.61;
		adjMatrix[24][7]=593.14;
		adjMatrix[25][7]=128.75;
		adjMatrix[26][7]=1465.26;

		adjMatrix[0][8]=1532.83;
		adjMatrix[1][8]=1655.68;
		adjMatrix[2][8]=1526.26;
		adjMatrix[3][8]=987.11;
		adjMatrix[4][8]=1181.68;
		adjMatrix[5][8]=1769.58;
		adjMatrix[6][8]=984;
		adjMatrix[7][8]=56.57;
		adjMatrix[8][8]=0;
		adjMatrix[9][8]=180.06;
		adjMatrix[10][8]=1175.93;
		adjMatrix[11][8]=2015.32;
		adjMatrix[12][8]=2509.52;
		adjMatrix[13][8]=872.66;
		adjMatrix[14][8]=1418.3;
		adjMatrix[15][8]=1784.99;
		adjMatrix[16][8]=1561.52;
		adjMatrix[17][8]=1735.49;
		adjMatrix[18][8]=1758.86;
		adjMatrix[19][8]=1474.88;
		adjMatrix[20][8]=483.91;
		adjMatrix[21][8]=1184.11;
		adjMatrix[22][8]=2027.88;
		adjMatrix[23][8]=1605.58;
		adjMatrix[24][8]=597.36;
		adjMatrix[25][8]=118.29;
		adjMatrix[26][8]=1457.8;

		adjMatrix[0][9]=1430.37;
		adjMatrix[1][9]=1488.79;
		adjMatrix[2][9]=1352.92;
		adjMatrix[3][9]=807.55;
		adjMatrix[4][9]=1038.48;
		adjMatrix[5][9]=1714.98;
		adjMatrix[6][9]=987.62;
		adjMatrix[7][9]=199.72;
		adjMatrix[8][9]=180.06;
		adjMatrix[9][9]=0;
		adjMatrix[10][9]=1001.01;
		adjMatrix[11][9]=1921.61;
		adjMatrix[12][9]=2419.71;
		adjMatrix[13][9]=786.45;
		adjMatrix[14][9]=1387.97;
		adjMatrix[15][9]=1610.32;
		adjMatrix[16][9]=1386.49;
		adjMatrix[17][9]=1557.33;
		adjMatrix[18][9]=1586.97;
		adjMatrix[19][9]=1307.49;
		adjMatrix[20][9]=468.58;
		adjMatrix[21][9]=1010.74;
		adjMatrix[22][9]=1912.64;
		adjMatrix[23][9]=1426.47;
		adjMatrix[24][9]=431.19;
		adjMatrix[25][9]=72.22;
		adjMatrix[26][9]=1278.71;

		adjMatrix[0][10]=977.5;
		adjMatrix[1][10]=932.13;
		adjMatrix[2][10]=721.84;
		adjMatrix[3][10]=250;
		adjMatrix[4][10]=446.46;
		adjMatrix[5][10]=1489.97;
		adjMatrix[6][10]=1294.44;
		adjMatrix[7][10]=1176.71;
		adjMatrix[8][10]=1175.93;
		adjMatrix[9][10]=1001.01;
		adjMatrix[10][10]=0;
		adjMatrix[11][10]=1415.42;
		adjMatrix[12][10]=1876.94;
		adjMatrix[13][10]=806.14;
		adjMatrix[14][10]=1385.09;
		adjMatrix[15][10]=888.59;
		adjMatrix[16][10]=707.43;
		adjMatrix[17][10]=754.59;
		adjMatrix[18][10]=924.19;
		adjMatrix[19][10]=346.25;
		adjMatrix[20][10]=1037.03;
		adjMatrix[21][10]=550.51;
		adjMatrix[22][10]=2027.88;
		adjMatrix[23][10]=609.14;
		adjMatrix[24][10]=586.06;
		adjMatrix[25][10]=1057.72;
		adjMatrix[26][10]=324.31;

		adjMatrix[0][11]=497.05;
		adjMatrix[1][11]=2292.67;
		adjMatrix[2][11]=2084.85;
		adjMatrix[3][11]=1612.1;
		adjMatrix[4][11]=1015.75;
		adjMatrix[5][11]=491.19;
		adjMatrix[6][11]=1252.37;
		adjMatrix[7][11]=1976.13;
		adjMatrix[8][11]=2015.32;
		adjMatrix[9][11]=1921.61;
		adjMatrix[10][11]=1415.42;
		adjMatrix[11][11]=0;
		adjMatrix[12][11]=499.44;
		adjMatrix[13][11]=1142.69;
		adjMatrix[14][11]=837.83;
		adjMatrix[15][11]=2162.48;
		adjMatrix[16][11]=2050.43;
		adjMatrix[17][11]=1992.76;
		adjMatrix[18][11]=2231.96;
		adjMatrix[19][11]=1188.74;
		adjMatrix[20][11]=1561.59;
		adjMatrix[21][11]=1965.92;
		adjMatrix[22][11]=284.74;
		adjMatrix[23][11]=1881.38;
		adjMatrix[24][11]=1581.77;
		adjMatrix[25][11]=1928.64;
		adjMatrix[26][11]=1561.76;

		adjMatrix[0][12]=996.17;
		adjMatrix[1][12]=2711.24;
		adjMatrix[2][12]=2509.28;
		adjMatrix[3][12]=2088.08;
		adjMatrix[4][12]=1501.42;
		adjMatrix[5][12]=843.73;
		adjMatrix[6][12]=1696.33;
		adjMatrix[7][12]=2468.92;
		adjMatrix[8][12]=2509.52;
		adjMatrix[9][12]=2419.71;
		adjMatrix[10][12]=1876.94;
		adjMatrix[11][12]=499.44;
		adjMatrix[12][12]=0;
		adjMatrix[13][12]=1637.89;
		adjMatrix[14][12]=1242.39;
		adjMatrix[15][12]=2554.74;
		adjMatrix[16][12]=2468.7;
		adjMatrix[17][12]=2382.61;
		adjMatrix[18][12]=2632.6;
		adjMatrix[19][12]=1612.93;
		adjMatrix[20][12]=2048.45;
		adjMatrix[21][12]=2424.79;
		adjMatrix[22][12]=618.68;
		adjMatrix[23][12]=2286.18;
		adjMatrix[24][12]=2080.21;
		adjMatrix[25][12]=2425.22;
		adjMatrix[26][12]=1981.97;

		adjMatrix[0][13]=663.98;
		adjMatrix[1][13]=1682.72;
		adjMatrix[2][13]=1485.01;
		adjMatrix[3][13]=822.26;
		adjMatrix[4][13]=487.42;
		adjMatrix[5][13]=942.89;
		adjMatrix[6][13]=488.73;
		adjMatrix[7][13]=834.35;
		adjMatrix[8][13]=872.66;
		adjMatrix[9][13]=786.45;
		adjMatrix[10][13]=806.14;
		adjMatrix[11][13]=1142.69;
		adjMatrix[12][13]=1637.89;
		adjMatrix[13][13]=0;
		adjMatrix[14][13]=674.79;
		adjMatrix[15][13]=1684.3;
		adjMatrix[16][13]=1485.1;
		adjMatrix[17][13]=1559.19;
		adjMatrix[18][13]=1707.83;
		adjMatrix[19][13]=918.51;
		adjMatrix[20][13]=439.97;
		adjMatrix[21][13]=1211.58;
		adjMatrix[22][13]=1169.1;
		adjMatrix[23][13]=1412.91;
		adjMatrix[24][13]=534.05;
		adjMatrix[25][13]=787.74;
		adjMatrix[26][13]=1122.76;

		adjMatrix[0][14]=623.48;
		adjMatrix[1][14]=2308.97;
		adjMatrix[2][14]=2101.97;
		adjMatrix[3][14]=1464.87;
		adjMatrix[4][14]=955.03;
		adjMatrix[5][14]=401.83;
		adjMatrix[6][14]=473.4;
		adjMatrix[7][14]=1367.39;
		adjMatrix[8][14]=1418.3;
		adjMatrix[9][14]=1387.97;
		adjMatrix[10][14]=1385.09;
		adjMatrix[11][14]=837.83;
		adjMatrix[12][14]=1242.39;
		adjMatrix[13][14]=674.79;
		adjMatrix[14][14]=0;
		adjMatrix[15][14]=2270.4;
		adjMatrix[16][14]=2091.74;
		adjMatrix[17][14]=2125.29;
		adjMatrix[18][14]=2309.26;
		adjMatrix[19][14]=1359.66;
		adjMatrix[20][14]=935.03;
		adjMatrix[21][14]=1860.57;
		adjMatrix[22][14]=1025.4;
		adjMatrix[23][14]=1984.45;
		adjMatrix[24][14]=1207.65;
		adjMatrix[25][14]=1366.74;
		adjMatrix[26][14]=1664.39;

		adjMatrix[0][15]=1803.11;
		adjMatrix[1][15]=257.42;
		adjMatrix[2][15]=261.87;
		adjMatrix[3][15]=890.52;
		adjMatrix[4][15]=1318.42;
		adjMatrix[5][15]=2337.55;
		adjMatrix[6][15]=2167.48;
		adjMatrix[7][15]=1810;
		adjMatrix[8][15]=1784.99;
		adjMatrix[9][15]=1610.32;
		adjMatrix[10][15]=888.59;
		adjMatrix[11][15]=2162.48;
		adjMatrix[12][15]=2554.74;
		adjMatrix[13][15]=1684.3;
		adjMatrix[14][15]=2270.4;
		adjMatrix[15][15]=0;
		adjMatrix[16][15]=224.04;
		adjMatrix[17][15]=172.21;
		adjMatrix[18][15]=97.9;
		adjMatrix[19][15]=981.14;
		adjMatrix[20][15]=1829.11;
		adjMatrix[21][15]=601.52;
		adjMatrix[22][15]=1943.63;
		adjMatrix[23][15]=289.88;
		adjMatrix[24][15]=1319.21;
		adjMatrix[25][15]=1681.53;
		adjMatrix[26][15]=619.09;

		adjMatrix[0][16]=1659.29;
		adjMatrix[1][16]=242.83;
		adjMatrix[2][16]=63.38;
		adjMatrix[3][16]=677.08;
		adjMatrix[4][16]=1150.04;
		adjMatrix[5][16]=2186.17;
		adjMatrix[6][16]=1963.53;
		adjMatrix[7][16]=1586.14;
		adjMatrix[8][16]=1561.52;
		adjMatrix[9][16]=1386.49;
		adjMatrix[10][16]=707.43;
		adjMatrix[11][16]=2050.43;
		adjMatrix[12][16]=2468.7;
		adjMatrix[13][16]=1485.1;
		adjMatrix[14][16]=2091.74;
		adjMatrix[15][16]=224.04;
		adjMatrix[16][16]=0;
		adjMatrix[17][16]=222.57;
		adjMatrix[18][16]=223.17;
		adjMatrix[19][16]=862.15;
		adjMatrix[20][16]=1610.36;
		adjMatrix[21][16]=379.42;
		adjMatrix[22][16]=1851.15;
		adjMatrix[23][16]=203.02;
		adjMatrix[24][16]=1099.51;
		adjMatrix[25][16]=1457.63;
		adjMatrix[26][16]=489.08;

		adjMatrix[0][17]=1641.79;
		adjMatrix[1][17]=386.33;
		adjMatrix[2][17]=284.42;
		adjMatrix[3][17]=794.78;
		adjMatrix[4][17]=1170.54;
		adjMatrix[5][17]=2178.02;
		adjMatrix[6][17]=2046.16;
		adjMatrix[7][17]=1755.63;
		adjMatrix[8][17]=1735.49;
		adjMatrix[9][17]=1557.33;
		adjMatrix[10][17]=754.59;
		adjMatrix[11][17]=1992.76;
		adjMatrix[12][17]=2382.61;
		adjMatrix[13][17]=1559.19;
		adjMatrix[14][17]=2125.29;
		adjMatrix[15][17]=172.21;
		adjMatrix[16][17]=222.57;
		adjMatrix[17][17]=0;
		adjMatrix[18][17]=257.73;
		adjMatrix[19][17]=815.68;
		adjMatrix[20][17]=1736.35;
		adjMatrix[21][17]=574.76;
		adjMatrix[22][17]=1771.93;
		adjMatrix[23][17]=146.65;
		adjMatrix[24][17]=1232.6;
		adjMatrix[25][17]=1626.94;
		adjMatrix[26][17]=462.88;

		adjMatrix[0][18]=1859.87;
		adjMatrix[1][18]=166.08;
		adjMatrix[2][18]=237.35;
		adjMatrix[3][18]=899.62;
		adjMatrix[4][18]=1362.43;
		adjMatrix[5][18]=2391.35;
		adjMatrix[6][18]=2186.69;
		adjMatrix[7][18]=1786.56;
		adjMatrix[8][18]=1758.86;
		adjMatrix[9][18]=1586.97;
		adjMatrix[10][18]=924.19;
		adjMatrix[11][18]=2231.96;
		adjMatrix[12][18]=2632.6;
		adjMatrix[13][18]=1707.83;
		adjMatrix[14][18]=2309.26;
		adjMatrix[15][18]=97.9;
		adjMatrix[16][18]=223.17;
		adjMatrix[17][18]=257.73;
		adjMatrix[18][18]=0;
		adjMatrix[19][18]=1045.61;
		adjMatrix[20][18]=1829.22;
		adjMatrix[21][18]=576.9;
		adjMatrix[22][18]=2019.07;
		adjMatrix[23][18]=350.66;
		adjMatrix[24][18]=1317.97;
		adjMatrix[25][18]=1658.76;
		adjMatrix[26][18]=676.64;

		adjMatrix[0][19]=829.63;
		adjMatrix[1][19]=1104.75;
		adjMatrix[2][19]=898.76;
		adjMatrix[3][19]=596.1;
		adjMatrix[4][19]=438.56;
		adjMatrix[5][19]=1367.71;
		adjMatrix[6][19]=1389.78;
		adjMatrix[7][19]=1467.83;
		adjMatrix[8][19]=1474.88;
		adjMatrix[9][19]=1307.49;
		adjMatrix[10][19]=346.25;
		adjMatrix[11][19]=1188.74;
		adjMatrix[12][19]=1612.93;
		adjMatrix[13][19]=918.51;
		adjMatrix[14][19]=1359.66;
		adjMatrix[15][19]=981.14;
		adjMatrix[16][19]=862.15;
		adjMatrix[17][19]=815.68;
		adjMatrix[18][19]=1045.61;
		adjMatrix[19][19]=0;
		adjMatrix[20][19]=1252.42;
		adjMatrix[21][19]=837.01;
		adjMatrix[22][19]=994.25;
		adjMatrix[23][19]=695.19;
		adjMatrix[24][19]=877.76;
		adjMatrix[25][19]=1357.19;
		adjMatrix[26][19]=373.13;

		adjMatrix[0][20]=1098.1;
		adjMatrix[1][20]=1765.37;
		adjMatrix[2][20]=1592.84;
		adjMatrix[3][20]=942.06;
		adjMatrix[4][20]=866.13;
		adjMatrix[5][20]=1287.94;
		adjMatrix[6][20]=519.06;
		adjMatrix[7][20]=434.63;
		adjMatrix[8][20]=483.91;
		adjMatrix[9][20]=468.58;
		adjMatrix[10][20]=1037.03;
		adjMatrix[11][20]=1561.59;
		adjMatrix[12][20]=2048.45;
		adjMatrix[13][20]=439.97;
		adjMatrix[14][20]=935.03;
		adjMatrix[15][20]=1829.11;
		adjMatrix[16][20]=1610.36;
		adjMatrix[17][20]=1736.35;
		adjMatrix[18][20]=1829.22;
		adjMatrix[19][20]=1252.42;
		adjMatrix[20][20]=0;
		adjMatrix[21][20]=1268.92;
		adjMatrix[22][20]=1606.87;
		adjMatrix[23][20]=1592.28;
		adjMatrix[24][20]=511.27;
		adjMatrix[25][20]=436.19;
		adjMatrix[26][20]=1358.32;

		adjMatrix[0][21]=1520.31;
		adjMatrix[1][21]=496.5;
		adjMatrix[2][21]=342.24;
		adjMatrix[3][21]=395.86;
		adjMatrix[4][21]=977.85;
		adjMatrix[5][21]=2016.33;
		adjMatrix[6][21]=1667.57;
		adjMatrix[7][21]=1210.44;
		adjMatrix[8][21]=1184.11;
		adjMatrix[9][21]=1010.74;
		adjMatrix[10][21]=550.51;
		adjMatrix[11][21]=1965.92;
		adjMatrix[12][21]=2424.79;
		adjMatrix[13][21]=1211.58;
		adjMatrix[14][21]=1860.57;
		adjMatrix[15][21]=601.52;
		adjMatrix[16][21]=379.42;
		adjMatrix[17][21]=574.76;
		adjMatrix[18][21]=576.9;
		adjMatrix[19][21]=837.01;
		adjMatrix[20][21]=1268.92;
		adjMatrix[21][21]=0;
		adjMatrix[22][21]=1810.65;
		adjMatrix[23][21]=472;
		adjMatrix[24][21]=760.55;
		adjMatrix[25][21]=1082.36;
		adjMatrix[26][21]=530.4;

		adjMatrix[0][22]=511.68;
		adjMatrix[1][22]=2093.87;
		adjMatrix[2][22]=1891.03;
		adjMatrix[3][22]=1486.6;
		adjMatrix[4][22]=921.61;
		adjMatrix[5][22]=737.79;
		adjMatrix[6][22]=1381.65;
		adjMatrix[7][22]=1994.97;
		adjMatrix[8][22]=2027.88;
		adjMatrix[9][22]=1912.64;
		adjMatrix[10][22]=2027.88;
		adjMatrix[11][22]=284.74;
		adjMatrix[12][22]=618.68;
		adjMatrix[13][22]=1169.1;
		adjMatrix[14][22]=1025.4;
		adjMatrix[15][22]=1943.63;
		adjMatrix[16][22]=1851.15;
		adjMatrix[17][22]=1771.93;
		adjMatrix[18][22]=2019.07;
		adjMatrix[19][22]=994.25;
		adjMatrix[20][22]=1606.87;
		adjMatrix[21][22]=1810.65;
		adjMatrix[22][22]=0;
		adjMatrix[23][22]=1670.97;
		adjMatrix[24][22]=1533.59;
		adjMatrix[25][22]=1930.37;
		adjMatrix[26][22]=1363.71;

		adjMatrix[0][23]=1513.72;
		adjMatrix[1][23]=432.84;
		adjMatrix[2][23]=261.56;
		adjMatrix[3][23]=651.93;
		adjMatrix[4][23]=1030.77;
		adjMatrix[5][23]=2047.75;
		adjMatrix[6][23]=1899.67;
		adjMatrix[7][23]=1623.61;
		adjMatrix[8][23]=1605.58;
		adjMatrix[9][23]=1426.47;
		adjMatrix[10][23]=609.14;
		adjMatrix[11][23]=1881.38;
		adjMatrix[12][23]=2286.18;
		adjMatrix[13][23]=1412.91;
		adjMatrix[14][23]=1984.45;
		adjMatrix[15][23]=289.88;
		adjMatrix[16][23]=203.02;
		adjMatrix[17][23]=146.65;
		adjMatrix[18][23]=350.66;
		adjMatrix[19][23]=695.19;
		adjMatrix[20][23]=1592.28;
		adjMatrix[21][23]=472;
		adjMatrix[22][23]=1670.97;
		adjMatrix[23][23]=0;
		adjMatrix[24][23]=1090.72;
		adjMatrix[25][23]=1495.18;
		adjMatrix[26][23]=329.34;

		adjMatrix[0][24]=1084.89;
		adjMatrix[1][24]=1256.28;
		adjMatrix[2][24]=1081.58;
		adjMatrix[3][24]=439.1;
		adjMatrix[4][24]=626.73;
		adjMatrix[5][24]=1462.7;
		adjMatrix[6][24]=927.98;
		adjMatrix[7][24]=593.14;
		adjMatrix[8][24]=597.36;
		adjMatrix[9][24]=431.19;
		adjMatrix[10][24]=586.06;
		adjMatrix[11][24]=1581.77;
		adjMatrix[12][24]=2080.21;
		adjMatrix[13][24]=534.05;
		adjMatrix[14][24]=1207.65;
		adjMatrix[15][24]=1319.21;
		adjMatrix[16][24]=1099.51;
		adjMatrix[17][24]=1232.6;
		adjMatrix[18][24]=1317.97;
		adjMatrix[19][24]=877.76;
		adjMatrix[20][24]=511.27;
		adjMatrix[21][24]=760.55;
		adjMatrix[22][24]=1533.59;
		adjMatrix[23][24]=1090.72;
		adjMatrix[24][24]=0;
		adjMatrix[25][24]=479.48;
		adjMatrix[26][24]=887.69;

		adjMatrix[0][25]=1441.18;
		adjMatrix[1][25]=1560.99;
		adjMatrix[2][25]=1424.49;
		adjMatrix[3][25]=871.21;
		adjMatrix[4][25]=1071.19;
		adjMatrix[5][25]=1704.22;
		adjMatrix[6][25]=952.47;
		adjMatrix[7][25]=128.75;
		adjMatrix[8][25]=118.29;
		adjMatrix[9][25]=72.22;
		adjMatrix[10][25]=1057.72;
		adjMatrix[11][25]=1928.64;
		adjMatrix[12][25]=2425.22;
		adjMatrix[13][25]=787.74;
		adjMatrix[14][25]=1366.74;
		adjMatrix[15][25]=1681.53;
		adjMatrix[16][25]=1457.63;
		adjMatrix[17][25]=1626.94;
		adjMatrix[18][25]=1658.76;
		adjMatrix[19][25]=1357.19;
		adjMatrix[20][25]=436.19;
		adjMatrix[21][25]=1082.36;
		adjMatrix[22][25]=1930.37;
		adjMatrix[23][25]=1495.18;
		adjMatrix[24][25]=479.48;
		adjMatrix[25][25]=0;
		adjMatrix[26][25]=1341.14;

		adjMatrix[0][26]=1184.47;
		adjMatrix[1][26]=731.79;
		adjMatrix[2][26]=527.33;
		adjMatrix[3][26]=472;
		adjMatrix[4][26]=709.39;
		adjMatrix[5][26]=1718.46;
		adjMatrix[6][26]=1611.42;
		adjMatrix[7][26]=1465.26;
		adjMatrix[8][26]=1457.8;
		adjMatrix[9][26]=1278.71;
		adjMatrix[10][26]=324.31;
		adjMatrix[11][26]=1561.76;
		adjMatrix[12][26]=1981.97;
		adjMatrix[13][26]=1122.76;
		adjMatrix[14][26]=1664.39;
		adjMatrix[15][26]=619.09;
		adjMatrix[16][26]=489.08;
		adjMatrix[17][26]=462.88;
		adjMatrix[18][26]=676.64;
		adjMatrix[19][26]=373.13;
		adjMatrix[20][26]=1358.32;
		adjMatrix[21][26]=530.4;
		adjMatrix[22][26]=1363.71;
		adjMatrix[23][26]=329.34;
		adjMatrix[24][26]=887.69;
		adjMatrix[25][26]=1341.14;
		adjMatrix[26][26]=0;

		



	}
}



class QueueBFS
{
	int front,rear;
	int[] queue;
	int n;
	QueueBFS(int size)
	{
		n=size;
		front=-1;
		rear=-1;
		queue=new int[n];
	}
	boolean isQueuefull()
	{
		return(rear==n-1);
	}
	boolean isQueueEmpty() 
	{
		return(rear==-1 && front==-1);
	}
	void enqueue(int data)
	{
		if(isQueuefull()) 
		{
			System.out.println("Queue overflow");
			return;
		}
		else if(isQueueEmpty())
		{
			rear=0;
			front=0;			
		}
		else 
		{
			rear++;
		}
		queue[rear] = data;
		
	}
	int dequeue()
	{
		if(isQueueEmpty())
	    {
			System.out.println("stack underflow");
			return -1;
	    }
		else if(front==rear)
		{
			int temp=queue[front];
			front=-1;
			rear=-1;
			return temp;
		}
		else 
			return queue[front++];
		
	}	
}


class StackDFS {
	int top;
	int[] arr;

	StackDFS(int size) {
		top = -1;
		arr = new int[size];
	}

	boolean isStackFull() {
//		if(top == arr.length-1)
//		{
//			return true;
//		}
//		else
//		{
//			return false;
//		}

		return (top == arr.length - 1);
	}

	boolean isStackEmpty() {
		return (top == -1);
	}

	void Push(int data) {
		if (isStackFull()) {
			System.out.println("Stack Overflow. Cannot insert value into the stack");
		} else {
//			top++;
//			arr[top]= data;

			arr[++top] = data;
			// System.out.println("Data pushed on to the stack successfully.");
		}
	}

	int Pop() {
		if (isStackEmpty()) {
			System.out.println("Stack Underflow. Cannot delete value from the stack.");
			return -1;
		} else {
			//int data = arr[top];
		    //top--;
			//return data;

			return arr[top--];
		}
	}
}
