package nl.kadaster.sensor.search.register;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(name = "register", decode404 = true)
public interface RegisterClient {

    @RequestMapping(method = RequestMethod.GET, value = "/sensors?code={code}", consumes = "application/json")
    Sensor getSensor(@PathVariable("code") String codeValue);
}