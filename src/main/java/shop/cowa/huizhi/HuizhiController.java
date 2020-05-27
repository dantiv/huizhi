package shop.cowa.huizhi;

import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.web.bind.annotation.*;
import shop.cowa.huizhi.service.HuizhiService;
import shop.cowa.huizhi.service.impl.HuizhiServiceImpl;

/**
 * @author huyuchang
 */
@CrossOrigin
@RestController
@RequestMapping("/cbt")
public class HuizhiController {
    @Reference
    private HuizhiServiceImpl cbtCallbackService;
    @RequestMapping(path = "/greeting", method = RequestMethod.GET)
    public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return "hello " +name;
    }

    // orderListCallback.do
    @RequestMapping(path = "/orderListCallback.do", method = RequestMethod.POST)
    public String orderListCallback(@RequestBody String body) {
        cbtCallbackService = new HuizhiServiceImpl();
        return cbtCallbackService.orderListCallback(body);
    }

    // orderListCallback.do
    @RequestMapping(path = "/cargoListCallback.do", method = RequestMethod.POST)
    public String cargoListCallback(@RequestBody String body) {
        cbtCallbackService = new HuizhiServiceImpl();
        return cbtCallbackService.cargoListCallback(body);
    }
}
