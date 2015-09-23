package com.pineone.icbms.so.adp.controller;

import com.pineone.icbms.so.adp.model.Occurrence;
import com.pineone.icbms.so.core.model.Command;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by existmaster on 2015. 9. 22..
 */
@Controller
public class OccurrenceController {

    @ResponseBody
    @RequestMapping(value = "/occ", method = RequestMethod.POST)
    public Command home(@RequestBody Occurrence occurrence) {
//    public Occum home(@RequestParam(value = "id", required = true) String id,
//                      @RequestParam(value = "information", required = false) List<Information> informations, Model model) {

        System.out.println("OCCUM_CONTROLLER_RUN");
        System.out.println("OCCUM_ID : " + occurrence.getId());

        return occurrence;
    }

}
