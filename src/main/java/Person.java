import java.util.Objects;
import java.io.Serializable;

public class Person implements Serializable {
    private String name, lastName, patronymic;
    private int day, month, year;

    Person() {
        name = "";
        lastName = "";
        patronymic = "";
        day = 0;
        month = 0;
        year = 0;
    }

    public Person(String name, String lastName, String patronymic, int day, int month, int year) throws Exception {
        if (name == null || "".equals(name)
                || lastName == null || "".equals(lastName)
                || patronymic == null || "".equals(patronymic)) {
            throw new Exception("Пустые ФИО");
        } else if ((day <= 0 || day > 31)
                || (month <= 0 || month > 12)
                || (year < 0)) {
            throw new Exception("Некорректная дата");
        }
        this.name = name;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) throws Exception {
        if (day <= 0 || day > 31)
            throw new Exception("Некорректный день");
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) throws Exception {
        if (month <= 0 || month > 12)
            throw new Exception("Некорректный месяц");
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) throws Exception {
        if (year < 0) {
            throw new Exception("Некорректный год");
        }
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        if (name == null || "".equals(name)) {
            throw new Exception("Пустое имя");
        }
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) throws Exception {
        if (lastName == null || "".equals(lastName))
            throw new Exception("Пустая фамилия");
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) throws Exception {
        if (patronymic == null || "".equals(patronymic))
            throw new Exception("Пустое отчество");
        this.patronymic = patronymic;
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", day=" + day +
                ", month=" + month +
                ", year=" + year +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return day == person.day && month == person.month && year == person.year && name.equals(person.name) && lastName.equals(person.lastName) && patronymic.equals(person.patronymic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastName, patronymic, day, month, year);
    }

}