package com.worldofthings.restapi;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.worldofthings.services.VirtualObjectService;
import com.worldofthings.vo.VirtualObjectVO;

@RestController
@RequestMapping("/api")
public class VirtualObjectApiController {

	public static final Logger logger = LoggerFactory
			.getLogger(VirtualObjectApiController.class);

	// Services or APIs are exposed to outside work.

	@Autowired
	VirtualObjectService virtualObjectService;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/vo/", method = RequestMethod.GET)
	public ResponseEntity<List<VirtualObjectVO>> getAllVos() {
		List<VirtualObjectVO> vos = virtualObjectService
				.getAllVirtualObjectVO();
		if (vos.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<VirtualObjectVO>>(vos, HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/vo/{name}", method = RequestMethod.GET)
	public ResponseEntity<VirtualObjectVO> getVo(
			@PathVariable("name") String name) {
		VirtualObjectVO vo = virtualObjectService
				.getVirtualObjectVOBySource(name);
		if (vo == null) {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<VirtualObjectVO>(vo, HttpStatus.OK);
	}

	@RequestMapping(value = "/vo/", method = RequestMethod.POST)
	public ResponseEntity<?> createVo(@RequestBody VirtualObjectVO vo,
			UriComponentsBuilder ucBuilder) {
		logger.info("Creating VO : {}", vo);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

}
