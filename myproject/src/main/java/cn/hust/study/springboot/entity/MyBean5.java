package cn.hust.study.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MyBean5 {

    @Value("${my.rval}")
    private String rval;

    @Value("${my.rint}")
    private String rint;

    @Value("${my.rlong}")
    private long rlong;

    @Value("${my.ruuid}")
    private String ruuid;
//
    @Value("${my.rlessten}")
    private int rlessten;
//
//    @Value("${my.rrange}")
//    private String rrange;

    /*
      rval: ${random.value}
  rint: ${random.int}
  rlong: ${random.long}
  ruuid: ${random.uuid}
  rlessten: ${random.int(10)}
  rrange:${random.int[1024, 65536]}
     */
}
