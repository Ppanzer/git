package springmvc.web.ch4_5;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/commonfile", method = RequestMethod.POST)
public class UploadController {
	
	@RequestMapping(value = "/upload")
	public String upload( @RequestPart(name="file") MultipartFile file) {
		
			try {
				FileUtils.writeByteArrayToFile(new File("e:/upload/"+file.getOriginalFilename()),file.getBytes());
				return "ok";
			} catch (IOException e) {
				e.printStackTrace();
				return "wrong";
			}
			
		
	}

}
