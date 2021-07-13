package com.auth.spring;
import org.springframework.http.ResponseEntity;
import com.auth.spring.dto.ErrorDto;
import com.auth.spring.dto.ReturnCode;


/**
 * 
 * @author Fernando Granato
 *
 */
public class BaseEndPoint {

	/**
	 * The Method user
	 * 
	 * @param <T>
	 * @param dto
	 * @param returnCode
	 * @param errorMessaage
	 * @return
	 */
	public <T> ResponseEntity<T> managerResponseBuilderRead(T dto, ReturnCode returnCode, String errorMessaage) {
		ErrorDto error = null;
		ResponseEntity<T> response = null;
		if (returnCode.equals(ReturnCode.OK)) {
			response = ResponseEntity.ok(dto);
		} else if (returnCode.equals(ReturnCode.NOT_FOUND)) {
			error = new ErrorDto();
			error.setReturnCode(returnCode);
			error.setErrorMessage(errorMessaage);
			response = ResponseEntity.notFound().build();
		} else if (returnCode.equals(ReturnCode.ERROR)) {
			error = new ErrorDto();
			error.setReturnCode(returnCode);
			error.setErrorMessage(errorMessaage);
			response = ResponseEntity.status(500).build();
		}
		return response;

	}

	/**
	 * 
	 * @param <T>
	 * @param returnCode
	 * @param errorMessaage
	 * @return
	 */
	public <T> ResponseEntity<T> managerResponseBuilderCreate(ReturnCode returnCode, String errorMessaage) {
		ErrorDto error = null;
		ResponseEntity<T> response = null;
		if (returnCode.equals(ReturnCode.CREATED)) {
			response = ResponseEntity.created(null).build();
		} else if (returnCode.equals(ReturnCode.ALREDY_EXIST)) {
			error = new ErrorDto();
			error.setReturnCode(returnCode);
			error.setErrorMessage(errorMessaage);
			response = ResponseEntity.status(409).build();
		} else if (returnCode.equals(ReturnCode.ERROR)) {
			error = new ErrorDto();
			error.setReturnCode(returnCode);
			error.setErrorMessage(errorMessaage);
			response = ResponseEntity.status(500).build();
		}
		return response;

	}

	/**
	 * 
	 * @param <T>
	 * @param returnCode
	 * @param errorMessaage
	 * @return
	 */
	public <T> ResponseEntity<T> managerResponseBuilderUpdate(ReturnCode returnCode, String errorMessaage) {
		ErrorDto error = null;
		ResponseEntity<T> response = null;
		if (returnCode.equals(ReturnCode.OK)) {
			response = ResponseEntity.ok(null);
		} else if (returnCode.equals(ReturnCode.CREATED)) {
			response = ResponseEntity.created(null).build();
		} else if (returnCode.equals(ReturnCode.ERROR)) {
			error = new ErrorDto();
			error.setReturnCode(returnCode);
			error.setErrorMessage(errorMessaage);
			response = ResponseEntity.status(500).build();
		}
		return response;

	}

	/**
	 * 
	 * @param <T>
	 * @param returnCode
	 * @param errorMessaage
	 * @return
	 */
	public <T> ResponseEntity<T> managerResponseBuilderDelete(ReturnCode returnCode, String errorMessaage) {
		ErrorDto error = null;
		ResponseEntity<T> response = null;
		if (returnCode.equals(ReturnCode.DELETED)) {
			response = ResponseEntity.ok(null);
		} else if (returnCode.equals(ReturnCode.NOT_FOUND)) {
			response = ResponseEntity.notFound().build();
		} else if (returnCode.equals(ReturnCode.ERROR)) {
			error = new ErrorDto();
			error.setReturnCode(returnCode);
			error.setErrorMessage(errorMessaage);
			response = ResponseEntity.status(500).build();
		}
		return response;

	}

}
