package nl.kadaster.sensor.search.controller;

import nl.kadaster.sensor.search.register.RegisterClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class InfoController {

    private RegisterClient registerClient;

    @Autowired
    public InfoController(RegisterClient registerClient) {
        this.registerClient = registerClient;
    }

    @GetMapping("/info}")
    public ModelAndView info(@RequestParam("q") String code) {
        return new ModelAndView();
    }

}
