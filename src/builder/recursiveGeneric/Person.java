package builder.recursiveGeneric;

public class Person {
    public String name;
    public String position;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}

class PersonBuilder<SELF extends PersonBuilder<SELF>>{
    protected Person person = new Person();

    public SELF withName(String name){
        this.person.name = name;
        return self();
    }

    protected SELF self(){
        return (SELF)this;
    }

    public Person build(){
        return person;
    }
}

class EmployeeBuilder extends PersonBuilder<EmployeeBuilder>{

    public EmployeeBuilder withPosition(String position){
        this.person.position = position;
        return self();
    }

    @Override
    protected EmployeeBuilder self() {
        return this;
    }
}


class Demo{

    public static void main(String[] args) {
        final EmployeeBuilder personBuilder = new EmployeeBuilder();
        final Person person = personBuilder
                        .withName("Jair")
                        .withPosition("Software Engineer")
                        .build();
        System.out.println(person.toString());
    }
}