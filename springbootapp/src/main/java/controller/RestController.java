package controller;

import model.SimpleResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
class WebController {
    @RequestMapping("/simple")
    public SimpleResponse Sample(@RequestParam(value = "name",
            defaultValue = "Robot") String name) {
        SimpleResponse response = new SimpleResponse("welcome",1);
        response.setId(1);
        response.setMessage("Your name is "+name);
        return response;

    }

}
