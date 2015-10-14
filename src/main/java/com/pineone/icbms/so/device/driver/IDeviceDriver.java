package com.pineone.icbms.so.device.driver;

import com.pineone.icbms.so.resources.model.VirtualDeviceControlMessage;

import java.util.List;

/**
 * Created by existmaster on 2015. 10. 14..
 */
public interface IDeviceDriver {

    String excute(VirtualDeviceControlMessage vdcm);

    List<String> getModels();

}
