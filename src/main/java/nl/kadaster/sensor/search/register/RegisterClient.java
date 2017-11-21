package nl.kadaster.sensor.search.register;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name = "register", decode404 = true)
public interface RegisterClient {

//    @RequestLine("GET /sensors/search/findOneByCode_ValueAndCode_StatusIs?value={value}")
    @RequestMapping(method = RequestMethod.GET, value = "/sensors/search/findOneByCode_ValueAndCode_StatusIs")
    Sensor getSensor(@RequestParam("value") String codeValue, @RequestParam("status") String Status);
}