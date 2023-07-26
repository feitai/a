package springtest3.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description: Student
 * Author: heyv
 * Time: 2023 2023/7/26 8:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String name;
    private double weight;
    private double height;

}
