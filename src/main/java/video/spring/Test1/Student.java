package video.spring.Test1;

/**
 * Description: Student
 * Author: heyv
 * Time: 2023 2023/7/25 20:21
 */
public class Student {
    private int id;
    private String name;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    private Address address;

    public Student() {
        System.out.println("调用该无参构造方法！！！");
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address.getProvince()+address.getCity() +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
