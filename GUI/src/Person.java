public abstract class Person {
protected
    String name;
    String surname;
    int age;
    String phoneNumber;
    String mail;

    public Person(String name, String surname, int age, String phoneNumber, String mail) {
        setName(name);
        setSurname(surname);
        setAge(age);
        setPhoneNumber(phoneNumber);
        setMail(mail);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getMail() {
        return mail;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
