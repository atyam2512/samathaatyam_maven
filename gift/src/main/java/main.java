import  chocolates.*;
import sweets.*;
import java.util.*;
public class main {
	public static void sortedMerge(int a[], int b[],  int res[]) 
{ 
int i = 0, j = 0, k = 0; 
while (i < 3) { 
res[k] = a[i]; 
i++; 
k++; 
} 

while (j < 3) { 
res[k] = b[j]; 
j++; 
k++; 
} 

Arrays.sort(res); 
} 

	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		String[] chocolates={"Dairy Milk","Kit_Kat","Snickers"};
		int [] chocolates_weight={150,90,50};
		String[] sweets={"Barfi","Halva","Laddu"};
		int [] sweets_weight={200,150,100};
		System.out.println("****Menu****	WEIGHTS");
		for(int i=0;i<3;i++)
		{
			System.out.printf((i+1)+")"+chocolates[i]+"\t"+chocolates_weight[i]+"\n\n");
		}
		int []qty_chocolates=new int[3];
		for (int i=0;i<3;i++)
		{
			System.out.printf("Enter the quantity of "+chocolates[i]+"::--->");
			qty_chocolates[i]=sc.nextInt();
		}
        System.out.println("****Menu****	WEIGHTS");
		for(int i=0;i<3;i++)
		{
			System.out.printf((i+1)+")"+sweets[i]+"\t\t"+sweets_weight[i]+"\n\n");
		}
		int []qty_sweets=new int[3];
		for (int i=0;i<3;i++)
		{
			System.out.printf("Enter the quantity of "+sweets[i]+"::--->");
			qty_sweets[i]=sc.nextInt();
		}
		String[] Merge= {"Diary Milk","Kit-Kat    ","Snickers","Barfi    ","Halva    ","Laddu    "};
		int[] choco_weight =new int[3];
		int[] sweet_weight = new int[3];
		int[] choco_price = new int[3];
		int[] sweet_price = new int[3];
		int[] sorted_weight=new int[6];
		int[] sorted_price =new int[6];
		dairymilk dm = new dairymilk();
		kitkat k=new kitkat();
		snickers s=new snickers();
		barfi b=new barfi();
		halva h=new halva();
		laddu l=new laddu();
		for(int j=0;j<3;j++)
		{
			switch(j)
			{
			case 0 : choco_weight[j] = dm.weight();
					 choco_price[j] = dm.price(qty_chocolates[j]);
					 break;
			case 1:  choco_weight[j] = k.weight();
			 		 choco_price[j] = k.price(qty_chocolates[j]);
			 		 break;
			case 2:	 choco_weight[j] = s.weight();
			 		 choco_price[j] = s.price(qty_chocolates[j]);
			 		 break;
			 }
		}
		for(int j=0;j<3;j++)
		{
			switch(j)
			{
			case 0 : sweet_weight[j] = b.weight();
					 sweet_price[j] = b.price(qty_chocolates[j]);
					 break;
			case 1:  sweet_weight[j] = h.weight();
			 		 sweet_price[j] = h.price(qty_chocolates[j]);
			 		 break;
			case 2:	 sweet_weight[j] = l.weight();
			 		 sweet_price[j] = l.price(qty_chocolates[j]);
			 		 break;
			 }
		}
		for(int i=0;i<3;i++)
			System.out.println(choco_weight[i]);
		sortedMerge(choco_weight,sweet_weight, sorted_weight);
		sortedMerge(choco_price,sweet_price,sorted_price);
		
		System.out.println("Choose the option in which you want to sort\n1.)Based On WEIGHT\n2.)Based On PRICE");
		int n=sc.nextInt();
		if(n==1)
		{
			for(int i=0;i<6;i++)
			{
				for(int j=0;j<6;j++)
				{
					if(sorted_weight[i]>sorted_weight[j])
					{
						int u1=sorted_weight[i];
						sorted_weight[i]=sorted_weight[j];
						sorted_weight[j]=u1;
						int u3=sorted_price[i];
						sorted_price[i]=sorted_price[j];
						sorted_price[j]=u3;
						String u2=Merge[i];
						Merge[i]=Merge[j];
						Merge[j]=u2;
					}
				}
			}
			System.out.println("****MENU****	WEIGHTS		PRICE");
			for(int i=0;i<6;i++)
			{
				System.out.printf(Merge[i]+"\t"+sorted_weight[i]+"\t\t"+sorted_price[i]+"\n");
			}
		}
		else if(n==0)
		{
			for(int i=0;i<6;i++)
			{
				for(int j=0;j<6;j++)
				{
					if(sorted_price[i]>sorted_price[j])
					{
						int u1=sorted_price[i];
						sorted_price[i]=sorted_price[j];
						sorted_price[j]=u1;
						int u3=sorted_weight[i];
						sorted_weight[i]=sorted_weight[j];
						sorted_weight[j]=u3;
						String u2=Merge[i];
						Merge[i]=Merge[j];
						Merge[j]=u2;
					}
				}
			}
			
			System.out.println("****MENU****	WEIGHTS		PRICE");
			for(int i=0;i<6;i++)
			{
				System.out.printf(Merge[i]+"\t"+sorted_weight[i]+"\t\t"+sorted_price[i]+"\n");
			}
			
		}
	}

}
