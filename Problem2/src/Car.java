
import java.io.Serializable;
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.FileWriter;

public class Car implements Serializable{
    private int id;
    private String make;
    private String model;
    private int year;
    private String color;
    private double price;
    private String registrationNumber;

    // Constructor
    public Car(int id, String make, String model, int year, String color, double price, String registrationNumber) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.price = price;
        this.registrationNumber = registrationNumber;
    }

    @Override
    public String toString() {
        return String.format("Car{id: %d, make: '%s', model: '%s', year: %d, color: '%s', price: %.2f, registrationNumber: '%s'}",
                id, make, model, year, color, price, registrationNumber);
    }
    
    // Filter for a list of cars of a given brand
    public static void CarsBrand(Car[] CarList, String brand, String filename) {
    	try {  
  		  	FileWriter myWriter = new FileWriter(filename);
  		  	myWriter.write("ID\t Brand\t Model\t Year\t Color\t Price\t Registration Number\n");
	  		for(int i=0; i<5; i++) {
	    		if(CarList[i].make == brand) {
	    			System.out.println(CarList[i]);
	    	  	    myWriter.write(CarList[i].id + "\t " + CarList[i].make + "\t " + CarList[i].model + "\t " + CarList[i].year + "\t " + CarList[i].color + "\t " + CarList[i].price + "\t " + CarList[i].registrationNumber + "\n");
	    		}
	    	}
	  		myWriter.close();
	  		System.out.println("Successfully wrote to the file.");
  	    } catch (IOException e) {
	  	      System.out.println("An error occurred.");
	  	      e.printStackTrace();
  	    } 
    	System.out.println("Done");
    }
    
    // Filter for a list of cars of a given model that have been in use for more than n years
    public static void CarsModelAndYear(Car[] CarList, String model, int givenyear, String filename) {
    	try {  
  		  	FileWriter myWriter = new FileWriter(filename);
  		  	myWriter.write("ID\t Brand\t Model\t Year\t Color\t Price\t Registration Number\n");
	  		for(int i=0; i<5; i++) {
	    		if(CarList[i].model == model && ((2024 - CarList[i].year) > givenyear)) {
	    			System.out.println(CarList[i]);
	    	  	    myWriter.write(CarList[i].id + "\t " + CarList[i].make + "\t " + CarList[i].model + "\t " + CarList[i].year + "\t " + CarList[i].color + "\t " + CarList[i].price + "\t " + CarList[i].registrationNumber + "\n");
	    		}
	    	}
	  		myWriter.close();
	  		System.out.println("Successfully wrote to the file.");
  	    } catch (IOException e) {
	  	      System.out.println("An error occurred.");
	  	      e.printStackTrace();
  	    } 
    	System.out.println("Done");
    }
    
    // Filter for a list of cars of a given year of manufacture, the price of which is higher than the specified one.
    public static void CarsPriceAndYear(Car[] CarList, int price, int year, String filename) {
    	try {  
  		  	FileWriter myWriter = new FileWriter(filename);
  		  	myWriter.write("ID\t Brand\t Model\t Year\t Color\t Price\t Registration Number\n");
	  		for(int i=0; i<5; i++) {
	    		if(CarList[i].price > price && (CarList[i].year == year)) {
	    			System.out.println(CarList[i]);
	    	  	    myWriter.write(CarList[i].id + "\t " + CarList[i].make + "\t " + CarList[i].model + "\t " + CarList[i].year + "\t " + CarList[i].color + "\t " + CarList[i].price + "\t " + CarList[i].registrationNumber + "\n");
	    		}
	    	}
	  		myWriter.close();
	  		System.out.println("Successfully wrote to the file.");
  	    } catch (IOException e) {
	  	      System.out.println("An error occurred.");
	  	      e.printStackTrace();
  	    } 
    	System.out.println("Done");
    }
    
    public static void main(String[] args) {
    	int ObjectNum = 5;
    	Car CarList[] = new Car[ObjectNum];
    	CarList[0] = new Car(1, "Toyota", "Corolla", 2018, "Red", 15000, "ABC123");
    	CarList[1] = new Car(2, "Toyota", "Camry", 2020, "Blue", 20000, "XYZ789");
    	CarList[2] = new Car(3, "Honda", "Civic", 2017, "Black", 17000, "LMN456");
    	CarList[3] = new Car(4, "Honda", "Accord", 2019, "White", 18000, "OPQ012");
    	CarList[4] = new Car(5, "Ford", "Focus", 2022, "Gray", 22000, "RST345");
    	//======================================================================
    	
    	CarsBrand(CarList, "Honda", "Brand_cars.txt");
    	CarsModelAndYear(CarList, "Camry", 2, "old_cars.txt");
    	CarsPriceAndYear(CarList, 17000, 2019, "cars_price.txt");
    	
    	
    }
}
