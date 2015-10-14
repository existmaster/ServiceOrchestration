package com.pineone.icbms.so.device.driver;

import com.pineone.icbms.so.resources.model.VirtualDeviceControlMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by existmaster on 2015. 10. 14..
 */
public class LGHD3xxLightDeviceDriver extends ALGDeviceDriver {

    List<String> models = Arrays.asList("LGHD394", "LGHD340");

    @Override
    public List<String> getModels() {
        return this.models;
    }

    @Override
    String Hello() {
        return "Hello";
    }

    @Override
    String Hello2() {
        return "Hello2";
    }
}
