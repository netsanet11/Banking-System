package lab8.finalProject.framework.dataLayer.models.basicData;


public class Address
{
    private String street;
    private String state;
    private int zipCode;

    public Address(String street, String state, int zipCode) {
        this.street = street;
        this.state = state;
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public String getState() {
        return state;
    }

    public int getZipCode() {
        return zipCode;
    }
}
