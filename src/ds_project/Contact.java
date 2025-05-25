package ds_project;

public class Contact {

    String FirstName;
    String SecondName;
    String number;

    public String getFirstName() {
        return FirstName;
    }

    public String getSecondName() {
        return SecondName;
    }

    public String getNumber() {
        return number;
    }

    public Contact(String FirstName, String SecondName, String number) {
        this.FirstName = FirstName;
        this.SecondName = SecondName;
        this.number = number;
    }

    public String Compare(Contact obj, Contact x) {

        if (obj.FirstName.charAt(0) > x.FirstName.charAt(0)) {
            System.out.println(obj.getFirstName());
            return x.getFirstName();

        }
        if (obj.FirstName.charAt(0) < x.FirstName.charAt(0)) {
            System.out.println(x.getFirstName());
            return obj.getFirstName();

        }
        return null;

    }
}
