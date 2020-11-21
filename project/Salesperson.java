/**
 * Salesperson class
 */
package project;

public class Salesperson
{
    private String name;
    private float totalSales;
    private float totalCommission;
    private float commissionRate;
    
    public Salesperson()
    {
        this.name = "";
        this.totalSales = 0;
        this.totalCommission = 0;
        this.commissionRate = 0;
    }
    /*---Overloaded Constructors---*/

    public Salesperson(String name, float totalSales, float totalCommission, float commissionRate)
    {
        this.name = name;
        this.totalSales = totalSales;
        this.totalCommission = totalCommission;
        this.commissionRate = commissionRate;
    }
    /*---Accessors---*/
    public String getName()
    {
        return this.name;
    }
    public float getTotalSales()
    {
        return this.totalSales;
    }
    public float getTotalCommission()
    {
        return this.totalCommission;
    }
    public float getCommissionRate()
    {
        return this.commissionRate;
    }
    /*---Mutators---*/
    public void setCommissionRate(float rate)
    {
        this.commissionRate = rate;
    }

    /**
     * Returns a string in a specific format.
     */
    @Override
    public String toString()
    {
        return "Salesperson Name: " + name + ", Total Sales: " + totalSales + ", Total Commission: " + totalCommission + ", Commission Rate: " + commissionRate;
    }   

    /**
    @Override
    public boolean equals(Object o)
    {
        if (o instanceof Salesperson)
        {
            Salesperson c = (Salesperson) o;
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

    public int compareTo(Salesperson o)
    {
        if (lastName.compareTo(o.getLastName()) == 0)
        {
            return firstName.compareTo(o.getFirstName());
        }
        return lastName.compareTo(o.getLastName());
    }
    */
}
