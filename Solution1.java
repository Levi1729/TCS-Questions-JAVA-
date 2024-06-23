//Question goes here

/*
Create class Medicine with below attributes:

MedicineName - String
batch - String
disease - String
price - int

Create class Solution and implement static method "getPriceByDisease" in the Solution class.
This method will take array of Medicine objects and a disease String as parameters.
And will return another sorted array of Integer objects where the disease String matches with the
original array of Medicine object's disease attribute (case insensitive search).

Write necessary getters and setters.

Before calling "getPriceByDisease" method in the main method, read values for four Medicine objects
referring the attributes in above sequence along with a String disease. Then call the "getPriceByDisease"
method and print the result.

Input
-------------

dolo650
FAC124W
fever
100
paracetamol
PAC545B
bodypain
150
almox
ALM747S
fever
200
aspirin
ASP849Q
flu
250
fever

Output
---------
100
200
 */





//Code goes here:


import java.util.*; //importing packages

class Medicine //Medicine class
{
    String MedicineName;
    String batch;
    String disease;
    int price;

    public Medicine(String medicineName, String batch, String disease, int price) //parameterized constructor
    {
        MedicineName = medicineName;
        this.batch = batch;
        this.disease = disease;
        this.price = price;
    }

    public String getMedicineName() {
        return MedicineName;
    }

    public String getBatch() {
        return batch;
    }

    public String getDisease() {
        return disease;
    }

    public int getPrice() {
        return price;
    }
}

public class Solution1 //Main Class
{
    public static void main(String args[]) //Main Method
    {
        Scanner sc = new Scanner(System.in); //Scanner object for taking input from users
        Medicine med[] = new Medicine[4]; //Creating med[] array of Medicine type to store objects
        for (int i = 0; i < 4; i++)
        {
            String Medicinename = sc.nextLine();
            String batch = sc.nextLine();
            String disease = sc.nextLine();
            int price = sc.nextInt();
            sc.nextLine(); // taking all the variable inputs from the user

            med[i] = new Medicine(Medicinename, batch, disease, price);
        }
        String disease_check = sc.nextLine();
        Medicine res[] = Solution1.getPriceByDisease(med, disease_check); // Storing the returned array by the getPriceByDisease method
        if (res != null) {
            for (int j = 0; j < res.length; j++) {
                System.out.println(res[j].getPrice()); //printing the prices of required medicines in ascending order
            }
        } else {
            System.out.println("No disease found with the given attributes");
        }
    }

    public static Medicine[] getPriceByDisease(Medicine med[], String disease_check) //Static method
    {
        int count=0,index=0;
        for(int i=0;i<med.length;i++) // Knowing how many times the particular disease repeated for creating the array to store all the objects of the disease
        {
            if(med[i].getDisease().equalsIgnoreCase(disease_check))
                count++;
        }
        Medicine[] tem_arr = new Medicine[count];
        for(int j=0;j<med.length;j++)
        {
            if(med[j].getDisease().equalsIgnoreCase(disease_check))
                tem_arr[index++]=med[j]; // Storing all the disease objects into tem_arr array
        }

        if(tem_arr.length>0)
            Arrays.sort(tem_arr,Comparator.comparingInt(Medicine::getPrice)); //sorting array in ascending order based on the price of medicines.
        return tem_arr;
    }
}
