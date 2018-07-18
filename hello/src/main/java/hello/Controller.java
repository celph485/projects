package hello;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @RequestMapping(value = "/process", method = RequestMethod.POST)
    public ResponseEntity<ExternalResponse> process(@RequestBody ExternalRequest request) {
	System.out.print("Request: \n" + request);

	ExternalResponse response;
	
	if(StringUtils.startsWith(request.getImeiNo(), "8686830")){
	    response = getNegativeRespose();
	}else{
	    response = getPositiveRespose();
	}
	
	System.out.print("Response: \n" + response);
	return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }

    private ExternalResponse getNegativeRespose() {
	ExternalResponse response = new ExternalResponse();
	response.setResult("false");
	response.setMsg("Failure");
	return response;
    }

    private ExternalResponse getPositiveRespose() {
	ExternalResponse response = new ExternalResponse();
	response.setResult("true");
	response.setMsg("Success");
	return response;
    }

}
