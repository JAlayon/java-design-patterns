package builder.facade;

public class Demo {

    public static void main(String[] args) {
        final PersonBuilder pb = new PersonBuilder();
        Person person = pb.
                        lives()
                            .at("123 Street")
                            .in("Mexico")
                            .withPostCode("33029")
                        .works()
                            .at("IBM")
                            .asA("Software Engineer")
                            .earning(10000)
                        .build();

        System.out.println(person.toString());
    }
}

class Person{
    //Address information
    public String streetAddress, postCode, city;

    //Employment information
    public String companyName, position;
    public int annualIncoming;

    @Override
    public String toString() {
        return "Person{" +
                "streetAddress='" + streetAddress + '\'' +
                ", postCode='" + postCode + '\'' +
                ", city='" + city + '\'' +
                ", companyName='" + companyName + '\'' +
                ", position='" + position + '\'' +
                ", annualIncoming=" + annualIncoming +
                '}';
    }
}

//Builder Facade
class PersonBuilder{
    protected Person person = new Person();

    public PersonAddressBuilder lives(){
        return new PersonAddressBuilder(person);
    }

    public PersonJobBuilder works(){
        return new PersonJobBuilder(person);
    }

    public Person build(){
        return person;
    }
}

class PersonAddressBuilder extends PersonBuilder{
    public PersonAddressBuilder(Person person){
        this.person = person;
    }

    public PersonAddressBuilder at(String streetAddress){
        this.person.streetAddress = streetAddress;
        return this;
    }

    public PersonAddressBuilder withPostCode(String postCode){
        this.person.postCode = postCode;
        return this;
    }

    public PersonAddressBuilder in(String city){
        this.person.city = city;
        return this;
    }
}

class PersonJobBuilder extends PersonBuilder{
    public PersonJobBuilder(Person person){
        this.person = person;
    }

    public PersonJobBuilder at(String companyName){
        this.person.companyName = companyName;
        return this;
    }

    public PersonJobBuilder asA(String position){
        this.person.position = position;
        return this;
    }

    public PersonJobBuilder earning(int annualIncoming) {
        this.person.annualIncoming = annualIncoming;
        return this;
    }
}
