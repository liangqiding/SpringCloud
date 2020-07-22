package spring.cloud.nacos.consumer.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import spring.cloud.nacos.consumer.client.MyTest;
import spring.cloud.nacos.consumer.client.ProviderClient;

import javax.annotation.Resource;


@RestController
@EnableDiscoveryClient
@EnableFeignClients
public class ConsumerController {

    @Autowired
    RestTemplate restTemplate;
    @Resource
    MyTest myTest;
    @Autowired
    ProviderClient providerClient;

    @GetMapping("/hi")
    public String hiResttemplate(){
        return restTemplate.getForObject("http://nacos-provider/hi?name=resttemplate", String.class);
    }

    @GetMapping("/send")
    public String hiFeign(){
       return providerClient.send("feign");
    }

    @GetMapping("/sendTest")
    public String sendTest(){
       return providerClient.sendTest();
    }

    @GetMapping("/sendMy")
    public String sendMy(String msg){
       return myTest.send(msg);
    }


}
