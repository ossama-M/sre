package com.vois.inventory.controller;

import com.vois.clients.constant.ResponseCodes;
import com.vois.clients.utils.DeviceList;
import com.vois.clients.utils.ErrorModel;
import com.vois.inventory.dto.request.AddRequest;
import com.vois.inventory.dto.request.UpdateRequest;
import com.vois.clients.utils.Response;
import com.vois.inventory.service.DeviceInventoryServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/inventory")
@Slf4j
public class Controller {
    private final DeviceInventoryServiceImpl deviceInventoryService ;

    @PostMapping("/add-device")
    public @ResponseBody Response addDevice(@RequestBody AddRequest addRequest) {
        return deviceInventoryService.addDevice(addRequest);
    }

    @PutMapping("/update-device")
    public @ResponseBody Response updateDevice(@Valid @RequestBody UpdateRequest updateRequest) {
        return deviceInventoryService.updateDevice(updateRequest);
    }

    @GetMapping("/unconfig-device")
    public @ResponseBody Response getUnConfigDevice(){
        return deviceInventoryService.getUnConfigDevices();
    }

    @GetMapping("/config-device")
    public @ResponseBody Response getConfigDevice(){
        return deviceInventoryService.getConfigDevices();
    }

    @GetMapping("/check-availability-to-config")
    public @ResponseBody Response checkAvailabilityToConfig(){
        if(deviceInventoryService.checkAvailabToConfig()) {
            log.info("mmmm..... there is some unConfig Device let's config them .....");
            deviceInventoryService.sendNotificationToConfig();
            return new Response(ResponseCodes.WE_HAVE_DEVICE_TO_CONFIG);
        }
        log.info("ooooow ..... we are good, no need to extra work let's check later .....");
        return new Response(ResponseCodes.THERE_IS_NO_DEVICE_TO_CONFIG);
    }

    @PostMapping("/save-config-devices")
    public @ResponseBody Response saveConfigDevicesToDB(@RequestBody DeviceList deviceList){
         deviceInventoryService.saveConfiguredDevices(deviceList);
        return new Response(ResponseCodes.CONFIGURED_DEVICE_SAVED_TO_DB);
    }




    @ExceptionHandler
    public ResponseEntity<ErrorModel> handleExcption(Exception ex){
        ErrorModel error = new ErrorModel().builder()
                .message(ex.getMessage())
                .status(HttpStatus.FORBIDDEN.value())
                .timestamp(System.currentTimeMillis()).build();
        return new ResponseEntity<>(error,HttpStatus.FORBIDDEN);
    }


}
