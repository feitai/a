package video.spring.Test1;

/**
 * Description: Address
 * Author: heyv
 * Time: 2023 2023/7/25 23:25
 */
public class Address {
    private String province;
    private String city;



    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    private Address(){
        System.out.println("构建了地址类");
    }
}
