package project;

import java.io.Serializable;

public class Product implements Serializable
{
    private String name;
    private float sellingPrice;
    private float costPrice;
    int totalProductSales;
    private float totalCost;
    private float totalProfit;
    private int quantitySold;
    
    public Product()
    {
        this.name = "";
        this.sellingPrice = 0;
        this.costPrice = 0;
        this.totalProductSales = 0;
        this.totalCost = 0;
        this.totalProfit = 0;
        this.quantitySold = 0;
    }

    public Product(String name, float sellingPrice, float costPrice)
    {
        this.name = name;
        this.sellingPrice = sellingPrice;
        this.costPrice = costPrice;
    }
    /*---Accessors---*/
    public String getName()
    {
        return this.name;
    }
    public float getSellingPrice()
    {
        return this.sellingPrice;
    }
    public float getCostPrice()
    {
        return this.costPrice;
    }
    public int getTotalProductSales()
    {
        return this.totalProductSales;
    }
    public float getTotalCost()
    {
        return this.totalCost;
    }
    public float getTotalProfit()
    {
        return this.totalProfit;
    }
    public int getQuantitySold(){ return this.quantitySold;}
    //public float getTotalProfitPercent(){}; Probably a return based off of TotalProfit compared
    // to some other value
    /*---Mutators---*/
    public void setSellingPrice(float newSellingPrice){ this.sellingPrice = newSellingPrice;}
    public void setCostPrice(float newCostPrice){ this.costPrice = newCostPrice;}

    /** I feel that these methods are needed to properly manage totalProductSales, totalCost, and totalProfit
     *  even though I also feel that warehouse should somehow manage this. Our documents conflict somewhat after
     *  cross-examining Class Diagrams, List of Entity Methods, and List of Objects
     * @param x, y
     */
    public void addStock(int x){
        this.totalCost += (this.costPrice * x);
        this.totalProfit -= (this.costPrice * x);
    }
    public void sellStock(int y){
        this.totalProductSales += (this.sellingPrice * y);
        this.totalProfit += (this.sellingPrice * y);
        this.quantitySold += y;
    }


    /**
     * Returns a string in a specific format.
     */
    @Override
    public String toString()
    {
        return "Product Name: " + name + ", Selling Price: " + sellingPrice + ", Cost Price: " + costPrice + 
               ", Total Product Sales: " + totalProductSales + ", Total Cost: " + totalCost + 
               ", Total Profit: " + totalProfit;
    }   

/**
    @Override
    public boolean equals(Object o)
    {
        if (o instanceof Product)
        {
            Product c = (Product) o;
            if (name.equals(c.getName()))
            {
                return true;
            }
        }
        return false;
    }
*/
    /**
     * Compares two objects, first by last name then by first to see if
     * they are equal
     * @param o - explicit object to the compared.
     * @return 0 if equal, otherwise negative or positive depending on if
     * the last name is bigger or smaller.

    public int compareTo(Product o)
    {
        if (lastName.compareTo(o.getLastName()) == 0)
        {
            return firstName.compareTo(o.getFirstName());
        }
        return lastName.compareTo(o.getLastName());
    }
    */
   
}
