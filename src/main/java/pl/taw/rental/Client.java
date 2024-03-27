/**
 * Created by tomasz_taw
 * Date: 27.03.2024
 * Time: 22:10
 * Project Name: java-exercises
 * Description:
 */
package pl.taw.rental;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@Component
public class Client {

    private String name;
    private String surname;
    private String licenseNumber;

}
