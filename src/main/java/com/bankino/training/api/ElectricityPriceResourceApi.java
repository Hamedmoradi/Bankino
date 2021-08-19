package com.bankino.training.api;

import com.bankino.training.service.ElectricityPriceService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/api/electricity")
@Api(value = "Swagger2DemoRestController", description = "REST APIs related to electricity Entity!!!!")
public class ElectricityPriceResourceApi {
    public static final Logger logger = LoggerFactory.getLogger(ElectricityPriceResourceApi.class);

    @Autowired
    private ElectricityPriceService electricityPriceService;

    @GetMapping("/price")
    @ApiOperation(value = "calculate electricity price", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully calculate"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public String calculateElectricityPrice(@ApiParam(value = "calculate electricity price", required = true)
                                      @RequestParam String startDate, @RequestParam String endDate, @RequestParam Long counterId) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
        Date sdate = null;
        Date edate = null;
        try {
            sdate = formatter.parse(startDate);
            if (endDate!=null){
                edate = formatter.parse(endDate);
            }else {
                edate = null;
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        logger.info(startDate + "\t" + sdate);
        logger.info(endDate + "\t" + edate);

        String result=electricityPriceService.calculatePeriodicCounterPrice(sdate, edate, counterId);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/price")
                .buildAndExpand().toUri().resolve(result);

        return ResponseEntity.status(200).location(location).build().getHeaders().get("location").toString();
    }

}
