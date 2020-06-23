package eureka.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: QiDing
 * @DateTime: 2020/6/23 0023 16:29
 * @Description: TODO
 */
@RestController
public class ClientController {

    @Value("${server.port}")
    String port;

    @RequestMapping("/hi")
    public String home(@RequestParam(value = "name", defaultValue = "QiDing") String name) {
        return "hi " + name + " ,I am from port:" + port;
    }
}
