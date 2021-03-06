package project;

public class Product
{
    private String name;
    private float sellingPrice;
    private float costPrice;
    private float totalProductSales;
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
    public float getTotalProductSales()
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
    public float getTotalProfitPercent(){
    	return this.totalProfit / this.totalProductSales;
    }
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
    }
    public void sellStock(int y){
        this.totalProductSales += (this.sellingPrice * y);
        this.totalProfit += ((this.sellingPrice - this.costPrice) * y);
        this.quantitySold += y;
    }


    /**
     * Returns a string in a specific format.
     */
    @Override
    public String toString()
    {
        return "\nProduct Name: " + name + "\nSelling Price: " + sellingPrice + "\nCost Price: " + costPrice + "\n";
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
