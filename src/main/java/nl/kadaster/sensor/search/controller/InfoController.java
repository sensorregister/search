package nl.kadaster.sensor.search.controller;

import nl.kadaster.sensor.search.register.RegisterClient;
import nl.kadaster.sensor.search.register.Sensor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class InfoController {

    protected final Log logger = LogFactory.getLog(getClass());
    public final static String SENSOR_ACTIVATED = "ACTIVATED";

    private RegisterClient registerClient;

    @Autowired
    public InfoController(RegisterClient registerClient) {
        this.registerClient = registerClient;
    }

    @GetMapping("/")
    public ModelAndView info(@RequestParam(value="q", required = false) String code) {

        Sensor sensor = null;

        if (code != null && !code.isEmpty()) {
            logger.debug(String.format("Finding info for %s", code));
            sensor = registerClient.getSensor(code, SENSOR_ACTIVATED);
            logger.debug(String.format("Found: %s", sensor));
        }

        if (sensor == null) {
            return new ModelAndView("sensor-not-found");
        }
        else {
            return new ModelAndView("sensor-info", "sensor", sensor);
        }
    }

}
