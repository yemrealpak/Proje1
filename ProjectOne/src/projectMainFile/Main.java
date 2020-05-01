package projectMainFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import linkedList.cityOperationClass;
import map.StartScreen;



public class Main {

	public static void main(String[] args) {
		
		Main use = new Main();
		
		//use.readFile();
		
		StartScreen scc = new StartScreen();
		
		Scanner oku = new Scanner(System.in);
		
		String[] enterCity = new String[10];
		
		System.out.println("Gitmek istedi�iniz sehirleri giriniz=? ");
		System.out.println("C�kmak i�in 2 defa enter");
		
		int i;
		String tmp2;
		for(i=0;i<10;i++) {
			System.out.println( i+1 + ".Sehir:");
			tmp2 = oku.next();
			enterCity[i] = tmp2;
			
		
			
		}
		
	
	
	}
	
	public void readFile() {
		File file = new File("Sehirler.txt");
		try {
			
			Scanner sc = new Scanner(file);
			
			cityOperationClass cityOp = new cityOperationClass();
			
			int plate;
			String intPlate;
			int neigCityBuffer;
			int[] neigDistances = new int[81];
			int tmpDistance;
			String intNneigDistances;
			String cityName;
			String[] neigCitys = new String[15];
			
			int i;
			int j;
			
			while(sc.hasNextLine()) {
					
				String[] lineSplit = null;
				
				String str = sc.nextLine();
				
				//System.out.println(str);
				
				lineSplit = str.split(",");
				
				//System.out.println("plakalar:" + lineSplit[0]);//read test
				intPlate = lineSplit[0];
				plate = Integer.parseInt(intPlate);
				//System.out.println("plakalar:" + plate);//LL test
				
				//System.out.println("adi:" + lineSplit[1]);
				cityName = lineSplit[1];
				//System.out.println("adi:" + cityName);
				
				neigCityBuffer = 0;
				for(i=2;i<(lineSplit.length-81);i++) {
					
					//System.out.println( (neigCityBuffer+1) + ".komsu:" + lineSplit[i] );
					neigCitys[neigCityBuffer] = lineSplit[i];
					neigCityBuffer++;
					//System.out.println( neigCityBuffer + ".komsu:" + neigCitys[neigCityBuffer-1] );
				}
				//System.out.println("komsu sayisi:" + neigCityBuffer);
				
				
				j=0;
				int tmpi;
				tmpi = i;
				for(i=tmpi;i<lineSplit.length;i++) {
					//System.out.println( (j+1) +".komsu mesafe:" + lineSplit[i]);
					intNneigDistances = lineSplit[i];
					tmpDistance = Integer.parseInt(intNneigDistances);
					//System.out.println( (j+1) +".komsu mesafe:" + intNneigDistances);
					//System.out.println( (j+1) +".komsu mesafe:" + tmpDistance);
					neigDistances[j] = tmpDistance;
					//System.out.println( (j+1) +".komsu mesafe:" + neigDistances[j]);
					j++;
				}
				
				/*int iTest;
				
				System.out.println("plakalar:" + plate);
				
				System.out.println("adi:" + cityName);
				
				for(iTest=0;iTest<neigCityBuffer;iTest++) {
					System.out.println( (iTest+1) + ".komsu:" + neigCitys[iTest] );
				}
				
				System.out.println("komsu sayisi:" + neigCityBuffer);
				
				for(iTest=0;iTest<neigDistances.length;iTest++) {
				System.out.println( (iTest+1) +".komsu mesafe:" + neigDistances[iTest]);	
				}*/
				
				cityOp.addTail(plate, neigCityBuffer, cityName, neigCitys, neigDistances);
				
				cityOp.printList();
				
				
				
			}
			
			sc.close();
			
			
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			System.out.println("Dosya mevcut de�il");
		}
	}
	
}

