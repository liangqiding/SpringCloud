package spring.cloud.nacos.consumer.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient("myProvider")
public interface MyTest {

    @GetMapping("/send")
    String send(@RequestParam(value = "name", defaultValue = "forezp", required = false) String msg);
}


