package hello;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	private static final Logger logger = Logger.getLogger(EmployeeController.class);
	
	private final String sharedKey = "SHARED_KEY";
	private static final String SUCCESS_STATUS = "success";
	private static final String ERROR_STATUS = "error";
	private static final int CODE_SUCCESS = 100;
	private static final int AUTH_FAILURE = 102;

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public BaseResponse get(@RequestParam(value = "id") String id) {
        logger.info("EmployeeController > get() > id:"+id);
        
		BaseResponse response = new BaseResponse();
		Employee emp = new Employee(1801, "Agus Sigit Wisnubroto", "aswzen@gmail.com", new Date().toString(), "Petronas Tower", "0857123123123");
		response.setStatus(SUCCESS_STATUS);
		response.setCode(CODE_SUCCESS);

        logger.info("EmployeeController > getMap(emp) > "+getMap(emp));
			
		response.setContent(getMap(emp));
		return response;
	}
	
	public final static Map<String, Object> getMap(Object obj) {
	    Map<String, Object> hashMap = new HashMap<String, Object>();
	    try {
	        Class<? extends Object> c = obj.getClass();
	        Method m[] = c.getMethods();
	        for (int i = 0; i < m.length; i++) {
	            if (m[i].getName().indexOf("get") == 0) {
	                String name = m[i].getName().toLowerCase().substring(3, 4) + m[i].getName().substring(4);
	                hashMap.put(name, m[i].invoke(obj, new Object[0]));
	            }
	        }
	    } catch (Throwable e) {
	    	logger.info(e);
	    }
	    return hashMap;
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public BaseResponse post(@RequestBody Employee request) {
        logger.info("EmployeeController > post() > "+request.toString());
        
		BaseResponse response = new BaseResponse();
		response.setStatus(SUCCESS_STATUS);
		response.setCode(CODE_SUCCESS);
		response.setRequest(request.toString());
		return response;
	}
	
}