package model;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class PDA {
	int pda=0;
	int zak1=300;
	int zak2=600;
	int zm1, zm2, zm3, zm4,zm5, zm6, area, zak;
	int average=0;





	public PDA(int zm1, int zm2, int zm3, int zm4, int zm5, int zm6, int area) {
		super();
		this.zm1 = zm1;
		this.zm2 = zm2;
		this.zm3 = zm3;
		this.zm4 = zm4;
		this.zm5 = zm5;
		this.zm6 = zm6;
		this.area = area;

	}

	public int averageM(){
		average =(zm1+zm2+zm3+zm4+zm5+zm6)/6;
		return average;
	}

    public int ile_PDA(){
    	int pula;

    	if (average<999){pula=1;}
    	else
    	{if(average<5000){pula=2;}
    	else
    	{if (average<20000){pula=3;}
    	else pula=4;}}

    	System.out.print(pula);


    	switch(pula){
    	case 1:{if (zak<zak1){pda=1;}
				else
			{if(zak<zak2){pda=2;}
			else zak=3;}

    	}
    	break;
    	case 2:{if (zak<zak1){pda=2;}
		else
				{if(zak<zak2){pda=3;}
				else zak=4;}

    	}
    	break;
    	case 3:{if (zak<zak1){pda=3;}
				else
				{if(zak<zak2+200){pda=4;}
				else pda=5;}

    	}
    	break;
    	case 4:{if (zak<zak1+400){pda=4;}
				else
				{if(zak<zak2){pda=5;}
				else pda=6;}

    	}
    	break;
    	}
		return pda;

     }

    public void writeTOFile(String patch){

    	try {
			PrintWriter fw =new PrintWriter(new File(patch+"PDA.txt"));
			fw.println(zm1);
			fw.println(zm2);
			fw.println(zm3);
			fw.println(zm4);
			fw.println(zm5);
			fw.println(zm6);
			fw.println("Average = "+average);
			fw.println("Amount PDA = "+pda);
			fw.flush();
			fw.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



    }

}
