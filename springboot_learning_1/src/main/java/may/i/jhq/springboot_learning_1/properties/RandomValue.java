package may.i.jhq.springboot_learning_1.properties;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "my.")//yaml里的配置不能通过@PropertySource加载
public class RandomValue {

  @Value(value = "${secret}")
  @NotEmpty
  private String secret;

  @Value(value = "${number}")
  private int number;

  @Value(value = "${bignumber}")
  private Long bignumber;

  @Value(value = "${number.less.than.ten}")
  private int tenNumber;

  @Value(value = "number.in.range")
  private int rangeNumber;


}
