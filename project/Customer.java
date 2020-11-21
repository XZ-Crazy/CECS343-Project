package project;

public class Customer
{
    private String name;
    private float taxPercentage;
    private boolean delinquencyStatus;
    
    public Customer()
    {
        this.name = "";
        this.taxPercentage = 0;
        this.delinquencyStatus = false;
    }
    /*---Overloaded Constructors---*/

    public Customer(String name, float taxPercentage, Boolean delinquencyStatus)
    {
        this.name = name;
        this.taxPercentage = taxPercentage;
        this.delinquencyStatus = delinquencyStatus;
    }
    /*---Accessors---*/
    public String getName()
    {
        return this.name;
    }
    public float getTaxPercentage()
    {
        return this.taxPercentage;
    }
    public Boolean getDelinquencyStatus()
    {
        return this.delinquencyStatus;
    }
    /*---Mutators---*/
    public void setDelinquencyStatus(Boolean status)
    {
        this.delinquencyStatus = status;
    }

    /**
     * Returns a string in a specific format.
     */
    @Override
    public String toString()
    {
        return "Customer Name: " + name + ", Tax Percentage: " + taxPercentage + ", Delinquency Status: " + delinquencyStatus;
    }   
    /**
     * maybe we can use to check if we already have a customer in the system before
     * registering a new one
     */
    @Override
    public boolean equals(Object o)
    {
        if (o instanceof Customer)
        {
            Customer c = (Customer) o;
            if (name.equals(c.getName()))
            {
                return true;
            }
        }
        return false;
    }
    /**
     * Compares two objects, first by last name then by first to see if
     * they are equal
     * @param o - explicit object to the compared.
     * @return 0 if equal, otherwise negative or positive depending on if
     * the last name is bigger or smaller.

    public int compareTo(Customer o)
    {
        if (lastName.compareTo(o.getLastName()) == 0)
        {
            return firstName.compareTo(o.getFirstName());
        }
        return lastName.compareTo(o.getLastName());
    }
    */
}
