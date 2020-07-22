package spring.cloud.nacos.consumer.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient("smsJpush")
public interface ProviderClient {

    @GetMapping("/i2dsp/jpush/sysmqtt")
    String send(@RequestBody String requestDTO);

    @GetMapping("/test")
    String sendTest();
}


